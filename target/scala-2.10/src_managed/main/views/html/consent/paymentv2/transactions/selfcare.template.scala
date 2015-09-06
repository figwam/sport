
package views.html.consent.paymentv2.transactions

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
object selfcare extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,String,String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String, redirectUri : String, clientId : String, response : String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.168*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.transactions.selfcare")+" Apis")/*6.93*/ {_display_(Seq[Any](format.raw/*6.95*/("""
    <div class="container">
        <p>
            <a href=""""),_display_(Seq[Any](/*9.23*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*9.92*/("""?response_type=code&redirect_uri="""),_display_(Seq[Any](/*9.126*/helper/*9.132*/.urlEncode(redirectUri))),format.raw/*9.155*/("""&client_id="""),_display_(Seq[Any](/*9.167*/helper/*9.173*/.urlEncode(clientId))),format.raw/*9.193*/("""&lang=en">Get Transactions</a>
        </p>
    </div>

    """),_display_(Seq[Any](/*13.6*/if(error.isDefined)/*13.25*/ {_display_(Seq[Any](format.raw/*13.27*/("""
        <div class="alert alert-dismissable alert-danger">
            <button type="button" class="close" data-dismiss="alert">x</button>
            Error: """),_display_(Seq[Any](/*16.21*/error/*16.26*/.get)),format.raw/*16.30*/("""
        </div>
    """)))})),format.raw/*18.6*/("""

    """),_display_(Seq[Any](/*20.6*/if(response != null)/*20.26*/ {_display_(Seq[Any](format.raw/*20.28*/("""
        <div class="success alert alert-dismissable alert-success">
            <button type="button" class="close" data-dismiss="alert">x</button>
            Response: """),_display_(Seq[Any](/*23.24*/response)),format.raw/*23.32*/("""
        </div>
    """)))})),format.raw/*25.6*/("""
""")))})))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,response:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,response,error)(request)
    
    def f:((String,String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,response,error) => (request) => apply(backend,redirectUri,clientId,response,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/transactions/selfcare.scala.html
                    HASH: e813664b6dfe8efdb95ee2de14820c1b3bdc1130
                    MATRIX: 672->1|983->167|1013->222|1050->225|1149->316|1188->318|1289->384|1379->453|1449->487|1464->493|1509->516|1557->528|1572->534|1614->554|1714->619|1742->638|1782->640|1981->803|1995->808|2021->812|2075->835|2119->844|2148->864|2188->866|2399->1041|2429->1049|2483->1072
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|31->9|31->9|31->9|31->9|31->9|31->9|31->9|31->9|35->13|35->13|35->13|38->16|38->16|38->16|40->18|42->20|42->20|42->20|45->23|45->23|47->25
                    -- GENERATED --
                */
            