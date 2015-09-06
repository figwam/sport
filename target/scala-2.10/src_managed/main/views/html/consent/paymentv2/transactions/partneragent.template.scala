
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
object partneragent extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[String,String,String,String,Option[String],Form[PaymentsInfo],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String, redirectUri : String, clientId : String, response : String, error : Option[String], paymentsinfoForm: Form[PaymentsInfo])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages


Seq[Any](format.raw/*1.206*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to " + Messages.get("section.consent.paymentv2.transactions.partneragent") + " Apis")/*6.101*/ {_display_(Seq[Any](format.raw/*6.103*/("""
    <div class="container">
    """),_display_(Seq[Any](/*8.6*/helper/*8.12*/.form(action = routes.PaymentV2.partneragentconsentRedirect(backend), 'class -> "form-horizontal col-xs-12 col-md-6")/*8.129*/ {_display_(Seq[Any](format.raw/*8.131*/("""
        <div class="form-group">
        """),_display_(Seq[Any](/*10.10*/helper/*10.16*/.inputText(paymentsinfoForm("UUID"), 'class -> "form-control", 'placeholder -> "Enter UUID"))),format.raw/*10.108*/("""
        </div>

        <div class="form-group">
        """),_display_(Seq[Any](/*14.10*/helper/*14.16*/.inputRadioGroup(paymentsinfoForm("Flow"),
            options = options("true" -> "Partner", "false" -> "Agent")))),format.raw/*15.72*/("""
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary">Display Transactions</button>
        </div>
    """)))})),format.raw/*21.6*/("""
    </div>

    """),_display_(Seq[Any](/*24.6*/if(error.isDefined)/*24.25*/ {_display_(Seq[Any](format.raw/*24.27*/("""
        <div class="alert alert-dismissable alert-danger">
            <button type="button" class="close" data-dismiss="alert">x</button>
            Error: """),_display_(Seq[Any](/*27.21*/error/*27.26*/.get)),format.raw/*27.30*/("""
        </div>
    """)))})),format.raw/*29.6*/("""

    """),_display_(Seq[Any](/*31.6*/if(response != null)/*31.26*/ {_display_(Seq[Any](format.raw/*31.28*/("""
        <div class="success alert alert-dismissable alert-success">
            <button type="button" class="close" data-dismiss="alert">x</button>
            Response: """),_display_(Seq[Any](/*34.24*/response)),format.raw/*34.32*/("""
        </div>
    """)))})),format.raw/*36.6*/("""
""")))})))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,response:String,error:Option[String],paymentsinfoForm:Form[PaymentsInfo],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,response,error,paymentsinfoForm)(request)
    
    def f:((String,String,String,String,Option[String],Form[PaymentsInfo]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,response,error,paymentsinfoForm) => (request) => apply(backend,redirectUri,clientId,response,error,paymentsinfoForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/transactions/partneragent.scala.html
                    HASH: 128bc4fcf1f01a5aae472aa6a09f6b6a936e1b54
                    MATRIX: 695->1|1039->205|1069->255|1106->258|1214->357|1254->359|1324->395|1338->401|1464->518|1504->520|1585->565|1600->571|1715->663|1814->726|1829->732|1966->847|2161->1011|2217->1032|2245->1051|2285->1053|2484->1216|2498->1221|2524->1225|2578->1248|2622->1257|2651->1277|2691->1279|2902->1454|2932->1462|2986->1485
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|30->8|30->8|30->8|30->8|32->10|32->10|32->10|36->14|36->14|37->15|43->21|46->24|46->24|46->24|49->27|49->27|49->27|51->29|53->31|53->31|53->31|56->34|56->34|58->36
                    -- GENERATED --
                */
            