
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
object withoutAPI extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CapacityInfo],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

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
	<img src=""""),_display_(Seq[Any](/*12.13*/routes/*12.19*/.Assets.at("images/4z60_und_1z15.png"))),format.raw/*12.57*/("""" width="420" />
	<br>
	<br>

    <p>
    	<h4>This is the result WITHOUT the Mobile Network Information API</h4>
    </p>
    
    <table class="table table-bordered">
    	<tr><td colspan="3"><b>Swisscom</b></td></tr>
    	<tr bgcolor="""),_display_(Seq[Any](/*22.19*/capacityForm("color")/*22.40*/.value)),format.raw/*22.46*/("""><td width="33%">Download Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*22.133*/capacityForm("downloadRate")/*22.161*/.value)),format.raw/*22.167*/("""</td><td><b>"""),_display_(Seq[Any](/*22.180*/capacityForm("downloadRatio")/*22.209*/.value)),format.raw/*22.215*/("""%</b> of expected Speed</td></tr>
    	<tr bgcolor="""),_display_(Seq[Any](/*23.19*/capacityForm("color")/*23.40*/.value)),format.raw/*23.46*/("""><td width="33%">Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*23.131*/capacityForm("uploadRate")/*23.157*/.value)),format.raw/*23.163*/("""</td><td><b>"""),_display_(Seq[Any](/*23.176*/capacityForm("uploadRatio")/*23.203*/.value)),format.raw/*23.209*/("""%</b> of expected Speed</td></tr>
    </table>
    
    <p>
    	<h4>This is what was expected with 4G</h4>
    </p>
    
   	<table class="table table-bordered">
    	<tr><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*31.121*/capacityForm("expectedDownload")/*31.153*/.value)),format.raw/*31.159*/("""<br>"""),_display_(Seq[Any](/*31.164*/capacityForm("expectedUpload")/*31.194*/.value)),format.raw/*31.200*/("""</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*31.243*/routes/*31.249*/.MobileCapacity.withoutAPI)),format.raw/*31.275*/("""" role="button">Send trouble ticket to <b>Swisscom</b></a></td></tr>
    </table>
    
    <p>
    	<h4>This is what the competitors had</h4>
    </p>
    
   	<table class="table table-bordered">
    	<tr bgcolor="#CCFFCC"><td colspan="3"><b>Rank 1: Sunset</b></td></tr>
    	<tr bgcolor="#CCFFCC"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">45.34<br>8.23</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*40.194*/routes/*40.200*/.MobileCapacity.withoutAPI)),format.raw/*40.226*/("""" role="button">Switch to <b>Sunset</b></a></td></tr>
    	<tr bgcolor="#FFC68D"><td colspan="3"><b>Rank 2: Pepper</b></td></tr>
    	<tr bgcolor="#FFC68D"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">44.62<br>7.24</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*42.194*/routes/*42.200*/.MobileCapacity.withoutAPI)),format.raw/*42.226*/("""" role="button">Switch to <b>Pepper</b></a></td></tr>
		<tr bgcolor="#FF704D"><td colspan="3"><b>Rank 3: Swisscom</b></td></tr>
    	<tr bgcolor="#FF704D"><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">14.95<br>5.70</td><td><a class="btn btn-primary" href=""""),_display_(Seq[Any](/*44.194*/routes/*44.200*/.MobileCapacity.withoutAPI)),format.raw/*44.226*/("""" role="button">Cancel <b>Swisscom</b> subscription</a></td></tr>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/capacity/withoutAPI.scala.html
                    HASH: 66f126c3665eaa369f41d24b5f2e867cff718af3
                    MATRIX: 635->1|897->100|927->173|964->176|1002->206|1041->208|1093->225|1107->231|1162->265|1242->309|1257->315|1317->353|1601->601|1631->622|1659->628|1783->715|1821->743|1850->749|1900->762|1939->791|1968->797|2057->850|2087->871|2115->877|2237->962|2273->988|2302->994|2352->1007|2389->1034|2418->1040|2746->1331|2788->1363|2817->1369|2859->1374|2899->1404|2928->1410|3008->1453|3024->1459|3073->1485|3584->1959|3600->1965|3649->1991|4010->2315|4026->2321|4075->2347|4435->2670|4451->2676|4500->2702|4657->2823|4672->2829|4714->2849
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|32->9|32->9|32->9|35->12|35->12|35->12|45->22|45->22|45->22|45->22|45->22|45->22|45->22|45->22|45->22|46->23|46->23|46->23|46->23|46->23|46->23|46->23|46->23|46->23|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|54->31|63->40|63->40|63->40|65->42|65->42|65->42|67->44|67->44|67->44|70->47|70->47|70->47
                    -- GENERATED --
                */
            