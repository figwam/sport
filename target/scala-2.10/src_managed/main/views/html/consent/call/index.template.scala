
package views.html.consent.call

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,String,String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend : String, redirectUri : String, clientId : String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.150*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Voip Click to Call Flow: Start")/*7.40*/ {_display_(Seq[Any](format.raw/*7.42*/("""

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*12.17*/routes/*12.23*/.Assets.at("images/rousseau.png"))),format.raw/*12.56*/(""""/>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Welcome to Voip Click to Call Flow</h2>


    <p>
    <a href=""""),_display_(Seq[Any](/*21.15*/{Play.current.configuration.getString(backend + ".call_endpoint")})),format.raw/*21.81*/("""?response_type=token&redirect_uri="""),_display_(Seq[Any](/*21.116*/helper/*21.122*/.urlEncode(redirectUri))),format.raw/*21.145*/("""&client_id="""),_display_(Seq[Any](/*21.157*/helper/*21.163*/.urlEncode(clientId))),format.raw/*21.183*/("""&lang=en"><img class="swisscom-login-button" src="/assets/images/login_swisscom_l.png"/></a>
    </p>
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*26.2*/("""
"""))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,error)(request)
    
    def f:((String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,error) => (request) => apply(backend,redirectUri,clientId,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/call/index.scala.html
                    HASH: b2c893119d5a1aa8afe2b7497aa2752331aad85e
                    MATRIX: 644->1|955->149|985->222|1022->225|1068->263|1107->265|1245->367|1260->373|1315->406|1526->581|1614->647|1686->682|1702->688|1748->711|1797->723|1813->729|1856->749|2048->910
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|35->12|35->12|35->12|44->21|44->21|44->21|44->21|44->21|44->21|44->21|44->21|49->26
                    -- GENERATED --
                */
            