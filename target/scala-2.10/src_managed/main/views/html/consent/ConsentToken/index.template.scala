
package views.html.consent.ConsentToken

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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Form[TokenInfo],String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String, tokenInfoForm: Form[TokenInfo], transactionId: String, error: Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.162*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main("Consent Token flow: End")/*7.33*/ {_display_(Seq[Any](format.raw/*7.35*/("""


    <div class="panel">
        <div class="panel-heading">
            <h3 class="panel-title">
                <img src=""""),_display_(Seq[Any](/*13.28*/routes/*13.34*/.Assets.at("images/api.png"))),format.raw/*13.62*/("""" width="100" height="100"/>
            </h3>
            <div class="btn-group pull-right"></div>
        </div>
        <div class="panel-body">
            <h2>Token Demo</h2>
            <p>
                This demo shows an oauth token creation with authorization code grant type.
            </p>
            """),_display_(Seq[Any](/*22.14*/if(transactionId != null)/*22.39*/ {_display_(Seq[Any](format.raw/*22.41*/("""
                <div class="success alert alert-dismissable alert-success">
                    <button type="button" class="close" data-dismiss="alert">x</button>
                    """),_display_(Seq[Any](/*25.22*/Html(transactionId))),format.raw/*25.41*/("""
                </div>
            """)))})),format.raw/*27.14*/("""

            """),_display_(Seq[Any](/*29.14*/if(error.isDefined)/*29.33*/ {_display_(Seq[Any](format.raw/*29.35*/("""
                <div class="alert alert-dismissable alert-danger">
                    <button type="button" class="close" data-dismiss="alert">x</button>
                    Error: """),_display_(Seq[Any](/*32.29*/error/*32.34*/.get)),format.raw/*32.38*/("""
                </div>
            """)))})),format.raw/*34.14*/("""

            <p>
            """),_display_(Seq[Any](/*37.14*/helper/*37.20*/.form(action = routes.ConsentToken.consentRedirect(backend), 'class -> "form-horizontal col-xs-12 col-md-6")/*37.128*/ {_display_(Seq[Any](format.raw/*37.130*/("""
                <div class="form-group">
                """),_display_(Seq[Any](/*39.18*/helper/*39.24*/.inputText(tokenInfoForm("ClientId"), 'class -> "form-control", 'placeholder -> "Enter client ID"))),format.raw/*39.122*/("""
                </div>
                <div class="form-group">
                """),_display_(Seq[Any](/*42.18*/helper/*42.24*/.inputText(tokenInfoForm("ClientSecret"), 'class -> "form-control", 'placeholder -> "Enter client secret"))),format.raw/*42.130*/("""
                </div>
                <div class="form-group">
                """),_display_(Seq[Any](/*45.18*/helper/*45.24*/.inputText(tokenInfoForm("Scope"), 'class -> "form-control", 'placeholder -> "Enter scope (optional)"))),format.raw/*45.126*/("""
                </div>
                
                <!--
                <div class="form-group">
                """),_display_(Seq[Any](/*50.18*/helper/*50.24*/.inputRadioGroup(tokenInfoForm("Flow"),
                    options = options("true" -> "Code", "false" -> "Token")))),format.raw/*51.77*/("""
                </div>
                -->
                
                <div class="form-group">
                    <button type="submit" class="btn btn-primary">Get</button>
                </div>
            """)))})),format.raw/*58.14*/("""
            </p>

        </div><!-- panel-heading -->
    </div> <!-- panel -->

""")))})),format.raw/*64.2*/("""
"""))}
    }
    
    def render(backend:String,tokenInfoForm:Form[TokenInfo],transactionId:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,tokenInfoForm,transactionId,error)(request)
    
    def f:((String,Form[TokenInfo],String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,tokenInfoForm,transactionId,error) => (request) => apply(backend,tokenInfoForm,transactionId,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/ConsentToken/index.scala.html
                    HASH: 20bfe58cd568dd2534f4a161bffef1daa68a96b0
                    MATRIX: 661->1|984->161|1014->234|1051->237|1090->268|1129->270|1298->403|1313->409|1363->437|1726->764|1760->789|1800->791|2025->980|2066->999|2137->1038|2190->1055|2218->1074|2258->1076|2481->1263|2495->1268|2521->1272|2592->1311|2662->1345|2677->1351|2795->1459|2836->1461|2933->1522|2948->1528|3069->1626|3190->1711|3205->1717|3334->1823|3455->1908|3470->1914|3595->2016|3756->2141|3771->2147|3910->2264|4166->2488|4287->2578
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|36->13|36->13|36->13|45->22|45->22|45->22|48->25|48->25|50->27|52->29|52->29|52->29|55->32|55->32|55->32|57->34|60->37|60->37|60->37|60->37|62->39|62->39|62->39|65->42|65->42|65->42|68->45|68->45|68->45|73->50|73->50|74->51|81->58|87->64
                    -- GENERATED --
                */
            