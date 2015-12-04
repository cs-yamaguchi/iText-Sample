package jp.co.comster.itext.sample.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.seasar.framework.util.BooleanConversionUtil;
import org.seasar.framework.util.DateConversionUtil;
import org.seasar.framework.util.DoubleConversionUtil;
import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.framework.util.LongConversionUtil;
import org.seasar.framework.util.ResourceUtil;
import org.seasar.framework.util.StringConversionUtil;

/**
 * TypeSafeな値取得メソッドを追加したPropertiesクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者           修正内容
 * ---------------------------------------
 * 2013/07/02 1.0　NETCITYS ota  新規作成
 * </pre>
 *
 * @author NETCITYS
 * @version 1.0
 */
public class TypeProperties implements Serializable {

	private static final long serialVersionUID = 1L;

	private Properties prop = null;

	/**
	 * コンストラクタ
	 *
	 * @param path
	 *            プロパティファイル名
	 */
	public TypeProperties(String path) {
		// 設定ファイル取得
		prop = ResourceUtil.getProperties(path);
	}

	/**
	 * コンストラクタ
	 *
	 * @param path
	 *            プロパティ
	 */
	public TypeProperties(Properties p) {
		// 設定ファイル取得
		prop = p;
	}

	public int getPropertyInt(String key) {
		return IntegerConversionUtil.toPrimitiveInt(prop.getProperty(key));
	}

	public String getPropertyString(String key) {
		return StringConversionUtil.toString(prop.getProperty(key));
	}

	public double getPropertyDouble(String key) {
		return DoubleConversionUtil.toDouble(prop.getProperty(key));
	}

	public long getPropertyLong(String key) {
		return LongConversionUtil.toPrimitiveLong(prop.getProperty(key));
	}

	public Date getPropertyDate(String key) {
		return DateConversionUtil.toDate(prop.getProperty(key));
	}

	public Date getPropertyDate(String key, String pattern) {
		return DateConversionUtil.toDate(prop.getProperty(key), pattern);
	}

	public Object setProperty(String key, String value) {
		return prop.setProperty(key, value);
	}

	public int size() {
		return prop.size();
	}

	public boolean isEmpty() {
		return prop.isEmpty();
	}

	public Enumeration<Object> keys() {
		return prop.keys();
	}

	public Enumeration<Object> elements() {
		return prop.elements();
	}

	public boolean contains(Object value) {
		return prop.contains(value);
	}

	public boolean containsValue(Object value) {
		return prop.containsValue(value);
	}

	public boolean containsKey(Object key) {
		return prop.containsKey(key);
	}

	public Object get(Object key) {
		return prop.get(key);
	}

	public void load(InputStream inStream) throws IOException {
		prop.load(inStream);
	}

	public Object put(Object key, Object value) {
		return prop.put(key, value);
	}

	public Object remove(Object key) {
		return prop.remove(key);
	}

	public void putAll(Map<? extends Object, ? extends Object> t) {
		prop.putAll(t);
	}

	public void clear() {
		prop.clear();
	}

	public Object clone() {
		return prop.clone();
	}

	public String toString() {
		return prop.toString();
	}

	public Set<Object> keySet() {
		return prop.keySet();
	}

	public Set<Entry<Object, Object>> entrySet() {
		return prop.entrySet();
	}

	public Collection<Object> values() {
		return prop.values();
	}

	@SuppressWarnings("deprecation")
	public void save(OutputStream out, String comments) {
		prop.save(out, comments);
	}

	public boolean equals(Object o) {
		return prop.equals(o);
	}

	public int hashCode() {
		return prop.hashCode();
	}

	public void store(OutputStream out, String comments) throws IOException {
		prop.store(out, comments);
	}

	public void loadFromXML(InputStream in) throws IOException,
			InvalidPropertiesFormatException {
		prop.loadFromXML(in);
	}

	public void storeToXML(OutputStream os, String comment) throws IOException {
		prop.storeToXML(os, comment);
	}

	public void storeToXML(OutputStream os, String comment, String encoding)
			throws IOException {
		prop.storeToXML(os, comment, encoding);
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

	public String getPropertyFormat(String key, Object... arguments) {
		return MessageFormat.format(prop.getProperty(key), arguments);
	}

	public String getProperty(String key, String defaultValue) {
		return prop.getProperty(key, defaultValue);
	}

	public Enumeration<?> propertyNames() {
		return prop.propertyNames();
	}

	public void list(PrintStream out) {
		prop.list(out);
	}

	public void list(PrintWriter out) {
		prop.list(out);
	}

	/**
	 * 20150908 Add COMSTER Yamaguchi
	 * Booleanの値を取得する。
	 * @return
	 */
	public boolean getPropertyBool(String key) {
		return BooleanConversionUtil.toPrimitiveBoolean(prop.getProperty(key));
	}

	/**
	 * 20150909 Add COMSTER Yamaguchi
	 * getPropertyFormatのエイリアス
	 * @return
	 */
	public String getMessage(String key, Object... arguments) {
		return getPropertyFormat(key, arguments);
	}

}
