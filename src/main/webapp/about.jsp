<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<jsp:include page="head.jsp" />
<!-- used for the sorting/paging on the table -->
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#ProjectsTable').DataTable({
            "lengthChange": false
        });
    });

</script>
<body>
<main class="container-fluid bg-light">
    <jsp:include page="header.jsp" />
    <jsp:include page="navigation.jsp" />
    <div class="row">
        <h3 class="col-md-11 mx-5 bg-warning text-center border"> Please LogIn  </h3>
    </div>

    <div class="row">

        <article class="col-md-4 text-center">
            <h3>About Homestead Project Planner</h3>
            <p> Do you have a list of projects ? Maybe you have several lists of projects scattered about.    Homestead Project Planner
                is a website where you can record and organize all your projects in one place.  We will help you put your project lists
                into the cloud with our websites project entry form.   If you are a new user clicking the Login button will
                allow you to create an account and get started.</p>
        </article>

        <article class="col-md-4 text-center">
            <h3>Today's Projects: <small class="text-muted">Narrow down your list</small></h3>
            <img src="images/weatherMap.jpg" class="card-img-top w-50 mx-auto rounded" alt="weather">
            <p> Homestead Project Planner keeps an eye on current weather Conditions
                and helps you decide what projects to work on today.   When you enter a New
                project you have the option to enter weather conditions for the project.  For example,
                if you were entering a project "Burn the brush pile", you could check the "calm day" checkbox on the
                project entry page.  Now that project will only appear in your Today's Projects list if its a calm day.</p>
        </article>

        <article class="col-md-4 text-center">
            <h3>Store List: <small class="text-muted">Keep track of materials you need</small></h3>
            <img src="images/store.png" class="card-img-top w-25 mx-auto rounded" alt="storeIcon">
            <p> When you enter a project you have the option to enter items you may need for that project.  You can then
                checkout our Store List section and see items from every project, all in one place.  As you pickup the
                materials you need, you can remove the items from your store list page as well.</p>
        </article>


    </div>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>






</body>
</html>