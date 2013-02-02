<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!-- %@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" % -->
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- base href="${pageContext.request.contextPath}" -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="selection" content="index">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>OSIFY - Code Bank - <decorator:title default="Welcome!"/></title>
    <link href="${pageContext.request.contextPath}/styles/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/styles/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/styles/codebank.css" rel="stylesheet">
	<!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <decorator:head/>
</head>

<body>

	<div class="navbar navbar-fixed-top">
      <%@ include file="/jsp/includes/header.jsp" %>
  	</div>

    <div class="container-fluid">
      <div class="row-fluid">
      	<div class="span2">
      	<%@ include file="/jsp/includes/navigation.jsp" %>
      	</div>
      	<div class="span10">
      	<decorator:body />
      	</div>
      </div>
      <hr>
      <footer>
      	<div class="span2">&nbsp;</div>
      	<div class="span10">
        <%@ include file="/jsp/includes/footer.jsp" %>
        </div>
      </footer>

    </div> <!-- /container -->
    <script src="${pageContext.request.contextPath}/scripts/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/styles/codepress/codepress.js" type="text/javascript"></script>
</body>
</html>

