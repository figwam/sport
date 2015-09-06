
package views.html.consent.verifyaddress

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
object summary extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,String,String,String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(firstName : String, backend : String, responseType : String, app : String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages


Seq[Any](format.raw/*1.142*/("""

"""),format.raw/*5.1*/("""
"""),_display_(Seq[Any](/*6.2*/main("Welcome Consent: Verify address")/*6.41*/ {_display_(Seq[Any](format.raw/*6.43*/("""	

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*11.17*/routes/*11.23*/.Assets.at("images/logo-roberto.png"))),format.raw/*11.60*/(""""/>
        <a href=""""),_display_(Seq[Any](/*12.19*/routes/*12.25*/.ConsentVerifyAddress.index(backend,responseType,app))),format.raw/*12.78*/("""" class="btn btn-warning btn-sm pull-right">Logout</a>
        <span class="pull-right">Welcome """),_display_(Seq[Any](/*13.43*/firstName)),format.raw/*13.52*/("""!&nbsp;&nbsp;&nbsp;</span>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Congratulations you successfully registered to roberto.ch online shop!</h2>
  	<p>
  	Now you can start selling products, have fun...
    </p>
   	<img src=""""),_display_(Seq[Any](/*22.16*/routes/*22.22*/.Assets.at("images/ricardo.png"))),format.raw/*22.54*/("""" height="100%"/>
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})))}
    }
    
    def render(firstName:String,backend:String,responseType:String,app:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(firstName,backend,responseType,app)(request)
    
    def f:((String,String,String,String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (firstName,backend,responseType,app) => (request) => apply(firstName,backend,responseType,app)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/verifyaddress/summary.scala.html
                    HASH: 2a57271b4c3490a45cea0cab89a7934e9ac182c0
                    MATRIX: 647->1|925->141|953->187|989->189|1036->228|1075->230|1209->328|1224->334|1283->371|1341->393|1356->399|1431->452|1564->549|1595->558|1914->841|1929->847|1983->879
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|33->11|33->11|33->11|34->12|34->12|34->12|35->13|35->13|44->22|44->22|44->22
                    -- GENERATED --
                */
            