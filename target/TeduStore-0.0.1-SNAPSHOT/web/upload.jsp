<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px">
<!-- 
1.method="post" ：上传文件比较大，所以不能使用get，要使用post
2.enctype="multipart/form-data"
enctype的值必须为multipart/fprm-data,才能实现上传的功能
3.<input type="file">
上传组件使用file
-->
	<form action="${pageContext.request.contextPath }/upload/uploadFile.do" method="post"
	enctype="multipart/form-data">
	请选中文件:
		<input type="file" name="file" id="file">
		<br>
		<input type="submit" value="上传">
	</form>
</body>
</html>