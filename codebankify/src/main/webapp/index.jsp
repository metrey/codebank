<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
	<title>OSIFY - CodeBank - Example Programming Codes!</title>
	<meta name="selection" content="index">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
	<sj:head jqueryui="true"/>	
</head>

<body>	
		<!-- Main hero unit for a primary marketing message or call to action -->
      <div class="leaderboard hero-unit">
      	<h1>Welcome to OSIFY CodeBank</h1>
		<p>All Programming Code Collection; Short, Simple &amp; Useful for your daily programming.</p>
	    <p>
	    <sj:a id="link1" cssClass="btn btn-success btn-large" href="listcode.action" indicator="indicator1" targets="result-div" effect="highlight">
	      Check it Out
	    </sj:a>
	    </p>	
      </div>

      <!-- Example row of columns -->
      <div class="row">
        <div class="span4">
          <h2>HTML5 and JS</h2>
           <p>Useful codes of HTML5, JS </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
        </div>
        <div class="span4">
          <h2>Ruby</h2>
           <p>Useful codes of Ruby </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
       </div>
        <div class="span4">
          <h2>PHP MySQL</h2>
          <p>Useful codes of PHP MySQL </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
        </div>
     </div>
     <div class="row">   
        <div class="span4">
          <h2>Java and Oracle</h2>
           <p>Java, Oracle, Struts, Swing, Spring, Hibernet etc. </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
        </div>
        <div class="span4">
          <h2>.Net, C#, VB.Net</h2>
           <p>Useful codes of .Net, C#, VB.Net </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
       </div>
        <div class="span4">
          <h2>Programming Tool Tips</h2>
          <p>Useful codes of Maven, ANT, Eclipse, Visual Studio.NET etc. </p>
          <p><a class="btn btn-success btn-small" href="listcodes.action">View Code</a></p>
        </div>
      </div>
		
</body>
</html>
