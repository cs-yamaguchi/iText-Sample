package jp.co.netcitys.pdf;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.WritableRaster;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;


public class ITextServlet4 extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      FileOutputStream fo = null;
      OutputStream bs = null;
      try {

          bs = response.getOutputStream();

          BarcodeQRCode qr = new BarcodeQRCode("http://www.google.co.jp", 100, 100, null);
          qr.createAwtImage(Color.WHITE, Color.BLACK);
          Image img = qr.getImage();

          response.setContentType("image/png");

          BufferedImage image = toBufferedImage(qr.createAwtImage( Color.black, Color.white ));
          ImageIO.write( image, "png", bs );

      } catch (Exception e) {
              // めんどくさいのでまとめてキャッチ
              // 行儀は良くない
      } finally {
        bs.close();
              // 他にもStreamをクローズ
      }
  }

  public static BufferedImage toBufferedImage(java.awt.Image image) {

      PixelGrabber pixelGrabber = new PixelGrabber( image, 0, 0, -1, -1, false );
      try {
          pixelGrabber.grabPixels();
      } catch(InterruptedException e) {
          return null;
      }
      ColorModel colorModel = pixelGrabber.getColorModel();
      WritableRaster raster = colorModel.createCompatibleWritableRaster( pixelGrabber.getWidth(), pixelGrabber.getHeight() );
      BufferedImage bufferdImage = new BufferedImage( colorModel, raster, colorModel.isAlphaPremultiplied(), new Hashtable() );
      bufferdImage.getRaster().setDataElements( 0, 0, pixelGrabber.getWidth(), pixelGrabber.getHeight(), pixelGrabber.getPixels() );

      return bufferdImage;
  }

}