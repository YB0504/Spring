package sample09;

import java.io.FileWriter;
import java.io.IOException;


public class FileOutputer implements Outputer {
	private String fileName;

	// file이 생성되면 file의 이름이 될 값이 주입된다.
	public void setFileName(String fileName) {
		this.fileName = fileName;	// fileName="test.txt"
	}

	// 메소드 오버라이딩
	public void output(String msg) {
		try {
			// 전달된 fileName값이 파일명인 파일이 생성된다.
			FileWriter fw = new FileWriter(fileName);
			fw.write(msg);
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}