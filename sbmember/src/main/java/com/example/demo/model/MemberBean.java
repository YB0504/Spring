package com.example.demo.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("member")
public class MemberBean {

	private int join_code;
	private String join_id;
	private String join_pwd;
	private String join_name;
	private String join_zip;
	private String join_addr1;
	private String join_addr2;
	private String join_tel;
	private String join_phone;
	private String join_email;
	private String join_profile;
	private String join_regdate;
	private int join_state;
	private String join_delcont;
	private String join_deldate;

}
