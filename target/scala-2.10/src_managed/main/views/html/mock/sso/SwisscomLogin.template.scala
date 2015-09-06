
package views.html.mock.sso

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object SwisscomLogin extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[play.api.data.Form[scala.Tuple2[String, String]],play.api.mvc.RequestHeader,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: play.api.data.Form[(String,String)])(implicit request: play.api.mvc.RequestHeader):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.91*/("""

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>

  <html class="responsive" style="height:100%"><head id="j_idt2">
	    	<link rel="shortcut icon" href="https://login.sso.bluewin.ch/favicon.ico" />
	        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
	        <title>Swisscom Login</title>
	        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	          <link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/bootstrap/bootstrap-common.css" type="text/css" media="screen, print" />
	          <link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/default.css" type="text/css" media="screen, print" />
	          <link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/login-desktop.css" type="text/css" media="screen, print" />
	          <link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/print.css" type="text/css" media="print" /><!--[if lt IE 8]><link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/IE7-fixes.css" /><![endif]--><!--[if IE 8]><link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/IE8-fixes.css" /><![endif]--><!--[if IE 9]><link rel="stylesheet" href="https://login.sso.bluewin.ch/resources/responsive/css/IE9-fixes.css" /><![endif]--><script type="text/javascript" src="https://login.sso.bluewin.ch/javax.faces.resource/responsive/js/jquery-1.8.1.min.js.xhtml"></script><script type="text/javascript" src="https://login.sso.bluewin.ch/javax.faces.resource/responsive/js/header.js.xhtml"></script><script type="text/javascript" src="https://login.sso.bluewin.ch/javax.faces.resource/responsive/js/responsive-common.js.xhtml"></script>
</head><body id="bodydesktop" class="sam-responsive DESKTOP" style="background: url('https://login.sso.bluewin.ch/resources/responsive/images/img_login_Default.jpg') no-repeat center center;background-size: cover;position:relative;z-index:0;">
	        <div id="sam-page" class="sam-page">
	          <script language="javascript" type="text/javascript">
	                var formSubmitted = false;
	                function onSubmitButton() """),format.raw/*19.44*/("""{"""),format.raw/*19.45*/(""" 
	                    if (!formSubmitted) """),format.raw/*20.42*/("""{"""),format.raw/*20.43*/("""
	                        formSubmitted = true;
	                    """),format.raw/*22.22*/("""}"""),format.raw/*22.23*/(""" else """),format.raw/*22.29*/("""{"""),format.raw/*22.30*/("""
	                        // disable event propagation if form is already submitted
	                    	(event.preventDefault) ? event.preventDefault() : event.returnValue = false;
	                    """),format.raw/*25.22*/("""}"""),format.raw/*25.23*/("""
	                """),format.raw/*26.18*/("""}"""),format.raw/*26.19*/("""
	            </script>
	            <script type="text/javascript">
	              //<![CDATA[
	                $(document).ready(function () """),format.raw/*30.48*/("""{"""),format.raw/*30.49*/("""
	                    $("#username").focus();
	                """),format.raw/*32.18*/("""}"""),format.raw/*32.19*/(""");
	              //]]>
	            </script><div class="scs-pageheader sam-no-print">
        <div class="scs-pageheader-themeDark">
            <div id="scs-pageheader-logo-container" class="pageCenter"><a id="scs-pageheader-logo" name="scs-pageheader-logo" href="http://www.swisscom.ch/en/residential.html" tabindex="-1"><img id="logo-swisscom-image" src="https://login.sso.bluewin.ch/javax.faces.resource/logo-dark.png.xhtml?ln=responsive/images" alt="Swisscom Logo" height="53" title="Home" /></a><div class="metanav">
                    <ul id="scs-pageheader-metanav">
                        
                        <li id="scs-pageheader-language-switch">
                            <div id="language-switch"><a href="" class="active">en</a>
                                <ul>
                                           <li><a href="https://login.sso.bluewin.ch:443/login?SNA=sam&amp;L=de&amp;LPR=yes" target="_top">de</a>
                                          </li>
                                           <li><a href="https://login.sso.bluewin.ch:443/login?SNA=sam&amp;L=fr&amp;LPR=yes" target="_top">fr</a>
                                          </li>
                                           <li><a href="https://login.sso.bluewin.ch:443/login?SNA=sam&amp;L=it&amp;LPR=yes" target="_top">it</a>
                                          </li>
                                </ul>
                            </div>
                        </li>
                    </ul></div>
                <div id="scs-pageheader-customelements"></div>
                <div class="clear"></div>
                <div class="clear"></div>
            </div>
        </div></div>
	                    
	        <div class="containerTop container-fluid clearfix" id="containerTop">
	            <div id="printLogo"><img src="https://login.sso.bluewin.ch/javax.faces.resource/logo-dark.png.xhtml?ln=responsive/images" alt="" style="margin-left: -30px;" />
	            </div><div id="navigation" class="navigation clearfix sam-collapsed sam-no-print"><div id="titlebox">
                        <iframe src="iframetopleft" width="100%" frameborder="0" height="50px" scrolling="no" allowTransparency="true">
                             <p>Your browser does not support iframes.</p>
                         </iframe></div><div id="textbox">
	                    <iframe src="iframeleft" width="100%" frameborder="0" height="400px" scrolling="no" allowTransparency="true">
	                         <p>Your browser does not support iframes.</p>
	                     </iframe></div>
	                <div class="spacerwide"></div></div>
	            <div class="contentarea clearfix sam-print-area" id="container"><div id="naviSCLogin" class="sam-top-spacer">
	                       <ul class="sam-tabbar-list" data-maxtabs="2" role="tablist">
	                           <li class="sam-tab-active first_phone_tab" role="tab" aria-selected="true">Swisscom Login</li>
	                               <li class="sam-tab" role="tab"><a id="mobileLoginLink" name="mobileLoginLink" href="?L=en&amp;vt=smstoken&amp;LPR=yes&amp;SNA=sam">NATEL&reg; Login</a>
	                               </li>
	                       </ul></div><div id="SCLogin" class="sso-main-login-stage">
        
        
		"""),_display_(Seq[Any](/*76.4*/helper/*76.10*/.form(routes.Application.authenticateSwisscom())/*76.58*/ {_display_(Seq[Any](format.raw/*76.60*/("""
            <input type="hidden" name="L" value="en" />
            <input name="count_tries" value="0" type="hidden" />
            """),_display_(Seq[Any](/*79.14*/form/*79.18*/.globalError.map/*79.34*/ { error =>_display_(Seq[Any](format.raw/*79.45*/("""
                <p style="color:red;">
                    """),_display_(Seq[Any](/*81.22*/error/*81.27*/.message)),format.raw/*81.35*/("""
                </p>
            """)))})),format.raw/*83.14*/("""
            <div class="row-fluid sam-form-row">
                <label class="span3 " for="username">Username</label>
            </div>
            <div class="row-fluid sam-form-row">
                <div class="span12"><input id="username" type="text" name="username" value="" class="none" size="15" tabindex="1" />
                </div>
            </div>
            <div class="row-fluid sam-form-row">
               <label class="span3 " for="password">Password</label>
            </div>
            <div class="row-fluid sam-form-row">
               <div class="span12"><input id="password" type="password" name="password" value="" size="15" tabindex="2" class="none" />
               </div>
            </div><div class="row-fluid sam-form-row-no-textfield">
               <label id="lblStayLoggedInClickable" class="span3 sam-single-checkbox">
                    <input name="p" value="true" tabindex="3" type="checkbox" />
                    <span>Stay logged in</span>
                </label></div>
            <div class="row-fluid sam-form-row-no-textfield">
                <div class="span12">
                    <input name="anmelden" id="anmelden" class="sam-button-primary" tabindex="4" value="Login" type="submit" onclick="onSubmitButton();" />
                </div>
            </div>
            <div class="row-fluid sam-form-row-no-textfield">
                <div class="span12"><a href="javascript:window.open(Page='https://www1.swisscom.ch/registration/online/PWCForget?lang=en&amp;mode=index_pwchannel','PWchannel',Size='width=700,height=460,resizable=yes,toolbar=yes,scrollbars=yes');void(0);" shape="rect" tabindex="5">
                    Forgotten username or password?
                    </a>
                </div>
            </div>
         """)))})),format.raw/*113.11*/("""

        <div class="sam-content-inlay sam-top-spacer sam-bottom-spacer">
            <div class="span12"><a href="https://www1.swisscom.ch/registration/online/app/sclregistration?lang=en&amp;serviceName=sam&amp;returnurl=https%3A%2F%2Flogin.sso.bluewin.ch%3A443%2Flogin%3FSNA%3Dsam%26BUSR%3Dyes%26L%3Den" tabindex="6">Setting up a Swisscom Login</a>
            </div>
        </div></div>
			        
			        
			    </div>
            </div><div class="sam-footer"><div class="pageCenter">
            <div id="footer">
               <iframe src="https://www1.swisscom.ch/sampub/online/login/kuce/loginfooter/desktop/en/res" marginheight="0" marginwidth="0" frameborder="0" width="980" height="40" scrolling="no" allowTransparency="true">
                   <p>Your browser does not support iframes.</p>
               </iframe>
           </div></div></div>
	        
	        
	       </div></body>
	</html>
"""))}
    }
    
    def render(form:play.api.data.Form[scala.Tuple2[String, String]],request:play.api.mvc.RequestHeader): play.api.templates.HtmlFormat.Appendable = apply(form)(request)
    
    def f:((play.api.data.Form[scala.Tuple2[String, String]]) => (play.api.mvc.RequestHeader) => play.api.templates.HtmlFormat.Appendable) = (form) => (request) => apply(form)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mock/sso/SwisscomLogin.scala.html
                    HASH: a9542dc45acb92e45c73a62848b7c94521d63f38
                    MATRIX: 642->1|825->90|3084->2321|3113->2322|3184->2365|3213->2366|3310->2435|3339->2436|3373->2442|3402->2443|3634->2647|3663->2648|3709->2666|3738->2667|3909->2810|3938->2811|4029->2874|4058->2875|7400->6182|7415->6188|7472->6236|7512->6238|7683->6373|7696->6377|7721->6393|7770->6404|7867->6465|7881->6470|7911->6478|7978->6513|9803->8305
                    LINES: 19->1|22->1|40->19|40->19|41->20|41->20|43->22|43->22|43->22|43->22|46->25|46->25|47->26|47->26|51->30|51->30|53->32|53->32|97->76|97->76|97->76|97->76|100->79|100->79|100->79|100->79|102->81|102->81|102->81|104->83|134->113
                    -- GENERATED --
                */
            