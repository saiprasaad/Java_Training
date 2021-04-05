package spring;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;
public class ExportImpl extends DelegatingIntroductionInterceptor implements Export{
public void doExport() {
	System.out.println("do export method is called...");
}
}