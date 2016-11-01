<%@page import="com.search.entitys.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/content.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/getXmlHttpRequest.js"></script>
</head>
<body>
	<div id="container">
		<div id="search">
			<form action="doSearch" method="post">
				<a href="${pageContext.request.contextPath}/index.jsp"><img id="titleLogo" src="${pageContext.request.contextPath}/image/logo1.png"></a>
				<input type="text" id="keyword" onkeyup="search()" name="key" value="${param.key }">
				<input type="submit" value="搜索一下" id="sub">
				<ul id="advice">
				</ul>
			</form>
		</div>
		<div id="list">
			<table>
				<c:forEach items="${requestScope.list}" var="advice">
					<tr>
						<td class="msg" colspan="10"><span><a href="${advice.url}" target="_blank"><c:out value="${advice.title}"></c:out></a></span></td>
					</tr>
				</c:forEach>
				<tr>
					<c:forEach var="i" begin="0" end="9">
						<c:choose>
							<c:when test="${param.currentPage==i}">
								<td>${i+1}</td>
							</c:when>
							<c:otherwise>
								<td><a href="doSearch?key=${param.key}&currentPage=${i}" class="page">${i+1}</a></td>
							</c:otherwise>
						</c:choose>
					</c:forEach>         
				</tr>
			</table>
		</div>
	</div>
</body>
</html>