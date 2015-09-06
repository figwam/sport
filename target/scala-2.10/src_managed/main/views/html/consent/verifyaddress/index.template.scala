
package views.html.consent.verifyaddress

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,String,String,String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend:String, responseType:String, clientId:String, redirectUri:String, app : String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.155*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Welcome Consent: Verify address")/*7.41*/ {_display_(Seq[Any](format.raw/*7.43*/("""	

"""),_display_(Seq[Any](/*9.2*/if("token".equals(responseType))/*9.34*/ {_display_(Seq[Any](format.raw/*9.36*/("""
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*10.39*/routes/*10.45*/.Assets.at("javascripts/jquery-2.1.0.min.js"))),format.raw/*10.90*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*11.39*/routes/*11.45*/.Assets.at("javascripts/json2.js"))),format.raw/*11.79*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*12.39*/routes/*12.45*/.Assets.at("javascripts/localstorage.js"))),format.raw/*12.86*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*13.39*/routes/*13.45*/.Assets.at("javascripts/jso.js"))),format.raw/*13.77*/(""""></script>
  <script type="text/javascript" src=""""),_display_(Seq[Any](/*14.40*/routes/*14.46*/.ConsentVerifyAddress.getOauthProviders(backend, app))),format.raw/*14.99*/(""""></script>
    
	<script type="text/javascript">
	  function doImplicit() """),format.raw/*17.26*/("""{"""),format.raw/*17.27*/("""
	
	    // This dumps all cached tokens to console, for easyer debugging.
	    jso_dump();
		
		  jso_wipe();
		  
		  //checks if has token
		  jso_ensureTokens("""),format.raw/*25.22*/("""{"""),format.raw/*25.23*/(""""swisscom": []"""),format.raw/*25.37*/("""}"""),format.raw/*25.38*/(""");
		 	   
	  """),format.raw/*27.4*/("""}"""),format.raw/*27.5*/("""
	</script>
""")))})),format.raw/*29.2*/("""

<script type="text/javascript">
  function getConsent(responseType) """),format.raw/*32.37*/("""{"""),format.raw/*32.38*/("""
    if (responseType === "token") """),format.raw/*33.35*/("""{"""),format.raw/*33.36*/("""
      doImplicit();
    """),format.raw/*35.5*/("""}"""),format.raw/*35.6*/("""
    else if ("code" === responseType) """),format.raw/*36.39*/("""{"""),format.raw/*36.40*/("""
      window.location.href = """"),_display_(Seq[Any](/*37.32*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*37.101*/("""?response_type="""),_display_(Seq[Any](/*37.117*/helper/*37.123*/.urlEncode(responseType))),format.raw/*37.147*/("""&redirect_uri="""),_display_(Seq[Any](/*37.162*/helper/*37.168*/.urlEncode(redirectUri))),format.raw/*37.191*/("""&client_id="""),_display_(Seq[Any](/*37.203*/helper/*37.209*/.urlEncode(clientId))),format.raw/*37.229*/("""&lang=en"""),_display_(Seq[Any](/*37.238*/if(app=="manual40"||app=="automatic40")/*37.277*/{_display_(Seq[Any](format.raw/*37.278*/("""&RAL=40""")))})),format.raw/*37.286*/("""";
    """),format.raw/*38.5*/("""}"""),format.raw/*38.6*/("""
  """),format.raw/*39.3*/("""}"""),format.raw/*39.4*/("""
