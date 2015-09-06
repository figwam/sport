
package views.html

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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[scala.Tuple2[String, String]],Flash,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(loginForm: Form[(String,String)])(implicit flash: Flash, request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.115*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Login")/*6.15*/ {_display_(Seq[Any](format.raw/*6.17*/("""
	<div role="main" class="ui-content scm-content">
		<h1>Login</h1>
		<p> 
			<form action=""""),_display_(Seq[Any](/*10.19*/routes/*10.25*/.Application.authenticate)),format.raw/*10.50*/("""" method="POST" data-ajax="false">
		        <div class="ui-grid-a ui-responsive">
		        	<div class="ui-block-a">
		        		"""),_display_(Seq[Any](/*13.14*/if(loginForm.hasErrors)/*13.37*/ {_display_(Seq[Any](format.raw/*13.39*/("""
			        		<div class="alert alert-danger">
					            <p><strong>Oops</strong> Please fix all errors</p>
					        </div>
    					""")))})),format.raw/*17.11*/("""
		        	</div>
		        	<div class="ui-block-a">
				        """),_display_(Seq[Any](/*20.14*/inputText(
				            loginForm("username"), 
                			'_label -> "Username:", 
				            '_showConstraints -> false,
                			'_error -> loginForm.error("username")
				        ))),format.raw/*25.14*/("""
			        </div>
		        	<div class="ui-block-a">
				        """),_display_(Seq[Any](/*28.14*/inputText(
				            loginForm("password"), 
                			'_label -> "Password:", 
				            '_showConstraints -> false,
                			'_error -> loginForm.error("password")
			        ))),format.raw/*33.13*/("""
			        </div>
		        	<div class="ui-block-a">
		        		<button type="submit" class="ui-btn ui-corner-all ui-icon-check ui-btn-icon-right scm-ui-btn-primary">Send</button>
		        	</div>
		        	<div class="ui-block-a">
		        		<a href=""""),_display_(Seq[Any](/*39.23*/routes/*39.29*/.Application.index)),format.raw/*39.47*/("""" data-role="button" class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-right scm-ui-btn-secondary">Cancel</a>
		        	</div>
			        <div class="ui-block-a">
			        	<p>Not a member? Do <a href="#">Register Now</a> or </p>
		        	</div>
			        <div class="ui-block-a">
			        		<a href=""""),_display_(Seq[Any](/*45.24*/routes/*45.30*/.SSOMock.index)),format.raw/*45.44*/(""""><img src=""""),_display_(Seq[Any](/*45.57*/routes/*45.63*/.Assets.at("images/register_swisscom_m.png"))),format.raw/*45.107*/(""""/></a>
		        	</div>
		        	  	
		        </div>
	        </form>
       	</p>
	</div><!-- /content -->
""")))})))}
    }
    
    def render(loginForm:Form[scala.Tuple2[String, String]],flash:Flash,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)(flash,request)
    
    def f:((Form[scala.Tuple2[String, String]]) => (Flash,play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => (flash,request) => apply(loginForm)(flash,request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:50 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/login.scala.html
                    HASH: bff4b2f905e060838f0f844ac49b3f19da95a490
                    MATRIX: 636->1|894->114|922->167|958->169|979->182|1018->184|1147->277|1162->283|1209->308|1377->440|1409->463|1449->465|1626->610|1730->678|1962->888|2066->956|2297->1165|2592->1424|2607->1430|2647->1448|2998->1763|3013->1769|3049->1783|3098->1796|3113->1802|3180->1846
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|32->10|35->13|35->13|35->13|39->17|42->20|47->25|50->28|55->33|61->39|61->39|61->39|67->45|67->45|67->45|67->45|67->45|67->45
                    -- GENERATED --
                */
            