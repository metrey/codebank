<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjr" uri="/struts-jquery-richtext-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>View Code</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<sj:head jqueryui="true"/>	
</head>

<body>
	<div class="row">
	<s:iterator status="statPost" value="lstPost">
		<div>&nbsp;&nbsp;</div>
		<div class="span10">
          <h2><s:property value="postTitle" escape="false" /></h2>
          <hr/>
           <p><s:property value="postDesc" escape="false" /></p>
           <input type="hidden" id="post_id" name="post_id" value='<s:property value="postId"/>' /> 
           <p>
           <textarea class="inputtextarea codepress javascript readonly-on" id="post_code" name="post_code" cols="180" rows="8"><s:property value="postCode" escape="false"/></textarea>
           </p>
          <p><a class="btn btn-success btn-mini" href="listcode.action">View All Codes</a>&nbsp;
          	<a class="btn btn-primary btn-mini" href="editcode.action?postId=<s:property value='postId'/>">Edit Code</a>&nbsp;
          	<a class="btn btn-danger btn-mini" href="delcode.action?postId=<s:property value='postId'/>">Delete Code</a>          	
          </p>
        </div> 
	</s:iterator>        
    </div>
</body>
</html>
