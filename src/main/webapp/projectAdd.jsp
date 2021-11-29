<%@include file="head.jsp"%>
<%@include file="taglib.jsp"%>
<html>
<body>
<main class="container bg-light">
    <%@include file="header.jsp"%>
    <%@include file="navigation.jsp"%>

<div id="container">

    <div id="main" class="row">
        <h2>Add Project page for ${cognitoUser.name}</h2><br>




        <form action="HPPaddProject" method="POST" class="border">

            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />

            <label for="projectName">Project Name</label>
            <input type="text" name="projectName" id="projectName"/><br />



            <fieldset class="border border-dark rounded">
                <h3>Project Details </h3>

                <div class="form-group">
                    <input type="radio" value="m" id="weekDay" name="day"  >
                    <label for="weekDay">Weekday Project</label>

                    <input type="radio" value="s" id="weekend"  name="day" >
                    <label for="Weekend">Weekend Project</label>

                    <input type="radio" value="b" id="both"  name="day">
                    <label for="both">Any Day Project</label>
                </div>

            </fieldset>

            <input type="submit" value="Submit">


        </form>
    </div>


</div>


</body>
</html>

