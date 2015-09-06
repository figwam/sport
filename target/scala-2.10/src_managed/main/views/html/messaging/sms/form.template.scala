
package views.html.messaging.sms

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Sms],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(smsForm: Form[Sms])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*2.2*/implicitField/*2.15*/ = {{ FieldConstructor(fieldConstructorTemplate.f) }};
Seq[Any](format.raw/*1.87*/("""
"""),format.raw/*2.67*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to Messaging Apis")/*6.35*/ {_display_(Seq[Any](format.raw/*6.37*/("""	
	<h1>Welcome to Swisscom Send SMS Api</h1>
    <p>
    	This Send SMS Api allows you to send SMS.<br/>
    	<img src=""""),_display_(Seq[Any](/*10.17*/routes/*10.23*/.Assets.at("images/234_sms_03_rgb.png"))),format.raw/*10.62*/("""" height="50em">
    </p>
    """),_display_(Seq[Any](/*12.6*/helper/*12.12*/.form(action = routes.SmsSender.send, 'class->"form-horizontal")/*12.76*/ {_display_(Seq[Any](format.raw/*12.78*/("""
   		"""),_display_(Seq[Any](/*13.7*/if(smsForm.hasErrors)/*13.28*/ {_display_(Seq[Any](format.raw/*13.30*/("""
	    	<div class="alert alert-dismissable alert-danger">
	  			<button type="button" class="close" data-dismiss="alert">x</button>
			  	<strong>Oh snap!</strong> Please fix all errors and try sending again.
			</div>
    	""")))})),format.raw/*18.7*/("""

	  <fieldset>
	    <legend></legend>
    	"""),_display_(Seq[Any](/*22.7*/inputText(
            smsForm("clientId"), 
            '_label -> "ClientId",
            'class -> "form-control",
            'placeholder -> "ClientId",
            '_error -> smsForm.error("clientId")
        ))),format.raw/*28.10*/("""
    	"""),_display_(Seq[Any](/*29.7*/inputText(
            smsForm("senderMsisdn"), 
            '_label -> "Sender",
            'class -> "form-control",
            'placeholder -> "Sender",
            '_error -> smsForm.error("senderMsisdn")
        ))),format.raw/*35.10*/("""
    	"""),_display_(Seq[Any](/*36.7*/inputText(
            smsForm("recipient"), 
            '_label -> "Recipient",
            'class -> "form-control",
            'placeholder -> "Recipient",
            '_error -> smsForm.error("recipient")
        ))),format.raw/*42.10*/("""
    	"""),_display_(Seq[Any](/*43.7*/inputText(
            smsForm("message"), 
            '_label -> "Message",
            'class -> "form-control",
            'placeholder -> "Message",
            '_error -> smsForm.error("message")
        ))),format.raw/*49.10*/("""
	    <div class="form-group">
	      <div class="col-lg-10 col-lg-offset-2">
	        <a href=""""),_display_(Seq[Any](/*52.20*/routes/*52.26*/.Application.index)),format.raw/*52.44*/("""" class="btn btn-default">Cancel</a>
	        <button type="submit" class="btn btn-primary">Send</button>
	      </div>
	    </div>
	  </fieldset>
	""")))})),format.raw/*57.3*/("""

""")))})))}
    }
    
    def render(smsForm:Form[Sms],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(smsForm)(request)
    
    def f:((Form[Sms]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (smsForm) => (request) => apply(smsForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/messaging/sms/form.scala.html
                    HASH: a7aa491f14e665411f04cfc09e0063cbd27d0ed6
                    MATRIX: 618->1|806->89|827->102|909->86|938->154|968->176|1005->179|1046->212|1085->214|1246->339|1261->345|1322->384|1390->417|1405->423|1478->487|1518->489|1561->497|1591->518|1631->520|1892->750|1976->799|2220->1021|2263->1029|2511->1255|2554->1263|2802->1489|2845->1497|3085->1715|3221->1815|3236->1821|3276->1839|3461->1993
                    LINES: 19->1|22->2|22->2|23->1|24->2|26->5|27->6|27->6|27->6|31->10|31->10|31->10|33->12|33->12|33->12|33->12|34->13|34->13|34->13|39->18|43->22|49->28|50->29|56->35|57->36|63->42|64->43|70->49|73->52|73->52|73->52|78->57
                    -- GENERATED --
                */
            