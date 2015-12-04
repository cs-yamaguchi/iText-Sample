package jp.co.netcitys.pdf;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;


public class ITextServlet2 extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  	//入力画面から送信されてきた名称を表示します。
  	request.setCharacterEncoding("Shift-JIS");
  	String strName ="aaa";

  	//出力用のStreamをインスタンス化します。
    ByteArrayOutputStream byteout = new ByteArrayOutputStream();

    //文書オブジェクトを生成
    //ページサイズを設定します。
    Document doc = new Document(PageSize.A4, 50, 50, 50, 50);
    try {
		//アウトプットストリームをPDFWriterに設定します。
		PdfWriter pdfwriter = PdfWriter.getInstance(doc, byteout);


		Font hoge1 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 36,  Font.BOLD);
		Font hoge2 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 128, Font.BOLD);
		Font hoge3 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 64,  Font.BOLD);

		/* フォント設定部 */
		//(ゴシック15pt(太字)
//		Font font_header = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),15,Font.BOLD);
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

		//ヘッダーの設定をします。
//		HeaderFooter header = new HeaderFooter(new Phrase("○○商事 月間売上実績", font_header), false);
//		header.setAlignment(Element.ALIGN_CENTER);
//		doc.setHeader(header);
		//フッターの設定をします。
//		HeaderFooter footer = new HeaderFooter(new Phrase("--"), new Phrase("--"));
//		footer.setAlignment(Element.ALIGN_CENTER);
//		footer.setBorder(Rectangle.NO_BORDER);
//		doc.setFooter(footer);

		//文章の出力を開始します。
		doc.open();

		Paragraph para_1 = new Paragraph("平成二十一年七月十四日生", hoge1);
		para_1.setAlignment(Element.ALIGN_LEFT);
		doc.add(para_1);


		Paragraph para_2 = new Paragraph(strName, hoge2);
		para_2.setAlignment(Element.ALIGN_RIGHT);
		doc.add(para_2);

		Paragraph para_3 = new Paragraph("命名", hoge3);
		para_3.setAlignment(Element.ALIGN_RIGHT);
		doc.add(para_3);

//		Image img = Image.getInstance("C:\\usr\\var\\workspace3.4\\iText\\logo_wp.gif");
		final String standardInfomation = super.getServletContext().getRealPath("logo_wp.gif");
		Image img = Image.getInstance(standardInfomation);

		// PDF(72dpi)とWindows(96dpi)の画面解像度の違いを補正する。
//		img.scalePercent(72.0f / 96.0f * 100f);
		img.setAbsolutePosition(350, 200);
		img.setAlignment(Element.ALIGN_BOTTOM);
		doc.add(img);




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

	 } catch (DocumentException e) {
	 	e.printStackTrace();
	 }

    // 出力を終了します
	doc.close();

	// ブラウザへのデータを送信します
    //(出力するコンテキストタイプにPDFを指定します。)
    response.setContentType("application/pdf");
//    response.setContentType("application/octetstream");

//    response.setHeader("Content-Disposition","inline; filename=aaaa.pdf");
    response.setContentLength(byteout.size());
    OutputStream out = response.getOutputStream();
    out.write(byteout.toByteArray());
    out.close();
  }
}