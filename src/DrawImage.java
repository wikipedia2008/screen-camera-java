import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zhantong on 16/3/17.
 */
public class DrawImage {
    int blockLength;
    Graphics2D g;
    BufferedImage img;
    public DrawImage(int imgWidthBlock,int imgHeightBlock,int blockLength){
        this.blockLength=blockLength;
        int imgWidth=imgWidthBlock*blockLength;
        int imgHeight=imgHeightBlock*blockLength;
        img=new BufferedImage(imgWidth,imgHeight,BufferedImage.TYPE_BYTE_BINARY);
        g=img.createGraphics();
        initGraphics(imgWidth,imgHeight);
    }
    private void initGraphics(int imgWidth,int imgHeight){
        g.setBackground(Color.WHITE);
        g.clearRect(0,0,imgWidth,imgHeight);
    }
    public void fillWhiteRect(int x,int y,int width,int height){
        g.setColor(Color.WHITE);
        fillRect(x,y,width,height);
    }
    public void fillBlackRect(int x,int y,int width,int height){
        g.setColor(Color.BLACK);
        fillRect(x,y,width,height);
    }
    public void setDefaultColor(String color){
        if(color.equals("black")){
            g.setColor(Color.BLACK);
        }
        else{
            g.setColor(Color.WHITE);
        }
    }
    public void fillRect(int x,int y,int width,int height){
        g.fillRect(x*blockLength,y*blockLength,width*blockLength,height*blockLength);
    }
    public void fillContentRect(boolean isTrue,int x,int y,int width,int height){
        x*=blockLength;
        width*=blockLength;
        height=(int)Math.round(height*0.6*blockLength);
        if(isTrue){
            y*=blockLength;
        }
        else{
            y=(int)Math.round(y*blockLength+0.4*blockLength);
        }
        g.fillRect(x,y,width,height);
    }
    public void save(String imgFormat,String filePath) throws IOException{
        g.dispose();
        img.flush();
        File file=new File(filePath);
        ImageIO.write(img,imgFormat,file);
    }
}
