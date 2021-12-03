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

        </article>
            <article class="col-md-3 text-center">
                <p>Weather for zip code :  ${cognitoUser.zip_code}</p>

                <p>Todays High Temperature ${currentWeather.getDataseries().get(0).getTemp2m().getMax()}
                     Todays Low Temperature ${currentWeather.getDataseries().get(0).getTemp2m().getMin()}  </p>

            </article>


        </div>






    </c:otherwise>
</c:choose>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</main>
</body>
</html>