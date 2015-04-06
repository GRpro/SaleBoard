<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
    <title>Home page</title>
<body>

    <%@ include file="/view/common/header.jsp" %>

    <h2 style="margin: 0 auto;">SaleBoard service</h2><br><hr>

    <table cellpadding="5" style="margin: 0 auto;">
        <form name="orderingForm" action="${root}/home/ordering" method="post">
            <tr>
                <td>Board</td>
                <td>Sail</td>
                <td>Trainer</td>
                <td>Tariff</td>
                <td>User Name</td>
                <td>Start point</td>
                <td>End point</td>
                <td>Total price</td>
                <td>Is paid</td>
            </tr>
            <tr>
                <td>
                    <select id="board" name="boardId">
                        <c:forEach items="${boards}" var="board">
                            <option value="${board.id}">${board.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select id="sail" name="sailId">
                        <c:forEach items="${sails}" var="sail">
                            <option value="${sail.id}">${sail.name}</option>
                        </c:forEach>
                    </select>

                </td>
                <td>
                    <select id="trainer" name="trainerId" >
                        <c:forEach items="${trainers}" var="trainer">
                            <option value="${trainer.id}">${trainer.name}</option>
                        </c:forEach>
                    </select>
                </td>
                <td>
                    <select id="tariff" name="tariffId">
                        <c:forEach items="${tariffs}" var="tariff">
                            <option value="${tariff.id}">${tariff.tariff}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="text" name="userName" ></td>
                <td><input type="text" name="startPoint" ></td>
                <td><input type="text" name="endPoint" ></td>
                <td><input type="text" name="price" ></td>
                <td>
                    <select name="paid">
                        <option value="true">True</option>
                        <option value="false">False</option>
                    </select>
                </td>
            </tr>
            <br>
            <tr><td><input type="submit" value="add ordering"></td></tr>
        </form>
    </table>

    <h3 style="margin: 0 auto;">Ordering list</h3>
    <table border="1" cellpadding="5" style="border: 1px solid black;
                    margin: 0 auto;">
        <tr style="background-color: seagreen">
            <td>Board</td>
            <td>Sail</td>
            <td>Trainer</td>
            <td>Tariff</td>
            <td>User Name</td>
            <td>Start point</td>
            <td>End point</td>
            <td>Total price</td>
            <td>Is paid</td>
            <td></td>
        </tr>
        <c:forEach items="${orderings}" var="ordering">
            <tr>
                <td>${ordering.board.name}</td>
                <td>${ordering.sail.name}</td>
                <td>${ordering.trainer.name}</td>
                <td>${ordering.tariff.tariff}</td>
                <td>${ordering.userName}</td>
                <td>${ordering.startPoint}</td>
                <td>${ordering.endPoint}</td>
                <td>${ordering.price}</td>
                <td>${ordering.paid}</td>
                <td><a href="#">options</a></td>
            </tr>
        </c:forEach>
    </table>



</body>
</html>
