<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css" type="text/css">
<script type="text/javascript">
	function search(){
		clear();
		var str=document.getElementById("keyword").value;
		var result;
		if(str==""){
			clear();
			return;
		}
		var xmlhttp;
		if(window.XMLHttpRequest){
			xmlhttp=new XMLHttpRequest();
		}else{
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange=function(){
			if(xmlhttp.readyState==4&&xmlhttp.status==200){
				var data=xmlhttp.responseText;
				var result=eval('('+data+')');
				setContent(result);
			}
		}
		
		xmlhttp.open("get","search?keyword="+str,"true");
		xmlhttp.send();
	}
	
	function setContent(contents){
		var size=contents.length;
		for(var i=0;i<size;i++){
			var li=document.createElement("li")
			var text=document.createTextNode(contents[i]);
			li.appendChild(text);
			document.getElementById("advice").appendChild(li);
		}
	}
	function clear(){
		var ul=document.getElementById("advice");
		var lis=document.getElementsByTagName("li");
		for(var i=lis.length-1;i>=0;i--){
			ul.removeChild(lis[i]);
		}
	}
</script>
</head>
<body>
	<div id="container">
		<div id="logo"></div>
		<form action="doSearch" method="post">
			<input type="text" id="keyword" onkeyup="search()" name="key">
			<input type="submit" value="搜索一下" id="sub">
			<ul id="advice">
			</ul>
		</form>
	</div>
</body>
</html>