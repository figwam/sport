
package views.html

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
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.69*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Welcome to Swisscom API Demo")/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
	<h1>"""),_display_(Seq[Any](/*6.7*/Messages/*6.15*/.get("welcome"))),format.raw/*6.30*/("""</h1>
        <p>"""),_display_(Seq[Any](/*7.13*/Messages/*7.21*/.get("welcome.desc"))),format.raw/*7.41*/("""</p>
        <p><a class="btn btn-primary btn-lg" role="button" href="https://developer.swisscom.com/api">"""),_display_(Seq[Any](/*8.103*/Messages/*8.111*/.get("button.get.started"))),format.raw/*8.137*/(""" &raquo;</a></p>
      </div>

    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>"""),_display_(Seq[Any](/*15.16*/Messages/*15.24*/.get("section.messaging"))),format.raw/*15.49*/(""" APIs</h2>
          <p>"""),_display_(Seq[Any](/*16.15*/Messages/*16.23*/.get("section.messaging.desc"))),format.raw/*16.53*/("""</p>
          <p><a class="btn btn-default" href=""""),_display_(Seq[Any](/*17.48*/routes/*17.54*/.Application.messaging)),format.raw/*17.76*/("""" role="button">"""),_display_(Seq[Any](/*17.93*/Messages/*17.101*/.get("button.explore"))),format.raw/*17.123*/(""" &raquo;</a></p>
        </div>
      </div>
""")))})),format.raw/*20.2*/("""
"""))}
    }
    
    def render(request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply()(request)
    
    def f:(() => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = () => (request) => apply()(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:34:28 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/index.scala.html
                    HASH: 71294691110a606d54e3f34b995dcc70342895d6
                    MATRIX: 595->1|782->68|810->97|846->99|890->135|929->137|970->144|986->152|1022->167|1075->185|1091->193|1132->213|1275->320|1292->328|1340->354|1543->521|1560->529|1607->554|1668->579|1685->587|1737->617|1825->669|1840->675|1884->697|1937->714|1955->722|2000->744|2077->790
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|27->6|27->6|27->6|28->7|28->7|28->7|29->8|29->8|29->8|36->15|36->15|36->15|37->16|37->16|37->16|38->17|38->17|38->17|38->17|38->17|38->17|41->20
                    -- GENERATED --
                */
            