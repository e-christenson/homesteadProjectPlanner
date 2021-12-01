<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<main class="container bg-light">
    <%@include file="header.jsp"%>
        <%@include file="navigation.jsp"%>


        <div class="row">
            <article class="col-md-9 text-center">
<c:choose>
    <c:when test="${empty cognitoUser}">
       <h2> <a href = "logIn">Please Log in</a> </h2>
    </c:when>
    <c:otherwise>
        <h2>Welcome ${cognitoUser.name}</h2>

        <h3>Total Projects: ${projects.size()}</h3>

        <table id="userTable" class="table ">
            <thead class="thead-dark">

            <th>Name</th>
            <th>Helper</th>
            <th>Actions</th>

            </thead>
            <tbody>
            <c:forEach var="project" items="${projects}">
                <tr>

                    <td>${project.getProject_name()} </td>
                    <td>${project.getHelper()} </td>
                    <td><a href="HPPdeleteProject?projectId=${project.getId()}"/> DELETE </a> </td>


                </tr>

            </c:forEach>
            </tbody>
        </table>
        </div>
        </article>






    </c:otherwise>
</c:choose>
</main>
</body>
</html>