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
        <article class="col-md-12 text-center">
            <c:choose>
            <c:when test="${empty cognitoUser}">
                <div class="row">
                    <h3 class="col-md-11 mx-5 bg-warning text-center border"> <a href="logIn">Please Log in</a></h3>
                </div>


                <div class="row">

                    <article class="col-md-4 text-center">
                        <h3>About Homestead Project Planner</h3>
                        <p> Do you have a list of projects ? Maybe you have several lists of projects scattered about.    Homestead Project Planner
                            is a website where you can record and organize all your projects in one place.  We will help you put your project lists
                            into the cloud with our websites project entry form.   If you are a new user clicking the Login button will
                            allow you to create an account and get started.</p>
                    </article>

        <article class="col-md-4 text-center">
            <h3>Today's Projects: <small class="text-muted">Narrow down your list</small></h3>
            <img src="images/weatherMap.jpg" class="card-img-top w-50 mx-auto rounded" alt="weather">
            <p> Homestead Project Planner keeps an eye on current weather Conditions
                and helps you decide what projects to work on today.   When you enter a New
                project you have the option to enter weather conditions for the project.  For example,
                if you were entering a project "Burn the brush pile", you could check the "calm day" checkbox on the
                project entry page.  Now that project will only appear in your Today's Projects list if its a calm day.</p>
        </article>

        <article class="col-md-4 text-center">
            <h3>Store List: <small class="text-muted">Keep track of materials you need</small></h3>
            <img src="images/store.png" class="card-img-top w-25 mx-auto rounded" alt="storeIcon">
            <p> When you enter a project you have the option to enter items you may need for that project.  You can then
                checkout our Store List section and see items from every project, all in one place.  As you pickup the
                materials you need, you can remove the items from your store list page as well.</p>
        </article>


    </div>



</c:when>
            <c:otherwise>


            <h3> ${cognitoUser.name}'s Projects</h3>
                <p>A listing of all of your Homestead's projects.  You can click on the column header
                to sort by field type. Projects can be edited or deleted by clicking on the action column links.</p>

            <table id="ProjectsTable" class="display table table-sm table-responsive-sm table-bordered table-striped">
                <thead class="thead-dark">

                <th>Name</th>
                <th>Date</th>
                <th>Conditions</th>
                <th>Action</th>
                </thead>
                <tbody>
                <c:forEach var="project" items="${projects}">
                    <tr>
                        <td>${project.project_name} </td>
                        <td>${project.date} </td>

                        <td>
                            <div class="row mx-3">

                                <c:choose>
                                    <c:when test="${empty project.helper}">

                                    </c:when>
                                    <c:otherwise>
                                        <a class="nav-link" href="myHelp.jsp"><img src="images/helper.png"  width="25" height="25" alt="H"></a></li>

                                    </c:otherwise>
                                </c:choose>

                                <c:choose>
                                    <c:when test="${empty project.store}">

                                    </c:when>
                                    <c:otherwise>
                                        <a class="nav-link" href="storeList"><img src="images/store.png"  width="30" height="30" alt="H"></a></li>

                                    </c:otherwise>
                                </c:choose>


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
                        <td><a href="projectEdit?projectId=${project.getId()}" class="text-success" mx-2/>Edit</a>
                            <a href="HPPdeleteProject?projectId=${project.getId()}" class="text-danger px-2"/> Del </a>
                        </td>
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
                <th>--- </th>
                <th>High</th>
                <th>Low</th>
                <th>Wind (0-5)</th>

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