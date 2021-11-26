<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<main class="container bg-light">
    <%@include file="header.jsp"%>
        <%@include file="navigation.jsp"%>
    <main>

        <div class="row">
            <article class="col-md-9 text-center">
<c:choose>
    <c:when test="${empty cognitoUser}">
        <a href = "logIn">Log in</a>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${cognitoUser.name}</h3>
        <h2>Your email is: ${cognitoUser.getEmail()}</h2>
        <h3>Total Projects: ${projects.size()}</h3>

        <table id="userTable" class="display border border-primary" cellspacing="0" width="100%">
            <thead>
            <th>ID</th>
            <th>Name</th>

            </thead>
            <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>
                    <td>${project.getId()} </td>
                    <td>${project.getProject_name()} </td>


                </tr>

            </c:forEach>
            </tbody>
        </table>
        </div>
        </article>

        <a href = "welcome.jsp">HOME</a>
        <a href = "displayAllUsers.jsp">all user (testing)</a>




    </c:otherwise>
</c:choose>
</main>
</body>
</html>