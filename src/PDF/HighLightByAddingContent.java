package PDF;

import com.itextpdf.text.BaseColor;  
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;  
import com.itextpdf.text.pdf.PdfReader;  
import com.itextpdf.text.pdf.PdfStamper;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
   
/**
 * <p>PDF增加遮盖层+文字<p>
 * @version 1.0
 * @author li_hao
 * @date 2018年3月13日
 */
public class HighLightByAddingContent {  
   
    
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {  
        PdfReader reader = new PdfReader(src);  
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));  
        //添加一个遮挡处，可以把原内容遮住，后面在上面写入内容
//        PdfContentByte canvas = stamper.getUnderContent(1);  //不可以遮挡文字
        PdfContentByte canvas = stamper.getOverContent(1);  //可以遮挡文字
        
        float height=780;  
        System.out.println(canvas.getHorizontalScaling());  
        float x,y;  
        x= 116;  
        y = height -49.09F;  
        canvas.saveState();  
        canvas.setColorFill(BaseColor.YELLOW);  //遮挡层颜色：黄色
//      canvas.setColorFill(BaseColor.WHITE);  //遮挡层颜色：白色
        canvas.rectangle(x, y-5, 43, 15);  
        
        canvas.fill();  
        canvas.restoreState();  
        //开始写入文本   
        canvas.beginText();   
//        BaseFont bf = BaseFont.createFont(URLDecoder.decode(CutAndPaste.class.getResource("/AdobeSongStd-Light.otf").getFile()), BaseFont.IDENTITY_H, BaseFont.EMBEDDED);  
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
//        BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/STSONG.TTF", BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED)
        Font font = new Font(bf,10,Font.BOLD);   
        //设置字体和大小   
        canvas.setFontAndSize(font.getBaseFont(), 10);    
        //设置字体的输出位置   
        canvas.setTextMatrix(x, y);    
        //要输出的text   
        canvas.showText("我是替换" );     
          
        canvas.endText();  
        stamper.close();  
        reader.close();  
        System.out.println("complete");   
    }  
    
    /**
     * 测试
     */
    public static void main(String[] args) throws IOException, DocumentException {  
    	String SRC = "D:/testpdf/test.pdf";
    	String DEST = "D:/testpdf/test_a.pdf";
        File file = new File(DEST);  
        file.getParentFile().mkdirs();  
        new HighLightByAddingContent().manipulatePdf(SRC, DEST);  
    }  
}  