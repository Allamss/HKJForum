<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>HKJ论坛注册</title>
</head>
<body>
<br/><br/><br/><br/>
<center>
    <h1>注册</h1>
    <p style="color: red; font-weight: 500">
        <c:forEach items="${errors}" var="error">
            ${error.value}<br/>
        </c:forEach>
    </p>
    <form action="<c:url value='/UserServlet'/>" method="post">
        <input type="hidden" name="method" value="regist"/>
        <b>用户名：</b><input type="text" name="username" value="${form.username}"/><br/><br/>
        <b>密 码：&nbsp&nbsp</b><input type="password" name="password" value="${form.password}"/><br/><br/>
        <input type="submit" value="注册" style="width:100px;height:30px;">
    </form>
</center>
</body>
</html>
