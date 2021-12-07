<%@include file="head.jsp" %>
<%@include file="taglib.jsp" %>
<html>
<body>
<main class="container bg-light">
    <%@include file="header.jsp" %>
    <%@include file="navigation.jsp" %>


    <div class="row">
        <article class="col-md-8 text-center">
            <c:choose>
            <c:when test="${empty cognitoUser}">
                <h2><a href="logIn">Please Log in</a></h2>
            </c:when>
            <c:otherwise>


            <h2>Store shopping list for: ${cognitoUser.name}</h2>
                <h3>Total items: ${storeList.size()}</h3>
            <table id="userTable" class="table ">
                <thead class="thead-dark">


                <th>Items </th>
                <th>Actions</th>

                </thead>
                <tbody>
                <c:forEach var="store" items="${storeList}">
                    <tr>

                        <td>${store.getItem()} </td>
                        <td><a href="HPPdeleteProject?projectId=${project.getId()}"/> DELETE </a> </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>

        </article>

        <article class="col-md-3 text-center mx-2 my-auto">
            <img src="images/weatherMap.jpg" class="img-fluid" alt="weatherIcon">
            <p>Weather for ZIP: ${cognitoUser.zip_code}</p>

            <table id="weatherTable" class="table table-sm">
                <thead class="thead-success">

                <th>Day</th>
                <th>Condition</th>
                <th>High</th>
                <th>Low</th>

                </thead>
                <tbody>

                <tr>
                    <td>Today</td>
                    <td>${currentWeather.getDataseries().get(0).getWeather()} </td>
                    <td>${currentWeather.getDataseries().get(0).getTemp2m().getMax()}</td>
                    <td>${currentWeather.getDataseries().get(0).getTemp2m().getMin()}</td>
                </tr>

                <tr>
                    <td>Tomorrow</td>
                    <td>${currentWeather.getDataseries().get(1).getWeather()} </td>
                    <td>${currentWeather.getDataseries().get(1).getTemp2m().getMax()}</td>
                    <td>${currentWeather.getDataseries().get(1).getTemp2m().getMin()}</td>
                </tr>


                </tbody>
            </table>


        </article>

    </div>


    </c:otherwise>
    </c:choose>


    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</main>
</body>
</html>