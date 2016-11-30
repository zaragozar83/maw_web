<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Users</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Users</h1>
            <p>All the available users</p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${users}" var="user">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <div class="caption">
                        <h3>${user.name}</h3>
                        <p>${user.lastName}</p>
                        <p>${user.middleName}</p>
                        <p>Age ${user.age} years</p>
                        <p>
                            <a href="<spring:url value="/users/user?id=${user.userId}" htmlEscape="true"/>" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"></span>Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>