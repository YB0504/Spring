package sample13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/sample13/beans13.xml");
		// bean객체를 만들지 않았기 때문에 getBean메소드 안에 서비스 객체의 이름으로 구해온다.
		// 인터페이스, 구현클래스 모두 가능
		ProductService ps = ac.getBean(ProductService.class);
		Product product = ps.getProduct();
		System.out.println(product);
	}
}