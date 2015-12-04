package jp.co.comster.itext.sample.action;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.struts.upload.FormFile;
import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.co.comster.itext.sample.Const;
import jp.co.comster.itext.sample.form.ImagepngActionForm;

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
public class ImagepngAction extends AbstractAction {

//	@Resource
//	private TypeProperties typeProperties;

	@ActionForm
	@Resource
	protected ImagepngActionForm imagepngActionForm;

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
	 */
	@Execute(validator = false, removeActionForm = true)
	public String png() throws IOException {

		if (imagepngActionForm.uploadfileOver == null || imagepngActionForm.uploadfileUnder == null)
			return Const.DEFAULT_PAGE;

//	    ByteArrayOutputStream byteout = new ByteArrayOutputStream();

//		//Imageインスタンスの作成
//		Image bgimg = Image.getInstance(ServletContextUtil.getServletContext().getRealPath("") + "WEB-INF/classes/mzl.btncrqaa.png");
//
//		//表示位置の設定(※)
//		bgimg.setAbsolutePosition(0, 0);
//
//		//表示サイズの設定
//		bgimg.scaleAbsolute(800, 600);


//	    Font font_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
//		Font hoge1 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),12);
//		Font hoge2 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),40, Font.BOLD);
//		Font hoge3 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 21,  Font.BOLD);


//		Image img = Image.getInstance(((FormFile)imagepngActionForm.uploadfileOver).getFileData());
//		img.scalePercent(72.0f / 96.0f * 100f);


		response.setContentType("image/jpeg");
//		response.setContentType("application/pdf");
//		response.setContentType("application/octet-stream");
		response.setHeader("Expires",					"-1");
		response.setHeader("Cache-Control",				"no-cache");
		response.setHeader("Pragma",					"no-cache");
//		response.setHeader("Content-disposition",		"attachment; filename=\"" + ((FormFile)imagepngActionForm.uploadfileOver).getFileName() + ".jpg\"");
//		response.setHeader("Content-disposition",		"inline; filename=\"" + ((FormFile)imagepngActionForm.uploadfileOver).getFileName() + ".jpg\"");
//		response.setHeader("X-Content-Type-Options",	"nosniff");
//		response.setHeader("X-XSS-Protection",			"1; mode=block");
//		response.setHeader("X-Frame-Options",			"SAMEORIGIN");

//	    response.setContentLength(byteout.size());


		BufferedImage img =  ImageIO.read(((FormFile)imagepngActionForm.uploadfileUnder).getInputStream());
		BufferedImage img2 = ImageIO.read(((FormFile)imagepngActionForm.uploadfileOver).getInputStream());
		Graphics2D gr = img.createGraphics();
		gr.drawImage(img2,100,100,null);
		gr.dispose();
//		ImageIO.write(img, "jpg", new File("sample496a.jpg"));

//		response.setContentLength();

//		final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//		byteOut.write( ((FormFile)imagepngActionForm.uploadfileUnder).getFileData(), 0, ((FormFile)imagepngActionForm.uploadfileUnder).getFileData().length);
//		byteOut.write( ((FormFile)imagepngActionForm.uploadfileOver).getFileData(), 0, ((FormFile)imagepngActionForm.uploadfileOver).getFileData().length);
	    OutputStream out;
		try {
			out = response.getOutputStream();
		    out.write(getImageBytes(img, "png"));
//		    out.write(byteOut.toByteArray());
//			out.write(((FormFile)imagepngActionForm.uploadfileUnder).getFileData());
//			out.write(((FormFile)imagepngActionForm.uploadfileOver).getFileData());
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		byteOut.close();
		return null;
	}
	  /**
	   * 画像オブジェクトを指定した画像フォーマットのバイナリ表現に変換します。
	   * @param image 画像オブジェクト
	   * @param imageFormat 画像フォーマット
	   * @return バイナリ表現
	   */
	  public static byte[] getImageBytes(BufferedImage image, String imageFormat)  throws IOException {
	    ByteArrayOutputStream bos = new ByteArrayOutputStream();
	    BufferedOutputStream os = new BufferedOutputStream(bos);
	    image.flush();
	    ImageIO.write(image, imageFormat, os);
	    os.flush();
	    os.close();
	    return bos.toByteArray();
	  }
}