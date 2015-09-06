
package views.html.consent.location

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,String,String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend : String, redirectUri : String, clientId : String, error: Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.149*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Location: Start")/*7.25*/ {_display_(Seq[Any](format.raw/*7.27*/("""
	<div class="panel">
		<div class="panel-heading">
			<h3 class="panel-title"></h3>
			</div class="buton-group pul-right"></div>
		</div>
		<div class="panel-body">
			<h2>Welcome to the Device locator</h2>
			    """),_display_(Seq[Any](/*15.9*/if(error.isDefined)/*15.28*/ {_display_(Seq[Any](format.raw/*15.30*/("""
			        <div class="alert alert-dismissable alert-danger">
			          <button type="button" class="close" data-dismiss="alert">x</button>
			          Error: """),_display_(Seq[Any](/*18.22*/error/*18.27*/.get)),format.raw/*18.31*/("""
			        </div>
			    """)))})),format.raw/*20.9*/("""
			<p>
				Check the location of your device:
			</p>
			<p>
				<a href=""""),_display_(Seq[Any](/*25.15*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*25.84*/("""?response_type=code&redirect_uri="""),_display_(Seq[Any](/*25.118*/helper/*25.124*/.urlEncode(redirectUri))),format.raw/*25.147*/("""&client_id="""),_display_(Seq[Any](/*25.159*/helper/*25.165*/.urlEncode(clientId))),format.raw/*25.185*/("""&lang=en"><img class="swisscom-login-button" src="/assets/images/login_swisscom_l.png"/></a>
			</p>
		</div>
	</div>
""")))})))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,error)(request)
    
    def f:((String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,error) => (request) => apply(backend,redirectUri,clientId,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/location/index.scala.html
                    HASH: 7fa365a93c0d9d5e082a9207d14655c4a2edaba5
                    MATRIX: 648->1|958->148|988->221|1025->224|1056->247|1095->249|1355->474|1383->493|1423->495|1627->663|1641->668|1667->672|1727->701|1844->782|1935->851|2006->885|2022->891|2068->914|2117->926|2133->932|2176->952
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|38->15|38->15|38->15|41->18|41->18|41->18|43->20|48->25|48->25|48->25|48->25|48->25|48->25|48->25|48->25
                    -- GENERATED --
                */
            