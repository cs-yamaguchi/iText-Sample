package jp.co.comster.itext.sample.action;

import java.awt.Color;
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
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jp.co.comster.itext.sample.Const;
import jp.co.comster.itext.sample.form.ImagepdfActionForm;

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
public class ImagepdfAction extends AbstractAction {

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
//	    Rectangle rectangle = new Rectangle(800, 600);
	    Rectangle rectangle = new Rectangle(1058, 875);
	    Document doc = new Document(rectangle, 0, 0, 0, 0);
	    doc.addAuthor("Benesse Corporation");
	    doc.addTitle("たまひよ");
	    doc.addSubject("フォトカード");
	    doc.addCreationDate();

		PdfWriter pdfwriter = PdfWriter.getInstance(doc, byteout);
		doc.open();


//		//Imageインスタンスの作成
//		Image bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "WEB-INF/classes/mzl.btncrqaa.png");
//
//		//表示位置の設定(※)
//		bgimg.setAbsolutePosition(0, 0);
//
//		//表示サイズの設定
//		bgimg.scaleAbsolute(800, 600);
//
//		//PdfContentByteの取得
//		PdfContentByte pdfContentByte = pdfwriter.getDirectContent();
//
//		//文章に画像を追加する
//		pdfContentByte.addImage(bgimg);


//	    Font font_w_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
		Font font_w_m12 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),12);
		Font font_w_m32_red = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),32, Font.BOLD, new Color(255,0,0));
		Font font_h_m21 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 18,  Font.BOLD);

        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(1058);
        table.setLockedWidth(true);
        table.setExtendLastRow(true);
        table.getDefaultCell().setFixedHeight(446);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);


//        PdfPCell cell;
//        cell = new PdfPCell(new Paragraph("iTextサンプル",font_m10));
//        cell.setColspan(3);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(Color.ORANGE);
//        table.addCell(cell);


      PdfPTable table2 = new PdfPTable(5);
      table2.setTotalWidth(358);
      table2.setLockedWidth(true);
      table2.setExtendLastRow(true);
      table2.getDefaultCell().setFixedHeight(400);
      table2.getDefaultCell().setBorder(Rectangle.NO_BORDER);

      table2.setWidths(new int[]{50,(358-50)/4,(358-50)/4,(358-50)/4,(358-50)/4});
      table2.setHorizontalAlignment(Element.ALIGN_LEFT);

      PdfPCell cell;

      cell = new PdfPCell(new Paragraph("7 0 0 - 0 0 3 4",font_w_m12));
      cell.setColspan(5);
      cell.setFixedHeight(18);
      cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      cell.setBorder(Rectangle.NO_BORDER);
      table2.addCell(cell);

      cell = new PdfPCell();
      cell.setNoWrap(true);
      cell.setBorder(Rectangle.NO_BORDER);
      cell.setVerticalAlignment(Element.ALIGN_RIGHT);
      cell.setHorizontalAlignment(Element.ALIGN_TOP);
//      cell.setBackgroundColor(Color.CYAN);
      table2.addCell(cell);

      Paragraph paragraph = new Paragraph("送り主Ａ",font_h_m21);
      paragraph.setAlignment( Element.ALIGN_MIDDLE );
      cell = new PdfPCell(paragraph);
      cell.setNoWrap(true);
      cell.setBorder(Rectangle.NO_BORDER);
//      cell.setVerticalAlignment(Element.ALIGN_RIGHT);
//      cell.setHorizontalAlignment(Element.ALIGN_TOP);
//      cell.setBackgroundColor(Color.BLUE);
      table2.addCell(cell);

      cell = new PdfPCell(new Paragraph("岡山県岡山市北区高柳東町10-1",font_h_m21));
      cell.setNoWrap(true);
      cell.setBorder(Rectangle.NO_BORDER);
      cell.setVerticalAlignment(Element.ALIGN_RIGHT);
      cell.setHorizontalAlignment(Element.ALIGN_TOP);
//      cell.setBackgroundColor(Color.RED);
      table2.addCell(cell);

      cell = new PdfPCell(new Paragraph("宛先Ａ",font_h_m21));
      cell.setNoWrap(true);
      cell.setBorder(Rectangle.NO_BORDER);
      cell.setVerticalAlignment(Element.ALIGN_LEFT);
      cell.setHorizontalAlignment(Element.ALIGN_TOP);
