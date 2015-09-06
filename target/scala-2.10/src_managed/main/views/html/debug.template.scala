
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
object debug extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(info : String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.i18n.Messages


Seq[Any](format.raw/*1.82*/("""

"""),format.raw/*4.1*/("""
"""),_display_(Seq[Any](/*5.2*/main("Welcome to Demapi")/*5.27*/ {_display_(Seq[Any](format.raw/*5.29*/("""
	<h1>"""),_display_(Seq[Any](/*6.7*/info)),format.raw/*6.11*/("""</h1>
""")))})),format.raw/*7.2*/("""
"""))}
    }
    
    def render(info:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(info)(request)
    
    def f:((String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (info) => (request) => apply(info)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:50 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/debug.scala.html
                    HASH: 3956be4502718e7efed46a91f7ec564635384db5
                    MATRIX: 602->1|802->81|830->110|866->112|899->137|938->139|979->146|1004->150|1041->157
                    LINES: 19->1|23->1|25->4|26->5|26->5|26->5|27->6|27->6|28->7
                    -- GENERATED --
                */
            