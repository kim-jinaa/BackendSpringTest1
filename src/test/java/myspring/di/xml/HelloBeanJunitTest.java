package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	BeanFactory factory;
	
	@BeforeEach
	void init() {
		// 1.Spring Bean Container 객체생성
		factory = new GenericXmlApplicationContext("classpath:spring-beans.xml");
	}
	
	@Test //@Disabled
	void 생성자주입테스트() { // java는 unicode라서 한글로 해도됨
		Hello bean = factory.getBean("helloC", Hello.class);
		assertEquals("Hello 생성자", bean.sayHello());
		bean.print();
		
		List<String> names = bean.getNames();
		
		assertEquals(3, names.size());
		assertEquals("SpringBoot", names.get(1));
	}
	
	@Test // 어노테이션 반드시 붙여줘야함!
	@Disabled // 일시적으로 실행 안됨
	void hello() {
		// 2.Container가 생성한 Bean을 요청하기
		// Hello hello = new Hello();
		Hello hello1 = (Hello)factory.getBean("hello");
		Hello hello2 = factory.getBean("hello", Hello.class);
		// 3.HelloBean 레퍼런스 비교하기 >> 싱글톤인지 아닌지 비교
		System.out.println(hello1 == hello2);
		assertSame(hello1, hello2); // 주소가 같은지 확인(싱글톤)
		
		assertEquals("Hello 스프링", hello2.sayHello()); // 값이 같은지 비교
		hello2.print();
		
		Printer printer = factory.getBean("strPrinter", Printer.class);
		assertEquals("Hello 스프링", printer.toString());
	}
}
