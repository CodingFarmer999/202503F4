import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.CarConfig;
import model.LazyBean;
import model.ProtoTypeBean;
import model.SingletonBean;

public class ScopeMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CarConfig.class);
		
		String[] beans = ctx.getBeanDefinitionNames();
		for (String name : beans) {
			System.out.println(name);
		}
		
		SingletonBean bean1 = (SingletonBean)ctx.getBean("singletonBean");
		System.out.println(bean1);
		
		SingletonBean bean2 = (SingletonBean)ctx.getBean("singletonBean");
		System.out.println(bean2);
		
		ProtoTypeBean pBean1 = (ProtoTypeBean)ctx.getBean("protoTypeBean");
		System.out.println(pBean1);
		
		ProtoTypeBean pBean2 = (ProtoTypeBean)ctx.getBean("protoTypeBean");
		System.out.println(pBean2);
		
		System.out.println("================ Lazy ===================");
		LazyBean lazyBean = ctx.getBean(LazyBean.class);

	}

}
