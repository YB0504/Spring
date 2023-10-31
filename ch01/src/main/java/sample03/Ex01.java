package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		
//		 BeanFactory bf = new XmlBeanFactory(new FileSystemResource("beans01.xml"));
		// 객체생성을 xml파일에서 수행한다.
		// bean.xml을 불러와서 객체를 구해온다.
		ApplicationContext bf = new FileSystemXmlApplicationContext("beans01.xml");
		
		// MessageBean mb = bf.getBean("mb", MessageBean.class);
		// Object형으로 값을 돌려주기 때문에 하위로 다운 캐스팅한다.
		// getBean()로 bean객체를 불러온다.
		MessageBean mb = (MessageBean) bf.getBean("mb");
		// MessageBean mb = bf.getBean(MessageBean.class);
		// MessageBean mb = (MessageBean)bf.getBean("a");
		
		mb.sayHello("Spring");
	}
}