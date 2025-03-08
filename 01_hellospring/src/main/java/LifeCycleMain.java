import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.LifeCycleBean;

public class LifeCycleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(LifeCycleBean.class);
		
		String[] beans = ctx.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println(name);
		}

		System.out.println("容器要被關了~~~");
		ctx.close();
	}

}
