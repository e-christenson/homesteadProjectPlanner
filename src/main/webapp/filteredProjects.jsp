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
        <article class="text-center px-3 mx-auto">
            <c:choose>
            <c:when test="${empty cognitoUser}">
                <h2><a href="logIn">Please Log in</a></h2>
            </c:when>
            <c:otherwise>

                <h2>Based on your weather today:</h2>
                <ul class="list-group">
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Removed due to high wind
                        <span class="badge bg-primary text-white rounded-pill">${removedWind}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Removed because its not hot enough
                        <span class="badge bg-primary text-white rounded-pill">${removedHot}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between align-items-center">
                        Removed because its not cold enough
                        <span class="badge bg-primary text-white rounded-pill">${removedCold}</span>
                    </li>
                </ul>
    </div>
    </article>

          <div class="row">

<div class="table-responsive">

                <table id="ProjectsTable" class="display table  table-bordered table-striped mx-3 mx-auto">
                    <thead class="thead-dark">

                    <th>Name</th>
                    <th>Date</th>
                    <th>Action</th>
                    <th>Day</th>
                    <th>Indoor</th>
                    <th>Conditions</th>

                    </thead>
                    <tbody>
                    <c:forEach var="project" items="${fProjects}">
                        <tr>
                            <td>${project.project_name} </td>
                            <td>${project.date} </td>
                            <td><a href="projectEdit?projectId=${project.getId()}" class="text-success" mx-2/>Edit</a>
                                <a href="HPPdeleteProject?projectId=${project.getId()}" class="text-danger px-2"/> Del </a>
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${project.mon_fri =='y'}">
                                        Only Weekday
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${project.sat_sun =='y'}">
                                        Weekends Only
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>


                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${project.in_out =='y'}">
                                        Store items needed
                                    </c:when>
                                    <c:otherwise>
                                    </c:otherwise>
                                </c:choose>



                            </td>
                            <td>
                                <div class="row mx-3">
                                    <c:choose>
                                        <c:when test="${project.in_out =='i'}">
                                            <img src="images/atHome.png"  width="25" height="25" alt="w">
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${project.windy =='w'}">
                                            <img src="images/windy.png"  width="25" height="25" alt="w">
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${project.windy =='c'}">
                                            <img src="images/calm.png"  width="25" height="25"  alt="w">
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${project.hot_cold =='h'}">
                                            <img src="images/hot.png"  width="25" height="25"  alt="w">
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${project.hot_cold =='c'}">
                                            <img src="images/cold.png"  width="25" height="25"  alt="w">
                                        </c:when>
                                        <c:otherwise>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </td>

                        </tr>

                    </c:forEach>
                    </tbody>
                </table>
</div>


    </div>

    <div class="row">
        <article class="col-md-6 text-center mx-2 my-auto">
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

                <tr>
                    <td>Day After Tomorrow</td>
                    <td>${currentWeather.getDataseries().get(2).getWeather()} </td>
                    <td>${currentWeather.getDataseries().get(2).getTemp2m().getMax()}</td>
                    <td>${currentWeather.getDataseries().get(2).getTemp2m().getMin()}</td>
                    <td>${currentWeather.getDataseries().get(2).getWind10mMax()}</td>
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