<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<jsp:include page="head.jsp" />
<!-- used for the sorting/paging on the table -->
<script type="text/javascript" class="init">

    $(document).ready( function () {
        $('#ProjectsTable').DataTable({
            "lengthChange": false

        });
    });



</script>
<body>
<main class="container-fluid bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />

    <div class="row">
        <article class="col-md-8 text-center">
            <c:choose>
            <c:when test="${empty cognitoUser}">
                <h2><a href="logIn">Please Log in</a></h2>
            </c:when>
            <c:otherwise>


            <h3> ${cognitoUser.name}'s Projects with helpers</h3>


            <table id="ProjectsTable" class="display table table-sm table-responsive-sm table-bordered table-striped">
                <thead class="thead-dark">

                <th>Project Name</th>
                <th>Helper Name</th>

                <th>Action</th>
                </thead>
                <tbody>
                <c:forEach var="project" items="${projects}">

                            <c:choose>
                                <c:when test="${project.helper.length() > 1 }">
                                    <tr>

                                    <td>


                                ${project.project_name} </td>


                        <td>${project.helper} </td>


                        <td><a href="projectEdit?projectId=${project.getId()}" class="text-success" mx-2/>Edit</a>
                            <a href="HPPdeleteProject?projectId=${project.getId()}" class="text-danger px-2"/> Del </a>



                        </td>
                    </tr>
                                </c:when>
                                <c:otherwise>
                                </c:otherwise>
                            </c:choose>
                </c:forEach>
                </tbody>
            </table>

        </article>

        <article class="col-md-3 text-center mx-2 my-auto">
            <img src="images/weatherMap.jpg" class="img-fluid" alt="weatherIcon">
            <h3>Weather for ZIP: ${cognitoUser.zip_code}</h3>

            <table id="weatherTable" class="table table-sm">
                <thead class="thead-success">

                <th>Day</th>
                <th>Condition</th>
                <th>High</th>
                <th>Low</th>
                <th>Wind(0-5)</th>

                </thead>
                <tbody>

                <tr>
                    <td>Today</td>
                    <td>${currentWeather.getDataseries().get(0).getWeather()} </td>
                    <td>${currentWeather.getDataseries().get(0).getTemp2m().getMax()}</td>
                    <td>${currentWeather.getDataseries().get(0).getTemp2m().getMin()}</td>
                    <td>${currentWeather.getDataseries().get(0).getWind10mMax()}</td>
                </tr>

                <tr>
                    <td>Tomorrow</td>
                    <td>${currentWeather.getDataseries().get(1).getWeather()} </td>
                    <td>${currentWeather.getDataseries().get(1).getTemp2m().getMax()}</td>
                    <td>${currentWeather.getDataseries().get(1).getTemp2m().getMin()}</td>
                    <td>${currentWeather.getDataseries().get(1).getWind10mMax()}</td>
                </tr>


                </tbody>
            </table>


        </article>
        </c:otherwise>
        </c:choose>

    </div>





    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</main>
</body>
</html>