<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp" />

<html>
<body>
<main class="container bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />



    <div id="main" class="row">
<c:choose>
    <c:when test="${empty cognitoUser}">
        <h2><a href="logIn">Please Log in</a></h2>
    </c:when>
    <c:otherwise>

        <h2 class="mx-auto">Enter New Project</h2><br>
    </div>

<div class="row text-center">



        <form action="HPPaddProject" method="POST" class="mx-auto border needs-validation" novalidate>
            <p>User : ${cognitoUser.name}</p>
            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />

            <div class="form-group">
            <label for="projectName" class="form-label">Project Name (required)</label>
            <input type="text" name="projectName" id="projectName" class="form-control" pattern="[a-zA-z\d][^{}]{1,99}" required /><br />

                <div class="valid-feedback">Looks good!</div>
                <div class="invalid-feedback">Something isn't right. up to 99 characters, letters numbers ok, no {} allowed </div>

            </div>

            <div class="form-group">
            <label for="helper">Project Helper Name</label>
            <input type="text" name="helper" id="helper" class="form-control" pattern="[a-zA-z\d][^{}]{1,40}"/><br />

                <div class="valid-feedback">Looks good!</div>
                <div class="invalid-feedback">Something isn't right. up to 40 characters, letters numbers ok, no {} allowed </div>
            </div>

            <div class="form-group">
            <label for="store">Items needed from Store with a space between them (space=new item)</label>
            <input type="text" name="store" id="store" class="form-control" pattern="[a-zA-z\d][^{}]{1,99}" /><br />

                <div class="valid-feedback">Looks good!</div>
                <div class="invalid-feedback">Something isn't right. up to 99 characters, letters numbers ok, no {} allowed
            </div>


            <fieldset class="border border-dark rounded">
                <h3>When</h3>
                <p>Default is any day- but you can change that below  </p>
                <div class="form-group">
                    <fieldset class="border border-secondary rounded mx-5">
                    <input type="radio" value="y" id="weekDay" name="Wday"  >
                    <label for="weekDay">Weekday</label>

                    <input type="radio" value="y" id="weekend"  name="Sday" >
                    <label for="Weekend">Weekend</label>

                        <input type="radio" value="" id="any"  name="Sday" checked>
                        <label for="any">Any Day</label>

                    </fieldset>

                </div>
            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Where</h3>
                <p>Default is outside- but you can change that below</p>
                <div class="form-group">
                    <fieldset class="border border-secondary rounded mx-5">
                    <input type="radio" value="i" id="inside" name="in_out"  >
                    <label for="inside">Inside</label>

                    <input type="radio" value="" id="outside"  name="in_out" checked >
                    <label for="outside">Outside</label>
                    </fieldset>
                </div>
            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Pick useful weather conditions</h3>
                <p>leave blank if these don't apply</p>
                <p></p>
                <div class="form-group">
                    <fieldset class="border border-secondary rounded mx-5">
                    <input type="radio" value="h" id="hot" name="hot_cold"  >
                    <label for="hot">Hot Day</label>

                    <input type="radio" value="c" id="cold"  name="hot_cold" >
                    <label for="cold">Cold Day</label>
                    </fieldset>

                </div>
                <div class="form-group">
                    <fieldset class="border border-secondary rounded mx-5">
                    <input type="radio" value="w" id="windy" name="windy"  >
                    <label for="windy">Windy Day</label>

                    <input type="radio" value="c" id="calm"  name="windy" >
                    <label for="calm">Calm Day</label>
                    </fieldset>

                </div>

            </fieldset>



            <input type="submit" value="Submit">



      </div>
   </form>
    </c:otherwise>
    </c:choose>

</div>
    <script src="javascript/formValidation.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</main>

</body>
</html>

