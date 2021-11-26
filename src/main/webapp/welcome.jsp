<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>


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
        <a href = "index.jsp">HOME</a>
        <a href = "displayAllUsers.jsp">all user (testing)</a>





</body>
</html>