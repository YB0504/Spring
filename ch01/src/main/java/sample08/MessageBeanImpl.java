package sample08;

public class MessageBeanImpl implements MessageBean {
	
	// 필드
	private String name;
	private String greet;

	// 생성자
	public MessageBeanImpl(String name) {
		this.name = name;	// 돌쇠
	}

	// setter메소드
	public void setGreet(String greet) {
		this.greet = greet;	// 안뇽
	}

	public void syaHello() {
		System.out.println(name + " ! " + greet);
	}
}