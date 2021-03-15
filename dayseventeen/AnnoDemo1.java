package dayseventeen;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class AnnoDemo1 {
	public static void main(String[] args) {
		A obj=new A();
		//how will I decide whether to give injection or not
		Inject in=obj.getClass().getAnnotation(Inject.class);
		if(in!=null) {
			obj.b=new B(in.val(),in.num());
		}
		System.out.println(obj.b);
	}
}
@Retention(RetentionPolicy.RUNTIME)
@interface Inject{
	int num() default 100;
	String val() default "ramu";
}
@Inject(val = "this is new value...")
class A{
	
	B b;
}
class B{
	String val;
	int n;
	public B(String val,int n) {
		this.val=val;
		this.n=n;
	}
	@Override
	public String toString() {
		return val+":"+n;
	}
}