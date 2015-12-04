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

  	//���͉�ʂ��瑗�M����Ă������̂�\�����܂��B
  	request.setCharacterEncoding("Shift-JIS");
  	String strName =request.getParameter("input_name");;

  	//�o�͗p��Stream���C���X�^���X�����܂��B
    ByteArrayOutputStream byteout = new ByteArrayOutputStream();

    //�����I�u�W�F�N�g�𐶐�
    //�y�[�W�T�C�Y��ݒ肵�܂��B
    Rectangle rectangle = new Rectangle(283, 420);
    Document doc = new Document(rectangle, 0, 0, 0, 0);

	doc.setPageCount(1);
    try {
		//�A�E�g�v�b�g�X�g���[����PDFWriter�ɐݒ肵�܂��B
		PdfWriter pdfwriter = PdfWriter.getInstance(doc, byteout);

        Font font_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
		Font hoge1 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 12,  Font.BOLD);
		Font hoge2 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 43, Font.BOLD);
		Font hoge3 = new Font(BaseFont.createFont("HeiseiMin-W3","UniJIS-UCS2-V",BaseFont.NOT_EMBEDDED), 21,  Font.BOLD);

		/* �t�H���g�ݒ蕔 */
		//(�S�V�b�N15pt(����)
		Font font_header = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),12,Font.BOLD);
//	    //�S�V�b�N11pt
//		Font font_g11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11);
//	    //�S�V�b�N10pt
//		Font font_g10 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),10);
//		//����10pt
//		Font font_m10 = new Font(BaseFont.createFont("HeiseiMin-W3", "UniJIS-UCS2-HW-H",BaseFont.NOT_EMBEDDED),10);
//	    //�S�V�b�N11pt(��������)
//		Font font_underline_11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11,Font.UNDERLINE);
//		//�S�V�b�N11pt(��)
//		Font font_red_11 = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),11);
//		font_red_11.setColor(new Color(255,0,0));
		//�󔒃Z���p�t�H���g(��\��)
//		Font font_empty = new Font(BaseFont.createFont("HeiseiKakuGo-W5","UniJIS-UCS2-H",BaseFont.NOT_EMBEDDED),9);
//		font_empty.setColor(new Color(255,255,255));

		//�o�͂���PDF�ɐ�����t�^���܂��B
//		doc.addAuthor("�� ��v");
//		doc.addSubject("iText�T���v��");

//		//�w�b�_�[�̐ݒ�����܂��B
//		HeaderFooter header = new HeaderFooter(new Phrase("�E�B�����Y�p�[�N�@�݂�Ȃ̖��Â�", font_header), false);
//		header.setTop(5);
//		header.setAlignment(Element.ALIGN_CENTER);
//		doc.setHeader(header);
//		//�t�b�^�[�̐ݒ�����܂��B
//		HeaderFooter footer = new HeaderFooter(new Phrase("--- �r�`�l�o�k�d 84 * 63 ---",  font_header), false);
//		footer.setAlignment(Element.ALIGN_CENTER);
//		footer.setBorder(Rectangle.NO_BORDER);
//		doc.setFooter(footer);

		//���͂̏o�͂��J�n���܂��B
		doc.open();

//		Paragraph para_1 = new Paragraph("������\��N�����\�l����", hoge1);
//		para_1.setAlignment(Element.ALIGN_LEFT);
//		para_1.setFirstLineIndent(1000);
//		doc.add(para_1);
//
//		Paragraph para_2 = new Paragraph(strName, hoge2);
//		para_2.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_2);
//
//		Paragraph para_3 = new Paragraph("����", hoge3);
//		para_3.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_3);

////		Image img = Image.getInstance("C:\\usr\\var\\workspace3.4\\iText\\logo_wp.gif");
		final String standardInfomation = super.getServletContext().getRealPath("060906.jpg");
		Image img = Image.getInstance(standardInfomation);

		img.scalePercent(72.0f / 96.0f * 100f);
//		// PDF(72dpi)��Windows(96dpi)�̉�ʉ𑜓x�̈Ⴂ��␳����B
////		img.scalePercent(72.0f / 96.0f * 100f);
////		img.setAbsolutePosition(350, 200);
//		img.setAbsolutePosition(100, 340);
//		img.setAlignment(Element.ALIGN_BOTTOM);
//		doc.add(img);

//	    Paragraph p = new Paragraph();
//	    float pageWidth = doc.right() - doc.left();
//	    // ���̉����ɍ��킹�Ċg��or�k��
//		Image img2 = getImage(super.getServletContext().getRealPath("mafd_mcl.gif"), pageWidth);
//		p.add(new Chunk(img2, 0, 0, true));
////		p.add(new Chunk(files[i]));
//		p.add(Chunk.NEWLINE);
//
//	    doc.add(p);


		/* ������ѕ\�̃e�[�u�����쐬���܂� */
		//���[���ׂ̏���������ݒ肵�܂��B
//		doc.add(new Paragraph("2005�N5������", font_red_11));
//		Paragraph para_1 = new Paragraph("�S���ҁF" +  strName, font_g11);
//		para_1.setAlignment(Element.ALIGN_RIGHT);
//		doc.add(para_1);
//		doc.add(new Paragraph(""));
//		Paragraph para_2 = new Paragraph("���i���F��������", font_underline_11);
//		para_2.setAlignment(Element.ALIGN_LEFT);
//		doc.add(para_2);

