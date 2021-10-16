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


<h2>New User signup</h2>

      <form action="HPPaddUser" method="POST">

      <label for="name">Please enter your name</label>
      <input type="text" name="name" id="name" required/><br />



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

