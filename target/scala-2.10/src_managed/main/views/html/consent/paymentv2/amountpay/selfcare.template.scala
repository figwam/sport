
package views.html.consent.paymentv2.amountpay

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
/*
* Beginning and end of payment and refund flows.
*
* @param backend Backend to be used
* @param redirectUri Redirection url after authentication
* @param clientId Received as a result of authentication
* @param requestBody Request body - JSON
* @param responseBody Response body - JSON
* @param errorInfo Eventual error text from authentication
* @param flow Flow name: transactions/payselfcare/refundselfcare
*/
object selfcare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template8[String,String,String,Option[String],Option[String],Option[String],String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /*
* Beginning and end of payment and refund flows.
*
* @param backend Backend to be used
* @param redirectUri Redirection url after authentication
* @param clientId Received as a result of authentication
* @param requestBody Request body - JSON
* @param responseBody Response body - JSON
* @param errorInfo Eventual error text from authentication
* @param flow Flow name: transactions/payselfcare/refundselfcare
*/
    def apply/*13.2*/(backend: String, redirectUri : String, clientId : String, requestBody : Option[String], responseBody : Option[String], errorInfo : Option[String], flow: String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*13.228*/("""

"""),format.raw/*17.1*/("""
"""),_display_(Seq[Any](/*18.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.amountpay.selfcare")+" Apis")/*18.90*/ {_display_(Seq[Any](format.raw/*18.92*/("""
    <div class="container">
        <p>
            <a href=""""),_display_(Seq[Any](/*21.23*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*21.92*/("""?response_type=code&redirect_uri="""),_display_(Seq[Any](/*21.126*/helper/*21.132*/.urlEncode(redirectUri))),format.raw/*21.155*/("""&client_id="""),_display_(Seq[Any](/*21.167*/helper/*21.173*/.urlEncode(clientId))),format.raw/*21.193*/("""&lang=en">Perform transaction ("""),_display_(Seq[Any](/*21.225*/flow)),format.raw/*21.229*/(""")</a>
        </p>
        <p>
            """),_display_(Seq[Any](/*24.14*/if(requestBody.nonEmpty || responseBody.nonEmpty || errorInfo.nonEmpty)/*24.85*/ {_display_(Seq[Any](format.raw/*24.87*/("""
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Request</h3>
                        </div>
                        <div class="panel-body">
                            <code><pre>"""),_display_(Seq[Any](/*31.41*/{requestBody})),format.raw/*31.54*/("""</pre></code>
                        </div>
                    </div>
                </div>
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Response / Error</h3>
                        </div>
                        <div class="panel-body">
                            <code><pre>"""),_display_(Seq[Any](/*41.41*/{responseBody})),_display_(Seq[Any](/*41.56*/{errorInfo})),format.raw/*41.67*/("""</pre></code>
                        </div>
                    </div>
                </div>
            """)))})),format.raw/*45.14*/("""
        </p>
    </div>
""")))})))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,requestBody:Option[String],responseBody:Option[String],errorInfo:Option[String],flow:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,requestBody,responseBody,errorInfo,flow)(request)
    
    def f:((String,String,String,Option[String],Option[String],Option[String],String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,requestBody,responseBody,errorInfo,flow) => (request) => apply(backend,redirectUri,clientId,requestBody,responseBody,errorInfo,flow)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/amountpay/selfcare.scala.html
                    HASH: e34502f8140b111f21a98b1bc4a8d5dc5961cb06
                    MATRIX: 1542->430|1914->656|1945->711|1983->714|2080->802|2120->804|2222->870|2313->939|2384->973|2400->979|2446->1002|2495->1014|2511->1020|2554->1040|2623->1072|2650->1076|2733->1123|2813->1194|2853->1196|3227->1534|3262->1547|3742->1991|3787->2006|3820->2017|3964->2129
                    LINES: 39->13|45->13|47->17|48->18|48->18|48->18|51->21|51->21|51->21|51->21|51->21|51->21|51->21|51->21|51->21|51->21|54->24|54->24|54->24|61->31|61->31|71->41|71->41|71->41|75->45
                    -- GENERATED --
                */
            