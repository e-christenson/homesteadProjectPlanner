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


<h2>Table with all users </h2>


    <table id="userTable" class="display" cellspacing="0" width="100%">
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

<c:forEach items="${users}" var="user">
    ${user}<br>

</c:forEach>

<h1>  testing el </h1>
<p>${url}</p>

</body>
</html>

