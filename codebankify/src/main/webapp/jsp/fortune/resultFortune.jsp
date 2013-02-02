<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>Fortune Teller</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<sj:head jqueryui="true"/>	
</head>

<body>		 
	<div class="leaderboard hero-unit">
      	<h1>Your Phone: <s:property value="fortuneVO.inputFortune" escape="false" /> / Fortune No. <s:property value="fortuneVO.fortuneNumber" escape="false" /></h1>
		<h2 class="khmer"><s:property value="fortuneVO.description" escape="false" /></h2>	
      </div>
</body>
</html>