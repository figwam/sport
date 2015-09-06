
package views.html.consent.paymentv2.amountrefund

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
* Main page for refunds.
*
* @param backend Backend to be used
*/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /*
* Main page for refunds.
*
* @param backend Backend to be used
*/
    def apply/*7.2*/(backend: String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*7.84*/("""

"""),format.raw/*10.1*/("""
"""),_display_(Seq[Any](/*11.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.amountrefund")+" Apis")/*11.84*/ {_display_(Seq[Any](format.raw/*11.86*/("""
    <div class="container">
            <!-- Example row of columns -->
        <div class="row">
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*16.22*/Messages/*16.30*/.get("section.consent.paymentv2.amountrefund.selfcare"))),format.raw/*16.85*/("""</h2>
                <p>"""),_display_(Seq[Any](/*17.21*/Messages/*17.29*/.get("section.consent.paymentv2.amountrefund.selfcare.desc"))),format.raw/*17.89*/("""</p>
                <p><a class="btn btn-default" href='"""),_display_(Seq[Any](/*18.54*/routes/*18.60*/.PaymentV2.payselfcare(backend, "refundselfcare"))),format.raw/*18.109*/("""' role="button">"""),_display_(Seq[Any](/*18.126*/Messages/*18.134*/.get("button.explore"))),format.raw/*18.156*/(""" &raquo;</a></p>
            </div>
            <div class="col-md-4">
                <h2>"""),_display_(Seq[Any](/*21.22*/Messages/*21.30*/.get("section.consent.paymentv2.refundpartneragent"))),format.raw/*21.82*/("""</h2>
                <p>"""),_display_(Seq[Any](/*22.21*/Messages/*22.29*/.get("section.consent.paymentv2.desc.refundpartneragent"))),format.raw/*22.86*/("""</p>
                <p><a class="btn btn-default" href='"""),_display_(Seq[Any](/*23.54*/routes/*23.60*/.PaymentV2.paypartneragent(backend, "refundpartneragent"))),format.raw/*23.117*/("""' role="button">"""),_display_(Seq[Any](/*23.134*/Messages/*23.142*/.get("button.explore"))),format.raw/*23.164*/(""" &raquo;</a></p>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/amountrefund/index.scala.html
                    HASH: 8e646826b40c749da15ae228585f6279bdba78ec
                    MATRIX: 769->77|972->159|1003->191|1041->194|1132->276|1172->278|1368->438|1385->446|1462->501|1525->528|1542->536|1624->596|1719->655|1734->661|1806->710|1860->727|1878->735|1923->757|2054->852|2071->860|2145->912|2208->939|2225->947|2304->1004|2399->1063|2414->1069|2494->1126|2548->1143|2566->1151|2611->1173
                    LINES: 27->7|31->7|33->10|34->11|34->11|34->11|39->16|39->16|39->16|40->17|40->17|40->17|41->18|41->18|41->18|41->18|41->18|41->18|44->21|44->21|44->21|45->22|45->22|45->22|46->23|46->23|46->23|46->23|46->23|46->23
                    -- GENERATED --
                */
            