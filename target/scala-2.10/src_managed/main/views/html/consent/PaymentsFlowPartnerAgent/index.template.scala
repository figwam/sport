
package views.html.consent.PaymentsFlowPartnerAgent

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Form[PaymentsInfo],String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend : String, paymentsinfoForm: Form[PaymentsInfo], transactionId : String, error : Option[String] )(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.172*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Payments flow Partner/Agent: End")/*7.42*/ {_display_(Seq[Any](format.raw/*7.44*/("""


<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<div class="row">
    		<div class="col-md-12">
    			<img src=""""),_display_(Seq[Any](/*15.19*/routes/*15.25*/.Assets.at("images/O365.png"))),format.raw/*15.54*/("""">
    		</div>
    	</div>
    	
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Office Shop</h2>
  	"""),_display_(Seq[Any](/*24.5*/if(transactionId != null)/*24.30*/ {_display_(Seq[Any](format.raw/*24.32*/("""
        <div class="success alert alert-dismissable alert-success">
          <button type="button" class="close" data-dismiss="alert">x</button>
          TransactionId: """),_display_(Seq[Any](/*27.27*/transactionId)),format.raw/*27.40*/("""
        </div>
    """)))})),format.raw/*29.6*/("""
  	
  	Thank you for choosing Office 365. We are sure your client will be hAPI.
  	"""),_display_(Seq[Any](/*32.5*/if(error.isDefined)/*32.24*/ {_display_(Seq[Any](format.raw/*32.26*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error: """),_display_(Seq[Any](/*35.19*/error/*35.24*/.get)),format.raw/*35.28*/("""
        </div>
    """)))})),format.raw/*37.6*/("""

  	<p>  	
  	"""),_display_(Seq[Any](/*40.5*/helper/*40.11*/.form(action = routes.PaymentsFlowPartnerAgent.consentRedirect(backend), 'class->"form-horizontal col-xs-12 col-md-6")/*40.129*/ {_display_(Seq[Any](format.raw/*40.131*/("""
		<div class="form-group">
 			"""),_display_(Seq[Any](/*42.6*/helper/*42.12*/.inputText(paymentsinfoForm("UUID"), 'class->"form-control", 'placeholder->"Enter UUID" ))),format.raw/*42.101*/("""
		</div>
		
		<div class="form-group">
  			"""),_display_(Seq[Any](/*46.7*/helper/*46.13*/.inputRadioGroup(paymentsinfoForm("Flow"),
									options = options("true" -> "Partner", "false" -> "Agent")))),format.raw/*47.69*/("""
		</div>

		<div class="form-group">
	        <button type="submit" class="btn btn-primary">Buy</button>
	    </div>
	""")))})),format.raw/*53.3*/("""
	</p>
    
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*59.2*/("""
"""))}
    }
    
    def render(backend:String,paymentsinfoForm:Form[PaymentsInfo],transactionId:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,paymentsinfoForm,transactionId,error)(request)
    
    def f:((String,Form[PaymentsInfo],String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,paymentsinfoForm,transactionId,error) => (request) => apply(backend,paymentsinfoForm,transactionId,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/PaymentsFlowPartnerAgent/index.scala.html
                    HASH: 29b067e1c42ca5f275a8f6b19d4d96eefc0d1a64
                    MATRIX: 676->1|1009->171|1039->244|1076->247|1124->287|1163->289|1360->450|1375->456|1426->485|1623->647|1657->672|1697->674|1909->850|1944->863|1998->886|2121->974|2149->993|2189->995|2384->1154|2398->1159|2424->1163|2478->1186|2532->1205|2547->1211|2675->1329|2716->1331|2786->1366|2801->1372|2913->1461|2998->1511|3013->1517|3147->1629|3304->1755|3407->1827
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|38->15|38->15|38->15|47->24|47->24|47->24|50->27|50->27|52->29|55->32|55->32|55->32|58->35|58->35|58->35|60->37|63->40|63->40|63->40|63->40|65->42|65->42|65->42|69->46|69->46|70->47|76->53|82->59
                    -- GENERATED --
                */
            