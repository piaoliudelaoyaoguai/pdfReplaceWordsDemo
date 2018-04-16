package PDF;

/**
 * <p>需要替换的区域 <p>
 * @version 1.0
 * @author li_hao
 * @date 2018年3月14日
 */
public class ReplaceRegion {  
  
    private String aliasName;  
    private Float x;  
    private Float y;  
    private Float w;  
    private Float h;  
      
    public ReplaceRegion(String aliasName){  
        this.aliasName = aliasName;  
    }  
      
    /**
     * 替换区域的别名 
     * @return
     */
    public String getAliasName() {  
        return aliasName;  
    }  
    public void setAliasName(String aliasName) {  
        this.aliasName = aliasName;  
    }  
    public Float getX() {  
        return x;  
    }  
    public void setX(Float x) {  
        this.x = x;  
    }  
    public Float getY() {  
        return y;  
    }  
    public void setY(Float y) {  
        this.y = y;  
    }  
    public Float getW() {  
        return w;  
    }  
    public void setW(Float w) {  
        this.w = w;  
    }  
    public Float getH() {  
        return h;  
    }  
    public void setH(Float h) {  
        this.h = h;  
    }  
}  
