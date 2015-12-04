package jp.co.comster.itext.sample.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.env.Env;

import jp.co.comster.itext.sample.common.system.exception.ItextSampleException;

/**
 *
 * AbstructActionクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/08/11 1.0　COMSTER Yamaguchi  新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public abstract class AbstractAction {

    /* 本番・開発 */
    public boolean isProduct = false;

	/**
	 * コンストラクタ
	 */
	public AbstractAction() {
		isProduct = (Env.PRODUCT.equalsIgnoreCase(Env.getValue()));
	}
	/**
	 * アプリログ <br>
	 */
	protected static Log appliLog = LogFactory.getLog("appliLog");

	/**
	 * HTTPサーブレットリクエスト
	 */
	@Resource
	protected HttpServletRequest request;

	/**
	 * HTTPサーブレットレスポンス
	 */
	@Resource
	protected HttpServletResponse response;

	/**
	 * HTTPサーブレットセッション
	 */
	@Resource
	protected HttpSession session;

	/**
	 * トークンを発行する
	 */
	protected void saveToken() {
		TokenProcessor.getInstance().saveToken(request);
	}

	/**
	 * トークンをチェックする
	 */
	protected void checkToken() {
		if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
			throw new ItextSampleException("Tokenエラー");
		}
		saveToken();
	}

	/**
	 * セッションIDを取得する
	 */
	protected String getSessionId() {
		session = request.getSession();
		return session.getId();
	}

	protected String getRemoteUser() {
		return request.getRemoteUser();
	}

	/**
	 * エラー用のステータスを戻り値としてかえす
	 *
	 * @param status
	 *            HTTPステータス
	 * @return
	 */
	protected String forwardErrorStatus(int status) {
		try {
			response.sendError(status);
		} catch (IOException e) {
			appliLog.error("HTTPステータス設定エラー", e);
		}
		return null;
	}

	/**
	 * SAStrutsのActionクラスからindexのURLを生成する。
	 * @return
	 */
	protected String getSaStrutsIndexUrl() {
		return request.getContextPath() + "/" + this.getClass().getSimpleName().toLowerCase().split(this.getClass().getPackage().getName().split("\\.")[this.getClass().getPackage().getName().split("\\.").length - 1])[0] + "/";
	}

}