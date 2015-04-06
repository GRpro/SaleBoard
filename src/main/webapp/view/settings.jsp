<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .itemForm {
            display: inline-block;
        }
        .formContainer {

        }
        .content {

        }
    </style>
</head>
<body>

    <%@ include file="/view/common/header.jsp" %>

    <div class="formContainer" style="margin: 0 auto;">
        <form class="itemForm" action="${root}/settings/board" method="post">
            <h4>New board</h4>
            <input type="text" name="name">
            <input type="submit">
        </form>

        <form class="itemForm" action="${root}/settings/sail" method="post">
            <h4>New sail</h4>
            <input type="text" name="name">
            <input type="submit">
        </form>

        <form class="itemForm" action="${root}/settings/tariff" method="post">
            <h4>New tariff</h4>
            <input type="text" name="tariff">
            <input type="submit">
        </form>

        <form class="itemForm" action="${root}/settings/trainer" method="post">
            <h4>New trainer</h4>
            <input type="text" name="name">
            <input type="submit">
        </form>
    </div>
    <div class="content">

    </div>


</body>
</html>
