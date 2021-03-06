<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Корзина</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="<c:url value="/resources/css/my-style.css"/>">
</head>
<body>
<form:form id="logout" action="/logout" method="POST">
    <input type="hidden" value="Logout"/>
</form:form>
<div class="container-fluid">
    <div class="page-header text-centred">
        <img src="<c:url value="/resources/images/logo.png"/>"/>
    </div>
</div>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="<c:url value="/main"/>">Java Internet Shop</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="<c:url value="/main"/>"><span class="glyphicon glyphicon-home"></span> На
                главную</a>
            </li>
            <li><a href="<c:url value="/goods"/>">Товары</a></li>
            <li><a href="<c:url value="/about"/>">О компании</a></li>
            <li><a href="<c:url value="/contacts"/>">Контакты</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="<c:url value="/cart"/>"><span class="glyphicon glyphicon-shopping-cart">
                    </span><span class="text-right"> Корзина</span></a>
            </li>
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span
                        class="glyphicon glyphicon-user"></span>
                    <span class="text-right">Здравствуйте, ${pageContext.request.userPrincipal.name}</span><b
                            class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="<c:url value="/history"/>" id="history">История заказов</a>
                    </li>
                    <li><a href="#">Личные данные</a></li>
                    <li><a style="cursor: pointer" onclick="document.forms['logout'].submit()">
                        <span class="glyphicon glyphicon-log-out"></span>
                        Выйти </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</nav>

<hr>
<div class="container">
    <div id="cart">
    </div>
    <button class="btn btn-success" id="buy">Оформить заказ</button>
    <div>
        <h6 id="status"></h6>
    </div>
</div>

</div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<c:url value="/resources/js/cart.js"/>"></script>
</body>
</body>
</html>
