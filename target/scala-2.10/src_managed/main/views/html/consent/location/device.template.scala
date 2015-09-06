
package views.html.consent.location

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
object device extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend: String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play

import org.joda.time.{DateTime, Period}


Seq[Any](format.raw/*1.108*/("""

"""),format.raw/*7.1*/("""
"""),_display_(Seq[Any](/*8.2*/main("Location: Request Device")/*8.34*/ {_display_(Seq[Any](format.raw/*8.36*/("""
<script type="text/javascript" src=""""),_display_(Seq[Any](/*9.38*/routes/*9.44*/.Application.javascriptRoutes)),format.raw/*9.73*/(""""></script>

<script type="text/javascript">

function addJson(element, data) """),format.raw/*13.33*/("""{"""),format.raw/*13.34*/("""
  $(element).html("<pre>" + data + "</pre>");
"""),format.raw/*15.1*/("""}"""),format.raw/*15.2*/("""

function getDeviceLocation(data) """),format.raw/*17.34*/("""{"""),format.raw/*17.35*/("""
    addJson("#response-loc-msisdn", "Loading...")
	get('loc-msisdn', jsRoutes.controllers.Location.getDeviceLocation('"""),_display_(Seq[Any](/*19.70*/backend)),format.raw/*19.77*/("""').url, data);
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""

function get(what, url, data) """),format.raw/*22.31*/("""{"""),format.raw/*22.32*/("""
	$.getJSON(url,data,
	    function(data) """),format.raw/*24.21*/("""{"""),format.raw/*24.22*/("""
	      addJson("#response-" + what, data.response);
	    """),format.raw/*26.6*/("""}"""),format.raw/*26.7*/("""
  );
"""),format.raw/*28.1*/("""}"""),format.raw/*28.2*/("""

</script>

<div class="panel">
    <div class="panel-heading">
        <h3 class="panel-title">
    	    <img src=""""),_display_(Seq[Any](/*35.21*/routes/*35.27*/.Assets.at("images/location_icon.png"))),format.raw/*35.65*/(""""/>
        </h3>
        <div class="btn-group pull-right"></div>
    </div>
    <div class="panel-body">
  	    <h2>Device Locator</h2>
        <h3>Once available, use production demo for arbitrary imsi/tel values</h3>

        """),_display_(Seq[Any](/*43.10*/if(error.isDefined)/*43.29*/ {_display_(Seq[Any](format.raw/*43.31*/("""
            <div class="alert alert-dismissable alert-danger">
                <button type="button" class="close" data-dismiss="alert">x</button>
                Error: """),_display_(Seq[Any](/*46.25*/error/*46.30*/.get)),format.raw/*46.34*/("""
            </div>
        """)))})),format.raw/*48.10*/("""

        <h4>Get Device Location</h4>
        <form>
	        <div class="form-group">
		        <label for="device-msisdn" class="col-sm-2 control-label">Device identifier:</label>
		        <div class="col-sm-10">
                    <select name="device-msisdn" style="margin-bottom: 10px">
                        <option value="imsi-228014935000040" selected>imsi 228014935000040</option>
                        <option value="tel-+41794938523">tel +41794938523</option>
                        <option value="tel-+41794935040">tel +41794935040</option>
                        <option value="tel-+41794937062">tel +41794937062</option>
                    </select>
		        </div>
	      	</div>
	      	<input type="button" class="btn btn-default" value="Get Location" OnClick="javascript:getDeviceLocation($(this.form).serialize())"/>
	    </form>
	    <div id="response-loc-msisdn" style="margin-top: 15px"></div>
    </div>
</div>
""")))})))}
    }
    
    def render(backend:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,error)(request)
    
    def f:((String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,error) => (request) => apply(backend,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/location/device.scala.html
                    HASH: 53a773cdd7fd168a637936566a7c134d6fb80916
                    MATRIX: 635->1|946->107|976->222|1013->225|1053->257|1092->259|1166->298|1180->304|1230->333|1340->415|1369->416|1445->465|1473->466|1538->503|1567->504|1725->626|1754->633|1797->649|1825->650|1887->684|1916->685|1988->729|2017->730|2104->790|2132->791|2167->799|2195->800|2356->925|2371->931|2431->969|2706->1208|2734->1227|2774->1229|2985->1404|2999->1409|3025->1413|3088->1444
                    LINES: 19->1|29->1|31->7|32->8|32->8|32->8|33->9|33->9|33->9|37->13|37->13|39->15|39->15|41->17|41->17|43->19|43->19|44->20|44->20|46->22|46->22|48->24|48->24|50->26|50->26|52->28|52->28|59->35|59->35|59->35|67->43|67->43|67->43|70->46|70->46|70->46|72->48
                    -- GENERATED --
                */
            