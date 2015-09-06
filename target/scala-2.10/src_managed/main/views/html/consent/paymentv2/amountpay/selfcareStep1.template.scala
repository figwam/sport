
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
* Payment and refund flows: data form.
*
* @param backend Backend to be used
* @param code Received as a result of authentication
* @param paymentSelfcareForm Form representation
* @param flow Flow name: transactions/payselfcare/refundselfcare
*/
object selfcareStep1 extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,Form[PaymentData],String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /*
* Payment and refund flows: data form.
*
* @param backend Backend to be used
* @param code Received as a result of authentication
* @param paymentSelfcareForm Form representation
* @param flow Flow name: transactions/payselfcare/refundselfcare
*/
    def apply/*10.2*/(backend: String, code : String, paymentSelfcareForm: Form[PaymentData], flow: String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*10.177*/("""

"""),format.raw/*15.1*/("""
"""),_display_(Seq[Any](/*16.2*/main("Welcome to "+Messages.get("section.consent.paymentv2.amountpay.selfcare")+" Apis")/*16.90*/ {_display_(Seq[Any](format.raw/*16.92*/("""
    <div class="container">
        """),_display_(Seq[Any](/*18.10*/if(error.nonEmpty)/*18.28*/ {_display_(Seq[Any](format.raw/*18.30*/("""
	        <div class="row">
		        <p>
		            <div class="row">
		                <div class="alert-danger panel">
		                    <div class="alert-danger panel-heading">
		                        <h3 class="panel-title">Error</h3>
		                    </div>
		                    <div class="alert-danger panel-body">
		                        <code><pre>"""),_display_(Seq[Any](/*27.39*/{error})),format.raw/*27.46*/("""</pre></code>
		                    </div>
		                </div>
		            </div>
		        </p>
	        </div>
        """)))}/*33.11*/else/*33.16*/{_display_(Seq[Any](format.raw/*33.17*/("""
	        <p>
	            """),_display_(Seq[Any](/*35.15*/helper/*35.21*/.form(action = routes.PaymentV2.payselfcareStep2(backend, flow), 'class -> "form-horizontal")/*35.114*/ {_display_(Seq[Any](format.raw/*35.116*/("""
	                <input type="hidden" name="authCode" id="authCode" value=""""),_display_(Seq[Any](/*36.77*/code)),format.raw/*36.81*/(""""/>
	                <div class="form-group">
	                    <label for="endUserId" class="col-sm-4 control-label">End User ID</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="endUserId" id="endUserId" value="6c125983-d8ac-4a2d-8f3f-46367db810e3"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="amount" class="col-sm-4 control-label">Amount / Currency</label>
	                    <div class="col-sm-6">
	                        <input type="text" class="form-control" name="amount" id="amount" pattern="\-?\d+(\.\d+)?" required="1" value="256.02"/>
	                    </div>
	                    <div class="col-sm-2">
	                        <input type="text" class="form-control" name="currency" id="currency" required="1" value="CHF"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="description" class="col-sm-4 control-label">Description</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="description" id="description" required="1" value="Sample description"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="locale" class="col-sm-4 control-label">Locale</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="locale" id="locale" maxlength="5" required="1" value="de-CH"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="onBehalfOf" class="col-sm-4 control-label">On behalf of</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="onBehalfOf" id="onBehalfOf" required="1" value="Faraoh Shop"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="purchaseCategoryCode" class="col-sm-4 control-label">Purchase category code</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="purchaseCategoryCode" id="purchaseCategoryCode" required="1" value="Papyrus"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="taxRate" class="col-sm-4 control-label">Tax rate</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="taxRate" id="taxRate" pattern="\-?\d+(\.\d+)?" required="1" value="8"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="referenceCode" class="col-sm-4 control-label">Reference code</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="referenceCode" id="referenceCode" required="1" value="REF-FFFF"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <div class="col-sm-offset-4 col-sm-8">
	                        <input type="submit" class="btn btn-default"/>
	                    </div>
	                </div>
	            """)))})),format.raw/*93.15*/("""
	        </p>
	    """)))})),format.raw/*95.7*/("""
    </div>
""")))})))}
    }
    
    def render(backend:String,code:String,paymentSelfcareForm:Form[PaymentData],flow:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,code,paymentSelfcareForm,flow,error)(request)
    
    def f:((String,String,Form[PaymentData],String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,code,paymentSelfcareForm,flow,error) => (request) => apply(backend,code,paymentSelfcareForm,flow,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/amountpay/selfcareStep1.scala.html
                    HASH: c85920405a92d44f785b50579f64f4d98a56f522
                    MATRIX: 1190->261|1529->436|1560->509|1598->512|1695->600|1735->602|1811->642|1838->660|1878->662|2299->1047|2328->1054|2482->1190|2495->1195|2534->1196|2600->1226|2615->1232|2718->1325|2759->1327|2873->1405|2899->1409|6444->4922|6498->4945
                    LINES: 33->10|41->10|43->15|44->16|44->16|44->16|46->18|46->18|46->18|55->27|55->27|61->33|61->33|61->33|63->35|63->35|63->35|63->35|64->36|64->36|121->93|123->95
                    -- GENERATED --
                */
            