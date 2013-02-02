<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html>
    <head>
        <title>ERROR!</title>
		<meta name="selection" content="Error">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>

    <body>
        <h2>ERROR</h2>
		<p>There are some issue with the application, please contact site administrator.</p>
		<h2>Detail Message</h2>
		<p><s:property value="message" escape="false"/></p>
    </body>
</html>
