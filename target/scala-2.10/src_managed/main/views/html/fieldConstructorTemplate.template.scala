
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
object fieldConstructorTemplate extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[views.html.helper.FieldElements,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(elements: views.html.helper.FieldElements):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import play.api.i18n._

import views.html.helper._


Seq[Any](format.raw/*1.45*/("""

"""),format.raw/*5.1*/("""
<div class=""""),_display_(Seq[Any](/*6.14*/if(elements.hasErrors)/*6.36*/ {_display_(Seq[Any](format.raw/*6.38*/("""form-group has-error""")))}/*6.60*/else/*6.65*/{_display_(Seq[Any](format.raw/*6.66*/("""form-group""")))})),format.raw/*6.77*/("""">
   <label for=""""),_display_(Seq[Any](/*7.17*/elements/*7.25*/.id)),format.raw/*7.28*/("""" class="col-lg-2 control-label">"""),_display_(Seq[Any](/*7.62*/elements/*7.70*/.label)),format.raw/*7.76*/("""</label>
   <div class="col-lg-10">
     """),_display_(Seq[Any](/*9.7*/elements/*9.15*/.input)),format.raw/*9.21*/("""
     <p class="text-danger">"""),_display_(Seq[Any](/*10.30*/elements/*10.38*/.errors(elements.lang).mkString(", "))),format.raw/*10.75*/("""</p>
     <!-- <p class="text-info">"""),_display_(Seq[Any](/*11.33*/elements/*11.41*/.infos(elements.lang).mkString(", "))),format.raw/*11.77*/("""</p> -->
   </div>
</div>"""))}
    }
    
    def render(elements:views.html.helper.FieldElements): play.api.templates.HtmlFormat.Appendable = apply(elements)
    
    def f:((views.html.helper.FieldElements) => play.api.templates.HtmlFormat.Appendable) = (elements) => apply(elements)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:50 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/fieldConstructorTemplate.scala.html
                    HASH: a6d23aecd8929227e16a80947d9ed4caf74f52a0
                    MATRIX: 600->1|790->44|820->102|870->117|900->139|939->141|978->163|990->168|1028->169|1070->180|1125->200|1141->208|1165->211|1234->245|1250->253|1277->259|1355->303|1371->311|1398->317|1465->348|1482->356|1541->393|1615->431|1632->439|1690->475
                    LINES: 19->1|25->1|27->5|28->6|28->6|28->6|28->6|28->6|28->6|28->6|29->7|29->7|29->7|29->7|29->7|29->7|31->9|31->9|31->9|32->10|32->10|32->10|33->11|33->11|33->11
                    -- GENERATED --
                */
            