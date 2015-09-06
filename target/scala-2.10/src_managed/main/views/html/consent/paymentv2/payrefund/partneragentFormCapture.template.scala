
package views.html.consent.paymentv2.payrefund

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
object partneragentFormCapture extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,Form[PaymentData],String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

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
"""),_display_(Seq[Any](/*16.2*/main("Welcome to "+Messages.get("section.consent.paymentv2." + flow)+" Apis")/*16.79*/ {_display_(Seq[Any](format.raw/*16.81*/("""
    <div class="container">
        <div class="row">
		    <h2>"""),_display_(Seq[Any](/*19.12*/Messages/*19.20*/.get("section.consent.paymentv2." + flow))),format.raw/*19.61*/("""</h2>
		    <p>"""),_display_(Seq[Any](/*20.11*/Messages/*20.19*/.get("section.consent.paymentv2.desc." + flow))),format.raw/*20.65*/("""</p>
        </div>
        """),_display_(Seq[Any](/*22.10*/if(error.nonEmpty)/*22.28*/ {_display_(Seq[Any](format.raw/*22.30*/("""
	        <div class="row">
		        <p>
		            <div class="row">
		                <div class="alert-danger panel">
		                    <div class="alert-danger panel-heading">
		                        <h3 class="panel-title">Error</h3>
		                    </div>
		                    <div class="alert-danger panel-body">
		                        <code><pre>"""),_display_(Seq[Any](/*31.39*/{error})),format.raw/*31.46*/("""</pre></code>
		                    </div>
		                </div>
		            </div>
		        </p>
	        </div>
        """)))}/*37.11*/else/*37.16*/{_display_(Seq[Any](format.raw/*37.17*/("""
	        <p>
	            """),_display_(Seq[Any](/*39.15*/helper/*39.21*/.form(action = routes.PaymentV2.paypartneragentApigeeCall(backend, flow), 'class -> "form-horizontal")/*39.123*/ {_display_(Seq[Any](format.raw/*39.125*/("""
	                <input type="hidden" name="authCode" id="authCode" value=""""),_display_(Seq[Any](/*40.77*/code)),format.raw/*40.81*/(""""/>
	                <div class="form-group">
	                    <label for="endUserId" class="col-sm-4 control-label">End User ID</label>
	                    <div class="col-sm-8">
	                        <input type="text" class="form-control" name="endUserId" id="endUserId" value="6c125983-d8ac-4a2d-8f3f-46367db810e3"/>
	                    </div>
	                </div>
	                <div class="form-group">
	                    <label for="amount" class="col-sm-4 control-label">Amount / Currency</label>
	                    <div class="col-sm-6">
	                        <input type="text" class="form-control" name="amount" id="amount" pattern="\-?\d+(\.\d+)?" required="1" value='"""),_display_(Seq[Any](/*50.138*/if("refundpartneragent".equals(flow))/*50.175*/{_display_(Seq[Any](format.raw/*50.176*/("""-""")))})),format.raw/*50.178*/("""256.02'/>
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
                """)))})),format.raw/*97.18*/("""
	        </p>
        """)))})),format.raw/*99.10*/("""
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/paymentv2/payrefund/partneragentFormCapture.scala.html
                    HASH: 98a560198a243a9cb36a965eb21b8854f407ded3
                    MATRIX: 1200->261|1539->436|1570->509|1608->512|1694->589|1734->591|1839->660|1856->668|1919->709|1972->726|1989->734|2057->780|2124->811|2151->829|2191->831|2612->1216|2641->1223|2795->1359|2808->1364|2847->1365|2913->1395|2928->1401|3040->1503|3081->1505|3195->1583|3221->1587|3970->2299|4017->2336|4057->2337|4092->2339|6929->5144|6987->5170
                    LINES: 33->10|41->10|43->15|44->16|44->16|44->16|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|59->31|59->31|65->37|65->37|65->37|67->39|67->39|67->39|67->39|68->40|68->40|78->50|78->50|78->50|78->50|125->97|127->99
                    -- GENERATED --
                */
            