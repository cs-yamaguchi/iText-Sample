package jp.co.comster.itext.sample.common.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.aop.interceptors.ThrowsInterceptor;

/**
 * ThrowableInterceptorクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者         修正内容
 * ---------------------------------------
 * 2015/8/11　1.0　COMSTER)Yamaguchi  新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public class ThrowableInterceptor extends ThrowsInterceptor {

	private static final long serialVersionUID = 6133072236391460321L;

	/**
	 * 例外が起こった際のハンドリング処理を行う<br>
	 *
	 * @param e
	 *            例外
	 * @param invocation
	 *            インターセプターの管理インスタンス
	 */
	public void handleThrowable(Exception e, MethodInvocation invocation) throws Throwable {
		final String methodName = invocation.getMethod().getDeclaringClass().getName() + "." + invocation.getMethod().getName() + "()";
		final Throwable t = (e instanceof jp.co.comster.itext.sample.common.system.exception.ItextSampleException)?e.getCause():e;
		if (t instanceof org.seasar.framework.exception.SQLRuntimeException)
			LogFactory.getLog("sqlLog").error(String.format("cause by : %s", methodName), e);
		LogFactory.getLog("appliLog").error(String.format("cause by : %s", methodName), e);
		throw e;
	}
}
