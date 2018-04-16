package PDF;

import com.itextpdf.text.BaseColor;  
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;  
import com.itextpdf.text.pdf.PdfReader;  
import com.itextpdf.text.pdf.PdfStamper;  
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.IOException;  
   
/**
 * <p>PDF增加遮盖层<p>
 * @version 1.0
 * @author li_hao
 * @date 2018年3月14日
 */
public class HighLightByAddingContent0 {
	 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
//        PdfContentByte canvas = stamper.getUnderContent(1);  //不可遮挡文字
        PdfContentByte canvas = stamper.getOverContent(1);  //可以遮挡文字
        canvas.saveState();
//        canvas.setColorFill(BaseColor.YELLOW);  //黄色遮挡层
        canvas.setColorFill(BaseColor.WHITE);  //白色遮挡层
        canvas.rectangle(116, 726, 66, 16);
        canvas.fill();
        canvas.restoreState();
        stamper.close();
        reader.close();
    }
    
    /**
     * 测试
     */
    public static void main(String[] args) throws IOException, DocumentException {
    	
    	String SRC = "D:/testpdf/test.pdf";
        String DEST = "D:/testpdf/test3.pdf";
    	
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new HighLightByAddingContent0().manipulatePdf(SRC, DEST);
    }
}