<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Author: Erik Christenson
new project form
-->
<html xmlns="http://www.w3.org/1999/xhtml">


<body>
<div id="container">

    <div id="main">
        <h3>Welcome ${cognitoUser.name}</h3>


        <h2>Add New Project </h2>

        <form action="HPPaddProject" method="POST">


            <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />



            <label for="projectName">Project Name</label>
            <input type="text" name="projectName" id="projectName"/><br />


            <label class="container"> this is a weekday project <br />

                <input type="radio" checked="checked" name="day" value="mf">
                <span class="checkmark"></span>
            </label>
            <label class="container">This is a weekend project
                <input type="radio" name="day" value="ss">
                <span class="checkmark"></span>
            </label>
            <label class="container">This is a any day project
                <input type="radio" name="day" value="all">
                <span class="checkmark"></span>
            </label>




            <input type="submit" value="Submit">


        </form>
    </div>


</div>


</body>
</html>

