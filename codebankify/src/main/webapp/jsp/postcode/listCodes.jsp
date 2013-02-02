<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>List All Snippet Codes</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<sj:head jqueryui="true"/>	
</head>

<body>
	<h1>All Snippet Codes</h1>
	<% int counter = 0; %>
	<div class="row">
	<s:url id="viewPostUrl" value="viewcode.action"/>
	<s:iterator status="statPost" value="lstPost">
		<div class="span4 codelist">
          <h3><s:property value="postTitle" escape="false"/></h3>
           <p><s:property value="postDesc" escape="false"/></p>
           <input type="hidden" id="post_id" name="post_id" value='<s:property value="postId"/>' /> 
          <p><a class="btn btn-success btn-small" href="viewcode.action?postId=<s:property value='postId'/>">View Code</a></p>
        </div> 
        <% counter++; 
        if (counter == 3) {
            %>
            </div>
            <div class="row">
            <%
            counter = 0;
        }
        %>
	</s:iterator>        
    </div>
</body>
</html>
