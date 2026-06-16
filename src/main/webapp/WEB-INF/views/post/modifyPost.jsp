<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>
<%@ page import="www.dream.com.framework.display.*"%>
<%@ page import="www.dream.com.board.model.*"%>

<%@include file="../includes/header.jsp"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시글 상세 조회</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-body">
			<form id="frm_modify_post" action="/post/modifyPost" method="post">
				<%@include file="./include/postCommon.jsp"%>
				
				<!-- data : 요소에 추가적으로 변수와 정보를 마음대로 넣을 수 있는 장치. *** 주의사항:웹은 대소문자 구분 없어 -->
				<sec:authentication property="principal" var="curUser"/>
				<sec:authorize access="isAuthenticated()">
					<c:if test="${curUser.loginUser.id eq post.writer.id}">
						<button type="submit" data-oper="modify" class="btn btn-warning btnControl">Modify</button>
						<button type="submit" data-oper="remove" class="btn btn-danger btnControl">Delete</button>
					</c:if>
				</sec:authorize>
			</form>
			<%@include file="./include/pagingCommon.jsp"%>
			
		</div>
	</div>
</div>
<!-- /.container-fluid -->
<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {
		//create read update
		setOprationMode("update");

		var postId = "${post.id}";
		var ownerType = "${post.ownerType}";
		//최 하단에 책에서 제시하는 개발 방식은 모듈화가 약해요. 따라서 이렇게 부르더라도 문서가 로드된 직후에 자동 호출합니다.
		//즉시 실행 함수와 같은 역할을 하는 것이지요!
		showAttachFileList({ownerId:postId, ownerType:ownerType});
		
		var frmModifyPost = $("#frm_modify_post");
		var frmPaging = $("#frmPaging");
		
		$(".btnControl").on("click", function(e) {
			e.preventDefault();

			var oper = $(this).data("oper");
			
			addAttachToFrmAsHidden(frmModifyPost);
			
			if (oper === "remove") {
				frmModifyPost.attr("action", "/post/removePost");
			}
			frmModifyPost.append(frmPaging.children());
			frmModifyPost.submit();
		});

	})
</script>
