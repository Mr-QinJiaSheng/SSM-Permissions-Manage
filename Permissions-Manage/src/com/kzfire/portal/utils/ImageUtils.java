package com.kzfire.portal.utils;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;



/**
 * 图片锟斤拷锟�?锟斤拷锟洁：<br>
 * 锟斤拷锟杰ｏ拷锟斤拷锟斤拷图锟斤拷锟叫革拷图锟斤拷图锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷锟斤拷色转锟节白★拷锟斤拷锟斤拷水印锟斤拷图片水印锟斤拷
 * @author Administrator
 */
public class ImageUtils {


    /**
     * 锟斤拷锟街筹拷锟斤拷锟酵计拷锟绞�
     */
    public final static String IMAGE_TYPE_GIF = "GIF";// 图锟轿斤拷锟斤拷锟斤拷式
    public final static String IMAGE_TYPE_JPG = "JPG";// 锟斤拷锟斤拷锟斤拷片专锟斤拷锟斤拷
    public final static String IMAGE_TYPE_JPEG = "JPEG";// 锟斤拷锟斤拷锟斤拷片专锟斤拷锟斤拷
    public final static String IMAGE_TYPE_BMP = "BMP";// 英锟斤拷Bitmap锟斤拷位图锟斤拷锟侥硷拷写锟斤拷锟斤拷锟斤拷Windows锟斤拷锟斤拷系统锟叫的憋拷准图锟斤拷锟侥硷拷锟斤拷式
    public final static String IMAGE_TYPE_PNG = "PNG";// 锟斤拷锟斤拷植锟斤拷锟斤拷图锟斤拷
    public final static String IMAGE_TYPE_PSD = "PSD";// Photoshop锟斤拷专锟矫革拷式Photoshop


    /**
     * 锟斤拷锟斤拷锟斤拷冢锟斤拷锟斤拷诓锟斤拷锟�
     * @param args
     */
    public static void main(String[] args) {
        // 1-锟斤拷锟斤拷图锟斤拷
        // 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷
    	String aa="e:/aa.jpg";
    	String bb="d:/bb.jpg";
    	long l=System.currentTimeMillis();
//        ImageUtils.scale("d:/aa.jpg", "d:/abc_scale.jpg", 2, true);//锟斤拷锟斤拷OK
//        // 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟竭度和匡拷锟斤拷锟斤拷锟�
//        ImageUtils.scale(aa, bb, 500, 300, true);//锟斤拷锟斤拷OK
//
//
//        // 2-锟叫革拷图锟斤拷
//        // 锟斤拷锟斤拷一锟斤拷锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷涂锟斤拷锟叫革拷
//        ImageUtils.cut(aa, bb, 0, 0, 400, 400 );//锟斤拷锟斤拷OK
//        // 锟斤拷锟斤拷锟斤拷锟斤拷指锟斤拷锟斤拷片锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
//
//
//        // 3-图锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷
//        ImageUtils.convert("e:/abc.jpg", "jpg", "e:/abc_convert.jpg");//锟斤拷锟斤拷OK
//
//
//        // 4-锟斤拷色转锟节白ｏ拷
//        ImageUtils.gray("e:/abc.jpg", "e:/abc_gray.jpg");//锟斤拷锟斤拷OK
//
//
//        // 5-锟斤拷图片锟斤拷锟斤拷锟斤拷锟剿★拷锟�
//        // 锟斤拷锟斤拷一锟斤拷
//        ImageUtils.pressText("锟斤拷锟斤拷水印锟斤拷锟斤拷","e:/abc.jpg","e:/abc_pressText.jpg","锟斤拷锟斤拷",Font.BOLD,Color.white,80, 0, 0, 0.5f);//锟斤拷锟斤拷OK
//        // 锟斤拷锟斤拷锟斤拷锟斤拷
//        ImageUtils.pressText2("锟斤拷也锟斤拷水印锟斤拷锟斤拷", "e:/abc.jpg","e:/abc_pressText2.jpg", "锟斤拷锟斤拷", 36, Color.white, 80, 0, 0, 0.5f);//锟斤拷锟斤拷OK
//        
//        // 6-锟斤拷图片锟斤拷锟酵计★拷锟�
//        ImageUtils.pressImage("e:/abc2.jpg", "e:/abc.jpg","e:/abc_pressImage.jpg", 0, 0, 0.5f);//锟斤拷锟斤拷OK
       String aas= getImageStr("e:/abc.jpg");
       System.out.println(aas.getBytes().length);
    	generateImage(aas, "e:/ab.jpg");
    	long l1=System.currentTimeMillis();
        System.out.println("锟斤拷时锟斤拷"+(l1-l));
    }


    
    //图片转锟斤拷锟斤拷base64锟街凤拷  
    public static String getImageStr(String imgFile)  
    {//锟斤拷图片锟侥硷拷转锟斤拷为锟街斤拷锟斤拷锟斤拷锟街凤拷锟斤拷锟斤拷锟斤拷锟斤拷锟紹ase64锟斤拷锟诫处锟斤拷  
        InputStream in = null;  
        byte[] data = null;  
        //锟斤拷取图片锟街斤拷锟斤拷锟斤拷  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        Base64 base64=new   Base64() ;
        //锟斤拷锟街斤拷锟斤拷锟斤拷Base64锟斤拷锟斤拷  
//        BASE64Encoder encoder = new BASE64Encoder();  
//        return encoder.encode(data);//锟斤拷锟斤拷Base64锟斤拷锟斤拷锟斤拷锟街斤拷锟斤拷锟斤拷锟街凤拷  
        return new String(base64.encode(data));
    }  
    
