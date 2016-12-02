<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
        <div class="pull-right" style="padding-right:50px">
            <a href="<spring:url value="?id=${product.productId}&language=es"/>" ><spring:message code="general.lbl.es"/></a>|<a href="<spring:url value="?id=${product.productId}&language=en"/>"><spring:message code="general.lbl.en"/></a>
        </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="general.lbl.products"/> </h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/img/${product.productId}.png"/>" alt="image"  style = "width:100%"/>
        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong><spring:message code="form.product.lbl.productId"/>: </strong>
                <span class="label label-default">${product.productId}</span>
            </p>
            <p>
                <strong><spring:message code="form.product.lbl.manufacturer"/> </strong>: ${product.manufacturer}
            </p>
            <p>
                <strong>category</strong> :
                ${product.category}
            </p>
            <p>
                <strong><spring:message code="form.product.lbl.unitedAvailable"/> </strong> : ${product.unitsInStock}
            </p>
            <h4>${product.unitPrice} USD</h4>
            <p>
                <a href="<spring:url value="/products"/>" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span><spring:message code="form.product.lbl.back"/>
                </a>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon">          </span> <spring:message code="form.product.lbl.orderNow"/>
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>