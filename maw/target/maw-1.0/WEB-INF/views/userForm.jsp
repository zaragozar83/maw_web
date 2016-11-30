<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Users</h1>
            <p>Add User</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form  method="POST" modelAttribute="newUser" class="form-horizontal">
        <fieldset>
            <legend>Add new User</legend>

            <!-- Name -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    Name
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- lastName -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="lastName">
                    LastName
                </label>
                <div class="col-lg-10">
                    <form:input id="lastName" path="lastName" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- middleName -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="middleName">
                    MiddleName
                </label>
                <div class="col-lg-10">
                    <form:input id="middleName" path="middleName" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- age -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="age">
                    Age
                </label>
                <div class="col-lg-10">
                    <form:input maxlength="2" id="age" path="age" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- active -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="active">
                    Active
                </label>
                <div class="col-lg-10">
                    <form:checkbox  id="active" path="active"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value ="Add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>