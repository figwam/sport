
package views.html.messaging.sms

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
object summary extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[Sms],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(smsForm: Form[Sms])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.87*/("""



"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Welcome to Messaging Apis")/*7.35*/ {_display_(Seq[Any](format.raw/*7.37*/("""	
	    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Send SMS</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">Explore &raquo;</a></p>
        </div>
        <div class="col-md-4">
          <h2>TODO: Validate Token</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">Explore &raquo;</a></p>
       </div>
      </div>

""")))})))}
    }
    
    def render(smsForm:Form[Sms],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(smsForm)(request)
    
    def f:((Form[Sms]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (smsForm) => (request) => apply(smsForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/messaging/sms/summary.scala.html
                    HASH: c4f084c20af54fbc633c21c03599703de1563c1f
                    MATRIX: 621->1|817->86|851->112|888->115|929->148|968->150
                    LINES: 19->1|23->1|27->6|28->7|28->7|28->7
                    -- GENERATED --
                */
            