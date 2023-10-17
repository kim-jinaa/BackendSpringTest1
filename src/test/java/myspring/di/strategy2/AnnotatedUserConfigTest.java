package myspring.di.strategy2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.strategy2.config.AnnotatedUserConfig;
import myspring.di.strategy2.service.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AnnotatedUserConfig.class,
				loader = AnnotationConfigContextLoader.class)
public class AnnotatedUserConfigTest {
	@Autowired
	UserService userService;
	
	@Test
	public void user() {
		System.out.println(userService.getUserList());
	}
}
