package myspring.di.strategy2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring-bean-configuration-annot.xml")
public class AnnotatedUserBeanTest {
	@Autowired
	UserService userService;
	
	@Test
	public void userServiceBean() {
		assertEquals(2, userService.getUserList().size());
		System.out.println(userService.getUserList());
	}
}
