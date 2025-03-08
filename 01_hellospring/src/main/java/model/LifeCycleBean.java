package model;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class LifeCycleBean {
	
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
}
