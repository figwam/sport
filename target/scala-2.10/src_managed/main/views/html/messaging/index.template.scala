
package views.html.messaging

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/()(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages


Seq[Any](format.raw/*1.69*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome to "+Messages.get("section.messaging")+" Apis")/*6.63*/ {_display_(Seq[Any](format.raw/*6.65*/("""	
	    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*11.16*/Messages/*11.24*/.get("section.messaging.sms"))),format.raw/*11.53*/("""</h2>
          <p>"""),_display_(Seq[Any](/*12.15*/Messages/*12.23*/.get("section.messaging.sms.desc"))),format.raw/*12.57*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*13.48*/routes/*13.54*/.SmsSender.form)),format.raw/*13.69*/("""" role="button">"""),_display_(Seq[Any](/*13.86*/Messages/*13.94*/.get("button.explore"))),format.raw/*13.116*/(""" &raquo;</a></p>
        </div>
      </div>

""")))})))}
    }
    
    def render(request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply()(request)
    
    def f:(() => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = () => (request) => apply()(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/messaging/index.scala.html
                    HASH: 6e5f0f8c32d26f464883fc4c3ac6dc031939dd40
                    MATRIX: 605->1|811->68|841->118|878->121|947->182|986->184|1166->328|1183->336|1234->365|1291->386|1308->394|1364->428|1453->481|1468->487|1505->502|1558->519|1575->527|1620->549
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|35->13|35->13|35->13
                    -- GENERATED --
                */
            