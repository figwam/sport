
package views.html.mobile

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
"""),_display_(Seq[Any](/*6.2*/main("Welcome to "+Messages.get("section.mobile")+" Apis")/*6.60*/ {_display_(Seq[Any](format.raw/*6.62*/("""	
	    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*11.16*/Messages/*11.24*/.get("section.mobile.capacity"))),format.raw/*11.55*/("""</h2>
          <p>"""),_display_(Seq[Any](/*12.15*/Messages/*12.23*/.get("section.mobile.capacity.desc"))),format.raw/*12.59*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*13.48*/routes/*13.54*/.MobileCapacity.form)),format.raw/*13.74*/("""" role="button">"""),_display_(Seq[Any](/*13.91*/Messages/*13.99*/.get("button.explore"))),format.raw/*13.121*/(""" &raquo;</a></p>
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
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/index.scala.html
                    HASH: da465f8ca8bb80f03a3dfc6dd7211bc924d2b7e3
                    MATRIX: 602->1|808->68|838->118|875->121|941->179|980->181|1160->325|1177->333|1230->364|1287->385|1304->393|1362->429|1451->482|1466->488|1508->508|1561->525|1578->533|1623->555
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|35->13|35->13|35->13|35->13
                    -- GENERATED --
                */
            