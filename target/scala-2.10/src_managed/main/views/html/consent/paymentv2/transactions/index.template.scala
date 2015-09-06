
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.84*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.transactions")+" Apis")/*5.84*/ {_display_(Seq[Any](format.raw/*5.86*/("""
    <div class="container">
            <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*10.22*/Messages/*10.30*/.get("section.consent.paymentv2.transactions.selfcare"))),format.raw/*10.85*/("""</h2>
                <p>"""),_display_(Seq[Any](/*11.21*/Messages/*11.29*/.get("section.consent.paymentv2.transactions.selfcare.desc"))),format.raw/*11.89*/("""</p>
                <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*12.54*/routes/*12.60*/.PaymentV2.transactionsselfcare(backend))),format.raw/*12.100*/("""" role="button">"""),_display_(Seq[Any](/*12.117*/Messages/*12.125*/.get("button.explore"))),format.raw/*12.147*/(""" &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*15.22*/Messages/*15.30*/.get("section.consent.paymentv2.transactions.partneragent"))),format.raw/*15.89*/("""</h2>
                <p>"""),_display_(Seq[Any](/*16.21*/Messages/*16.29*/.get("section.consent.paymentv2.transactions.partneragent.desc"))),format.raw/*16.93*/("""</p>
                <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*17.54*/routes/*17.60*/.PaymentV2.transactionspartneragent(backend))),format.raw/*17.104*/("""" role="button">"""),_display_(Seq[Any](/*17.121*/Messages/*17.129*/.get("button.explore"))),format.raw/*17.151*/(""" &raquo;</a></p>
            </div>
        </div>
    </div>
""")))})))}
    }
    
    def render(backend:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend)(request)
    
    def f:((String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend) => (request) => apply(backend)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/transactions/index.scala.html
                    HASH: 24f91abba69fdec6c09c7dd3b5e1c2d312a86c4d
                    MATRIX: 633->1|836->83|866->115|903->118|993->200|1032->202|1228->362|1245->370|1322->425|1385->452|1402->460|1484->520|1579->579|1594->585|1657->625|1711->642|1729->650|1774->672|1905->767|1922->775|2003->834|2066->861|2083->869|2169->933|2264->992|2279->998|2346->1042|2400->1059|2418->1067|2463->1089
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|33->12|33->12|33->12|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|38->17|38->17|38->17
                    -- GENERATED --
                */
            