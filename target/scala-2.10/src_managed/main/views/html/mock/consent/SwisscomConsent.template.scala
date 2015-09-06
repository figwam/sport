
package views.html.mock.consent

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
object SwisscomConsent extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:webcomponents="http://sam.swisscom.ch/webcomponents" class="sam-responsive"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>Swisscom</title><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.277*/routes/*2.283*/.Assets.at("mock/consent/Swisscom-Consent_files/bootstrap-common.css"))),format.raw/*2.353*/("""")" type="text/css"><meta http-equiv="pragma" content="no-cache"><meta name="format-detection" content="telephone=no"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.501*/routes/*2.507*/.Assets.at("mock/consent/Swisscom-Consent_files/default.css"))),format.raw/*2.568*/("""" type="text/css"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.616*/routes/*2.622*/.Assets.at("mock/consent/Swisscom-Consent_files/layout-print.css"))),format.raw/*2.688*/("""" type="text/css" media="print"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.750*/routes/*2.756*/.Assets.at("mock/consent/Swisscom-Consent_files/layout-full-desktop.css"))),format.raw/*2.829*/("""" type="text/css" media="screen, print"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.899*/routes/*2.905*/.Assets.at("mock/consent/Swisscom-Consent_files/content-desktop.css"))),format.raw/*2.974*/("""" type="text/css" media="screen, print"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.1044*/routes/*2.1050*/.Assets.at("mock/consent/Swisscom-Consent_files/components-desktop.css"))),format.raw/*2.1122*/("""" type="text/css"><link rel="stylesheet" href=""""),_display_(Seq[Any](/*2.1170*/routes/*2.1176*/.Assets.at("mock/consent/Swisscom-Consent_files/progressnav-desktop.css"))),format.raw/*2.1249*/("""" type="text/css"><!--[if lt IE 8]>
			<link rel="stylesheet" href="../css/IE7-fixes.css?v=1" type="text/css"/>
		 <![endif]--><!--[if IE 8]>
			<link rel="stylesheet" href="../css/IE8-fixes.css?v=1" type="text/css"/>
		 <![endif]--><!--[if IE 9]>
			<link rel="stylesheet" href="../css/IE9-fixes.css?v=1" type="text/css"/>
		 <![endif]-->
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*9.63*/routes/*9.69*/.Assets.at("mock/consent/Swisscom-Consent_files/language-switch.js"))),format.raw/*9.137*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*10.63*/routes/*10.69*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery-1.10.2.min.js"))),format.raw/*10.139*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*11.63*/routes/*11.69*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery.tools.min.js"))),format.raw/*11.138*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*12.63*/routes/*12.69*/.Assets.at("mock/consent/Swisscom-Consent_files/jqOverlay.js"))),format.raw/*12.131*/(""""></script>
		 <script src=""""),_display_(Seq[Any](/*13.18*/routes/*13.24*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery.ui.core-1.8.21.js"))),format.raw/*13.98*/(""""></script>
		 <script src=""""),_display_(Seq[Any](/*14.18*/routes/*14.24*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery.ui.widget-1.8.14.js"))),format.raw/*14.100*/(""""></script>
		 <script src=""""),_display_(Seq[Any](/*15.18*/routes/*15.24*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery.ui.progressbar-1.8.14.js"))),format.raw/*15.105*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*16.63*/routes/*16.69*/.Assets.at("mock/consent/Swisscom-Consent_files/responsive-common.js"))),format.raw/*16.139*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*17.63*/routes/*17.69*/.Assets.at("mock/consent/Swisscom-Consent_files/header.js"))),format.raw/*17.128*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*18.63*/routes/*18.69*/.Assets.at("mock/consent/Swisscom-Consent_files/sitecatalyst.js"))),format.raw/*18.134*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*19.63*/routes/*19.69*/.Assets.at("mock/consent/Swisscom-Consent_files/userbox_IE8_fix.js"))),format.raw/*19.137*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*20.63*/routes/*20.69*/.Assets.at("mock/consent/Swisscom-Consent_files/jquery.cookie.js"))),format.raw/*20.135*/(""""></script>
		 <script language="JavaScript" type="text/javascript" src=""""),_display_(Seq[Any](/*21.63*/routes/*21.69*/.Assets.at("mock/consent/Swisscom-Consent_files/language-switch(1).js"))),format.raw/*21.140*/(""""></script>
		 <script type="text/javascript" language="JavaScript" src=""""),_display_(Seq[Any](/*22.63*/routes/*22.69*/.Assets.at("mock/consent/Swisscom-Consent_files/sam-util-url.js"))),format.raw/*22.134*/(""""></script>
		 <script type="text/javascript" src=""""),_display_(Seq[Any](/*23.41*/routes/*23.47*/.Assets.at("mock/consent/Swisscom-Consent_files/fully-loaded.js"))),format.raw/*23.112*/(""""></script>
		 <link rel="stylesheet" type="text/css" href=""""),_display_(Seq[Any](/*24.50*/routes/*24.56*/.Assets.at("mock/consent/Swisscom-Consent_files/mobileid-desktop.css"))),format.raw/*24.126*/("""">
		 <meta http-equiv="pragma" content="no-cache"><meta name="viewport" content="initial-scale=1, width=device-width">
		 <script src=""""),_display_(Seq[Any](/*26.18*/routes/*26.24*/.Assets.at("mock/consent/Swisscom-Consent_files/sam-tracking-empty-script.js"))),format.raw/*26.102*/("""" type="text/javascript"></script>
</head>

<body class="sam-responsive DESKTOP sam-lang-en" data-deviceclass="DESKTOP" style=""><script language="javascript" type="text/javascript">
			function openBrWindow1(theURL,winName,features) """),format.raw/*30.52*/("""{"""),format.raw/*30.53*/(""" 
				window.open(theURL,winName,features);
			"""),format.raw/*32.4*/("""}"""),format.raw/*32.5*/("""
		</script><script type="text/javascript" language="JavaScript" src=""""),_display_(Seq[Any](/*33.71*/routes/*33.77*/.Assets.at("mock/consent/Swisscom-Consent_files/sam-util-url(1).js"))),format.raw/*33.145*/(""""></script><form><input type="hidden" name="sam-page-hidden-id" value="xsl/consentserver/e/consent.html.e.xsl"></form>
	 <div class="scs-pageheader sam-no-print" id="header-desktop"><div class="scs-pageheader-themeDark">
						 
						 <div class="pageCenter sam-relative"><a id="scs-pageheader-logo" tabindex="-1" href="http://www.swisscom.ch/en/residential.html"><img src=""""),_display_(Seq[Any](/*36.148*/routes/*36.154*/.Assets.at("mock/consent/Swisscom-Consent_files/logo-dark.png"))),format.raw/*36.217*/("""" height="53" alt="" border="0" title="Home" id="logo-swisscom-image"></a><div class="scs-pageheader" id="noPrint"><div class="metanav"><ul id="scs-pageheader-metanav"><li><a data-tracking-link-name="Help SME" target="" href="http://www.swisscom.ch/en/residential/help/contact.html">
							Help
						</a></li><li id="scs-pageheader-language-switch"><a href="javascript:void(0)" class="active">EN</a><ul><li><a href="http://localhost-nevis/registration/online/app/DoReload.do?lang=de" target="_top" id="changelang-de">
											DE
										</a></li><li><a href="http://localhost-nevis/registration/online/app/DoReload.do?lang=fr" target="_top" id="changelang-fr">
											FR
										</a></li><li><a href="http://localhost-nevis/registration/online/app/DoReload.do?lang=it" target="_top" id="changelang-it">
											IT
										</a></li></ul></li></ul></div></div><div id="scs-pageheader-customelements sam-relative"></div><div class="clear"></div><div class="clear"></div></div></div></div><div class="sam-containerTop container-fluid" id="containerTop"><div class="sam-container expand" id="container"><div class="row-fluid">
										<h2 class="sam-heading">Authorization</h2></div>
<div class="sam-info-text"><div><span>Logged in as <span id="" class="sam-text-navy">Mocked Alex (alex)</span>. <a href="#">Click here</a>  to log in as a different user.</span></div></div>										<p>The application "<span id="application_name" class="sam-text-navy">DemAPI</span>" has requested the following rights:</p><div id="scopes"><ul class="sam-bullet-list"><li style="margin-top: 3px" id="scope_read-basicprofile">Read your basic profile (first name, last name, language).</li></ul></div>
										
										<form action=""""),_display_(Seq[Any](/*48.26*/routes/*48.32*/.ConsentMock.submit)),format.raw/*48.51*/("""" method="post" name="myForm" id="myForm">
											<input type="hidden" name="transaction" value="efQkM1SDuiyC1R9vy4B9ENfaXzX6iSYKWqOkWrMDrPCRVi3U">
											<div class="padding7" align="right"><input id="button_deny" class="sam-button-light" type="button" value="Deny" name="deny" onclick="window.location=&#39;http://localhost:9000/verify/summary?error=USER_CANCELED&#39;">&nbsp;
											<input id="submit_allow" class="sam-button-blue" type="submit" value="Authorize" name="allow"></div>
										</form>
					
					</div></div><div class="sam-footer sam-no-print" id="footer-wide"><div class="sam-footer-device-link sam-no-tablet">
		View: <span>Classic</span> | <a href="#">Mobile</a></div><div class="sam-footer-metanav"><ul><li><a target="_blank" href="http://www.swisscom.ch/en/residential/legal-information.html">Legal aspects</a></li><li><a target="_blank" href="http://www.swisscom.ch/en/residential/legal-notice.html">Imprint</a></li><li><a target="_blank" id="idFooterContact" href="http://www.swisscom.ch/en/residential/help/contact.html">Contact</a></li></ul><span>Ã‚Â© Copyright Swisscom Ltd. 2014</span></div></div><!--[if lt IE 8]>
			<script type="text/javascript">
				scssam.ieVersion = 7;
			</script>
		 <![endif]--><!--[if IE 8]>
			<script type="text/javascript">
				scssam.ieVersion = 8;
			</script>
		 <![endif]--><!--[if IE 9]>
			<script type="text/javascript">
				scssam.ieVersion = 9;
			</script>
		 <![endif]-->


</body></html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mock/consent/SwisscomConsent.scala.html
                    HASH: d807310b32280e9bec8c54ec2cb7ae8d762a6221
                    MATRIX: 660->0|1075->379|1090->385|1182->455|1366->603|1381->609|1464->670|1548->718|1563->724|1651->790|1749->852|1764->858|1859->931|1965->1001|1980->1007|2071->1076|2178->1146|2194->1152|2289->1224|2374->1272|2390->1278|2486->1351|2923->1753|2937->1759|3027->1827|3137->1901|3152->1907|3245->1977|3355->2051|3370->2057|3462->2126|3572->2200|3587->2206|3672->2268|3737->2297|3752->2303|3848->2377|3913->2406|3928->2412|4027->2488|4092->2517|4107->2523|4211->2604|4321->2678|4336->2684|4429->2754|4539->2828|4554->2834|4636->2893|4746->2967|4761->2973|4849->3038|4959->3112|4974->3118|5065->3186|5175->3260|5190->3266|5279->3332|5389->3406|5404->3412|5498->3483|5608->3557|5623->3563|5711->3628|5799->3680|5814->3686|5902->3751|5999->3812|6014->3818|6107->3888|6280->4025|6295->4031|6396->4109|6658->4343|6687->4344|6761->4391|6789->4392|6896->4463|6911->4469|7002->4537|7415->4913|7431->4919|7517->4982|9288->6717|9303->6723|9344->6742
                    LINES: 22->1|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|23->2|30->9|30->9|30->9|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|34->13|34->13|34->13|35->14|35->14|35->14|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|39->18|39->18|39->18|40->19|40->19|40->19|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|44->23|44->23|44->23|45->24|45->24|45->24|47->26|47->26|47->26|51->30|51->30|53->32|53->32|54->33|54->33|54->33|57->36|57->36|57->36|69->48|69->48|69->48
                    -- GENERATED --
                */
            