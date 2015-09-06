
package views.html.consent.PaymentsFlowSelfcare

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[String,String,String,String,String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend : String, redirectUri : String, clientId : String, transactionId : String, payment_amount : String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.199*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("O365 Selfcare Flow: Start")/*7.35*/ {_display_(Seq[Any](format.raw/*7.37*/("""
<script type="text/javascript" src=""""),_display_(Seq[Any](/*8.38*/routes/*8.44*/.Application.javascriptRoutes)),format.raw/*8.73*/(""""></script>
<script>
function savePaymentAmount() """),format.raw/*10.30*/("""{"""),format.raw/*10.31*/("""
  var value = document.getElementById('payment-amount').value;
  $('#amount-status-label').css("""),format.raw/*12.33*/("""{"""),format.raw/*12.34*/(""" 'display': 'none' """),format.raw/*12.53*/("""}"""),format.raw/*12.54*/(""")
  $.getJSON(jsRoutes.controllers.PaymentsFlowSelfcare.savePaymentAmount().url, """),format.raw/*13.80*/("""{"""),format.raw/*13.81*/("""
    "payment-amount": value
  """),format.raw/*15.3*/("""}"""),format.raw/*15.4*/(""", function(data) """),format.raw/*15.21*/("""{"""),format.raw/*15.22*/("""
      if(data && data.message) """),format.raw/*16.32*/("""{"""),format.raw/*16.33*/("""
          $('#amount-status-label').css("""),format.raw/*17.41*/("""{"""),format.raw/*17.42*/(""" 'display': 'inline' """),format.raw/*17.63*/("""}"""),format.raw/*17.64*/(""")
      """),format.raw/*18.7*/("""}"""),format.raw/*18.8*/("""
  """),format.raw/*19.3*/("""}"""),format.raw/*19.4*/(""")
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""
</script>

<div class="panel">
  <div class="panel-body">
  	<h2>Welcome to the O365 Selfcare Shop</h2>

   	"""),_display_(Seq[Any](/*27.6*/if(transactionId != null)/*27.31*/ {_display_(Seq[Any](format.raw/*27.33*/("""
        <div class="success alert alert-dismissable alert-success">
          <button type="button" class="close" data-dismiss="alert">x</button>
          TransactionId: """),_display_(Seq[Any](/*30.27*/transactionId)),format.raw/*30.40*/("""
        </div>
    """)))})),format.raw/*32.6*/("""
  	
  	"""),_display_(Seq[Any](/*34.5*/if(error.isDefined)/*34.24*/ {_display_(Seq[Any](format.raw/*34.26*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error: """),_display_(Seq[Any](/*37.19*/error/*37.24*/.get)),format.raw/*37.28*/("""
        </div>
    """)))})),format.raw/*39.6*/("""
   	"""),_display_(Seq[Any](/*40.6*/if(transactionId == null)/*40.31*/ {_display_(Seq[Any](format.raw/*40.33*/("""       
    	<p>
    		<img src=""""),_display_(Seq[Any](/*42.18*/routes/*42.24*/.Assets.at("images/O365.png"))),format.raw/*42.53*/(""""/>
    	</p>
      <p>
        <h4>Modify charged amount</h4>
        <input type="text" name="payment-amount" id="payment-amount" value=""""),_display_(Seq[Any](/*46.78*/payment_amount)),format.raw/*46.92*/("""" /><span id="amount-status-label" style="display: none; margin-left: 5px">Saved!</span>
        <div style="margin-top: 5px;"></div>
        <button onclick="javascript:savePaymentAmount()">Save</button>
      </p>    
    	<p>
    		<a href=""""),_display_(Seq[Any](/*51.17*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*51.86*/("""?response_type=code&redirect_uri="""),_display_(Seq[Any](/*51.120*/helper/*51.126*/.urlEncode(redirectUri))),format.raw/*51.149*/("""&client_id="""),_display_(Seq[Any](/*51.161*/helper/*51.167*/.urlEncode(clientId))),format.raw/*51.187*/("""&lang=en"><img src="/assets/images/BuyNow.jpg"/></a>
    	</p>
    """)))})),format.raw/*53.6*/("""
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*57.2*/("""
"""))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,transactionId:String,payment_amount:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,transactionId,payment_amount,error)(request)
    
    def f:((String,String,String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,transactionId,payment_amount,error) => (request) => apply(backend,redirectUri,clientId,transactionId,payment_amount,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/PaymentsFlowSelfcare/index.scala.html
                    HASH: eefbd8272c9cb5d1e3385b3e8fe9016e30abbf4d
                    MATRIX: 674->1|1034->198|1064->271|1101->274|1142->307|1181->309|1255->348|1269->354|1319->383|1399->435|1428->436|1554->534|1583->535|1630->554|1659->555|1769->637|1798->638|1858->671|1886->672|1931->689|1960->690|2021->723|2050->724|2120->766|2149->767|2198->788|2227->789|2263->798|2291->799|2322->803|2350->804|2380->807|2408->808|2561->926|2595->951|2635->953|2847->1129|2882->1142|2936->1165|2982->1176|3010->1195|3050->1197|3245->1356|3259->1361|3285->1365|3339->1388|3381->1395|3415->1420|3455->1422|3527->1458|3542->1464|3593->1493|3773->1637|3809->1651|4095->1901|4186->1970|4257->2004|4273->2010|4319->2033|4368->2045|4384->2051|4427->2071|4528->2141|4618->2200
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|31->8|31->8|31->8|33->10|33->10|35->12|35->12|35->12|35->12|36->13|36->13|38->15|38->15|38->15|38->15|39->16|39->16|40->17|40->17|40->17|40->17|41->18|41->18|42->19|42->19|43->20|43->20|50->27|50->27|50->27|53->30|53->30|55->32|57->34|57->34|57->34|60->37|60->37|60->37|62->39|63->40|63->40|63->40|65->42|65->42|65->42|69->46|69->46|74->51|74->51|74->51|74->51|74->51|74->51|74->51|74->51|76->53|80->57
                    -- GENERATED --
                */
            