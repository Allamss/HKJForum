<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/29
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HKJ论坛</title>
    <!-- css -->
    <style type="text/css">
        *{
            font-size:10pt;
        }
        body{
            text-align:center;
        }
        .table{
            width:1024px;
            height:100%;
            border:1px solid gray;/*固定边框,1像素*/
            border-collapse: collapse;/*单线的列表边框*/
        }
        .table td{
            border:1px solid gray;/*固定边框,1像素*/
        }
        iframe {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
    <table class="table" align="center">
        <tr style="background: green; height: 120px; ">
            <td colspan="2" align="center">
                <iframe frameborder="0" src="<c:url value='/top.jsp'/>" name="top"></iframe>
            </td>
        </tr>
        <tr>
            <td width="240" style="padding:5px;" align="center" valign="top">
                <iframe frameborder="0" width="120" src="<c:url value='/PostServlet?method=findAll'/>" name="left"></iframe>
            </td>
            <td>
                <iframe frameborder="0" src="<c:url value='/body.jsp'/>" name="body"></iframe>
            </td>
        </tr>
    </table>
</body>
</html>
