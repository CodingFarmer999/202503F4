package model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean implements InitializingBean, DisposableBean  {
	
	public LifeCycleBean() {
		System.out.println("LifeCycleBean 建構式");
	}
	
    /**
     * 建構完成之後呼叫
     * 方法名稱任意，有@PostConstruct即可
     */
    @PostConstruct
    public void init() {
        System.out.println("3. 我是PostConstruct");
    }
    
    /**
     * Bean要被銷毀前
     * 方法名稱任意，有@PreDestroy即可
     */
    @PreDestroy
    public void cleanup() {
        System.out.println("5. 我是@PreDestroy");
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("4. 我是afterPropertiesSet，要實作 InitializingBean");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("6. 我是destroy，要實作 DisposableBean");
		
	}
}