</script>

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*45.17*/routes/*45.23*/.Assets.at("images/logo-roberto.png"))),format.raw/*45.60*/(""""/>
        <a href="#" class="btn btn-primary btn-sm pull-right">"""),_display_(Seq[Any](/*46.64*/Messages/*46.72*/.get("button.login"))),format.raw/*46.92*/("""</a>
        <span class="pull-right">&nbsp;&nbsp;&nbsp;"""),_display_(Seq[Any](/*47.53*/Messages/*47.61*/.get("section.consent.verifyaddress.or"))),format.raw/*47.101*/("""&nbsp;&nbsp;&nbsp;</span>
		<button type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#myModal">"""),_display_(Seq[Any](/*48.104*/Messages/*48.112*/.get("section.consent.verifyaddress.get.member"))),format.raw/*48.160*/("""</button>
    	<span class="pull-right">"""),_display_(Seq[Any](/*49.32*/Messages/*49.40*/.get("section.consent.verifyaddress.new.here"))),format.raw/*49.86*/("""&nbsp;&nbsp;&nbsp;</span>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Welcome to roberto.ch online shop</h2>
  	<p>
  	This is a demo which simulates an online shop registration. Click on """"),_display_(Seq[Any](/*56.75*/Messages/*56.83*/.get("section.consent.verifyaddress.get.member"))),format.raw/*56.131*/("""".
    </p>
   	<img src=""""),_display_(Seq[Any](/*58.16*/routes/*58.22*/.Assets.at("images/ricardo.png"))),format.raw/*58.54*/("""" height="100%"/></>
  </div><!-- panel-heading -->
</div><!-- panel -->

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="purchaseLabel" aria-hidden="true">
     <div class="modal-dialog">
         <div class="modal-content">
             <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title" id="purchaseLabel">Do you want to provide us your data?</h4>
             </div>
             <div class="modal-body">
			      <h2>Provide us your data quickly and securely with Swisscom</h2>
			      <p>You can start selling immediately by allowing us to obtain your personal data (name and address) directly from Swisscom.
			      </p>
			      """),_display_(Seq[Any](/*73.11*/if(backend=="mock")/*73.30*/ {_display_(Seq[Any](format.raw/*73.32*/("""
			      	<a href=""""),_display_(Seq[Any](/*74.21*/routes/*74.27*/.SSOMock.index)),format.raw/*74.41*/(""""><img class="swisscom-login-button" src="/assets/images/register_swisscom_l.png"/></a>
			      """)))}/*75.12*/else/*75.17*/{_display_(Seq[Any](format.raw/*75.18*/("""
			      	<a href="javascript:getConsent('"""),_display_(Seq[Any](/*76.44*/responseType)),format.raw/*76.56*/("""')"><img class="swisscom-register-button" src="/assets/images/register_swisscom_l.png"/></a>
			      """)))})),format.raw/*77.11*/("""
             </div>
             <div class="modal-footer">
			      <button type="button" class="btn btn-warning" data-dismiss="modal">Proceed with postal verification (3 days)</button> 
			 </div>
         </div>
     </div><!-- modal-dialog -->
</div><!-- modal -->

""")))})),format.raw/*86.2*/("""
"""))}
    }
    
    def render(backend:String,responseType:String,clientId:String,redirectUri:String,app:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,responseType,clientId,redirectUri,app)(request)
    
    def f:((String,String,String,String,String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,responseType,clientId,redirectUri,app) => (request) => apply(backend,responseType,clientId,redirectUri,app)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/verifyaddress/index.scala.html
                    HASH: 9bf49647b072ad4a7bc2076849466f7061848a9c
                    MATRIX: 652->1|968->154|998->227|1035->230|1082->269|1121->271|1161->277|1201->309|1240->311|1316->351|1331->357|1398->402|1485->453|1500->459|1556->493|1643->544|1658->550|1721->591|1808->642|1823->648|1877->680|1965->732|1980->738|2055->791|2161->869|2190->870|2388->1040|2417->1041|2459->1055|2488->1056|2531->1072|2559->1073|2605->1088|2706->1161|2735->1162|2799->1198|2828->1199|2882->1226|2910->1227|2978->1267|3007->1268|3076->1301|3168->1370|3221->1386|3237->1392|3284->1416|3336->1431|3352->1437|3398->1460|3447->1472|3463->1478|3506->1498|3552->1507|3601->1546|3641->1547|3682->1555|3717->1563|3745->1564|3776->1568|3804->1569|3953->1682|3968->1688|4027->1725|4131->1793|4148->1801|4190->1821|4284->1879|4301->1887|4364->1927|4531->2057|4549->2065|4620->2113|4698->2155|4715->2163|4783->2209|5070->2460|5087->2468|5158->2516|5223->2545|5238->2551|5292->2583|6144->3399|6172->3418|6212->3420|6270->3442|6285->3448|6321->3462|6439->3562|6452->3567|6491->3568|6572->3613|6606->3625|6742->3729|7054->4010
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|32->9|32->9|32->9|33->10|33->10|33->10|34->11|34->11|34->11|35->12|35->12|35->12|36->13|36->13|36->13|37->14|37->14|37->14|40->17|40->17|48->25|48->25|48->25|48->25|50->27|50->27|52->29|55->32|55->32|56->33|56->33|58->35|58->35|59->36|59->36|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|60->37|61->38|61->38|62->39|62->39|68->45|68->45|68->45|69->46|69->46|69->46|70->47|70->47|70->47|71->48|71->48|71->48|72->49|72->49|72->49|79->56|79->56|79->56|81->58|81->58|81->58|96->73|96->73|96->73|97->74|97->74|97->74|98->75|98->75|98->75|99->76|99->76|100->77|109->86
                    -- GENERATED --
                */
            