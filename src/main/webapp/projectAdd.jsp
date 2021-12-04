<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<main class="container bg-light">
    <%@include file="header.jsp"%>
    <%@include file="navigation.jsp"%>



    <div id="main" class="row">
        <h2>Add Project page</h2><br>
    </div>

<div class="row text-center">

        <form action="HPPaddProject" method="POST" class="border">

            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />

            <label for="projectName">Project Name</label>
            <input type="text" name="projectName" id="projectName"/><br />

            <label for="helper">Project Helper Name</label>
            <input type="text" name="helper" id="helper"/><br />

            <label for="store">Items needed from Store</label>
            <input type="text" name="store" id="store"/><br />



            <fieldset class="border border-dark rounded">
                <h3>Day of the week works best for this project</h3>
                <div class="form-group">
                    <input type="radio" value="m" id="weekDay" name="day"  >
                    <label for="weekDay">Weekday</label>

                    <input type="radio" value="s" id="weekend"  name="day" >
                    <label for="Weekend">Weekend</label>

                    <input type="radio" value="b" id="both"  name="day" checked>
                    <label for="both">Any Day</label>
                </div>
            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Location of the project</h3>
                <div class="form-group">
                    <input type="radio" value="i" id="inside" name="in_out"  >
                    <label for="inside">Inside</label>

                    <input type="radio" value="o" id="outside"  name="in_out" checked >
                    <label for="outside">Outside</label>
                </div>
            </fieldset>

            <fieldset class="border border-dark rounded">
                <h3>Weather Factors- This project is best suited for </h3>
                <div class="form-group">
                    <input type="radio" value="h" id="hot" name="hot_cold"  >
                    <label for="hot">Hot Day</label>

                    <input type="radio" value="c" id="cold"  name="hot_cold" >
                    <label for="cold">Cold Day</label>

                    <input type="radio" value="b" id="hotcold"  name="hot_cold" checked>
                    <label for="both">Any Day</label>
                </div>
                <div class="form-group">
                    <input type="radio" value="w" id="windy" name="windy"  >
                    <label for="windy">Windy Day</label>

                    <input type="radio" value="c" id="calm"  name="windy" >
                    <label for="calm">Calm Day</label>

                    <input type="radio" value="b" id="anyW"  name="windy" checked>
                    <label for="anyW">Any Day</label>
                </div>

            </fieldset>



            <input type="submit" value="Submit">


        </form>
    </div>


</div>
</main>

</body>
</html>

