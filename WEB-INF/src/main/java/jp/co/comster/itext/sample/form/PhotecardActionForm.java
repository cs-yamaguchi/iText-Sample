package jp.co.comster.itext.sample.form;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;



/**
 *
 * PhotecardActionFormクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2015/12/04 1.0　COMSTER Yamaguchi  新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
@Component(instance = InstanceType.SESSION)
public class PhotecardActionForm implements Serializable {

	private static final long serialVersionUID = 1L;

	public Object uploadfile;

	public String freetext;

}
