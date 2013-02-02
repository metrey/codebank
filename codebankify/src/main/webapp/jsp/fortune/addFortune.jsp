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
	<s:url id="AjaxFortunePhone" value="phonefortune.action"/>
	<s:form id="form" cssClass="form-horizontal" action="%{AjaxFortunePhone}">
		<legend>Fortune Teller</legend>
		<div class="control-group">
			<label class="control-label" for="inputFortunePhone">Phone Number</label>
			<div class="controls">
				<s:textfield 
	                id="inputFortunePhone" 
	                name="inputFortunePhone" 
	                required="true"
	                cssClass="inputtext"
	        	/>&nbsp;
	        	<sj:submit formId="form" 
      				cssClass="btn" 
      				value="My Fortune"
      				targets="result" 
                    timeout="2500" 
                    indicator="indicator" 
                    onBeforeTopics="before" 
                    onCompleteTopics="complete" 
                    onErrorTopics="errorState"     
                    effect="highlight" 
                    effectOptions="{ color : '#222222' }" 
                    effectDuration="3000" />
			</div>
		</div>		
		
    </s:form>
    <div id="result">
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
	</div>
</body>
</html>