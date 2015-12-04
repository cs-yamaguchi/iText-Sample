package jp.co.netcitys.pdf;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class ITextServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  	//入力画面から送信されてきた名称を表示します。
  	request.setCharacterEncoding("Shift-JIS");
  	String strName =request.getParameter("input_name");;

  	//出力用のStreamをインスタンス化します。
    ByteArrayOutputStream byteout = new ByteArrayOutputStream();

    //文書オブジェクトを生成
    //ページサイズを設定します。
    Rectangle rectangle = new Rectangle(283, 420);
    Document doc = new Document(rectangle, 0, 0, 0, 0);

	doc.setPageCount(1);
    try {
		//アウトプットストリームをPDFWriterに設定します。
		PdfWriter pdfwriter = PdfWriter.getInstance(doc, byteout);

        Font font_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
		Font hoge1 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 12,  Font.BOLD);
		Font hoge2 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 43, Font.BOLD);
		Font hoge3 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 21,  Font.BOLD);

		/* フォント設定部 */
		//(ゴシック15pt(太字)
		Font font_header = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),12,Font.BOLD);
//	    //ゴシック11pt
//		Font font_g11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11);
//	    //ゴシック10pt
//		Font font_g10 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),10);
//		//明朝10pt
//		Font font_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
//	    //ゴシック11pt(下線あり)
//		Font font_underline_11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11,Font.UNDERLINE);
//		//ゴシック11pt(赤)
//		Font font_red_11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11);
//		font_red_11.setColor(new Color(255,0,0));
		//空白セル用フォント(非表示)
//		Font font_empty = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),9);
//		font_empty.setColor(new Color(255,255,255));

		//出力するPDFに説明を付与します。
//		doc.addAuthor("岡 雅久");
//		doc.addSubject("iTextサンプル");

//		//ヘッダーの設定をします。
//		HeaderFooter header = new HeaderFooter(new Phrase("ウィメンズパーク　みんなの名づけ", font_header), false);
//		header.setTop(5);
//		header.setAlignment(Element.ALIGN_CENTER);
//		doc.setHeader(header);
//		//フッターの設定をします。
//		HeaderFooter footer = new HeaderFooter(new Phrase("--- ＳＡＭＰＬＥ 84 * 63 ---",  font_header), false);
//		footer.setAlignment(Element.ALIGN_CENTER);
//		footer.setBorder(Rectangle.NO_BORDER);
//		doc.setFooter(footer);

		//文章の出力を開始します。
		doc.open();

//		Paragraph para_1 = new Paragraph("平成二十一年七月十四日生", hoge1);
//		para_1.setAlignment(Element.ALIGN_LEFT);
//		para_1.setFirstLineIndent(1000);
//		doc.add(para_1);
//
//		Paragraph para_2 = new Paragraph(strName, hoge2);
//		para_2.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_2);
//
//		Paragraph para_3 = new Paragraph("命名", hoge3);
//		para_3.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_3);

////		Image img = Image.getInstance("C:\\usr\\var\\workspace3.4\\iText\\logo_wp.gif");
		final String standardInfomation = super.getServletContext().getRealPath("060906.jpg");
		Image img = Image.getInstance(standardInfomation);

		img.scalePercent(72.0f / 96.0f * 100f);
//		// PDF(72dpi)とWindows(96dpi)の画面解像度の違いを補正する。
////		img.scalePercent(72.0f / 96.0f * 100f);
////		img.setAbsolutePosition(350, 200);
//		img.setAbsolutePosition(100, 340);
//		img.setAlignment(Element.ALIGN_BOTTOM);
//		doc.add(img);

//	    Paragraph p = new Paragraph();
//	    float pageWidth = doc.right() - doc.left();
//	    // 紙の横幅に合わせて拡大or縮小
//		Image img2 = getImage(super.getServletContext().getRealPath("mafd_mcl.gif"), pageWidth);
//		p.add(new Chunk(img2, 0, 0, true));
////		p.add(new Chunk(files[i]));
//		p.add(Chunk.NEWLINE);
//
//	    doc.add(p);


		/* 売上実績表のテーブルを作成します */
		//帳票明細の条件部分を設定します。
