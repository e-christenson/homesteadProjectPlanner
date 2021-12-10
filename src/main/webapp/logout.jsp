<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp" />
<html>
<body>
<main class="container bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />


    <div class="row">
        <article class="col-md-8 text-center">




            <h2>You are logged out </h2>


            <h2><a href="logIn">--->>> Log in</a></h2>



        </article>

        <article class="col-md-3 text-center mx-2 my-auto">
            <img src="images/logout.jpg" class="img-fluid" alt="logOut">




        </article>

    </div>




    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
</main>
</body>
</html>