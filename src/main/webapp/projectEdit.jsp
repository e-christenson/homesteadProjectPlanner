<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp" />

<html>
<body>
<main class="container bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />



    <div id="main" class="row">
        <h2 class="mx-auto">Edit your project</h2><br>
    </div>

<div class="row text-center">

        <form action="HPPaddProject" method="POST" class="mx-auto border">
            <p>User : ${cognitoUser.name}</p>
            <p>ID of project : ${projectEdit.id}</p>
            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />
            <input type="hidden" name="projectEditID" id="projectEditID" value="${projectEdit.id}"/><br />
            <input type="hidden" name="date" id="date" value="${projectEdit.date}"/><br />



            <div class="form-group">
            <label for="projectName">Project Name</label>
            <input type="text" value="${projectEdit.project_name} " name="projectName" id="projectName"/><br />
            </div>

            <div class="form-group">
            <label for="helper">Project Helper Name</label>
            <input type="text" value="${projectEdit.helper}" name="helper" id="helper"/><br />
            </div>

            <fieldset class="border border-dark rounded">
            <div class="form-group">

                <c:choose>
                    <c:when test="${empty storeList}">
            <h3>this project has 0 store items </h3>
                    </c:when>
                    <c:otherwise>
                        <p>Current Items from store:</p>
                        <p>${storeList}</p>
                        <p> To remove items visit the  <a class="nav-link" href="storeList">Store List Page</a></p>
                    </c:otherwise>
                </c:choose>



                <label for="store">enter additional items</label>
                <input type="text"  name="store" id="store"/><br />



            </div>
            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Is this a weekend or weekday project</h3>
                <p>if one is better, select it. </p>
                <div class="form-group">

                    <c:choose>
                       <c:when test="${empty projectEdit.mon_fri}">
                           <input type="checkbox" value="y" id="weekDay" name="Wday" >
                             <label for="weekDay">Weekday</label>
                       </c:when>
                        <c:otherwise>
                            <input type="checkbox" value="y" id="weekDay" name="Wday" checked>
                            <label for="weekDay">Weekday</label>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${empty projectEdit.sat_sun}">
                            <input type="checkbox" value="y" id="weekend"  name="Sday" >
                            <label for="Weekend">Weekend</label>
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" value="y" id="weekend"  name="Sday" checked>
                            <label for="Weekend">Weekend</label>
                        </c:otherwise>
                    </c:choose>

                </div>
            </fieldset>
            <fieldset class="border border-dark rounded">
                <h3>Location of the project</h3>

                <c:choose>
                    <c:when test="${empty projectEdit.in_out}">
                        <input type="radio" value="i" id="inside" name="in_out"  >
                        <label for="inside">Inside</label>

                        <input type="radio" value="" id="outside"  name="in_out" checked >
                        <label for="outside">Outside</label>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" value="i" id="inside" name="in_out" checked >
                        <label for="inside">Inside</label>

                        <input type="radio" value="" id="outside"  name="in_out"  >
                        <label for="outside">Outside</label>

                    </c:otherwise>
                </c:choose>


            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Pick useful weather conditions</h3>
                <p>leave blank if these don't apply</p>

                <div class="form-group">
                <c:choose>
                    <c:when test="${projectEdit.hot_cold == 'h'}">

                            <input type="radio" value="h" id="hot" name="hot_cold" checked >
                            <label for="hot">Hot Day</label>


                    </c:when>
                    <c:otherwise>

                        <input type="radio" value="h" id="hot" name="hot_cold"  >
                        <label for="hot">Hot Day</label>

                    </c:otherwise>
                </c:choose>
                </div>

                <div class="form-group">
                    <c:choose>
                        <c:when test="${projectEdit.hot_cold == 'c'}">

                            <input type="radio" value="c" id="cold"  name="hot_cold" checked >
                            <label for="cold">Cold Day</label>



                        </c:when>
                        <c:otherwise>
                            <input type="radio" value="c" id="cold"  name="hot_cold" >
                            <label for="cold">Cold Day</label>

                        </c:otherwise>
                    </c:choose>



                </div>
                <div class="form-group">

                    <c:choose>
                        <c:when test="${projectEdit.windy == 'w'}">

                            <input type="radio" value="w" id="wind" name="windy" checked >
                            <label for="wind">Windy Day</label>


                        </c:when>
                        <c:otherwise>

                            <input type="radio" value="w" id="wind" name="windy"  >
                            <label for="wind">Windy Day</label>

                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="form-group">
                    <c:choose>
                        <c:when test="${projectEdit.windy == 'c'}">

                            <input type="radio" value="c" id="calm"  name="windy" checked >
                            <label for="calm">Calm Day</label>



                        </c:when>
                        <c:otherwise>
                            <input type="radio" value="c" id="calm"  name="windy" >
                            <label for="cold">Calm Day</label>

                        </c:otherwise>
                    </c:choose>


                </div>

            </fieldset>



            <input type="submit" value="Submit">



        </form>
    </div>


</div>
</main>

</body>
</html>