  //base64锟街凤拷转锟斤拷锟斤拷图片  
    public static boolean generateImage(String imgStr,String imgFilePath)  
    {   //锟斤拷锟街斤拷锟斤拷锟斤拷锟街凤拷锟斤拷锟紹ase64锟斤拷锟诫并锟斤拷锟酵计�  
        if (imgStr == null) //图锟斤拷锟斤拷锟轿拷锟�  
            return false;  
        try   
        {  
        	  Base64 base64=new   Base64() ;
            //Base64锟斤拷锟斤拷  
            byte[] b =base64.decode(imgStr.getBytes());
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//锟斤拷锟斤拷锟届常锟斤拷锟�  
                    b[i]+=256;  
                }  
            }  
            OutputStream out = new FileOutputStream(imgFilePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        }   
        catch (Exception e)   
        {  
            return false;  
        }  
    }  
    /**
     * 锟斤拷锟斤拷图锟今（帮拷锟斤拷锟斤拷锟斤拷锟脚ｏ拷
     * @param srcImageFile 源图锟斤拷锟侥硷拷锟斤拷址
     * @param result 锟斤拷锟脚猴拷锟酵硷拷锟斤拷址
     * @param scale 锟斤拷锟脚憋拷锟斤拷
     * @param flag 锟斤拷锟斤拷选锟斤拷:true 锟脚达拷; false 锟斤拷小;
     */
    public  static void scale(String srcImageFile, String result,
            int scale, boolean flag) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 锟斤拷锟斤拷锟侥硷拷
            int width = src.getWidth(); // 锟矫碉拷源图锟斤拷
            int height = src.getHeight(); // 锟矫碉拷源图锟斤拷
            if (flag) {// 锟脚达拷
                width = width * scale;
                height = height * scale;
            } else {// 锟斤拷小
                width = width / scale;
                height = height / scale;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_DEFAULT);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 锟斤拷锟斤拷锟斤拷小锟斤拷锟酵�
            g.dispose();
            ImageIO.write(tag, "JPEG", new File(result));// 锟斤拷锟斤拷锟斤拷募锟斤拷锟�
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷锟斤拷图锟今（帮拷锟竭度和匡拷锟斤拷锟斤拷牛锟�
     * @param srcImageFile 源图锟斤拷锟侥硷拷锟斤拷址
     * @param result 锟斤拷锟脚猴拷锟酵硷拷锟斤拷址
     * @param height 锟斤拷锟脚猴拷母叨锟�
     * @param width 锟斤拷锟脚猴拷目锟斤拷
     * @param bb 锟斤拷锟斤拷锟绞憋拷欠锟斤拷锟揭拷锟斤拷祝锟絫rue为锟斤拷锟斤拷; false为锟斤拷锟斤拷锟斤拷;
     */
    public  static void scale(String srcImageFile, String result, int height, int width, boolean bb) {
        try {
            double ratio = 0.0; // 锟斤拷锟脚憋拷锟斤拷
            File f = new File(srcImageFile);
            BufferedImage bi = ImageIO.read(f);
            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
            // 锟斤拷锟斤拷锟斤拷锟�
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue()
                            / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(AffineTransform
                        .getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {//锟斤拷锟斤拷
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null))
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                else
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                g.dispose();
                itemp = image;
            }
            ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 图锟斤拷锟叫革拷(锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷涂锟斤拷锟叫革拷)
     * @param srcImageFile 源图锟斤拷锟街�
     * @param result 锟斤拷片锟斤拷锟酵硷拷锟斤拷址
     * @param x 目锟斤拷锟斤拷片锟斤拷锟斤拷锟斤拷X
     * @param y 目锟斤拷锟斤拷片锟斤拷锟斤拷锟斤拷Y
     * @param width 目锟斤拷锟斤拷片锟斤拷锟�
     * @param height 目锟斤拷锟斤拷片锟竭讹拷
     */
    public  static void cut(String srcImageFile, String result,
            int x, int y, int width, int height) {
        try {
            // 锟斤拷取源图锟斤拷
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getHeight(); // 源图锟斤拷锟�
            int srcHeight = bi.getWidth(); // 源图锟竭讹拷
            if (srcWidth > 0 && srcHeight > 0) {
                Image image = bi.getScaledInstance(srcWidth, srcHeight,
                        Image.SCALE_DEFAULT);
                // 锟侥革拷锟斤拷锟斤拷直锟轿硷拷锟斤拷锟斤拷锟斤拷锟酵匡拷锟�
                // 锟斤拷: CropImageFilter(int x,int y,int width,int height)
                ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
                Image img = Toolkit.getDefaultToolkit().createImage(
                        new FilteredImageSource(image.getSource(),
                                cropFilter));
                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                Graphics g = tag.getGraphics();
                g.drawImage(img, 0, 0, width, height, null); // 锟斤拷锟斤拷锟叫革拷锟斤拷图
                g.dispose();
                // 锟斤拷锟轿拷募锟�
                ImageIO.write(tag, "JPEG", new File(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    




    /**
     * 图锟斤拷锟斤拷锟斤拷转锟斤拷锟斤拷GIF->JPG锟斤拷GIF->PNG锟斤拷PNG->JPG锟斤拷PNG->GIF(X)锟斤拷BMP->PNG
     * @param srcImageFile 源图锟斤拷锟街�
     * @param formatName 锟斤拷锟绞斤拷锟斤拷锟绞斤拷锟狡碉拷 String锟斤拷锟斤拷JPG锟斤拷JPEG锟斤拷GIF锟斤拷
     * @param destImageFile 目锟斤拷图锟斤拷锟街�
     */
    public  static void convert(String srcImageFile, String formatName, String destImageFile) {
        try {
            File f = new File(srcImageFile);
            f.canRead();
            f.canWrite();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, formatName, new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷色转为锟节帮拷 
     * @param srcImageFile 源图锟斤拷锟街�
     * @param destImageFile 目锟斤拷图锟斤拷锟街�
     */
    public  static void gray(String srcImageFile, String destImageFile) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "JPEG", new File(destImageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷图片锟斤拷锟斤拷锟斤拷锟剿�
     * @param pressText 水印锟斤拷锟斤拷
     * @param srcImageFile 源图锟斤拷锟街�
     * @param destImageFile 目锟斤拷图锟斤拷锟街�
     * @param fontName 水印锟斤拷锟斤拷锟斤拷锟斤拷锟�
     * @param fontStyle 水印锟斤拷锟斤拷锟斤拷锟斤拷式
     * @param color 水印锟斤拷锟斤拷锟斤拷锟斤拷色
     * @param fontSize 水印锟斤拷锟斤拷锟斤拷锟叫�
     * @param x 锟斤拷锟斤拷值
     * @param y 锟斤拷锟斤拷值
     * @param alpha 透锟斤拷锟饺ｏ拷alpha 锟斤拷锟斤拷锟角凤拷围 [0.0, 1.0] 之锟节ｏ拷锟斤拷呓锟街碉拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
     */
    public  static void pressText(String pressText,
            String srcImageFile, String destImageFile, String fontName,
            int fontStyle, Color color, int fontSize,int x,
            int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷水印锟斤拷锟斤拷
            g.drawString(pressText, (width - (getLength(pressText) * fontSize))
                    / 2 + x, (height - fontSize) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));// 锟斤拷锟斤拷锟斤拷募锟斤拷锟�
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷图片锟斤拷锟斤拷锟斤拷锟剿�
     * @param pressText 水印锟斤拷锟斤拷
     * @param srcImageFile 源图锟斤拷锟街�
     * @param destImageFile 目锟斤拷图锟斤拷锟街�
     * @param fontName 锟斤拷锟斤拷锟斤拷锟�
     * @param fontStyle 锟斤拷锟斤拷锟斤拷式
     * @param color 锟斤拷锟斤拷锟斤拷色
     * @param fontSize 锟斤拷锟斤拷锟叫�
     * @param x 锟斤拷锟斤拷值
     * @param y 锟斤拷锟斤拷值
     * @param alpha 透锟斤拷锟饺ｏ拷alpha 锟斤拷锟斤拷锟角凤拷围 [0.0, 1.0] 之锟节ｏ拷锟斤拷呓锟街碉拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
     */
    public  static void pressText2(String pressText, String srcImageFile,String destImageFile,
            String fontName, int fontStyle, Color color, int fontSize, int x,
            int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            g.setColor(color);
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            // 锟斤拷指锟斤拷锟斤拷锟斤拷锟斤拷水印锟斤拷锟斤拷
            g.drawString(pressText, (width - (getLength(pressText) * fontSize))
                    / 2 + x, (height - fontSize) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷图片锟斤拷锟酵计�
     * @param pressImg 水印图片
     * @param srcImageFile 源图锟斤拷锟街�
     * @param destImageFile 目锟斤拷图锟斤拷锟街�
     * @param x 锟斤拷锟斤拷值锟斤拷 默锟斤拷锟斤拷锟叫硷拷
     * @param y 锟斤拷锟斤拷值锟斤拷 默锟斤拷锟斤拷锟叫硷拷
     * @param alpha 透锟斤拷锟饺ｏ拷alpha 锟斤拷锟斤拷锟角凤拷围 [0.0, 1.0] 之锟节ｏ拷锟斤拷呓锟街碉拷锟斤拷锟揭伙拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
     */
    public  static void pressImage(String pressImg, String srcImageFile,String destImageFile,
            int x, int y, float alpha) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            // 水印锟侥硷拷
            Image src_biao = ImageIO.read(new File(pressImg));
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    alpha));
            g.drawImage(src_biao, (wideth - wideth_biao) / 2,
                    (height - height_biao) / 2, wideth_biao, height_biao, null);
            // 水印锟侥硷拷锟斤拷锟斤拷
            g.dispose();
            ImageIO.write((BufferedImage) image,  "JPEG", new File(destImageFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 锟斤拷锟斤拷text锟侥筹拷锟饺ｏ拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟街凤拷
     * @param text
     * @return
     */
    private  static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }
}