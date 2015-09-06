
package views.html.mobile.capacity

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
object withAPI extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CapacityInfo],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(capacityForm: Form[CapacityInfo])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.101*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Welcome to Mobile Apis")/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""	

	<img src=""""),_display_(Seq[Any](/*9.13*/routes/*9.19*/.Assets.at("images/speedtest.png"))),format.raw/*9.53*/("""" width="150" />
	<br>
	<br>
	<img src=""""),_display_(Seq[Any](/*12.13*/routes/*12.19*/.Assets.at("images/13z15_und_1_8z2_0.png"))),format.raw/*12.61*/("""" width="420" />
	<br>
	<br>
    
	<p>
		<h4>This is the result WITH the Mobile Network Information API</h4>
	</p>

	<table class="table table-bordered">
		<tr><td colspan="3"><b>Swisscom</b></td></tr>
		<tr bgcolor="""),_display_(Seq[Any](/*22.16*/capacityForm("color")/*22.37*/.value)),format.raw/*22.43*/("""><td width="33%">Download Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*22.130*/capacityForm("downloadRate")/*22.158*/.value)),format.raw/*22.164*/("""</td><td><b>"""),_display_(Seq[Any](/*22.177*/capacityForm("downloadRatio")/*22.206*/.value)),format.raw/*22.212*/("""%</b> of expected Speed</td></tr>
		<tr bgcolor="""),_display_(Seq[Any](/*23.16*/capacityForm("color")/*23.37*/.value)),format.raw/*23.43*/("""><td width="33%">Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*23.128*/capacityForm("uploadRate")/*23.154*/.value)),format.raw/*23.160*/("""</td><td><b>"""),_display_(Seq[Any](/*23.173*/capacityForm("uploadRatio")/*23.200*/.value)),format.raw/*23.206*/("""%</b> of expected Speed</td></tr>
	</table>

	<p>
		<h4>This is what was expected from your subscription</h4>
	</p>

	<table class="table table-bordered">
		<tr><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*31.118*/capacityForm("expectedDownload")/*31.150*/.value)),format.raw/*31.156*/("""<br>"""),_display_(Seq[Any](/*31.161*/capacityForm("expectedUpload")/*31.191*/.value)),format.raw/*31.197*/("""</td><td>Throttling Status: <b>"""),_display_(Seq[Any](/*31.229*/capacityForm("throttling")/*31.255*/.value)),format.raw/*31.261*/("""</b></td></tr>
	</table>

	<p>
		<h4>This is what the competitors had (unthrottled)</h4>
	</p>

	<table class="table table-bordered">
		<tr bgcolor="#CCFFCC"><td colspan="3"><b>Rank 1: Swisscom</b></td></tr>
		<tr bgcolor="#CCFFCC"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">14.27<br>1.96</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*40.191*/routes/*40.197*/.MobileCapacity.withoutAPI)),format.raw/*40.223*/("""" role="button">Upgrade <b>Swisscom</b> subscription</a></td></tr>
		<tr bgcolor="#FFC68D"><td colspan="3"><b>Rank 2: Sunset</b></td></tr>
		<tr bgcolor="#FFC68D"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">12.88<br>1.71</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*42.191*/routes/*42.197*/.MobileCapacity.withoutAPI)),format.raw/*42.223*/("""" role="button">Switch to <b>Sunset</b></a></td></tr>
		<tr bgcolor="#FF704D"><td colspan="3"><b>Rank 3: Pepper</b></td></tr>
		<tr bgcolor="#FF704D"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">11.93<br>1.64</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*44.191*/routes/*44.197*/.MobileCapacity.withoutAPI)),format.raw/*44.223*/("""" role="button">Switch to <b>Pepper</b></a></td></tr>
	</table>

    <a class="btn btn-primary" href=""""),_display_(Seq[Any](/*47.39*/routes/*47.45*/.MobileCapacity.form)),format.raw/*47.65*/("""" role="button">Back</a>

""")))})))}
    }
    
    def render(capacityForm:Form[CapacityInfo],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(capacityForm)(request)
    
    def f:((Form[CapacityInfo]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (capacityForm) => (request) => apply(capacityForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/capacity/withAPI.scala.html
                    HASH: 0be37c1153a421ab4bfef79fc841de3c4bb28fdc
                    MATRIX: 632->1|894->100|924->173|961->176|999->206|1038->208|1090->225|1104->231|1159->265|1239->309|1254->315|1318->357|1581->584|1611->605|1639->611|1763->698|1801->726|1830->732|1880->745|1919->774|1948->780|2034->830|2064->851|2092->857|2214->942|2250->968|2279->974|2329->987|2366->1014|2395->1020|2712->1300|2754->1332|2783->1338|2825->1343|2865->1373|2894->1379|2963->1411|2999->1437|3028->1443|3472->1850|3488->1856|3537->1882|3905->2213|3921->2219|3970->2245|4325->2563|4341->2569|4390->2595|4532->2701|4547->2707|4589->2727
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|32->9|32->9|32->9|35->12|35->12|35->12|45->22|45->22|45->22|45->22|45->22|45->22|45->22|45->22|45->22|46->23|46->23|46->23|46->23|46->23|46->23|46->23|46->23|46->23|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|63->40|63->40|63->40|65->42|65->42|65->42|67->44|67->44|67->44|70->47|70->47|70->47
                    -- GENERATED --
                */
            