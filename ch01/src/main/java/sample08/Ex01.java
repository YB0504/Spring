package sample08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		// resources 폴더안에 있는 환경설정 파일을 불러올 때는 classpath:환경설정 파일명으로 불러온다.
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:beans08.xml");
		MessageBean mb = (MessageBean) ac.getBean("mb");
		mb.syaHello();

	}
}