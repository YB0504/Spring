import java.util.UUID;

public class RandomFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filename = "clock.jpg";
		
		// 파일 중복문제 해결
		// substring()로 filename의 .을 기준으로 확장자와 filename을 분리 시킨다.
		// .jpg
		String extension = filename.substring(filename.lastIndexOf("."), filename.length());
		System.out.println("extension:"+extension);
		
		// UUID클래스 하위에 randomUUID()메소드로 중복문제 해결
		// UUID : 문자형태의 난수를 방생시키는 클래스
		UUID uuid = UUID.randomUUID();
		System.out.println("uuid:"+uuid);
		
		// 위에서 잘라낸 확장자와 발생한 문자형 난수와 결합한다.
		String newfilename = uuid.toString() + extension;
		System.out.println("newfilename:"+newfilename);
		
//		extension:.jpg
//		uuid:605c38b4-b0c5-4c83-a18b-d6043f8effbc
//		newfilename:605c38b4-b0c5-4c83-a18b-d6043f8effbc.jpg
		
	}

}
