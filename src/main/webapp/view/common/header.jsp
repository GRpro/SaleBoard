<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${pageContext.request.contextPath}/res/panel_style.css" rel="stylesheet" type="text/css" media="screen" />
<nav class = "nav-primary" role = "navigation">
    <ul role = "menubar">
        <li role = "presentation"><a href = "${root}/home" role = "menuitem">Home</a></li>
        <li role = "presentation"><a href = "${root}/settings" role = "menuitem">Settings</a></li>
        <li role = "presentation"><a href = "#" role = "menuitem">About us</a></li>
    </ul>
</nav>