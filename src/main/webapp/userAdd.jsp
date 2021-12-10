<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Author: Erik Christenson
new user sign up form
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="head.jsp" />

<body>
<main class="container bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />

<div id="container" class="row">

<div id="main" class="col-md-10 text-center">
    <h3>Welcome ${cognitoUser.name}</h3>


<h2>Welcome -- This is your first log in, please enter your Zip Code</h2>

      <form action="HPPaddUser" method="POST" class="form">


      <input type="hidden" name="email" id="email" value="${cognitoUser.email}"/><br />
          <input type="hidden" name="name" id="name" value="${cognitoUser.name}"/><br />



      <label for="zip_code">Please enter your Zip code</label>
      <input type="text" name="zip_code" id="zip_code"/><br />




        <input type="submit" value="Submit">


      </form>
</div>


</div>

</main>
</body>
</html>

