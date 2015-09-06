
package views.html.mobile.capacity

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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.67*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Welcome to Mobile Apis")/*7.32*/ {_display_(Seq[Any](format.raw/*7.34*/("""

    <img src=""""),_display_(Seq[Any](/*9.16*/routes/*9.22*/.Assets.at("images/speedtest.png"))),format.raw/*9.56*/("""" />
    
    <br><br>
    <p>
    	<h4>This is a Speed Test for your Mobile Phone</h4>
    </p>
    
    <a class="btn btn-primary" href=""""),_display_(Seq[Any](/*16.39*/routes/*16.45*/.MobileCapacity.gaucheWithoutAPI)),format.raw/*16.77*/("""" role="button">Test Speed Without API</a>
    <a class="btn btn-primary" href=""""),_display_(Seq[Any](/*17.39*/routes/*17.45*/.MobileCapacity.gaucheWithAPI)),format.raw/*17.74*/("""" role="button">Test Speed With API</a>

""")))})))}
    }
    
    def render(request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(request)
    
    def f:((play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (request) => apply(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/capacity/form.scala.html
                    HASH: b6c87f1b3362ded744ff60c5057b7b316b2cb322
                    MATRIX: 610->1|837->66|867->139|904->142|942->172|981->174|1035->193|1049->199|1104->233|1287->380|1302->386|1356->418|1474->500|1489->506|1540->535
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|32->9|32->9|32->9|39->16|39->16|39->16|40->17|40->17|40->17
                    -- GENERATED --
                */
            