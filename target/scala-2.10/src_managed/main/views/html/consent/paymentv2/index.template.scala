
package views.html.consent.paymentv2

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
"""),_display_(Seq[Any](/*5.2*/main("Welcome to "+Messages.get("section.consent.paymentv2")+" Apis")/*5.71*/ {_display_(Seq[Any](format.raw/*5.73*/("""
    <div class="container">
            <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*10.22*/Messages/*10.30*/.get("section.consent.paymentv2.transactions"))),format.raw/*10.76*/("""</h2>
                <p>"""),_display_(Seq[Any](/*11.21*/Messages/*11.29*/.get("section.consent.paymentv2.transactions.desc"))),format.raw/*11.80*/("""</p>
                <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*12.54*/routes/*12.60*/.PaymentV2.transactions(backend))),format.raw/*12.92*/("""" role="button">"""),_display_(Seq[Any](/*12.109*/Messages/*12.117*/.get("button.explore"))),format.raw/*12.139*/(""" &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*15.22*/Messages/*15.30*/.get("section.consent.paymentv2.amountpay"))),format.raw/*15.73*/("""</h2>
                <p>"""),_display_(Seq[Any](/*16.21*/Messages/*16.29*/.get("section.consent.paymentv2.amountpay.desc"))),format.raw/*16.77*/("""</p>
                <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*17.54*/routes/*17.60*/.PaymentV2.pay(backend))),format.raw/*17.83*/("""" role="button">"""),_display_(Seq[Any](/*17.100*/Messages/*17.108*/.get("button.explore"))),format.raw/*17.130*/(""" &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*20.22*/Messages/*20.30*/.get("section.consent.paymentv2.amountrefund"))),format.raw/*20.76*/("""</h2>
                <p>"""),_display_(Seq[Any](/*21.21*/Messages/*21.29*/.get("section.consent.paymentv2.amountrefund.desc"))),format.raw/*21.80*/("""</p>
                <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*22.54*/routes/*22.60*/.PaymentV2.refund(backend))),format.raw/*22.86*/("""" role="button">"""),_display_(Seq[Any](/*22.103*/Messages/*22.111*/.get("button.explore"))),format.raw/*22.133*/(""" &raquo;</a></p>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/index.scala.html
                    HASH: b5d2ea6ef4cf5c8abeaf751a156cfa11ac8235ce
                    MATRIX: 620->1|823->83|853->115|890->118|967->187|1006->189|1202->349|1219->357|1287->403|1350->430|1367->438|1440->489|1535->548|1550->554|1604->586|1658->603|1676->611|1721->633|1852->728|1869->736|1934->779|1997->806|2014->814|2084->862|2179->921|2194->927|2239->950|2293->967|2311->975|2356->997|2487->1092|2504->1100|2572->1146|2635->1173|2652->1181|2725->1232|2820->1291|2835->1297|2883->1323|2937->1340|2955->1348|3000->1370
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|31->10|31->10|31->10|32->11|32->11|32->11|33->12|33->12|33->12|33->12|33->12|33->12|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|38->17|38->17|38->17|41->20|41->20|41->20|42->21|42->21|42->21|43->22|43->22|43->22|43->22|43->22|43->22
                    -- GENERATED --
                */
            