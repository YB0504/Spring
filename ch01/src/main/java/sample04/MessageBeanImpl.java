package sample04;

public class MessageBeanImpl implements MessageBean {
	
	// 필드 : 전달받은 값 저장
	private String name;
	private String greet;

	// 생성자 : 필드값 초기화
	public MessageBeanImpl(String name, String greet) {
		this.name = name;		// 도깨비
		this.greet = greet;		// 안뇽
	}
	
	// 메소드 : 필드값 출력
	public void sayHello() {
		System.out.println(name + " ! " + greet);
	}
}