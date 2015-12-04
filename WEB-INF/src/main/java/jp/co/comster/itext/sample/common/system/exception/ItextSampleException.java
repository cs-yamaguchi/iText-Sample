package jp.co.comster.itext.sample.common.system.exception;

/**
 * アプリ用例外<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/08/11 1.0　COMSTER Yamaghuchi  新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public class ItextSampleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItextSampleException() {
		super();
	}

	public ItextSampleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItextSampleException(String message) {
		super(message);
	}

	public ItextSampleException(Throwable cause) {
		super(cause);
	}

}
