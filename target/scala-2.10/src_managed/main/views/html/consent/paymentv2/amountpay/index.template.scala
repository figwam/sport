
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
* Main page for payments.
*
* @param backend Backend to be used
*/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /*
* Main page for payments.
*
* @param backend Backend to be used
*/
    def apply/*7.2*/(backend: String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*7.84*/("""

"""),format.raw/*10.1*/("""
"""),_display_(Seq[Any](/*11.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.amountPay")+" Apis")/*11.81*/ {_display_(Seq[Any](format.raw/*11.83*/("""
    <div class="container">
            <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*16.22*/Messages/*16.30*/.get("section.consent.paymentv2.amountpay.selfcare"))),format.raw/*16.82*/("""</h2>
                <p>"""),_display_(Seq[Any](/*17.21*/Messages/*17.29*/.get("section.consent.paymentv2.amountpay.selfcare.desc"))),format.raw/*17.86*/("""</p>
                <p><a class="btn btn-default" href='"""),_display_(Seq[Any](/*18.54*/routes/*18.60*/.PaymentV2.payselfcare(backend, "payselfcare"))),format.raw/*18.106*/("""' role="button">"""),_display_(Seq[Any](/*18.123*/Messages/*18.131*/.get("button.explore"))),format.raw/*18.153*/(""" &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*21.22*/Messages/*21.30*/.get("section.consent.paymentv2.paypartneragent"))),format.raw/*21.79*/("""</h2>
                <p>"""),_display_(Seq[Any](/*22.21*/Messages/*22.29*/.get("section.consent.paymentv2.desc.paypartneragent"))),format.raw/*22.83*/("""</p>
                <p><a class="btn btn-default" href='"""),_display_(Seq[Any](/*23.54*/routes/*23.60*/.PaymentV2.paypartneragent(backend, "paypartneragent"))),format.raw/*23.114*/("""' role="button">"""),_display_(Seq[Any](/*23.131*/Messages/*23.139*/.get("button.explore"))),format.raw/*23.161*/(""" &raquo;</a></p>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/amountpay/index.scala.html
                    HASH: 927904a0636469d6d64398cccce0881a7c7e7775
                    MATRIX: 768->78|971->160|1002->192|1040->195|1128->274|1168->276|1364->436|1381->444|1455->496|1518->523|1535->531|1614->588|1709->647|1724->653|1793->699|1847->716|1865->724|1910->746|2041->841|2058->849|2129->898|2192->925|2209->933|2285->987|2380->1046|2395->1052|2472->1106|2526->1123|2544->1131|2589->1153
                    LINES: 27->7|31->7|33->10|34->11|34->11|34->11|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|41->18|41->18|41->18|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|46->23|46->23|46->23|46->23
                    -- GENERATED --
                */
            