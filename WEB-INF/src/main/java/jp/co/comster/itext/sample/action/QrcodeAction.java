package jp.co.comster.itext.sample.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import jp.co.comster.itext.sample.Const;
import jp.co.comster.itext.sample.form.QrcodeActionForm;

/**
 *
 * CryptographyActionクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/08/25 1.0　COMSTER Yamaguchi 新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
@Component(instance= InstanceType.REQUEST)
public class QrcodeAction extends AbstractAction {

	@ActionForm
	@Resource
	protected QrcodeActionForm qrcodeActionForm;

	/**
	 * 初期読込
	 * @return
	 */
	@Execute(validator = false, removeActionForm = true)
	public String index() {
		return Const.DEFAULT_PAGE;
	}

	/**
	 * QRコード
	 * @return
	 * @throws IOException
	 * @throws WriterException
	 */
	@Execute(validator = false, removeActionForm = true)
	public String qrcode() throws IOException, WriterException {

//	      FileOutputStream fo = null;
	      OutputStream bs = null;
          BufferedImage image = null;
	      try {

	          bs = response.getOutputStream();

//	          BarcodeQRCode qr = new BarcodeQRCode(qrcodeActionForm.freetext, 100, 100, null);
//	          qr.createAwtImage(Color.WHITE, Color.BLACK);
//	          Image img = qr.getImage();

	          response.setContentType("image/png");

//	          image = toBufferedImage(qr.createAwtImage( Color.black, Color.white ));


//
//	          BarcodeEAN barcode = new BarcodeEAN();
//	          barcode.setBarHeight(100);
//	          barcode.setSize(100);
//	          barcode.setCodeType( Barcode.EAN13 );
//	          barcode.setCode( qrcodeActionForm.freetext );
//              image = toBufferedImage( barcode.createAwtImage( Color.black, Color.white ) );


	          BarcodeFormat format = BarcodeFormat.QR_CODE;
	          int width = 100;
	          int height = 100;

	          Hashtable<EncodeHintType, ErrorCorrectionLevel> hints = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
	          hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

	          QRCodeWriter writer = new QRCodeWriter();
	          BitMatrix bitMatrix = writer.encode(qrcodeActionForm.freetext, format, width, height, hints);
	          image = MatrixToImageWriter.toBufferedImage(bitMatrix);


              ImageIO.write( image, "png", bs );
	      } finally {
	          bs.close();
	      }

		return null;
	}

//	private static BufferedImage toBufferedImage(java.awt.Image image) {
//
//		PixelGrabber pixelGrabber = new PixelGrabber( image, 0, 0, -1, -1, false );
//		try {
//			pixelGrabber.grabPixels();
//		} catch(InterruptedException e) {
//			return null;
//		}
//		ColorModel colorModel = pixelGrabber.getColorModel();
//		WritableRaster raster = colorModel.createCompatibleWritableRaster( pixelGrabber.getWidth(), pixelGrabber.getHeight() );
//		BufferedImage bufferdImage = new BufferedImage( colorModel, raster, colorModel.isAlphaPremultiplied(), new Hashtable<Object, Object>() );
//		bufferdImage.getRaster().setDataElements( 0, 0, pixelGrabber.getWidth(), pixelGrabber.getHeight(), pixelGrabber.getPixels() );
//		return bufferdImage;
//	}

}