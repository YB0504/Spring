select * from tab;
select * from board;
select * from REPLYBOARD;

-- 댓글 게시판
drop table replyBoard;
create table replyBoard (
	rno number primary key,
	bno number not null references board(num),	-- 반드시 값을 가져가야함
	replytext varchar2(500) not null,
	replyer varchar2(50) not null,				-- 댓글 사용자(여기까지)
	regdate date not null,
	updatedate date not null
);
select * from REPLYBOARD;
select * from board order by num desc;
insert into REPLYBOARD values(10,262,'11','나',sysdate,sysdate);