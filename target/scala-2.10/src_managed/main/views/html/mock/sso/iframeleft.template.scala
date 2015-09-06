
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
object iframeleft extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html
  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"><meta charset="UTF-8"><base target="_top"><style type="text/css">
		@font-face 
		"""),format.raw/*5.3*/("""{"""),format.raw/*5.4*/("""
		    font-family: 'TheSaB3';
		    src: url('TheSaB3_.eot'); /* keep two src attribute even if there is a warning (IE needs it) */
		    src: url('TheSaB3_.eot?#iefix') format('embedded-opentype'),
		         url('TheSaB3_.woff') format('woff'),
		         url('TheSaB3_.ttf') format('truetype'),
		         url('TheSaB3_.svg?#TheSaB3_') format('svg');
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/("""
		@font-face 
		"""),format.raw/*14.3*/("""{"""),format.raw/*14.4*/("""
		    font-family: 'TheSaB5';
		    src: url('TheSaB5_.eot'); /* keep two src attribute even if there is a warning (IE needs it) */
		    src: url('TheSaB5_.eot?#iefix') format('embedded-opentype'),
		         url('TheSaB5_.woff') format('woff'),
		         url('TheSaB5_.ttf') format('truetype'),
		         url('TheSaB5_.svg?#TheSaB5_') format('svg');
		"""),format.raw/*21.3*/("""}"""),format.raw/*21.4*/("""
		body """),format.raw/*22.8*/("""{"""),format.raw/*22.9*/("""
			margin: 0;
			background:transparent;
			
				font-family: 'TheSaB3','Trebuchet MS',Arial,Helvetica,sans-serif;
				color: #015;
				font-size: 24px;
				padding: 66px 0px;
			
		"""),format.raw/*31.3*/("""}"""),format.raw/*31.4*/("""
		#intro """),format.raw/*32.10*/("""{"""),format.raw/*32.11*/("""
			
				margin-top: 12px;
			
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/("""
		a """),format.raw/*37.5*/("""{"""),format.raw/*37.6*/("""
		    display: list-item;
    		list-style-image: url("https://www1.swisscom.ch/registration/online/images/r/nav/arrow-right-blue.png");
   			margin-left: 15px;
   			font-family: 'TheSaB5','Trebuchet MS',Arial,Helvetica,sans-serif;
   			cursor: pointer;
		    font-style: normal;
		    font-variant: normal;
		    text-decoration: none;
		    text-transform: none;
   			color: #2D90EC;
		    
		    	font-size: 13px;
		    
		"""),format.raw/*51.3*/("""}"""),format.raw/*51.4*/("""
		#image """),format.raw/*52.10*/("""{"""),format.raw/*52.11*/("""
			margin-left: 4px;
		"""),format.raw/*54.3*/("""}"""),format.raw/*54.4*/("""
	</style></head><body><img id="image" src="https://www1.swisscom.ch/registration/online/images/login/devices.png"><p id="intro">Please sign In to your Swisscom account to proceed.</p><a class="sam-linklist-single" href="javascript:alert('coming soon');">
		Learn more.
	</a></body></html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mock/sso/iframeleft.scala.html
                    HASH: c4cf6fa94d7f62fa21111b5fc14df02ebd180c8e
                    MATRIX: 651->0|943->267|970->268|1354->625|1382->626|1426->644|1454->645|1838->1002|1866->1003|1901->1011|1929->1012|2139->1195|2167->1196|2205->1206|2234->1207|2294->1240|2322->1241|2354->1246|2382->1247|2840->1678|2868->1679|2906->1689|2935->1690|2986->1714|3014->1715
                    LINES: 22->1|26->5|26->5|33->12|33->12|35->14|35->14|42->21|42->21|43->22|43->22|52->31|52->31|53->32|53->32|57->36|57->36|58->37|58->37|72->51|72->51|73->52|73->52|75->54|75->54
                    -- GENERATED --
                */
            