<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>О компании</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link rel="stylesheet" href="<c:url value="/resources/css/my-style.css"/>">
</head>
<body>

<form:form id="logout" action="/logout" method="POST">
    <input type="hidden" value="Logout"/>
</form:form>
<div class="wrapper">
    <div class="container-fluid">
        <div class="page-header text-centred">
            <img src="<c:url value="/resources/images/logo.png"/>"/>
        </div>
    </div>
    <div class="content">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="<c:url value="/main"/>">Java Internet Shop</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<c:url value="/main"/>"><span class="glyphicon glyphicon-home"></span>
                        На
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
        <div id="mini-cart"></div>
        <div class="container">
            <p style="text-indent: 35px; text-align: justify;">Общество с ограниченной ответственностью «Корундум» было
                организовано в 2012 году с целью обеспечения производственных предприятий Украины высококачественным
                абразивным инструментом, в кратчайшие сроки по заводским ценам.</p>
            <p style="text-indent: 35px; text-align: justify; margin-left: 90px;"><strong>С 2013 года ООО «Корундум»
                является официальным дилером производственного предприятия «ТД «Украбразив» (Украина, г.Харьков)
                основной
                деятельностью которого является производство отрезных и зачистных кругов европейского качества ТМ
                «SPRUT-A»
                и ТМ «ТИТАН-АБРАЗИВ»</strong></p>
            <p style="text-indent: 35px; text-align: justify; margin-left: 30px;">Вся продукция соответствует ДСТУ ГОСТ
                21963:2003 с соблюдением всех европейских стандартов качества.</p>
            <p style="text-indent: 35px;"><strong> C 2014 года являемся официальным дистрибьютором ПАО&nbsp;«Запорожский
                абразивный комбинат» (Украина, г.Запорожье) </strong>и предлагаем к реализации высококачественную
                продукцию:<br/>-
                шлифовальные материалы из электрокорунда нормального в виде зерна, порошков, микропорошков;<br/>-
                шлифовальные материалы из карбида кремния чёрного в виде зерна, порошков, микропорошков и специальных
                огнеупорных фракций;<br/>- карбид кремния металлургического качества в виде фракций;<br/>- тугоплавкие
                материалы: карбид бора, в том числе для атомной промышленности; нитрид бора, в том числе косметического
                качества;<br/>- отрезные и зачистные армированные круги на бакелитовой связке; <br/>- абразивный
                инструмент
                на керамической и бакелитовой связке, в том числе специальные круги для шлифования шаров
                шарикоподшипников,
                специальные круги на бакелитовой связке для торцевого шлифования типов ПН и ПНР;<br/>- шлифовальная
                шкурка и
                изделия из неё, в том числе круги шлифовальные лепестковые радиальные типа КШЛ; круги шлифовальные
                лепестковые торцевые типа КЛТ (флэп-диски);<br/>- керамические связки для абразивного инструмента.<br/>Вся
                продукция соответствует системе качества поставщика и сертифицирована по ISO 9001 : 2008 QSCert Ukraine
                B.V
            </p>
            <p style="text-indent: 35px;">Мы предоставляем комплексное обеспечение клиентов необходимой и качественной
                продукцией в сжатые сроки по конкурентоспособным ценам.</p>
            <p style="text-indent: 35px;">Мы готовы на выгодных условиях сотрудничать с Вашим предприятием.</p>
            <p style="text-indent: 35px;"><strong>За время работы наше предприятие зарекомендовалосебя как надежный
                поставщик для таких компаний как: «Интерпайп», «Метинвест», «ДТЭК», «Corum Group», предприятий
                «Укроборонпрома».</strong></p>
        </div>
    </div>
    <div class="footer">
        <hr>
    </div>
</div>
<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>