//      cell.setBackgroundColor(Color.BLUE);
      table2.addCell(cell);

      cell = new PdfPCell(new Paragraph("東京都新宿区のあたり",font_h_m21));
      cell.setNoWrap(true);
      cell.setBorder(Rectangle.NO_BORDER);
      cell.setVerticalAlignment(Element.ALIGN_LEFT);
      cell.setHorizontalAlignment(Element.ALIGN_TOP);
//      cell.setBackgroundColor(Color.RED);
      table2.addCell(cell);

      table.addCell(table2);

      cell = new PdfPCell();
      cell.setBorder(Rectangle.NO_BORDER);
//      table.addCell(cell);

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

      table.addCell(Image.getInstance(bos.toByteArray()));


      cell = new PdfPCell(new Paragraph("\r\n\r\n\r\nたまひよフォトカード\r\nをお送りします。",font_w_m32_red));
      cell.setBorder(Rectangle.NO_BORDER);
      table.addCell(cell);


//		Image img = Image.getInstance(((FormFile)imagepdfActionForm.uploadfile).getFileData());
//		img.scalePercent(72.0f / 96.0f * 100f);

//        PdfPTable table2 = new PdfPTable(1);
//
//        cell = new PdfPCell();
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setImage(img);
//        table.addCell(cell);
//        table.addCell(cell);
//        table.addCell(cell);

//        table2.addCell(cell);
//
//        cell = new PdfPCell(new Paragraph( ((FormFile)imagepdfActionForm.uploadfile).getFileName(),hoge1));
//        cell.setNoWrap(true);
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table2.addCell(cell);
//        table2.setHorizontalAlignment(Element.ALIGN_MIDDLE);
//
//
//        table.addCell(table2);


//        cell = new PdfPCell(new Paragraph(imagepdfActionForm.freetext, hoge2));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_TOP);
//        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//        cell.setFixedHeight(500);
//        cell.setNoWrap(true);
//        table.addCell(cell);
//
//
//        cell = new PdfPCell(new Paragraph("うえーい",hoge3));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        table.addCell(cell);
//
//
//        cell = new PdfPCell(new Paragraph(DateUtil.format(new Date(), "yyyy/MM/dd"), font_m10));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setColspan(3);
//        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cell.setBackgroundColor(Color.red);
//        table.addCell(cell);


//        table.addCell(table2);

        doc.add(table);


		//Imageインスタンスの作成
//		Image bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "WEB-INF/classes/mzl.btncrqaa.png");

        Image img = Image.getInstance(((FormFile)imagepdfActionForm.uploadfile).getFileData());
		img.scalePercent(72.0f / 96.0f * 100f);


        Image bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "img/flower-back0557.png");

		//表示位置の設定(※)
		img.setAbsolutePosition(0, 0);
		bgimg.setAbsolutePosition(0, 0);

		//表示サイズの設定
//		bgimg.scaleAbsolute(800, 600);
		img.scaleAbsolute(358, 452);
		bgimg.scaleAbsolute(358, 452);


		//PdfContentByteの取得
		PdfContentByte pdfContentByte = pdfwriter.getDirectContent();

		//文章に画像を追加する
		pdfContentByte.addImage(img);
		pdfContentByte.addImage(bgimg);

//		bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "img/flower-back0557.png");

		//表示位置の設定(※)
		img.setAbsolutePosition(358, 0);
		bgimg.setAbsolutePosition(358, 0);

		//表示サイズの設定
//		bgimg.scaleAbsolute(800, 600);
//		bgimg.scaleAbsolute(358, 452);



		//文章に画像を追加する
		pdfContentByte.addImage(img);
		pdfContentByte.addImage(bgimg);

//		bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "img/flower-back0557.png");

		//表示位置の設定(※)
		img.setAbsolutePosition(358*2, 0);
		bgimg.setAbsolutePosition(358*2, 0);

		//表示サイズの設定
//		bgimg.scaleAbsolute(800, 600);
		img.scaleAbsolute(343, 452);
		bgimg.scaleAbsolute(343, 452);

		//文章に画像を追加する
		pdfContentByte.addImage(img);
		pdfContentByte.addImage(bgimg);


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

}