//		doc.add(new Paragraph("2005年5月実績", font_red_11));
//		Paragraph para_1 = new Paragraph("担当者：" +  strName, font_g11);
//		para_1.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_1);
//		doc.add(new Paragraph(""));
//		Paragraph para_2 = new Paragraph("商品名：△△△△", font_underline_11);
//		para_2.setAlignment(Element.ALIGN_LEFT);
//		doc.add(para_2);

//		//帳票明細の明細行を設定します
//		Table uriage_table = new Table(4);
//
//		//売上テーブル全体の幅を設定します。
//		uriage_table.setWidth(100);
//		//テーブル各列の幅をパーセンテージで設定します。
//		int uriage_table_width[] = {10,20,40,30};
//		uriage_table.setWidths(uriage_table_width);
//		//テーブルのデフォルトの表示位置（横）を設定します。
//		uriage_table.setDefaultHorizontalAlignment(Element.ALIGN_CENTER);
//		//テーブルのデフォルトの表示位置（縦）を設定します。
//		uriage_table.setDefaultVerticalAlignment(Element.ALIGN_MIDDLE);
//		//テーブルの余白を設定します。
//		uriage_table.setPadding(3);
//		//テーブルのセル間の間隔を設定します。
//		uriage_table.setSpacing(0);
//		//テーブルの線の色を設定します。
//		uriage_table.setBorderColor(new Color(0, 0, 0));

//		//明細行の項目名部分のセルの設定を行います
//		//（セルに網掛け設定を行います）
//		Cell cell_11 = new Cell(new Phrase("順位", font_g10));
//		cell_11.setGrayFill(0.8f);
//		Cell cell_21 = new Cell(new Phrase("顧客コード", font_g10));
//		cell_21.setGrayFill(0.8f);
//		Cell cell_31 = new Cell(new Phrase("顧客名称", font_g10));
//		cell_31.setGrayFill(0.8f);
//		Cell cell_41 = new Cell(new Phrase("金額", font_g10));
//		cell_41.setGrayFill(0.8f);
//
//		//テーブルにセルを設定します
//		uriage_table.addCell(cell_11);
//		uriage_table.addCell(cell_21);
//		uriage_table.addCell(cell_31);
//		uriage_table.addCell(cell_41);

//		//明細データを設定します
//		String[][] uriage_data = {
//		{"1", "AA-001", "○○物産", "100,000"},
//		{"2", "BB-001", "△△商事", "20,000"},
//		{"3", "CC-001", "□□商店", "10,000"},
//		{"4", "DD-001", "×××実業", "5,000"},
//		{"5", "EE-001", "○○運送", "1,000"},
//		{"6", "FF-001", "▲▲サービス", "500"},
//		{"7", "GG-001", "○○システム", "300"},
//		{"8", "HH-001", "○○産業", "100"},};
//		for(int i = 0; i < uriage_data.length; i++){
//			Cell cell = new Cell(new Phrase(uriage_data[i][0], font_m10));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			uriage_table.addCell(cell);
//			cell = new Cell(new Phrase(uriage_data[i][1], font_m10));
//			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//			uriage_table.addCell(cell);
//			cell = new Cell(new Phrase(uriage_data[i][2], font_m10));
//			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//			uriage_table.addCell(cell);
//			cell = new Cell(new Phrase(uriage_data[i][3], font_m10));
//			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//			uriage_table.addCell(cell);
//		}
		//空行を追加します。
//		Cell Empty_Cell = new Cell(new Phrase("empty", font_empty));
//		for (int i = uriage_data.length; i < uriage_data.length + 10; i++) {
//			for (int j = 0; j < 4; j++) {
//				uriage_table.addCell(Empty_Cell);
//			}
//		}

		//合計行を出力します。
//		Cell cell_goukei = new Cell(new Phrase("合計", font_g10));
//		cell_goukei.setGrayFill(0.8f);
//		cell_goukei.setColspan(3);
//		uriage_table.addCell(cell_goukei);
//		Cell cell_sum = new Cell(new Phrase("136,900", font_m10));
//		cell_sum.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		uriage_table.addCell(cell_sum);

		//テーブルをドキュメントオブジェクトに追加します
