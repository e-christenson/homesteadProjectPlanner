<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<row>
    <nav class="navbar navbar-expand-md navbar-dark bg-dark" role="navigation">
        <a class="navbar-brand" href="index">Homestead Project Planner</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#lab13Nav"
                aria-controls="lab13Nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="lab13Nav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="projectAdd.jsp">Add Project<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="fProjects">Today's Projects</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="storeList">Store List</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="myHelp.jsp">My Helpers</a></li>
                <li class="nav-item">
                    <a class="nav-link" href="about.jsp">About</a></li>
                <li class="nav-item">
                    <c:choose>
                    <c:when test="${empty cognitoUser}">
                    <a class="nav-link" href="logIn">Log In</a></li>
                </c:when>
                <c:otherwise>
                    <a class="nav-link" href="logout">Log Out</a> </li>
                </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </nav>
</row>
