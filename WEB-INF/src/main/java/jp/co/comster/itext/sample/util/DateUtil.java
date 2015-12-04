package jp.co.comster.itext.sample.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
*
* DateUtilクラス<br>
*
* <pre>
* 【修正履歴】
* 日付       Ver. 担当者           修正内容
* ---------------------------------------
* 2015/08/12 1.0　COMSTER Yamaguchi  新規作成
* </pre>
*
* @author COMSTER
* @version 1.0
*/
public class DateUtil {

	/**
	 * 明日（システム日の0時0分0秒0ミリ秒）を取得する
	 *
	 * @return
	 */
	public static Date getTommorow() {
		final Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	/**
	 * 引数のDateオブジェクトの日付を指定の形式で出力する。
	 *
	 * @param d
	 * @param format
	 * @return
	 */
	public static String format(Date d, String format) {
		final SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}

	/**
	 * 引数の文字型の日付を指定の形式の日付型で出力する。
	 *
	 * @param s
	 * @param format
	 * @return
	 * @throws ParseException
	 */
	public static Date parse(String s, String format) throws ParseException {
		final SimpleDateFormat sdf = new SimpleDateFormat(format);
		final Date d = sdf.parse(s);
		sdf.setLenient(false);
		String cnv = sdf.format(d);
		if (s.equals(cnv))
			return d;
		throw new ParseException(String.format("parse string mismatch org [%s] cnv [%s]", s, cnv), 0);
	}

}
