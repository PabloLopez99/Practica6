/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import view.*;
/**
 *
 * @author pabloantoniolopezmartin
 */
public class ImageHandler {
    

    public static void openImage(File fichero){
        try{
           BufferedImage image= ImageIO.read(fichero);
           fichero=fichero;
           Lienzo.setImage(image);
        }catch(Exception e){
            
        }
    }

    public static void saveImage(String path) throws IOException {
        System.out.println(path);
        System.out.println(Lienzo.getImage().getWidth());
        
        BufferedImage bi = Lienzo.getImage();
        File outputfile = new File(path);
        ImageIO.write(bi, "png", outputfile);


        //Mat m= new Mat(Lienzo.getImage().getWidth(),Lienzo.getImage().getHeight(),CvType.CV_8UC3);
     //   byte[] pixels = ((DataBufferByte) Lienzo.getImage().getRaster().getDataBuffer()).getData();
        
       // m.put(0, 0, pixels, 7, pixels.length);
       
        
        // Imgcodecs.imwrite(Lienzo.getImage().toString(),fichero.getAbsolutePath());

       // Imgcodecs.imwrite(path,bufferedImageToMat(Lienzo.getImage()));
       // BufferedImage img = new BufferedImage(320, 240, BufferedImage.TYPE_3BYTE_BGR);
        //img.setRGB(0, 0, 320, 240, pixels, 0, 320);
        
    }
    public static Mat bufferedImageToMat(BufferedImage bi) {
         Mat mat = new Mat(bi.getHeight(), bi.getWidth(), CvType.CV_8UC3);
        byte[] data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        mat.put(0, 0, data);
        return mat;
}
    public static Mat matify(BufferedImage sourceImg) {

    long millis = System.currentTimeMillis();

    DataBuffer dataBuffer = sourceImg.getRaster().getDataBuffer();
    byte[] imgPixels = null;
    Mat imgMat = null;

    int width = sourceImg.getWidth();
    int height = sourceImg.getHeight();

    if(dataBuffer instanceof DataBufferByte) {      
            imgPixels = ((DataBufferByte)dataBuffer).getData();
    }

    if(dataBuffer instanceof DataBufferInt) {

        int byteSize = width * height;      
        imgPixels = new byte[byteSize*3];

        int[] imgIntegerPixels = ((DataBufferInt)dataBuffer).getData();

        for(int p = 0; p < byteSize; p++) {         
            imgPixels[p*3 + 0] = (byte) ((imgIntegerPixels[p] & 0x00FF0000) >> 16);
            imgPixels[p*3 + 1] = (byte) ((imgIntegerPixels[p] & 0x0000FF00) >> 8);
            imgPixels[p*3 + 2] = (byte) (imgIntegerPixels[p] & 0x000000FF);
        }
    }

    if(imgPixels != null) {
        imgMat = new Mat(height, width, CvType.CV_8UC3);
        imgMat.put(0, 0, imgPixels);
    }

    System.out.println("matify exec millis: " + (System.currentTimeMillis() - millis));

    return imgMat;
}
    
    private static Mat img2Mat(BufferedImage in)
    {
          Mat out;
          byte[] data;
          int r, g, b;

          if(in.getType() == BufferedImage.TYPE_INT_RGB)
          {
              out = new Mat(in.getWidth(), in.getHeight(), CvType.CV_8UC3);
              data = new byte[in.getWidth() * in.getHeight() * (int)out.elemSize()];
              int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
              for(int i = 0; i < dataBuff.length; i++)
              {
                  data[i*3] = (byte) ((dataBuff[i] >> 16) & 0xFF);
                  data[i*3 + 1] = (byte) ((dataBuff[i] >> 8) & 0xFF);
                  data[i*3 + 2] = (byte) ((dataBuff[i] >> 0) & 0xFF);
              }
          }
          else
          {
              out = new Mat(240, 320, CvType.CV_8UC1);
              data = new byte[320 * 240 * (int)out.elemSize()];
              int[] dataBuff = in.getRGB(0, 0, 320, 240, null, 0, 320);
              for(int i = 0; i < dataBuff.length; i++)
              {
                r = (byte) ((dataBuff[i] >> 16) & 0xFF);
                g = (byte) ((dataBuff[i] >> 8) & 0xFF);
                b = (byte) ((dataBuff[i] >> 0) & 0xFF);
                data[i] = (byte)((0.21 * r) + (0.71 * g) + (0.07 * b)); //luminosity
              }
           }
           out.put(0, 0, data);
           return out;
     }

    public static void applyThreshold(File fichero,Integer umbral) throws IOException {
       nu.pattern.OpenCV.loadShared(); System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
  
         
  
         Mat mat2= Imgcodecs.imread(fichero.getAbsolutePath());
         
         mat2= umbralizar(mat2,umbral);
         
         
         BufferedImage image=(BufferedImage) HighGui.toBufferedImage(mat2);
         Lienzo.setImage(image);
        
         
    }
    private static  Mat umbralizar(Mat imagen_original, Integer umbral) { // crear dos imágenes en niveles de gris con el mismo
// crear dos imágenes en niveles de gris con el mismo        
// tamaño que la original
        Mat imagenGris = new Mat(imagen_original.rows(),
                                imagen_original.cols(),
                                CvType.CV_8U);
        
        Mat imagenUmbralizada = new Mat(imagen_original.rows(),
                                        imagen_original.cols(), 
                                        CvType.CV_8U);
        
       // convierte a niveles de grises la imagen original
        Imgproc.cvtColor(imagen_original,imagenGris, Imgproc.COLOR_BGR2GRAY);
        
// umbraliza la imagen:
// - píxeles con nivel de gris > umbral se ponen a 1 
// - píxeles con nivel de gris <= umbra se ponen a 0
        Imgproc.threshold(imagenGris,
                          imagenUmbralizada, 
                          umbral,
                          255,
                          Imgproc.THRESH_BINARY);
        return imagenUmbralizada;

        }
}

