package sample07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		// 동일 패키지 내부에 환경설정 파일이 있을 때는 앞에 패키지 명을 붙여줘야 한다.
		ApplicationContext ac =
				 new ClassPathXmlApplicationContext("/sample07/beans07.xml");
//				 new GenericXmlApplicationContext("/sample07/beans07.xml");
		MessageBean mb = (MessageBean) ac.getBean("mb");
		mb.sayHello();
	}
}
