<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Top</title>
    <style type="text/css">
        body {
            background: #27408B;
        }
        a {
            text-transform:none;
            text-decoration:none;
            color:#00FFFF;
            align: right;
        }
        a:hover {
            text-decoration:underline;
        }
    </style>
</head>
<body>
<h1 style="text-align: center;">黑科技论坛</h1>
<div style="font-size: 10pt; ">
    <c:choose>
        <c:when test="${empty sessionScope.session_user }">
            <b><a href="<c:url value='/login.jsp'/>" target="_parent">登录</a>&nbsp; |&nbsp; </b>
            <b><a href="<c:url value='/regist.jsp'/>" target="_parent">注册</a></b>
        </c:when>
        <c:otherwise>
            <b><font size="3">&nbsp&nbsp您好,${sessionScope.session_user.username}&nbsp;&nbsp;&nbsp;&nbsp;<br/><br/></font></b>
            &nbsp&nbsp<a href="<c:url value='/post.jsp'/>" target="_parent">发帖</a>&nbsp;&nbsp;
            <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退出</a>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
