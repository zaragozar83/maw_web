<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Users</title>
</head>
<body>
<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="?language=es" ><spring:message code="general.lbl.es"/></a>|<a href="?language=en"><spring:message code="general.lbl.en"/></a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="form.user.lbl.users"/> </h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${user.name}</h3>
            <p>
                <strong>User ID: </strong>
                <span class="label label-default">${user.userId}</span>
            </p>
            <p>
                <strong>Las Name:</strong> ${user.lastName}
            </p>
            <p>
                <strong>Middle Name:</strong> ${user.middleName}
            </p>
            <p>
                <strong>Age: </strong> ${user.age}
            </p>
            <p>
                <strong>Active:</strong> ${user.active}
            </p>
            <p>
                <a href="<spring:url value="/users"/>" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span>back
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>