//		//���[���ׂ̖��׍s��ݒ肵�܂�
//		Table uriage_table = new Table(4);
//
//		//����e�[�u���S�̂̕���ݒ肵�܂��B
//		uriage_table.setWidth(100);
//		//�e�[�u���e��̕����p�[�Z���e�[�W�Őݒ肵�܂��B
//		int uriage_table_width[] = {10,20,40,30};
//		uriage_table.setWidths(uriage_table_width);
//		//�e�[�u���̃f�t�H���g�̕\���ʒu�i���j��ݒ肵�܂��B
//		uriage_table.setDefaultHorizontalAlignment(Element.ALIGN_CENTER);
//		//�e�[�u���̃f�t�H���g�̕\���ʒu�i�c�j��ݒ肵�܂��B
//		uriage_table.setDefaultVerticalAlignment(Element.ALIGN_MIDDLE);
//		//�e�[�u���̗]����ݒ肵�܂��B
//		uriage_table.setPadding(3);
//		//�e�[�u���̃Z���Ԃ̊Ԋu��ݒ肵�܂��B
//		uriage_table.setSpacing(0);
//		//�e�[�u���̐��̐F��ݒ肵�܂��B
//		uriage_table.setBorderColor(new Color(0, 0, 0));

//		//���׍s�̍��ږ������̃Z���̐ݒ���s���܂�
//		//�i�Z���ɖԊ|���ݒ���s���܂��j
//		Cell cell_11 = new Cell(new Phrase("����", font_g10));
//		cell_11.setGrayFill(0.8f);
//		Cell cell_21 = new Cell(new Phrase("�ڋq�R�[�h", font_g10));
//		cell_21.setGrayFill(0.8f);
//		Cell cell_31 = new Cell(new Phrase("�ڋq����", font_g10));
//		cell_31.setGrayFill(0.8f);
//		Cell cell_41 = new Cell(new Phrase("���z", font_g10));
//		cell_41.setGrayFill(0.8f);
//
//		//�e�[�u���ɃZ����ݒ肵�܂�
//		uriage_table.addCell(cell_11);
//		uriage_table.addCell(cell_21);
//		uriage_table.addCell(cell_31);
//		uriage_table.addCell(cell_41);

//		//���׃f�[�^��ݒ肵�܂�
//		String[][] uriage_data = {
//		{"1", "AA-001", "�������Y", "100,000"},
//		{"2", "BB-001", "��������", "20,000"},
//		{"3", "CC-001", "�������X", "10,000"},
//		{"4", "DD-001", "�~�~�~����", "5,000"},
//		{"5", "EE-001", "�����^��", "1,000"},
//		{"6", "FF-001", "�����T�[�r�X", "500"},
//		{"7", "GG-001", "�����V�X�e��", "300"},
//		{"8", "HH-001", "�����Y��", "100"},};
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
		//��s��ǉ����܂��B
//		Cell Empty_Cell = new Cell(new Phrase("empty", font_empty));
//		for (int i = uriage_data.length; i < uriage_data.length + 10; i++) {
//			for (int j = 0; j < 4; j++) {
//				uriage_table.addCell(Empty_Cell);
//			}
//		}

		//���v�s���o�͂��܂��B
//		Cell cell_goukei = new Cell(new Phrase("���v", font_g10));
//		cell_goukei.setGrayFill(0.8f);
//		cell_goukei.setColspan(3);
//		uriage_table.addCell(cell_goukei);
//		Cell cell_sum = new Cell(new Phrase("136,900", font_m10));
//		cell_sum.setHorizontalAlignment(Element.ALIGN_RIGHT);
//		uriage_table.addCell(cell_sum);

		//�e�[�u�����h�L�������g�I�u�W�F�N�g�ɒǉ����܂�
//		doc.add(uriage_table);



        PdfPTable table = new PdfPTable(3);
        table.setTotalWidth(420);
        table.setExtendLastRow(true);
        table.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        PdfPCell cell;
        cell = new PdfPCell(new Paragraph("�݂�Ȃ̖��Â�",font_m10));
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
//        cell = new PdfPCell(new Paragraph("������\��N�㌎�����",hoge1));
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
//        cell = new PdfPCell(new Paragraph("����",hoge3));
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


        cell = new PdfPCell(new Paragraph("������\��N�㌎�����",hoge1));
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



        cell = new PdfPCell(new Paragraph("����",hoge3));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        table.addCell(cell);



        cell = new PdfPCell(new Paragraph("--- 200 * 200 ---",font_m10));
        cell.setBorder(Rectangle.NO_BORDER);
        cell.setColspan(3);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.red);
        table.addCell(cell);

        //�@�r���Ȃ��A�Ԃ̔w�i
//        cell = new PdfPCell(new Paragraph("��",font_m10));
//        cell.setBorder(Rectangle.NO_BORDER);
//        cell.setBackgroundColor(Color.red);
//        table.addCell(cell);
//        //�w�i��΁A�������}�[���^�ɐݒ�
//        cell = new PdfPCell(new Paragraph("��",font_m10));
//        cell.setBorder(Rectangle.BOTTOM);
//        cell.setBorderColorBottom(Color.magenta);
//        cell.setBorderWidthBottom(10f);
//        cell.setBackgroundColor(Color.green);
//        table.addCell(cell);
//        // �w�i��A�㕔�̌r�����V�A��
//        cell = new PdfPCell(new Paragraph("��",font_m10));
//        cell.setBorder(Rectangle.TOP);
//        cell.setUseBorderPadding(true);
//        cell.setBorderWidthTop(5f);
//        cell.setBorderColorTop(Color.cyan);
//        cell.setBackgroundColor(Color.blue);
//        table.addCell(cell);
//
//        cell = new PdfPCell(new Paragraph("�D�F�w�i�̃e�X�g",font_m10));
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



    // �o�͂��I�����܂�
	doc.close();

	// �u���E�U�ւ̃f�[�^�𑗐M���܂�
    //(�o�͂���R���e�L�X�g�^�C�v��PDF���w�肵�܂��B)
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