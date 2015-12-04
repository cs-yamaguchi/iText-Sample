package jp.co.netcitys.pdf;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ITextServlet3 extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FileInputStream  fis =null;
		BufferedInputStream is = null;
		BufferedOutputStream out= null;

		try {
			out = new BufferedOutputStream(response.getOutputStream());
			fis = new FileInputStream(super.getServletContext().getRealPath("sample3.pdf"));
			is = new BufferedInputStream(fis);

			//  コンテンツの長さをセットします。
			response.setContentLength(is.available());

			// キャッシュを無効化します。
			response.addHeader("Cache-Control","no-cache");
			response.addHeader("Pragma","no-cache");
			response.addHeader("Expires","0");

			byte[] by = new byte[8192];
			while(is.read(by) != -1){
				out.write(by);
			}
			out.flush();


		} catch ( Exception  e) {

			System.out.println(e.getMessage());

		}  finally {

			if (is != null) {
				is.close();
			}

			if (out != null) {
				out.close();
			}
		}
  }

}