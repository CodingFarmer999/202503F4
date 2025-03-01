import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.Kia;
import model.Tesla;
import model.Toyota;

public class SpringMain {

	public static void main(String[] args) {
		// Spring IoC 容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");

		String[] beans = ctx.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println(name);
		}
		
		Toyota car = ctx.getBean(Toyota.class);
		car.move();
		
		Kia kia = ctx.getBean(Kia.class);
		System.out.println(kia);
		kia.move();
		
		Tesla tesla = ctx.getBean(Tesla.class);
		System.out.println(tesla);
		tesla.move();
	}

}
