<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>毕业生党员组织关系转移网上登记系统</title>
</head>
<body>
	${result}
	<form action="/Party/Login" method="post">
	用户名：<input type="text" name="username">
	密码：<input type="password" name="userpass">
	<input type="submit" value="提交">
	</form>
	<a href="/Party/upload.jsp">上传文件</a>
</body>
</html>