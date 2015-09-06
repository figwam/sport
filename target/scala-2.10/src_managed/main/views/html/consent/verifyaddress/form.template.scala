
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
object form extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[Option[String],Form[VAUser],Option[String],String,String,String,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(warning : Option[String], userForm: Form[VAUser], infoMessage : Option[String], backend : String, responseType : String, app : String)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play

def /*8.2*/getDisabled/*8.13*/(field : Field):play.api.templates.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.32*/("""
	"""),_display_(Seq[Any](/*9.3*/if(field.value.isDefined && !field.value.get.isEmpty)/*9.56*/ {_display_(Seq[Any](format.raw/*9.58*/("""
		readonly
	""")))}/*11.4*/else/*11.9*/{_display_(Seq[Any](format.raw/*11.10*/("""
	  notreadonly
	""")))})),format.raw/*13.3*/("""
""")))};implicit def /*2.2*/implicitField/*2.15*/ = {{ FieldConstructor(fieldConstructorTemplate.f) }};
Seq[Any](format.raw/*1.202*/("""
"""),format.raw/*2.67*/("""

"""),format.raw/*7.1*/("""
"""),format.raw/*14.2*/("""

"""),_display_(Seq[Any](/*16.2*/main("Welcome Consent: Verify address")/*16.41*/ {_display_(Seq[Any](format.raw/*16.43*/("""	

"""),_display_(Seq[Any](/*18.2*/if("token".equals(responseType))/*18.34*/ {_display_(Seq[Any](format.raw/*18.36*/("""
		
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*20.39*/routes/*20.45*/.Assets.at("javascripts/jquery-2.1.0.min.js"))),format.raw/*20.90*/(""""></script>
  <script type="text/javascript" src=""""),_display_(Seq[Any](/*21.40*/routes/*21.46*/.Assets.at("javascripts/json2.js"))),format.raw/*21.80*/(""""></script>
  <script type="text/javascript" src=""""),_display_(Seq[Any](/*22.40*/routes/*22.46*/.Assets.at("javascripts/localstorage.js"))),format.raw/*22.87*/(""""></script>
  <script type="text/javascript" src=""""),_display_(Seq[Any](/*23.40*/routes/*23.46*/.Assets.at("javascripts/jso.js"))),format.raw/*23.78*/(""""></script>
	<script type="text/javascript" src=""""),_display_(Seq[Any](/*24.39*/routes/*24.45*/.ConsentVerifyAddress.getOauthProviders(backend, app))),format.raw/*24.98*/(""""></script>
	
	<script type="text/javascript">

    $.oajax("""),format.raw/*28.13*/("""{"""),format.raw/*28.14*/("""
        url: """"),_display_(Seq[Any](/*29.16*/{Play.current.configuration.getString(backend + ".address_endpoint")})),format.raw/*29.85*/("""?client_id="""),_display_(Seq[Any](/*29.97*/{Play.current.configuration.getString(backend + "." + app + ".client_id")})),format.raw/*29.171*/("""",
        jso_provider: "swisscom",
        jso_allowia: true,
        dataType: 'json',
        success: function(data) """),format.raw/*33.33*/("""{"""),format.raw/*33.34*/("""
          console.log("Response (Swisscom):");
          console.log(data);
          
          var address = data.address;
          //$("#firstname").val("test");
          //$("#name").val(address.);
          if (address.streetAddress) """),format.raw/*40.38*/("""{"""),format.raw/*40.39*/("""
            $("#street").val(address.streetAddress);
            $("#street").prop('readonly', 'true');
          """),format.raw/*43.11*/("""}"""),format.raw/*43.12*/("""
          if (address.streetAddress) """),format.raw/*44.38*/("""{"""),format.raw/*44.39*/("""
            $("#street").val(address.streetAddress);
            $("#street").prop('readonly', 'true');
          """),format.raw/*47.11*/("""}"""),format.raw/*47.12*/("""
          if (address.houseNumber) """),format.raw/*48.36*/("""{"""),format.raw/*48.37*/("""
            $("#housenr").val(address.houseNumber);
            $("#housenr").prop('readonly', 'true');
          """),format.raw/*51.11*/("""}"""),format.raw/*51.12*/("""
          if (address.postalCode) """),format.raw/*52.35*/("""{"""),format.raw/*52.36*/("""
            $("#zip").val(address.postalCode);
            $("#zip").prop('readonly', 'true');
          """),format.raw/*55.11*/("""}"""),format.raw/*55.12*/("""
          if (address.city) """),format.raw/*56.29*/("""{"""),format.raw/*56.30*/("""
            $("#city").val(address.city);
            $("#city").prop('readonly', 'true');
          """),format.raw/*59.11*/("""}"""),format.raw/*59.12*/("""
          if (address.country) """),format.raw/*60.32*/("""{"""),format.raw/*60.33*/("""
            $("#country").val(address.country);
            $("#country").prop('readonly', 'true');
          """),format.raw/*63.11*/("""}"""),format.raw/*63.12*/("""
          
          return false; 
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""",
        error: function(jqXHR, textStatus, errorThrown) """),format.raw/*67.57*/("""{"""),format.raw/*67.58*/("""
          console.log("Error:");
          console.log(textStatus);
          console.log(errorThrown);
        """),format.raw/*71.9*/("""}"""),format.raw/*71.10*/("""
      """),format.raw/*72.7*/("""}"""),format.raw/*72.8*/(""");
 	</script>
""")))})),format.raw/*74.2*/("""
      
<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*79.17*/routes/*79.23*/.Assets.at("images/logo-roberto.png"))),format.raw/*79.60*/(""""/>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Become a member now!</h2>
  	<p>
  	Create a free account on roberto.ch
    </p>
    """),_display_(Seq[Any](/*88.6*/helper/*88.12*/.form(action = routes.ConsentVerifyAddress.submit, 'class->"form-horizontal", 'name->"userdata")/*88.108*/ {_display_(Seq[Any](format.raw/*88.110*/("""
      <input type="hidden" name="backend" value='"""),_display_(Seq[Any](/*89.51*/backend)),format.raw/*89.58*/("""' >
      <input type="hidden" name="responseType" value='"""),_display_(Seq[Any](/*90.56*/responseType)),format.raw/*90.68*/("""' >
      <input type="hidden" name="app" value='"""),_display_(Seq[Any](/*91.47*/app)),format.raw/*91.50*/("""' >
    	
   		"""),_display_(Seq[Any](/*93.7*/if(userForm.hasErrors)/*93.29*/ {_display_(Seq[Any](format.raw/*93.31*/("""
	    	<div class="alert alert-dismissable alert-danger">
	  			<button type="button" class="close" data-dismiss="alert">x</button>
			  	<strong>Oh snap!</strong> Please fix all errors below and try again.
	  		</div>
    	""")))})),format.raw/*98.7*/("""
   		"""),_display_(Seq[Any](/*99.7*/if(warning.isDefined)/*99.28*/ {_display_(Seq[Any](format.raw/*99.30*/("""
	    	<div class="alert alert-dismissable alert-danger">
	  			<button type="button" class="close" data-dismiss="alert">x</button>
			  	<strong>Error calling API:</strong> """),_display_(Seq[Any](/*102.44*/warning/*102.51*/.get)),format.raw/*102.55*/("""
		  	</div>
    	""")))})),format.raw/*104.7*/(""" 
      """),_display_(Seq[Any](/*105.8*/if(!warning.isDefined && infoMessage.isDefined)/*105.55*/ {_display_(Seq[Any](format.raw/*105.57*/("""
	    	<div class="alert alert-dismissable alert-info">
	  			<button type="button" class="close" data-dismiss="alert">x</button>
			  	"""),_display_(Seq[Any](/*108.8*/infoMessage/*108.19*/.get)),format.raw/*108.23*/("""
			  </div>
    	""")))})),format.raw/*110.7*/("""

	  <fieldset>
	    <legend></legend>

    	"""),_display_(Seq[Any](/*115.7*/inputText(
	    		    userForm("firstname"),
	            '_label -> "First name",
	            'class -> "form-control",
	            Symbol(getDisabled(userForm("firstname")).toString) -> "true",
	            'placeholder -> userForm("firstname").value.getOrElse(""),
	            '_error -> userForm.error("firstname")
	        ))),format.raw/*122.11*/("""
	    
    	"""),_display_(Seq[Any](/*124.7*/inputText(
            userForm("name"), 
            '_label -> "Last name",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("name")).toString) -> "true",
            'placeholder -> userForm("name").value.getOrElse(""),
            '_error -> userForm.error("name")
        ))),format.raw/*131.10*/("""
        
    	"""),_display_(Seq[Any](/*133.7*/inputText(
            userForm("street"), 
            '_label -> "Street",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("street")).toString) -> "true",
            'placeholder -> userForm("street").value.getOrElse(""),
            '_error -> userForm.error("street")
        ))),format.raw/*140.10*/("""
    	"""),_display_(Seq[Any](/*141.7*/inputText(
            userForm("housenr"), 
            '_label -> "House Nr",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("housenr")).toString) -> "true",
            'placeholder -> userForm("housenr").value.getOrElse(""),
            '_error -> userForm.error("housenr")
        ))),format.raw/*148.10*/("""
        """),_display_(Seq[Any](/*149.10*/inputText(
            userForm("zip"), 
            '_label -> "Zip",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("zip")).toString) -> "true",
            'placeholder -> userForm("zip").value.getOrElse(""),
            '_error -> userForm.error("zip")
        ))),format.raw/*156.10*/("""
    	"""),_display_(Seq[Any](/*157.7*/inputText(
            userForm("city"), 
            '_label -> "City",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("city")).toString) -> "true",
            'placeholder -> userForm("city").value.getOrElse(""),
            '_error -> userForm.error("city")
        ))),format.raw/*164.10*/("""
        """),_display_(Seq[Any](/*165.10*/inputText(
            userForm("country"), 
            '_label -> "Country",
            'class -> "form-control",
	        Symbol(getDisabled(userForm("country")).toString) -> "true",
            'placeholder -> userForm("country").value.getOrElse(""),
            '_error -> userForm.error("country")
        ))),format.raw/*172.10*/("""
        
    	"""),_display_(Seq[Any](/*174.7*/inputText(
            userForm("msisdn"), 
            '_label -> "Phone number",
            'class -> "form-control"
        ))),format.raw/*178.10*/("""
	    <div class="form-group">
	      <div class="col-lg-10 col-lg-offset-2">
	      	<a href=""""),_display_(Seq[Any](/*181.19*/routes/*181.25*/.ConsentVerifyAddress.index(backend,responseType,app))),format.raw/*181.78*/("""" class="btn btn-default">Cancel</a>
	        <button type="submit" class="btn btn-primary pull-right">Complete registration</button>
	      </div>
	    </div>
	  </fieldset>
	""")))})),format.raw/*186.3*/("""
  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})))}
    }
    
    def render(warning:Option[String],userForm:Form[VAUser],infoMessage:Option[String],backend:String,responseType:String,app:String,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(warning,userForm,infoMessage,backend,responseType,app)(request)
    
    def f:((Option[String],Form[VAUser],Option[String],String,String,String) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (warning,userForm,infoMessage,backend,responseType,app) => (request) => apply(warning,userForm,infoMessage,backend,responseType,app)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/verifyaddress/form.scala.html
                    HASH: d2ae56ac1db542846e96871a3b46868c2781fad0
                    MATRIX: 680->1|1025->345|1044->356|1143->375|1181->379|1242->432|1281->434|1315->451|1327->456|1366->457|1417->477|1451->204|1472->217|1555->201|1584->269|1614->342|1643->480|1683->485|1731->524|1771->526|1812->532|1853->564|1893->566|1973->610|1988->616|2055->661|2143->713|2158->719|2214->753|2302->805|2317->811|2380->852|2468->904|2483->910|2537->942|2624->993|2639->999|2714->1052|2806->1116|2835->1117|2888->1134|2979->1203|3027->1215|3124->1289|3278->1415|3307->1416|3584->1665|3613->1666|3759->1784|3788->1785|3855->1824|3884->1825|4030->1943|4059->1944|4124->1981|4153->1982|4299->2100|4328->2101|4392->2137|4421->2138|4558->2247|4587->2248|4645->2278|4674->2279|4807->2384|4836->2385|4897->2418|4926->2419|5068->2533|5097->2534|5172->2582|5201->2583|5288->2642|5317->2643|5461->2760|5490->2761|5525->2769|5553->2770|5602->2788|5746->2896|5761->2902|5820->2939|6052->3136|6067->3142|6173->3238|6214->3240|6302->3292|6331->3299|6427->3359|6461->3371|6548->3422|6573->3425|6626->3443|6657->3465|6697->3467|6958->3697|7001->3705|7031->3726|7071->3728|7286->3906|7303->3913|7330->3917|7383->3938|7429->3948|7486->3995|7527->3997|7703->4137|7724->4148|7751->4152|7804->4173|7891->4224|8253->4563|8304->4578|8638->4889|8692->4907|9031->5223|9075->5231|9420->5553|9468->5564|9792->5865|9836->5873|10165->6179|10213->6190|10557->6511|10611->6529|10767->6662|10903->6761|10919->6767|10995->6820|11209->7002
                    LINES: 19->1|26->8|26->8|28->8|29->9|29->9|29->9|31->11|31->11|31->11|33->13|34->2|34->2|35->1|36->2|38->7|39->14|41->16|41->16|41->16|43->18|43->18|43->18|45->20|45->20|45->20|46->21|46->21|46->21|47->22|47->22|47->22|48->23|48->23|48->23|49->24|49->24|49->24|53->28|53->28|54->29|54->29|54->29|54->29|58->33|58->33|65->40|65->40|68->43|68->43|69->44|69->44|72->47|72->47|73->48|73->48|76->51|76->51|77->52|77->52|80->55|80->55|81->56|81->56|84->59|84->59|85->60|85->60|88->63|88->63|91->66|91->66|92->67|92->67|96->71|96->71|97->72|97->72|99->74|104->79|104->79|104->79|113->88|113->88|113->88|113->88|114->89|114->89|115->90|115->90|116->91|116->91|118->93|118->93|118->93|123->98|124->99|124->99|124->99|127->102|127->102|127->102|129->104|130->105|130->105|130->105|133->108|133->108|133->108|135->110|140->115|147->122|149->124|156->131|158->133|165->140|166->141|173->148|174->149|181->156|182->157|189->164|190->165|197->172|199->174|203->178|206->181|206->181|206->181|211->186
                    -- GENERATED --
                */
            