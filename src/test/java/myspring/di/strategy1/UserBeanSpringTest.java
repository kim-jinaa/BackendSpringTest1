package myspring.di.strategy1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.strategy1.dao.UserDao;
import myspring.di.strategy1.service.UserService;

public class UserBeanSpringTest {
	
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		factory = new GenericXmlApplicationContext("classpath:spring-bean-configuration.xml");
	}
	
	@Test
	void userService() {
		UserService userService = factory.getBean("userService", UserService.class);
		UserDao userDao = factory.getBean("userDao", UserDao.class);
		assertEquals(2, userService.getUserList().size());
		System.out.println(userService.getUserList());
	}
}
