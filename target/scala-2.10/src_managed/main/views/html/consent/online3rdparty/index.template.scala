
package views.html.consent.online3rdparty

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
"""),_display_(Seq[Any](/*7.2*/main("Online Third Party: Start")/*7.35*/ {_display_(Seq[Any](format.raw/*7.37*/("""

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*12.17*/routes/*12.23*/.Assets.at("images/3rdparty_logo.png"))),format.raw/*12.61*/(""""/>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Welcome to the Third Party online shop</h2>

    <h4>
      Your shopping cart:
    </h4>

    """),_display_(Seq[Any](/*23.6*/if(error.isDefined)/*23.25*/ {_display_(Seq[Any](format.raw/*23.27*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error: """),_display_(Seq[Any](/*26.19*/error/*26.24*/.get)),format.raw/*26.28*/("""
        </div>
    """)))})),format.raw/*28.6*/("""
    
    <p>
    Selected phone: 
    </p>
    <p>
    <img src=""""),_display_(Seq[Any](/*34.16*/routes/*34.22*/.Assets.at("images/nokia_5110.png"))),format.raw/*34.57*/(""""/>
    </p>
    <p>
    Renew your contract with Swisscom:
    </p>
    <p>
    <a href=""""),_display_(Seq[Any](/*40.15*/{Play.current.configuration.getString(backend + ".consent_endpoint")})),format.raw/*40.84*/("""?response_type=code&redirect_uri="""),_display_(Seq[Any](/*40.118*/helper/*40.124*/.urlEncode(redirectUri))),format.raw/*40.147*/("""&client_id="""),_display_(Seq[Any](/*40.159*/helper/*40.165*/.urlEncode(clientId))),format.raw/*40.185*/("""&lang=en"><img class="swisscom-login-button" src="/assets/images/login_swisscom_l.png"/></a>
    </p>
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*45.2*/("""
"""))}
    }
    
    def render(backend:String,redirectUri:String,clientId:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,redirectUri,clientId,error)(request)
    
    def f:((String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,redirectUri,clientId,error) => (request) => apply(backend,redirectUri,clientId,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/online3rdparty/index.scala.html
                    HASH: a9de37363841929926e705665b470495de80f1e4
                    MATRIX: 654->1|965->149|995->222|1032->225|1073->258|1112->260|1250->362|1265->368|1325->406|1569->615|1597->634|1637->636|1832->795|1846->800|1872->804|1926->827|2035->900|2050->906|2107->941|2240->1038|2331->1107|2402->1141|2418->1147|2464->1170|2513->1182|2529->1188|2572->1208|2764->1369
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|35->12|35->12|35->12|46->23|46->23|46->23|49->26|49->26|49->26|51->28|57->34|57->34|57->34|63->40|63->40|63->40|63->40|63->40|63->40|63->40|63->40|68->45
                    -- GENERATED --
                */
            