//		doc.add(uriage_table);



        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(420);
        table.setExtendLastRow(true);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        PdfPCell cell;
        cell = new PdfPCell(new Paragraph("みんなの名づけ",font_m10));
        cell.setColspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.ORANGE);
        table.addCell(cell);

//        cell = new PdfPCell();
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setColspan(3);
//        cell.addElement(img);
//        table.addCell(cell);
//
//
//        cell = new PdfPCell(new Paragraph("平成二十一年九月二日生",hoge1));
//        cell.setNoWrap(true);
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
//        cell.setFixedHeight(220);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Paragraph(strName,hoge2));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        table.addCell(cell);
//
//
//        PdfPTable table2 = new PdfPTable(1);
//
//        cell = new PdfPCell(new Paragraph("命名",hoge3));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//        cell.setFixedHeight(150);
//        table2.addCell(cell);
//
//        cell = new PdfPCell();
//        cell.setBorder(Rectangle.NO_BORDER);
//        img.setDpi(84, 63);
//        cell.setImage(img);
//        table2.addCell(cell);
//
//        table.addCell(table2);

        PdfPTable table2 = new PdfPTable(1);


        cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setImage(img);
        table2.addCell(cell);


        cell = new PdfPCell(new Paragraph("平成二十一年九月二日生",hoge1));
        cell.setNoWrap(true);
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        table2.addCell(cell);

        table.addCell(table2);

        cell = new PdfPCell(new Paragraph(strName,hoge2));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setFixedHeight(380);
        table.addCell(cell);



        cell = new PdfPCell(new Paragraph("命名",hoge3));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);



        cell = new PdfPCell(new Paragraph("--- 200 * 200 ---",font_m10));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.red);
        table.addCell(cell);

        //　罫線なし、赤の背景
//        cell = new PdfPCell(new Paragraph("赤",font_m10));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setBackgroundColor(Color.red);
//        table.addCell(cell);
//        //背景を緑、下線をマゼンタに設定
//        cell = new PdfPCell(new Paragraph("緑",font_m10));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBorderColorBottom(Color.magenta);
//        cell.setBorderWidthBottom(10f);
//        cell.setBackgroundColor(Color.green);
//        table.addCell(cell);
//        // 背景を青、上部の罫線をシアン
//        cell = new PdfPCell(new Paragraph("青",font_m10));
//        cell.setBorder(Rectangle.TOP);
//        cell.setUseBorderPadding(true);
//        cell.setBorderWidthTop(5f);
//        cell.setBorderColorTop(Color.cyan);
//        cell.setBackgroundColor(Color.blue);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Paragraph("灰色背景のテスト",font_m10));
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("0.25"));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setGrayFill(0.25f);
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("0.5"));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setGrayFill(0.5f);
//        table.addCell(cell);
//        cell = new PdfPCell(new Paragraph("0.75"));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setGrayFill(0.75f);
//        table.addCell(cell);
        doc.add(table);

	 } catch (DocumentException e) {
	 	e.printStackTrace();
	 }



    // 出力を終了します
	doc.close();

	// ブラウザへのデータを送信します
    //(出力するコンテキストタイプにPDFを指定します。)
//    response.setContentType("application/pdf");
//    response.setContentType("image/jpeg");

//    response.setContentType("application/octetstream");

//    response.setHeader("Content-Disposition","inline; filename=aaaa.pdf");


    response.setContentLength(byteout.size());
    OutputStream out = response.getOutputStream();
    out.write(byteout.toByteArray());
    out.close();
  }

  private static Image getImage(String file, float newWidth) {

	    BufferedImage bi;
	    com.lowagie.text.Image image = null;
		try {
			bi = ImageIO.read(new File(file));
			image = com.lowagie.text.Image.getInstance(bi, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//	    float percent = newWidth / image.getWidth() * 100.0f;
//	    image.scalePercent(percent);
 catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return image;
	  }



}