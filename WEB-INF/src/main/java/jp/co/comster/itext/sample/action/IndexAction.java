package jp.co.comster.itext.sample.action;

import org.seasar.struts.annotation.Execute;

import jp.co.comster.itext.sample.Const;

/**
 *
 * IndexActionクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/08/11 1.0　COMSTER Yamaguchi 新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public class IndexAction extends AbstractAction {

	/**
	 * iTextSampleメニュー
	 *
	 * @return
	 */
	@Execute(validator = false)
	public String index() {
		return Const.DEFAULT_PAGE;
	}

}