package jp.co.comster.itext.sample.common.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.container.SingletonS2Container;

/**
 * TraceInterceptorクラス<br>
 *
 * <pre>
 * 【修正履歴】
 * 日付       Ver. 担当者         修正内容
 * ---------------------------------------
 * 2015/8/11　1.0　COMSTER)Yamaguchi 新規作成
 * </pre>
 *
 * @author COMSTER
 * @version 1.0
 */
public class TraceInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 2096802944710135143L;

	/**
	 * 各メソッドが呼ばれるときの処理を行う。<br>
	 *
	 * @param methodinvocation
	 *            インターセプターの管理インスタンス
	 * @throws Throwable
	 */
	public Object invoke(MethodInvocation methodinvocation) throws Throwable {

//        final String className = methodinvocation.getMethod().getDeclaringClass().getSimpleName();
		final String methodName = methodinvocation.getMethod().getDeclaringClass().getName() + "." + methodinvocation.getMethod().getName() + "()";
		final Log logger = LogFactory.getLog("appliLog");
		final HttpServletRequest request = SingletonS2Container.getComponent( HttpServletRequest.class );
		final String commonNo = request.getRemoteUser();
        logger.info(String.format("[start][%s]#%s", commonNo, methodName));
		final long start = new Date().getTime();
        try {
    		return methodinvocation.proceed();
        } finally {
            logger.info(String.format("[ end ][%s]#%s, time:[%s]ms", commonNo, methodName, (new Date().getTime() - start)));
        }
	}
}
