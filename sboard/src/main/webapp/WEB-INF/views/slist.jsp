<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		$('.edit1').click(function() {
			var id  = $(this).attr('id');  // rno, $(this)로 class값이 edit1인 버튼중 하나만 가져온다.
			var txt = $('#td_'+id).text(); // replytext
			
			// 수정버튼 클릭시 내용부분을 textarea로 변환하여 수정할 수 있도록 변환
			$('#td_'+id).html("<textarea rows='3' cols='30' id='tt_"+id+"'>"+txt
				+"</textarea>");
			$('#btn_'+id).html(
			   "<input type='button' value='확인' onclick='up("+id+")'> "
			  +"<input type='button' value='취소' onclick='lst()'>");
		});
	});
	
	// 댓글 수정
	function up(id) {
		var replytext = $('#tt_'+id).val();
		var formData = "rno="+id+'&replytext='+replytext
			+"&bno=${board.num}";
		$.post('${path}/repUpdate',formData, function(data) {
			$('#slist').html(data);
		});
	}
	
	// 취소 버튼
	function lst() {
		$('#slist').load('${path}/slist/num/${board.num}');
	}
	
	// 댓글 삭제
	function del(rno,bno) {
		var formData="rno="+rno+"&bno="+bno;
		$.post("${path}/repDelete",formData, function(data) {
			$('#slist').html(data);
		});
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<h2 class="text-primary">댓글</h2>
		<table class="table table-bordered">
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>수정일</td>
				<td></td>
			</tr>
			<c:forEach var="rb" items="${slist}">
				<tr>
					<td>${rb.replyer}</td>
					<td id="td_${rb.rno}">${rb.replytext}</td>
					<td>${rb.updatedate }</td>
					<td id="btn_${rb.rno}">
						<c:if test="${rb.replyer==board.writer }">
							<input type="button" value="수정" class="edit1" id="${rb.rno}">
							<input type="button" value="삭제"	 onclick="del(${rb.rno},${rb.bno})">
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>