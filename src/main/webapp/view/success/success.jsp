<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success page</title>
</head>
<body>

    <%@ include file="/view/common/header.jsp" %>

    <h3>Success!</h3><br><hr>
    <h4 style="color: green">${message}</h4>
</body>
</html>
