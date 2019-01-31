<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Left</title>
    <base target="body"/>
    <style type="text/css">
        *{
            font-size:12pt;
            text-align: center;
        }
        div {
            background: #87CEFA;
            margin: 3px;
            padding: 3px;
        }
        a {
            text-decoration: none;
        }
    </style>
</head>
<body>
<div style="background:#009ACD">
    帖子
</div>
<c:forEach items="${postList }" var="post">
    <div>
        <a href="<c:url value='/PostServlet?method=findByPid&pid=${post.pid }'/>">${post.topic }</a>
    </div>
</c:forEach>
</body>
</html>
