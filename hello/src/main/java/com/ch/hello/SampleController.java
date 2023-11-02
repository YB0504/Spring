package com.ch.hello;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @RestController
// 1. spring4 부터 지원
// 2. @RestController = @Controller + @ResponseBody
// 3. DTO객체를 JSON형태로 변환해주는 Annotation
// JSON : {"Key", "Value"}형태의 데이터
@RestController
public class SampleController {
	@RequestMapping("/sample")
//	@ResponseBody	// @RestController가 위에 작성되어 있다면 필요없다.
	public SampleVo sample() {
		SampleVo sv = new SampleVo();
		sv.setMno(23);
		sv.setFirstName("홍");
		sv.setLastName("길동");
		
		// {"mno":23,"firstName":"홍","lastName":"길동"}로 출력된다.
		// 전달할 DTO객체를 JSON형태로 변환(jackson라이브러리)
		return sv;
	}

	@RequestMapping("/list")
	public List<SampleVo> list() {
		List<SampleVo> list = new ArrayList<SampleVo>();
		for (int i = 1; i <= 10; i++) {
			SampleVo sv = new SampleVo();
			sv.setMno(i);
			sv.setFirstName("홍");
			sv.setLastName("길동" + i);
			list.add(sv);
		}
		// 여러개의 JSON데이터가 출력되기 때문에
		// []안에 {JSON데이터} 가 각각 출력된다.
		return list;
	}
}