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


            <h3> ${cognitoUser.name}'s Projects</h3>
                <p>A listing of all of your Homestead's projects.  You can click on the column header
                to sort by field type. Projects can be edited or deleted by clicking on the action column links.</p>

            <table id="ProjectsTable" class="display table table-bordered table-striped">
                <thead class="thead-dark">

                <th>Name</th>
                <th>Date</th>
                <th>Action</th>
                <th>Helper?</th>
                <th>Store Items</th>
                <th>Inside</th>

                </thead>
                <tbody>
                <c:forEach var="project" items="${projects}">
                    <tr>
                        <td>${project.project_name} </td>
                        <td>${project.date} </td>
                        <td><a href="projectEdit?projectId=${project.getId()}" class="text-success" mx-2/>Edit</a>
                            <a href="HPPdeleteProject?projectId=${project.getId()}" class="text-danger px-2"/> Del </a>
                        </td>
                        <td>${project.helper} </td>
                        <td>${project.getStore()} </td>
                        <td>${project.in_out} </td>

                    </tr>

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
                <th>MaxWind(0-5)</th>

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
                    <td>${currentWeather.getDataseries().get(0).getWind10mMax()}</td>
                </tr>


                </tbody>
            </table>


        </article>

    </div>


    </c:otherwise>
    </c:choose>



    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</main>
</body>
</html>