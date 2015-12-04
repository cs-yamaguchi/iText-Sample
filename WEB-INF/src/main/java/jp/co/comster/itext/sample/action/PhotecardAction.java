package jp.co.comster.itext.sample.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ServletContextUtil;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

import jp.co.comster.itext.sample.Const;
import jp.co.comster.itext.sample.form.ImagepdfActionForm;

/**
 *
 * PhotecardActionクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/12/04 1.0　COMSTER Yamaguchi 新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
@Component(instance= InstanceType.REQUEST)
public class PhotecardAction extends AbstractAction {

//	@Resource
//	private TypeProperties typeProperties;

	@ActionForm
	@Resource
	protected ImagepdfActionForm imagepdfActionForm;

	/**
	 * 初期読込
	 * @return
	 */
	@Execute(validator = false, removeActionForm = true)
	public String index() {
		return Const.DEFAULT_PAGE;
	}

	/**
	 * 取り込み
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws WriterException
	 */
	@Execute(validator = false, removeActionForm = true)
	public String pdf() throws DocumentException, IOException, WriterException {

		if (imagepdfActionForm.uploadfile == null)
			return Const.DEFAULT_PAGE;

	    ByteArrayOutputStream byteout = new ByteArrayOutputStream();
	    Rectangle rectangle = new Rectangle(1338, 906);
	    Document doc = new Document(rectangle, 0, 0, 0, 0);
	    doc.addAuthor("Comster Yamaguchi");
	    doc.addTitle("iText Sample");
	    doc.addSubject("PhoteCard");
	    doc.addCreationDate();

		PdfWriter pdfwriter = PdfWriter.getInstance(doc, byteout);
		doc.open();

		//PdfContentByteの取得
		PdfContentByte pdfContentByte = pdfwriter.getDirectContent();

		Image img = Image.getInstance(((FormFile)imagepdfActionForm.uploadfile).getFileData());
//		img.scalePercent(72.0f / 96.0f * 100f);

		//表示位置の設定(※)
		img.setAbsolutePosition(17, 482);

		//表示サイズの設定
		img.scaleAbsolute(407, 623);

		//画像を９０度回転
		float radian = (float)(90 / 180.0 * 3.141592);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);


		img = Image.getInstance(((FormFile)imagepdfActionForm.uploadfile).getFileData());

		//表示位置の設定(※)
		img.setAbsolutePosition(17, 17);

		//表示サイズの設定
		img.scaleAbsolute(297, 407);

		//文章に画像を追加する
		pdfContentByte.addImage(img);


		img = Image.getInstance(((FormFile)imagepdfActionForm.uploadfile).getFileData());

		//表示位置の設定(※)
		img.setAbsolutePosition(343, 17);

		//表示サイズの設定
		img.scaleAbsolute(297, 407);

		//文章に画像を追加する
		pdfContentByte.addImage(img);



		//Imageインスタンスの作成
		img = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "WEB-INF/classes/area_a.jpg");

		//表示位置の設定(※)
		img.setAbsolutePosition(686, 10);

		//表示サイズの設定
		img.scaleAbsolute(646, 889);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		//ページ追加
		doc.newPage();

		//Imageインスタンスの作成
		img = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "WEB-INF/classes/area_b.jpg");

		//表示位置の設定(※)
		img.setAbsolutePosition(17, 482);

		//表示サイズの設定
		img.scaleAbsolute(430, 646);

		//画像を９０度回転
		radian = (float)(-90 / 180.0 * 3.141592);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		//画像を９０度回転
		radian = (float)(-90 / 180.0 * 3.141592);

		//Imageインスタンスの作成
		img = Image.getInstance( Create("〒000-0000"));

		//表示位置の設定(※)
		img.setAbsolutePosition(480, 100);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		//Imageインスタンスの作成
		img = Image.getInstance( Create("○○県○○市○区○○○町○○－○"));

		//表示位置の設定(※)
		img.setAbsolutePosition(455, 100);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		//Imageインスタンスの作成
		img = Image.getInstance( Create("○○○マンション３０１"));

		//表示位置の設定(※)
		img.setAbsolutePosition(430, 100);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		//Imageインスタンスの作成
		img = Image.getInstance( Create("○○　○○ 様"));

		//表示位置の設定(※)
		img.setAbsolutePosition(380, 100);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		BarcodeFormat format = BarcodeFormat.QR_CODE;
		int width = 100;
		int height = 100;

		Hashtable<EncodeHintType, ErrorCorrectionLevel> hints = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

		QRCodeWriter writer = new QRCodeWriter();
		BitMatrix bitMatrix = writer.encode(imagepdfActionForm.freetext, format, width, height, hints);

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		BufferedOutputStream os = new BufferedOutputStream(bos);

		ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "png", os);
		os.flush();
		os.close();

		//Imageインスタンスの作成
		img = Image.getInstance(bos.toByteArray());

		//表示位置の設定(※)
		img.setAbsolutePosition(355, 65);
		img.setRotation(radian);

		//文章に画像を追加する
		pdfContentByte.addImage(img);

		doc.close();

		response.setContentType("application/pdf");
//		response.setContentType("application/octet-stream");
		response.setHeader("Expires",					"-1");
		response.setHeader("Cache-Control",				"no-cache");
		response.setHeader("Pragma",					"no-cache");
//		response.setHeader("Content-disposition",		"attachment; filename=\"" + ((FormFile)imagepdfActionForm.uploadfile).getFileName() + ".pdf\"");
		response.setHeader("Content-disposition",		"inline; filename=\"" + ((FormFile)imagepdfActionForm.uploadfile).getFileName() + ".pdf\"");
		response.setHeader("X-Content-Type-Options",	"nosniff");
		response.setHeader("X-XSS-Protection",			"1; mode=block");
		response.setHeader("X-Frame-Options",			"SAMEORIGIN");

	    response.setContentLength(byteout.size());
	    OutputStream out;
		try {
			out = response.getOutputStream();
		    out.write(byteout.toByteArray());
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		pdfwriter.close();
		return null;
	}


	public byte[] Create(String str) {
		int w = 286;
		int h = 100;
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		Font font = new Font("メイリオ", Font.BOLD, 14);
		g2d.setFont(font);
		g2d.setBackground(Color.WHITE);
		g2d.clearRect(0, 0, w, h);
		g2d.setColor(Color.BLACK);
		g2d.drawString(str, 15, 15);
		g2d.dispose();
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    BufferedOutputStream os = new BufferedOutputStream(bos);
	    image.flush();
	    try {
			ImageIO.write(image, "jpg", os);
		    os.flush();
		    os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return bos.toByteArray();
	}
}