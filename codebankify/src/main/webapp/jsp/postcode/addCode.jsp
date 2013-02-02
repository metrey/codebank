<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>Add Snippet Code!</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<sj:head jqueryui="true"/>	
</head>

<body>	
	<div id="result">
	<img id="indicator" src="images/indicator.gif" alt="Loading..." style="display:none"/>
	</div> 
	<s:url id="AjaxSavePost" value="savecode.action"/>
	<s:form id="form" cssClass="form-horizontal" action="%{AjaxSavePost}">
		<legend>Add New Snippet Code</legend>
		<div class="control-group">
			<label class="control-label" for="inputTitle">Title</label><s:property value='postTitle' escape='false'/>
			<div class="controls">
				<input type="hidden" id="inputPostId" name="inputPostId" value="<s:property value=''/>" />
				<s:textfield 
	                id="inputTitle" 
	                name="inputTitle" 
	                required="true"
	                cssClass="inputtext"
	                value=""
	        	/>
			</div>
		</div>		
		<div class="control-group">
			<label class="control-label" for="inputDescription">Description</label>
			<div class="controls">
				<!-- textarea rows="5" cols="80" id="inputPost" name="inputPost" class="inputtextarea"></textarea --> 
				<sjr:tinymce
                        id="inputDescription"
                        name="inputDescription"
                        rows="6"
                        cols="80"
                        editorTheme="simple"
                        cssClass="inputtextarea"
                        value=""
                        required="true"
                /> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputPost">Code</label>
			<div class="controls">
				<!-- sj:textarea 
					id="inputPost"
					name="inputPost"  
					cssClass="inputtextarea codepress javascript" 
					required="true"
					rows="7" 
					cols="80"
					value="<s:property value='postVo.postCode'/>"
				/ -->
				<textarea class="inputtextarea codepress javascript" 
					id="inputPost" 
					name="inputPost" 
					cols="80" 
					rows="8"><s:property value='postVo.postCode'/></textarea>
				<textarea id="inputPost_hidden" name="inputPost_hidden" style="display: none;"><s:property value="postVo.postCode"/></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="inputCategory">Category</label>
			<div class="controls type-text">
				<s:url var="remoteurl" action="getJsonLanguage.action"/>				
				<sj:select
				        href="%{remoteurl}"
				        id="inputCategory"
				        name="inputCategory"
				        list="languageMap"
				        emptyOption="false"
				        headerKey="-1"
				        headerValue="Please Select a Language"
				        value=""
				        />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
      			<sj:submit formId="form" 
      				cssClass="btn" 
      				value="Add Code"
      				targets="result" 
                    timeout="2500" 
                    indicator="indicator" 
                    onBeforeTopics="before" 
                    onCompleteTopics="complete" 
                    onErrorTopics="errorState"            
                    onclick="jQuery('#inputPost_hidden').val(inputPost.getCode());"         
                    effect="highlight" 
                    effectOptions="{ color : '#222222' }" 
                    effectDuration="3000" />
      		</div>
      	</div>
    </s:form>
</body>
</html>