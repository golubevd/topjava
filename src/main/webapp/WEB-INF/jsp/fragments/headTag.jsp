<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><spring:message code="app.title"/></title>
    <base href="${pageContext.request.contextPath}/"/>

    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <link rel="stylesheet" href="webjars/datatables/1.10.16/css/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="webjars/noty/3.1.0/lib/noty.css"/>
    <link rel="stylesheet" href="webjars/datetimepicker/2.5.11/jquery.datetimepicker.css">
    <link rel="shortcut icon" href="resources/images/icon-meal.png">

    <!--http://stackoverflow.com/a/24070373/548473-->
    <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js" defer></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.16/js/jquery.dataTables.min.js" defer></script>
    <script type="text/javascript" src="webjars/datatables/1.10.16/js/dataTables.bootstrap.min.js" defer></script>
    <script type="text/javascript" src="webjars/noty/3.1.0/lib/noty.min.js" defer></script>
    <script type="text/javascript" src="webjars/datetimepicker/2.5.11/build/jquery.datetimepicker.full.min.js" defer></script>

    <script type="text/javascript">
        var i18n =[];
        i18n["user.add"] = '<spring:message code="user.add"/>';
        i18n["user.edit"] = '<spring:message code="user.edit"/>';
        i18n["meal.add"] = '<spring:message code="meal.add"/>';
        i18n["meal.edit"] = '<spring:message code="meal.edit"/>';
        i18n["common.deleted"] = '<spring:message code="common.deleted"/>';
        i18n["common.saved"] = '<spring:message code="common.saved"/>';
        i18n["common.enabled"] = '<spring:message code="common.enabled"/>';
        i18n["common.disabled"] = '<spring:message code="common.disabled"/>';
        i18n["common.errorStatus"] = '<spring:message code="common.errorStatus"/>';
    </script>


</head>