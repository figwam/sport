
package views.html.consent.payment

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[Either[String, String],Either[String, String],String,Option[Boolean],String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(accessToken : Either[String, String], transactionId : Either[String,String], amountReserved : String, charged : Option[Boolean], backend : String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.214*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Welcome Consent: Payment")/*7.34*/ {_display_(Seq[Any](format.raw/*7.36*/("""

<script type="text/javascript">
function reserveAmount() """),format.raw/*10.26*/("""{"""),format.raw/*10.27*/("""
	  var amount = window.prompt("Enter the amount to be reserved.");
	  window.location.href="reserve?token="""),_display_(Seq[Any](/*12.41*/if(accessToken.isRight)/*12.64*/{_display_(Seq[Any](_display_(Seq[Any](/*12.66*/accessToken/*12.77*/.right.get))))})),format.raw/*12.88*/("""&amount="+amount+"&transaction_id="""),_display_(Seq[Any](/*12.123*/if(transactionId.isRight)/*12.148*/{_display_(Seq[Any](_display_(Seq[Any](/*12.150*/transactionId/*12.163*/.right.get))))})),format.raw/*12.174*/("""&backend="""),_display_(Seq[Any](/*12.184*/backend)),format.raw/*12.191*/("""";
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/("""
function pay() """),format.raw/*14.16*/("""{"""),format.raw/*14.17*/("""
    var amount = 100;
	  window.location.href="pay?token="""),_display_(Seq[Any](/*16.37*/if(accessToken.isRight)/*16.60*/{_display_(Seq[Any](_display_(Seq[Any](/*16.62*/accessToken/*16.73*/.right.get))))})),format.raw/*16.84*/("""&amount="+amount+"&transaction_id="""),_display_(Seq[Any](/*16.119*/if(transactionId.isRight)/*16.144*/{_display_(Seq[Any](_display_(Seq[Any](/*16.146*/transactionId/*16.159*/.right.get))))})),format.raw/*16.170*/("""&reserved="""),_display_(Seq[Any](/*16.181*/amountReserved)),format.raw/*16.195*/("""&backend="""),_display_(Seq[Any](/*16.205*/backend)),format.raw/*16.212*/("""";
"""),format.raw/*17.1*/("""}"""),format.raw/*17.2*/("""
</script>

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*23.17*/routes/*23.23*/.Assets.at("images/logo-roberto.png"))),format.raw/*23.60*/(""""/>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Welcome to roberto.ch online shop</h2>
  	<p>
  	This is a demo which simulates payment.
    </p>
    
    """),_display_(Seq[Any](/*33.6*/if(accessToken.isLeft)/*33.28*/ {_display_(Seq[Any](format.raw/*33.30*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error getting access token: """),_display_(Seq[Any](/*36.40*/accessToken/*36.51*/.left.get)),format.raw/*36.60*/("""
        </div>
    """)))})),format.raw/*38.6*/("""
    """),_display_(Seq[Any](/*39.6*/if(transactionId.isLeft)/*39.30*/ {_display_(Seq[Any](format.raw/*39.32*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error reserving amount: """),_display_(Seq[Any](/*42.36*/transactionId/*42.49*/.left.get)),format.raw/*42.58*/("""
        </div>
    """)))})),format.raw/*44.6*/("""
    """),_display_(Seq[Any](/*45.6*/if(charged.isDefined && !charged.get)/*45.43*/ {_display_(Seq[Any](format.raw/*45.45*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error with payment. Do you have enough amount reserved?
        </div>
    """)))})),format.raw/*50.6*/("""
    """),_display_(Seq[Any](/*51.6*/if(charged.isDefined && charged.get)/*51.42*/ {_display_(Seq[Any](format.raw/*51.44*/("""
        <div class="alert alert-dismissable alert-info">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Payment successful!
        </div>
    """)))})),format.raw/*56.6*/("""
    
    <p>Your account balance</p>
    <p>CHF """),_display_(Seq[Any](/*59.13*/amountReserved)),format.raw/*59.27*/("""</p>
    <p><input type="button" value="Reserve Amount" OnClick="javascript: reserveAmount()"></p>
    
    <p>Your shopping cart:</p>
  
    <p>Product 1</p>
    <p>CHF 100,00</p>
    <p><input type="button" value="Pay with Swisscom" OnClick="javascript: pay()"></p>

  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*71.2*/("""
"""))}
    }
    
    def render(accessToken:Either[String, String],transactionId:Either[String, String],amountReserved:String,charged:Option[Boolean],backend:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(accessToken,transactionId,amountReserved,charged,backend)(request)
    
    def f:((Either[String, String],Either[String, String],String,Option[Boolean],String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (accessToken,transactionId,amountReserved,charged,backend) => (request) => apply(accessToken,transactionId,amountReserved,charged,backend)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/payment/index.scala.html
                    HASH: de601b44059d290692b2f2834b08468d6bd403d1
                    MATRIX: 687->1|1062->213|1092->286|1129->289|1169->321|1208->323|1298->385|1327->386|1473->496|1505->519|1553->521|1573->532|1610->543|1682->578|1717->603|1766->605|1789->618|1827->629|1874->639|1904->646|1935->650|1963->651|2008->668|2037->669|2134->730|2166->753|2214->755|2234->766|2271->777|2343->812|2378->837|2427->839|2450->852|2488->863|2536->874|2573->888|2620->898|2650->905|2681->909|2709->910|2858->1023|2873->1029|2932->1066|3187->1286|3218->1308|3258->1310|3474->1490|3494->1501|3525->1510|3579->1533|3621->1540|3654->1564|3694->1566|3906->1742|3928->1755|3959->1764|4013->1787|4055->1794|4101->1831|4141->1833|4401->2062|4443->2069|4488->2105|4528->2107|4750->2298|4839->2351|4875->2365|5241->2700
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|33->10|33->10|35->12|35->12|35->12|35->12|35->12|35->12|35->12|35->12|35->12|35->12|35->12|35->12|36->13|36->13|37->14|37->14|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|39->16|40->17|40->17|46->23|46->23|46->23|56->33|56->33|56->33|59->36|59->36|59->36|61->38|62->39|62->39|62->39|65->42|65->42|65->42|67->44|68->45|68->45|68->45|73->50|74->51|74->51|74->51|79->56|82->59|82->59|94->71
                    -- GENERATED --
                */
            