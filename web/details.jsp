<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Details</title>
</head>
<body>
<center><h2>${details.topic }</h2></center>
<div style="font-size: 18px"><b>1# ${details.uname }</b></div><br/>
${details.postcontent }
<br/>
<br/>
<c:forEach items="${replyList }" var="reply" varStatus="status">
    <div style="font-size: 18px"><b>${status.count+1 }# ${reply.uname }</b></div><br/>
    ${reply.replycontent }<br/><br/>
</c:forEach>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
浏览次数：${details.browsetimes }
<br/>
<br/>
<c:choose>
    <c:when test="${empty sessionScope.session_user }">
        <center> <a href="<c:url value='/login.jsp'/>" target="_parent">登陆</a>才可以评论</center>
    </c:when>
    <c:otherwise>
        <hr/><br/>
        <c:choose>
            <c:when test="${not empty sessionScope.session_user.ifsuper }">
                <a href="<c:url value='/PostServlet?method=delete'/>" target="_parent" style="position: relative ;left:650px;">删除</a><br/><br/>
            </c:when>
        </c:choose>
        <form action="<c:url value='/ReplyServlet'/>" method="post">
            <input type="hidden" name="method" value="reply"/>
            <textarea name="replycontent" style="width:700px;height:250px; position: relative ;left:10px;" >
                    ${form.replycontent}
            </textarea>
            <br/>
            <input type="submit" value="评论" style="width:100px;height:30px; position: relative ;left:10px;">
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
