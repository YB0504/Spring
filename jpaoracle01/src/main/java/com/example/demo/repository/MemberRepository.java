package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.Member;

@Repository
public interface MemberRepository extends CrudRepository<Member, String>{
	
//	메소드가 따로 없어도 자동으로 아래의 내용을 수행한다.

//	@Override
//	default <S extends Member> S save(S entity) {
//		return null;
//	}
	
//	@Override
//	default Optional<Member> findById(String id) {
//		return null;
//	}
	
//	@Override
//	default void delete(Member entity) {
//	}
	
//	대표적인 메소드
//	public Member save(Member member);               // 회원가입, 정보수정
//	public Optional<Member> findById(String id);     // 로그인, 수정폼
//	public void delete(Member member);     			 // 회원탈퇴
	
}
