package com.example.demo.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("board")	// DB연동에 관한 설정이 완료되면 사용할 수 있다.(DTO클래스의 alias설정)
public class Board {
	
	private int no;
	private String name;
	private String subject;
	private String content;
	private Date register;
}
