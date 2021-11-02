<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
Author: Erik Christenson
new user sign up form
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>HPP-Display</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>



<body>
<div class="container-fluid">

<div id="main">


<h2>Table with all users </h2>


    <table id="userTable" class="display border border-primary" cellspacing="0" width="100%">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>email</th>
        <th>zipcode</th>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.getId()} </td>
                <td>${user.getName()} </td>
                <td>${user.getEmail()}</td>
                <td>${user.getZip_code()}</td>

            </tr>

        </c:forEach>
        </tbody>
    </table>


</div>


</div>



<h1>  Return to : </h1>

<a href="index_old.jsp">Homepage </a>
<p>
<a href="userAdd.jsp">Add user form </a>
</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>

