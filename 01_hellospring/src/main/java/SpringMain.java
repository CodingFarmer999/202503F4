import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		// Spring IoC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

	}

}
