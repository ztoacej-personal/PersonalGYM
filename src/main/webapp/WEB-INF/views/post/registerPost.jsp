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
	<h1 class="h3 mb-2 text-gray-800">Register Post</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-body">
			<form id="frmPost" role="form" action="/post/registerPost" method="post">
				<%@include file="./include/postCommon.jsp"%>
				
				<button id='btnRegistPost' type="submit" class="btn btn-primary">Register</button>
				<button type="reset" class="btn btn-danger">Clear</button>

				<input type="hidden" name="boardId" value="${boardId}">
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
		setOprationMode("create");

		var frmPost = $("#frmPost");

		//게시물 등록 기능 
		$("#btnRegistPost").on("click", function(e){
			e.preventDefault();
			addAttachToFrmAsHidden(frmPost);
			frmPost.submit();
		});
	})
</script>
