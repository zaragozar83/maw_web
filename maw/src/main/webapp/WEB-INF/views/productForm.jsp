<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="pull-right" style="padding-right:50px">
        <a href="<spring:url value="/products"/>" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span><spring:message code="general.lbl.products"/>
        </a>
        <a href="?language=es" ><spring:message code="general.lbl.es"/> </a>|<a href="?language=en"><spring:message code="general.lbl.en"/></a>
        <a href="<c:url value="/logout" />"><spring:message code="general.lbl.logoutSystem"/> </a>
    </div>
</section>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Products</h1>
            <p>Add products</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form  method="POST" modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend><spring:message code="form.product.legend.lbl.addProduct"/> </legend>

            <!-- Name -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name">
                    <spring:message code="form.product.lbl.name"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- Description -->
            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="form.product.lbl.description"/>
                </label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows = "2"/>
                </div>
            </div>

            <!-- unitPrice -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
                    <spring:message code="form.product.lbl.price"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- manufacturer -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
                    <spring:message code="form.product.lbl.manufacturer"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- category -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="category">
                    <spring:message code="form.product.lbl.category"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- unitsInStock -->
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
                    <spring:message code="form.product.lbl.unitsInStock"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>

            <!-- unitsInOrder -->
            <!--div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">
                    <spring:message code="form.product.lbl.unitsInOrder"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="discontinued">
                    <spring:message code="form.product.lbl.discontinued"/>
                </label>
                <div class="col-lg-10">
                    <form:checkbox  id="discontinued" path="discontinued"/>
                </div>
            </div-->

            <div class="form-group">
                <label class="control-label col-lg-2" for="condition">
                    <spring:message code="form.product.lbl.condition"/>
                </label>
                <div class="col-lg-10" style="display:list-item">
                    <form:radiobutton path="condition" value="New" /><spring:message code="form.product.lbl.condition.new"/>
                    <form:radiobutton path="condition" value="Old" /><spring:message code="form.product.lbl.condition.old"/>
                    <form:radiobutton path="condition" value="Refurbished" /><spring:message code="form.product.lbl.condition.refurbished"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="form.product.lbl.productImage"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file" class="form:input-large"/>
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