<%@page import="com.search.entitys.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% List<Message> list=(List<Message>)request.getAttribute("list");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach items="${list}" var="advice">
			<tr>
				<td><a href="${advice.getUrl()}"><c:out value="${advice.getTitle()}"></c:out></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>