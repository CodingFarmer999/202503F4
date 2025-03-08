import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.CarConfig;
import model.Benz;

public class AnnotationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CarConfig.class);
		
		String[] beans = ctx.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println(name);
		}
		
//		Kia kia = ctx.getBean(Kia.class);
//		System.out.println(kia);
//		kia.move();
//		
//		Tesla tesla = (Tesla)ctx.getBean("bmw");
//		System.out.println(tesla);
//		tesla.move();
		
		Benz benz = (Benz)ctx.getBean("benz");
		System.out.println(benz);
		benz.move();
	}

}
