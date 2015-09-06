
package views.html.consent.paymentv2.payrefund

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
object partneragent extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template9[String,String,String,String,Option[String],Option[String],Option[String],Form[PaymentsInfo],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String, redirectUri : String, clientId : String, flow : String, requestBody : Option[String], responseBody : Option[String], error : Option[String], paymentsinfoForm: Form[PaymentsInfo])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages


Seq[Any](format.raw/*1.263*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to "+Messages.get("section.consent.paymentv2." + flow)+" Apis")/*6.79*/ {_display_(Seq[Any](format.raw/*6.81*/("""
    <div class="container">
        <div class="row">
		    <h2>"""),_display_(Seq[Any](/*9.12*/Messages/*9.20*/.get("section.consent.paymentv2." + flow))),format.raw/*9.61*/("""</h2>
		    <p>"""),_display_(Seq[Any](/*10.11*/Messages/*10.19*/.get("section.consent.paymentv2.desc." + flow))),format.raw/*10.65*/("""</p>
        </div>
        """),_display_(Seq[Any](/*12.10*/if(requestBody.nonEmpty || responseBody.nonEmpty || error.nonEmpty)/*12.77*/ {_display_(Seq[Any](format.raw/*12.79*/("""
	        <div class="row">
		        <p>
		            <div class="col-sm-6">
		                <div class="panel panel-default">
		                    <div class="panel-heading">
		                        <h3 class="panel-title">Request</h3>
		                    </div>
		                    <div class="panel-body">
		                        <code><pre>"""),_display_(Seq[Any](/*21.39*/{requestBody})),format.raw/*21.52*/("""</pre></code>
		                    </div>
		                </div>
		            </div>
		            <div class="col-sm-6">
		                <div class="panel panel-default">
		                    <div class="panel-heading">
		                        <h3 class="panel-title">Response / Error</h3>
		                    </div>
		                    <div class="panel-body">
		                        <code><pre>"""),_display_(Seq[Any](/*31.39*/{responseBody})),_display_(Seq[Any](/*31.54*/{error})),format.raw/*31.61*/("""</pre></code>
		                    </div>
		                </div>
		            </div>
		        </p>
	        </div>
        """)))})),format.raw/*37.10*/("""
    	"""),_display_(Seq[Any](/*38.7*/helper/*38.13*/.form(action = routes.PaymentV2.paypartneragentRedirect(backend, flow), 'class -> "form-horizontal col-xs-12 col-md-6")/*38.132*/ {_display_(Seq[Any](format.raw/*38.134*/("""
	        <div class="form-group">
	        """),_display_(Seq[Any](/*40.11*/helper/*40.17*/.inputText(paymentsinfoForm("UUID"), 'class -> "form-control", 'placeholder -> "Enter UUID"))),format.raw/*40.109*/("""
	        </div>
	
	        <div class="form-group">
	        """),_display_(Seq[Any](/*44.11*/helper/*44.17*/.inputRadioGroup(paymentsinfoForm("Flow"),
	            options = options("true" -> "Partner", "false" -> "Agent")))),format.raw/*45.73*/("""
	        </div>
	
	        <div class="form-group">
	            <button type="submit" class="btn btn-primary">"""),_display_(Seq[Any](/*49.61*/Messages/*49.69*/.get("section.consent.paymentv2.submit.button." + flow))),format.raw/*49.124*/("""
	            </button>
	        </div>
    	""")))})),format.raw/*52.7*/("""
    </div>

""")))})))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,flow:String,requestBody:Option[String],responseBody:Option[String],error:Option[String],paymentsinfoForm:Form[PaymentsInfo],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,flow,requestBody,responseBody,error,paymentsinfoForm)(request)
    
    def f:((String,String,String,String,Option[String],Option[String],Option[String],Form[PaymentsInfo]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,flow,requestBody,responseBody,error,paymentsinfoForm) => (request) => apply(backend,redirectUri,clientId,flow,requestBody,responseBody,error,paymentsinfoForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/payrefund/partneragent.scala.html
                    HASH: cf09e7031873f36c9c5823522856f90ec5058cb8
                    MATRIX: 722->1|1123->262|1153->312|1190->315|1275->392|1314->394|1418->463|1434->471|1496->512|1549->529|1566->537|1634->583|1701->614|1777->681|1817->683|2220->1050|2255->1063|2715->1487|2760->1502|2789->1509|2956->1644|2999->1652|3014->1658|3143->1777|3184->1779|3267->1826|3282->1832|3397->1924|3500->1991|3515->1997|3653->2113|3806->2230|3823->2238|3901->2293|3981->2342
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|31->9|31->9|31->9|32->10|32->10|32->10|34->12|34->12|34->12|43->21|43->21|53->31|53->31|53->31|59->37|60->38|60->38|60->38|60->38|62->40|62->40|62->40|66->44|66->44|67->45|71->49|71->49|71->49|74->52
                    -- GENERATED --
                */
            