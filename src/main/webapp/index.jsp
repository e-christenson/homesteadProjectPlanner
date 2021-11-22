<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<c:choose>
    <c:when test="${empty cognitoUser}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${cognitoUser.name}</h3>
        <h2>Your email is: ${cognitoUser.getEmail()}</h2>
    </c:otherwise>
</c:choose>
</body>
</html>