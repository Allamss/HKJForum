<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 16:14
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
    <base href="<%=basePath%>">
    <title>Post</title>
</head>
<body>
<br/>
<c:choose>
    <c:when test="${empty sessionScope.session_user }">
        <h1>您还没有登录 赶快登陆吧</h1><br/>
        <a href="<c:url value='/login.jsp'/>" target="_parent">登陆</a><br/>
        <a href="<c:url value='/regist.jsp'/>" target="_parent">注册</a><br/>
    </c:when>
    <c:otherwise>
        <p style="color: red; font-weight: 500">
                ${error.value}<br/>
            <c:forEach items="${errors}" var="error">
                ${error.value}<br/>
            </c:forEach>
        </p>
        <form action="<c:url value='/PostServlet'/>" method="post">
            <input type="hidden" name="method" value="post"/>
            标题 <input type="text" name="topic" value="${form.topic}"  style="width:500px"/><br/>
            <br/>
            <textarea name="postcontent" style="width:900px;height:450px">
                    ${form.postcontent}
            </textarea>
            <br/>
            <input type="submit" value="发表">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
