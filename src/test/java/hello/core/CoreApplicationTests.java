package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {


	}


	public void printAllBeans() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		System.out.println("=== Registered Beans ===");
		for (String beanName : allBeanNames) {
			System.out.println("HA KI SUNG ==> " + beanName + " : " + applicationContext.getBean(beanName).getClass().getName());
		}
	}

}
