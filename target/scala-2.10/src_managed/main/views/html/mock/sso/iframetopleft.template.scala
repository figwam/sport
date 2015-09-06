
package views.html.mock.sso

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
object iframetopleft extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html
  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta charset="UTF-8"><style type="text/css">
		@font-face 
		"""),format.raw/*5.3*/("""{"""),format.raw/*5.4*/("""
		    font-family: 'TheSaB3';
		    src: url('TheSaB3_.eot'); /* keep two src attribute even if there is a warning (IE needs it) */
		    src: url('TheSaB3_.eot?#iefix') format('embedded-opentype'),
		         url('TheSaB3_.woff') format('woff'),
		         url('TheSaB3_.ttf') format('truetype'),
		         url('TheSaB3_.svg?#TheSaB3_') format('svg');
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/("""
		body """),format.raw/*13.8*/("""{"""),format.raw/*13.9*/("""
			margin: 0;
			padding: 0;
			background:transparent;
			font-family: 'TheSaB3','Trebuchet MS',Arial,Helvetica,sans-serif;
			color: #015;
			
				font-size: 36px;
			
		"""),format.raw/*22.3*/("""}"""),format.raw/*22.4*/("""
		#image """),format.raw/*23.10*/("""{"""),format.raw/*23.11*/("""
			margin-left: 2px;
		"""),format.raw/*25.3*/("""}"""),format.raw/*25.4*/("""
	</style></head><body>
Swisscom API Login
</body></html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mock/sso/iframetopleft.scala.html
                    HASH: 8d9962e130b8d2641fced2812ab1fca8405096e7
                    MATRIX: 654->0|926->247|953->248|1337->605|1365->606|1400->614|1428->615|1628->788|1656->789|1694->799|1723->800|1774->824|1802->825
                    LINES: 22->1|26->5|26->5|33->12|33->12|34->13|34->13|43->22|43->22|44->23|44->23|46->25|46->25
                    -- GENERATED --
                */
            