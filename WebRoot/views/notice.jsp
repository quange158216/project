<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告信息</title>
<style type="text/css">
	table {
	margin: 10% auto 0 auto;
	background: #ccc;
	padding: 50px;
	font-size: 18px;
}	
	table .info{
		display:inline-block;
		margin-right: 200px;
		width: 540px;
	}
	table tr{
		margin-bottom: 40px;
		color: #000;
		padding: 5px 0;
	}
	table tbody{
		display:block;
		width: 1187px;
		height: 300px;
	}
	table a {
	text-decoration: none;
}
</style>
</head>
<body>
		<table>
			<tbody>
					<c:forEach var="notice" items="${ notice.noticesList }">
						<tr>
							<td class="info"><a href="${ pageContext.request.contextPath }/notice/findNoticeById.action?nid=${ notice.nid }">${ notice.ntitle }</a></td>
							<td class="time">${ notice.ttime }</td>
						</tr>
					</c:forEach>
			</tbody>

		</table>
				
				<center>
					第${ notice.pageCode }页/共${ notice.totalPage }页
					<c:if test="${ notice.totalPage ne 1 }">
						<a href="${ pageContext.request.contextPath }/notice/list.action?pc=${ 1 }">首页</a>
					</c:if>
					<c:if test="${ notice.pageCode > 1 }">
						<a href="${ pageContext.request.contextPath }/notice/list.action?pc=${ notice.pageCode - 1 }">上一页</a>
					</c:if>
					
					<!-- 定义属性 -->
					<c:choose>
						<c:when test="${ notice.totalPage <= 10 }">	
							<c:set var="begain" value="1"></c:set>
							<c:set var="end" value="${ notice.totalPage }"></c:set>
						</c:when>
						<c:otherwise>
							<c:set var="begain" value="${ notice.pageCode - 5 }"></c:set>
							<c:set var="end" value="${ notice.pageCode + 4 }"></c:set>
							<!-- 头溢出 -->
							<c:if test="${ begain < 1 }">
								<c:set var="begain" value="1"></c:set>
								<c:set var="end" value="10"></c:set>
							</c:if>
							<!-- 尾溢出 -->
							<c:if test="${ end > notice.totalPage }">
								<c:set var="begain" value="${ notice.totalPage - 9 }"></c:set>
								<c:set var="end" value="${ notice.totalPage }"></c:set>
							</c:if>
						</c:otherwise>
					</c:choose>
					
					<!-- 循环 -->
					<c:forEach var="i" begin="${ begain }" end="${ end }">
						<a href="${ pageContext.request.contextPath }/notice/list.action?pc=${ i }">[${ i }]</a>
					</c:forEach>
					
					<c:if test="${ page.pageCode < page.totalPage }">
						<a href="${ pageContext.request.contextPath }/notice/list.action?pc=${ notice.pageCode + 1 }">下一页</a>
					</c:if>
					<c:if test="${ page.totalPage ne 1 }">
						<a href="${ pageContext.request.contextPath }/notice/list.action?pc=${ notice.totalPage }">尾页</a>
					</c:if>
				</center>
</body>
</html>