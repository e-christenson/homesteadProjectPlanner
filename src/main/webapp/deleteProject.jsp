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
       <h2> <a href = "logIn">Please Log in</a> </h2>
    </c:when>
    <c:otherwise>
        <h3>Welcome ${cognitoUser.name}</h3>

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

        <h2>Please select a project to delete </h2>

        <form action="HPPdeleteProject" method="POST">

            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />

            <label for="projectId">Project ID to delete </label>
            <input type="text" name="projectId" id="projectId"/><br />
            <input type="submit" value="Submit">


        </form>




    </c:otherwise>
</c:choose>
</main>
</body>
</html>