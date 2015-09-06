
package views.html.consent

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
        _display_ {import helper._

import play.i18n.Messages


Seq[Any](format.raw/*1.84*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to "+Messages.get("section.consent")+" Apis")/*6.61*/ {_display_(Seq[Any](format.raw/*6.63*/("""	
	<div class="container">
      <div class="row">
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*10.16*/Messages/*10.24*/.get("section.consent.verifytokencreation"))),format.raw/*10.67*/("""</h2>
          <p>"""),_display_(Seq[Any](/*11.15*/Messages/*11.23*/.get("section.consent.verifytokencreation.desc"))),format.raw/*11.71*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*12.48*/routes/*12.54*/.ConsentToken.index(backend))),format.raw/*12.82*/("""" role="button">"""),_display_(Seq[Any](/*12.99*/Messages/*12.107*/.get("button.explore"))),format.raw/*12.129*/(""" &raquo;</a></p>
        </div>

        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*16.16*/Messages/*16.24*/.get("section.consent.verifyaddress"))),format.raw/*16.61*/("""</h2>
          <p>"""),_display_(Seq[Any](/*17.15*/Messages/*17.23*/.get("section.consent.verifyaddress.desc"))),format.raw/*17.65*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*18.48*/routes/*18.54*/.ConsentVerifyAddress.index("mock","","manual"))),format.raw/*18.101*/("""" role="button">"""),_display_(Seq[Any](/*18.118*/Messages/*18.126*/.get("button.explore"))),format.raw/*18.148*/(""" &raquo;</a></p>
        </div>
        
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*22.16*/Messages/*22.24*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*22.77*/("""</h2>
          <p>"""),_display_(Seq[Any](/*23.15*/Messages/*23.23*/.get("section.consent.verifyaddress.manual.authcode.desc"))),format.raw/*23.81*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*24.48*/routes/*24.54*/.ConsentVerifyAddress.index(backend,"code","manual"))),format.raw/*24.106*/("""" role="button">"""),_display_(Seq[Any](/*24.123*/Messages/*24.131*/.get("button.explore"))),format.raw/*24.153*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*27.16*/Messages/*27.24*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*27.80*/("""</h2>
          <p>"""),_display_(Seq[Any](/*28.15*/Messages/*28.23*/.get("section.consent.verifyaddress.automatic.authcode.desc"))),format.raw/*28.84*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*29.48*/routes/*29.54*/.ConsentVerifyAddress.index(backend,"code","automatic"))),format.raw/*29.109*/("""" role="button">"""),_display_(Seq[Any](/*29.126*/Messages/*29.134*/.get("button.explore"))),format.raw/*29.156*/(""" &raquo;</a></p>
        </div>
        
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*33.16*/Messages/*33.24*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*33.77*/("""</h2>
          <p>"""),_display_(Seq[Any](/*34.15*/Messages/*34.23*/.get("section.consent.verifyaddress.manual.implicit.desc"))),format.raw/*34.81*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*35.48*/routes/*35.54*/.ConsentVerifyAddress.index(backend,"token","manual"))),format.raw/*35.107*/("""" role="button">"""),_display_(Seq[Any](/*35.124*/Messages/*35.132*/.get("button.explore"))),format.raw/*35.154*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*38.16*/Messages/*38.24*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*38.80*/("""</h2>
          <p>"""),_display_(Seq[Any](/*39.15*/Messages/*39.23*/.get("section.consent.verifyaddress.automatic.implicit.desc"))),format.raw/*39.84*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*40.48*/routes/*40.54*/.ConsentVerifyAddress.index(backend,"token","automatic"))),format.raw/*40.110*/("""" role="button">"""),_display_(Seq[Any](/*40.127*/Messages/*40.135*/.get("button.explore"))),format.raw/*40.157*/(""" &raquo;</a></p>
        </div>
        
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*44.16*/Messages/*44.24*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*44.79*/("""</h2>
          <p>"""),_display_(Seq[Any](/*45.15*/Messages/*45.23*/.get("section.consent.verifyaddress.manual40.authcode.desc"))),format.raw/*45.83*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*46.48*/routes/*46.54*/.ConsentVerifyAddress.index(backend,"code","manual40"))),format.raw/*46.108*/("""" role="button">"""),_display_(Seq[Any](/*46.125*/Messages/*46.133*/.get("button.explore"))),format.raw/*46.155*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*49.16*/Messages/*49.24*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*49.82*/("""</h2>
          <p>"""),_display_(Seq[Any](/*50.15*/Messages/*50.23*/.get("section.consent.verifyaddress.automatic40.authcode.desc"))),format.raw/*50.86*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*51.48*/routes/*51.54*/.ConsentVerifyAddress.index(backend,"code","automatic40"))),format.raw/*51.111*/("""" role="button">"""),_display_(Seq[Any](/*51.128*/Messages/*51.136*/.get("button.explore"))),format.raw/*51.158*/(""" &raquo;</a></p>
        </div>
        
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*55.16*/Messages/*55.24*/.get("section.consent.payment"))),format.raw/*55.55*/("""</h2>
          <p>"""),_display_(Seq[Any](/*56.15*/Messages/*56.23*/.get("section.consent.payment.desc"))),format.raw/*56.59*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*57.48*/routes/*57.54*/.ConsentPayment.login(backend))),format.raw/*57.84*/("""" role="button">"""),_display_(Seq[Any](/*57.101*/Messages/*57.109*/.get("button.explore"))),format.raw/*57.131*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <h2>"""),_display_(Seq[Any](/*60.18*/Messages/*60.26*/.get("section.consent.paymentv2.transactions"))),format.raw/*60.72*/("""</h2>
            <p>"""),_display_(Seq[Any](/*61.17*/Messages/*61.25*/.get("section.consent.paymentv2.transactions.desc"))),format.raw/*61.76*/("""</p>
            <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*62.50*/routes/*62.56*/.PaymentV2.index(backend))),format.raw/*62.81*/("""" role="button">"""),_display_(Seq[Any](/*62.98*/Messages/*62.106*/.get("button.explore"))),format.raw/*62.128*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*65.16*/Messages/*65.24*/.get("section.consent.Online3rdParty"))),format.raw/*65.62*/("""</h2>
          <p>"""),_display_(Seq[Any](/*66.15*/Messages/*66.23*/.get("section.consent.Online3rdParty.desc"))),format.raw/*66.66*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*67.48*/routes/*67.54*/.Online3rdParty.index(backend))),format.raw/*67.84*/("""" role="button">"""),_display_(Seq[Any](/*67.101*/Messages/*67.109*/.get("button.explore"))),format.raw/*67.131*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*70.16*/Messages/*70.24*/.get("section.consent.Call"))),format.raw/*70.52*/("""</h2>
          <p>"""),_display_(Seq[Any](/*71.15*/Messages/*71.23*/.get("section.consent.Call.desc"))),format.raw/*71.56*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*72.48*/routes/*72.54*/.Calling.index(backend))),format.raw/*72.77*/("""" role="button">"""),_display_(Seq[Any](/*72.94*/Messages/*72.102*/.get("button.explore"))),format.raw/*72.124*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*75.16*/Messages/*75.24*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*75.72*/("""</h2>
          <p>"""),_display_(Seq[Any](/*76.15*/Messages/*76.23*/.get("section.consent.PaymentsFlowPartnerAgent.desc"))),format.raw/*76.76*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*77.48*/routes/*77.54*/.PaymentsFlowPartnerAgent.index(backend))),format.raw/*77.94*/("""" role="button">"""),_display_(Seq[Any](/*77.111*/Messages/*77.119*/.get("button.explore"))),format.raw/*77.141*/(""" &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*80.16*/Messages/*80.24*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*80.68*/("""</h2>
          <p>"""),_display_(Seq[Any](/*81.15*/Messages/*81.23*/.get("section.consent.PaymentsFlowSelfcare.desc"))),format.raw/*81.72*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*82.48*/routes/*82.54*/.PaymentsFlowSelfcare.index(backend))),format.raw/*82.90*/("""" role="button">"""),_display_(Seq[Any](/*82.107*/Messages/*82.115*/.get("button.explore"))),format.raw/*82.137*/(""" &raquo;</a></p>
        </div>

        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*86.16*/Messages/*86.24*/.get("section.consent.Location"))),format.raw/*86.56*/("""</h2>
          <p>"""),_display_(Seq[Any](/*87.15*/Messages/*87.23*/.get("section.consent.Location.desc"))),format.raw/*87.60*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*88.48*/routes/*88.54*/.Location.index(backend))),format.raw/*88.78*/("""" role="button">"""),_display_(Seq[Any](/*88.95*/Messages/*88.103*/.get("button.explore"))),format.raw/*88.125*/(""" &raquo;</a></p>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/index.scala.html
                    HASH: cacf807b635cdbbd0b63ca4e7612f0b584477ef8
                    MATRIX: 610->1|831->83|861->133|898->136|965->195|1004->197|1141->298|1158->306|1223->349|1280->370|1297->378|1367->426|1456->479|1471->485|1521->513|1574->530|1592->538|1637->560|1756->643|1773->651|1832->688|1889->709|1906->717|1970->759|2059->812|2074->818|2144->865|2198->882|2216->890|2261->912|2388->1003|2405->1011|2480->1064|2537->1085|2554->1093|2634->1151|2723->1204|2738->1210|2813->1262|2867->1279|2885->1287|2930->1309|3047->1390|3064->1398|3142->1454|3199->1475|3216->1483|3299->1544|3388->1597|3403->1603|3481->1658|3535->1675|3553->1683|3598->1705|3725->1796|3742->1804|3817->1857|3874->1878|3891->1886|3971->1944|4060->1997|4075->2003|4151->2056|4205->2073|4223->2081|4268->2103|4385->2184|4402->2192|4480->2248|4537->2269|4554->2277|4637->2338|4726->2391|4741->2397|4820->2453|4874->2470|4892->2478|4937->2500|5064->2591|5081->2599|5158->2654|5215->2675|5232->2683|5314->2743|5403->2796|5418->2802|5495->2856|5549->2873|5567->2881|5612->2903|5729->2984|5746->2992|5826->3050|5883->3071|5900->3079|5985->3142|6074->3195|6089->3201|6169->3258|6223->3275|6241->3283|6286->3305|6413->3396|6430->3404|6483->3435|6540->3456|6557->3464|6615->3500|6704->3553|6719->3559|6771->3589|6825->3606|6843->3614|6888->3636|7007->3719|7024->3727|7092->3773|7151->3796|7168->3804|7241->3855|7332->3910|7347->3916|7394->3941|7447->3958|7465->3966|7510->3988|7627->4069|7644->4077|7704->4115|7761->4136|7778->4144|7843->4187|7932->4240|7947->4246|7999->4276|8053->4293|8071->4301|8116->4323|8233->4404|8250->4412|8300->4440|8357->4461|8374->4469|8429->4502|8518->4555|8533->4561|8578->4584|8631->4601|8649->4609|8694->4631|8811->4712|8828->4720|8898->4768|8955->4789|8972->4797|9047->4850|9136->4903|9151->4909|9213->4949|9267->4966|9285->4974|9330->4996|9447->5077|9464->5085|9530->5129|9587->5150|9604->5158|9675->5207|9764->5260|9779->5266|9837->5302|9891->5319|9909->5327|9954->5349|10073->5432|10090->5440|10144->5472|10201->5493|10218->5501|10277->5538|10366->5591|10381->5597|10427->5621|10480->5638|10498->5646|10543->5668
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|32->10|32->10|32->10|33->11|33->11|33->11|34->12|34->12|34->12|34->12|34->12|34->12|38->16|38->16|38->16|39->17|39->17|39->17|40->18|40->18|40->18|40->18|40->18|40->18|44->22|44->22|44->22|45->23|45->23|45->23|46->24|46->24|46->24|46->24|46->24|46->24|49->27|49->27|49->27|50->28|50->28|50->28|51->29|51->29|51->29|51->29|51->29|51->29|55->33|55->33|55->33|56->34|56->34|56->34|57->35|57->35|57->35|57->35|57->35|57->35|60->38|60->38|60->38|61->39|61->39|61->39|62->40|62->40|62->40|62->40|62->40|62->40|66->44|66->44|66->44|67->45|67->45|67->45|68->46|68->46|68->46|68->46|68->46|68->46|71->49|71->49|71->49|72->50|72->50|72->50|73->51|73->51|73->51|73->51|73->51|73->51|77->55|77->55|77->55|78->56|78->56|78->56|79->57|79->57|79->57|79->57|79->57|79->57|82->60|82->60|82->60|83->61|83->61|83->61|84->62|84->62|84->62|84->62|84->62|84->62|87->65|87->65|87->65|88->66|88->66|88->66|89->67|89->67|89->67|89->67|89->67|89->67|92->70|92->70|92->70|93->71|93->71|93->71|94->72|94->72|94->72|94->72|94->72|94->72|97->75|97->75|97->75|98->76|98->76|98->76|99->77|99->77|99->77|99->77|99->77|99->77|102->80|102->80|102->80|103->81|103->81|103->81|104->82|104->82|104->82|104->82|104->82|104->82|108->86|108->86|108->86|109->87|109->87|109->87|110->88|110->88|110->88|110->88|110->88|110->88
                    -- GENERATED --
                */
            