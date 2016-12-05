<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title><spring:message code="general.lbl.products"/> </title>
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
            <a href="<spring:url value="/products/add"/>" class="btn btn-default">
                <span class="glyphicon glyphicon-plus"></span><spring:message code="form.product.legend.lbl.addProduct"/>
            </a>
            <h1><spring:message code="general.lbl.products"/> </h1>
            <p><spring:message code="general.lbl.products.title"/> </p>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail">
                    <img src="<c:url value="/img/${product.productId}.png"></c:url> " alt="image"  style = "width:100%"/>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>$${product.unitPrice}</p>
                        <p><spring:message code="form.product.lbl.unitedAvailable"/> ${product.unitsInStock}</p>
                        <p>
                            <a href=" <spring:url value="/products/product?id=${product.productId}" htmlEscape="true"/> " class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"/></span> <spring:message code="form.product.lbl.details"/>
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