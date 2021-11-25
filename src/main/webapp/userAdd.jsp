<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Author: Erik Christenson
new user sign up form
-->
<html xmlns="http://www.w3.org/1999/xhtml">


<body>
<div id="container">

<div id="main">
    <h3>Welcome ${cognitoUser.name}</h3>
    <h2>Your email is: ${cognitoUser.getEmail()}</h2>

<h2>Welcome -- This is your first log in,  lets update a few things</h2>

      <form action="HPPaddUser" method="POST">


      <input type="hidden" name="name" id="name" value="${cognitoUser.name}"/><br />



      <label for="email">Please enter your email address</label>
      <input type="text" name="email" id="email"/><br />

       <label for="password">Please enter your password </label>
       <input type="text" name="password" id="password"/><br />

      <label for="zip_code">Please enter your Zip code</label>
      <input type="text" name="zip_code" id="zip_code"/><br />




        <input type="submit" value="Submit">


      </form>
</div>


</div>


</body>
</html>

