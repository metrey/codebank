<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
	<div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.jsp"><img src="${pageContext.request.contextPath}/images/codebank.png" width="111" height="30" alt="Osify CodeBank logo" /></a>
          <div class="nav-collapse">
            <ul class="nav">
              <li class="active"><a href="index.jsp"><i class="icon-home"></i>&nbsp;Home</a></li>
              <li>
              	<!-- 
              	<sj:dialog id="aboutDialog" title="About CodeBank" autoOpen="false">
			     <strong>OSIFY CodeBank</strong> is a collection of all snippet codes and useful tools.<br/><br/>
			     CodeBank is intended for education purpose of OSIFY founder, if you have any doubt of using the code here, please contact to the owner at: 
			     <a href="http://osify.com" target="_blank">http://osify.com</a>
			     <br/><br/>
			     Thanks for being a part of CodeBank by sharing the snippet code to all users around the globe.
			   </sj:dialog>
			   -->
              	<a href="about.jsp"><i class="icon-user"></i>&nbsp;About</a>              	
              </li>
              <li>
              	<!-- 
              	<sj:dialog id="contactDialog" title="Contact CodeBank" autoOpen="false">
			     <strong>Welcome to OSIFY CodeBank!</strong> <br/><br/> 
 				 <ul>
 				 	<li>E-mail: osify.com@gmail.com</li>
 				 	<li>Website: <a href="http://osify.com" target="_blank">http://osify.com</a></li>
 				 </ul>			     
			     <br/><br/>
			     Thanks for being a part of CodeBank by sharing the snippet code to all users around the globe.
			   </sj:dialog>
			    -->
              	<a href="contact.jsp"><i class="icon-envelope"></i>&nbsp;Contact</a>
              </li>
            </ul>
            <form class="navbar-form pull-right">
		    <input type="text" name="s" id="s" class="span3">
		    <button type="submit" class="btn"><i class="icon-search"></i> Search</button>
		    </form>
          </div><!--/.nav-collapse -->
        </div>
      </div>