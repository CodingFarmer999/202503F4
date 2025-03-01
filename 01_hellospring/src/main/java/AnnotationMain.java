import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.CarConfig;
import model.Kia;

public class AnnotationMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CarConfig.class);
		
		String[] beans = ctx.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println(name);
		}
		
		Kia kia = ctx.getBean(Kia.class);
		System.out.println(kia);
		kia.move();
		
	}

}
