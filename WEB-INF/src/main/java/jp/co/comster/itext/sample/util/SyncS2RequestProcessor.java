package jp.co.comster.itext.sample.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.seasar.struts.action.S2RequestProcessor;

/**
 *	<p><strong>SyncS2RequestProcessor</strong></p>
 *	マルチスレッドでは問題があるURLを
 *	同期制御する為のリクエストプロセッサー拡張クラス。<br>
 *	利用するにはstruts-configに下記を追加する必要があります。<br>
 *	&lt;controller processorClass="org.seasar.struts.action.S2RequestProcessor" /&gt;
 *
 * <pre>
 * 【修正履歴】
 * 日付        Ver.   担当者           修正内容
 * --------------------------------------------------
 * 2015/08/11  1.0    COMSTER)Yamaguchi         新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public class SyncS2RequestProcessor extends S2RequestProcessor{

	private static final String SASTRUTS_METHOD = "SAStruts.method";
	private static final int STRUTS_ACTION_INDEX = 0;
	private static final int DISPATCH_METHOD_INDEX = 1;
	private static final String[][] SYNC_LIST = {
		{"/enquete.do", "append"},
	};

	/**
	 * <p>Process an <code>HttpServletRequest</code> and create the
	 * corresponding <code>HttpServletResponse</code>.</p>
	 *
	 * @param request The servlet request we are processing
	 * @param response The servlet response we are creating
	 *
	 * @exception IOException if an input/output error occurs
	 * @exception ServletException if a processing exception occurs
	 */
	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		final String[] syncCheckPath = {request.getServletPath(), (request.getParameter(SASTRUTS_METHOD) == null)?"":request.getParameter(SASTRUTS_METHOD) };
		for (String[] sync : SYNC_LIST)
			if (syncCheckPath[STRUTS_ACTION_INDEX].equals(sync[STRUTS_ACTION_INDEX]) && syncCheckPath[DISPATCH_METHOD_INDEX].equals(sync[DISPATCH_METHOD_INDEX])) {
		    	synchronized(this) {
		    		super.process(request, response);
		    	}
		    	return;
			}
		super.process(request, response);

	}
}
