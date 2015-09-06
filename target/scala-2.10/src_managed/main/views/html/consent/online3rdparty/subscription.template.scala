
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
object subscription extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template6[String,String,String,String,Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(backend : String, subscriptionKey : String, msisdn : String, productName : String, error : Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play

import org.joda.time.{DateTime, Period}


Seq[Any](format.raw/*1.174*/("""

"""),format.raw/*7.1*/("""
"""),_display_(Seq[Any](/*8.2*/main("Online Third Party: Contract Selected")/*8.47*/ {_display_(Seq[Any](format.raw/*8.49*/("""

<script type="text/javascript" src=""""),_display_(Seq[Any](/*10.38*/routes/*10.44*/.Application.javascriptRoutes)),format.raw/*10.73*/(""""></script>

<script type="text/javascript">

function addJson(element, data) """),format.raw/*14.33*/("""{"""),format.raw/*14.34*/("""
  $(element).html("<pre>" + data + "</pre>");
"""),format.raw/*16.1*/("""}"""),format.raw/*16.2*/("""

function getCustomerInfo(what) """),format.raw/*18.32*/("""{"""),format.raw/*18.33*/("""
  get(what, jsRoutes.controllers.Online3rdParty[what]('"""),_display_(Seq[Any](/*19.57*/backend)),format.raw/*19.64*/("""').url, null);
"""),format.raw/*20.1*/("""}"""),format.raw/*20.2*/("""

function getContractInfo(what, data) """),format.raw/*22.38*/("""{"""),format.raw/*22.39*/("""
  get(what, jsRoutes.controllers.Online3rdParty[what]('"""),_display_(Seq[Any](/*23.57*/subscriptionKey)),format.raw/*23.72*/("""','"""),_display_(Seq[Any](/*23.76*/backend)),format.raw/*23.83*/("""').url, data);
"""),format.raw/*24.1*/("""}"""),format.raw/*24.2*/("""

function get(what, url, data) """),format.raw/*26.31*/("""{"""),format.raw/*26.32*/("""
	$.getJSON(url,data,
	    function(data) """),format.raw/*28.21*/("""{"""),format.raw/*28.22*/("""
	      addJson("#response-" + what, data.response);
	    """),format.raw/*30.6*/("""}"""),format.raw/*30.7*/("""
  );
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/("""

</script>

<div class="panel">
  <div class="panel-heading">
    <h3 class="panel-title">
    	<img src=""""),_display_(Seq[Any](/*39.17*/routes/*39.23*/.Assets.at("images/3rdparty_logo.png"))),format.raw/*39.61*/(""""/>
    </h3>
    <div class="btn-group pull-right"></div>
  </div>
  <div class="panel-body">
  	<h2>Third Party Online Shop</h2>

    """),_display_(Seq[Any](/*46.6*/if(error.isDefined)/*46.25*/ {_display_(Seq[Any](format.raw/*46.27*/("""
        <div class="alert alert-dismissable alert-danger">
          <button type="button" class="close" data-dismiss="alert">x</button>
          Error: """),_display_(Seq[Any](/*49.19*/error/*49.24*/.get)),format.raw/*49.28*/("""
        </div>
    """)))})),format.raw/*51.6*/("""

    <p>
    Selected phone: 
    </p>
    <p>
    <img src=""""),_display_(Seq[Any](/*57.16*/routes/*57.22*/.Assets.at("images/nokia_5110.png"))),format.raw/*57.57*/(""""/>
    </p>
		<p>
		  The following contract will be renewed:
		</p>
    <table class="table-bordered table-condensed">
      <tr>
        <th class="col-md-2"><b>Msisdn</b></th>
        <td>"""),_display_(Seq[Any](/*65.14*/msisdn)),format.raw/*65.20*/("""</td>
		  </tr>
		  <tr>
		    <th class="col-md-2"><b>subscriptionKey</b></th>
		    <td>"""),_display_(Seq[Any](/*69.12*/subscriptionKey)),format.raw/*69.27*/("""</td>
		  </tr>
		  <tr>
		    <th class="col-md-2"><b>productName</b></th>
		    <td>"""),_display_(Seq[Any](/*73.12*/productName)),format.raw/*73.23*/("""</td>
		  </tr>		  
		</table>
		
    <h4>Customers - Segments</h4>
    <input type="button" class="btn btn-default" value="Get Segment" OnClick="javascript: getCustomerInfo('segment')"/>
    <div id="response-segment"></div>
    
    <h4>Customers - Birthdates</h4>
    <input type="button" class="btn btn-default" value="Get Birthdate" OnClick="javascript: getCustomerInfo('birthdate')"/>
    <div id="response-birthdate"></div>

    <h4>Contracts - Simcards</h4>
    <input type="button" class="btn btn-default" value="Get Simcards" OnClick="javascript: getContractInfo('simcards', null)"/>
    <div id="response-simcards"></div>
    
    <h4>Contracts - Retentions</h4>
    <form class="form-horizontal" method="post">
      <div class="form-group">
        <label for="language" class="col-sm-2 control-label">language</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="language" id="language" value="de"/>
        </div>
      </div>
      <div class="form-group">
        <label for="language" class="col-sm-2 control-label">channel</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="channel" id="channel" value="RESELLER_ONLINE"/>
        </div>
      </div>
      <input type="button" class="btn btn-default" value="Get Retention" OnClick="javascript: getContractInfo('retention',$(this.form).serialize())"/>
    </form>
    <div id="response-retention"></div>
  
    <h4>Contracts - Eligibilities</h4>
    <form class="form-horizontal" method="post">
	    <div class="form-group">
	      <label for="isDeviceWithoutVZ" class="col-sm-2 control-label">isDeviceWithoutVZ</label>
	      <div class="col-sm-10">
	        <input type="text" class="form-control" name="isDeviceWithoutVZ" id="isDeviceWithoutVZ" value="false"/>
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="useCase" class="col-sm-2 control-label">useCase</label>
        <div class="col-sm-10">
	        <input type=text class="form-control" name="useCase" id="useCase" value="RETENTION"/>
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="channel" class="col-sm-2 control-label">channel</label>
        <div class="col-sm-10">
	        <input type=text class="form-control" name="channel" id="channel" value="RESELLER_ONLINE"/>
	      </div>
	    </div>
	    <div class="form-group" class="col-sm-2 control-label">
	      <label for="segment" class="col-sm-2 control-label">segment</label>
        <div class="col-sm-10">
	        <input type=text class="form-control" name="segment" id="segment" value="RES"/>
	      </div>
	    </div>
	    <div class="form-group" class="col-sm-2 control-label">
	      <label for="deviceId" class="col-sm-2 control-label">deviceId</label>
        <div class="col-sm-9">
	        <input type=text class="form-control" name="deviceId" id="deviceId" value=""/>
	      </div>
        <div class="text-info col-sm-1">
          optional
        </div>
	    </div>
	    <input type="button" class="btn btn-default" value="Get Eligibility" OnClick="javascript: getContractInfo('eligibility',$(this.form).serialize())">
    </form>
    <div id="response-eligibility"></div>

    <h4>Contracts - Orders</h4>
    <form class="form-horizontal" method="post">
      <div class="form-group">
        <label for="externalUserLoginId" class="col-sm-2 control-label">externalUserLoginId</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="externalUserLoginId" id="externalUserLoginId" value="OADMIN"/>
        </div>
      </div>
      <div class="form-group">
        <label for="dealerId" class="col-sm-2 control-label">dealerId</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="dealerId" id="dealerId" value="2800069"/>
        </div>
      </div>
      <div class="form-group">
        <label for="deviceId" class="col-sm-2 control-label">deviceId</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="deviceId" id="deviceId" value="10029375"/>
        </div>
      </div>
      <div class="form-group">
        <label for="commitmentPeriod" class="col-sm-2 control-label">commitmentPeriod</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="commitmentPeriod" id="commitmentPeriod" value="ONE_YEAR"/>
        </div>
      </div>
      <div class="form-group">
        <label for="useCase" class="col-sm-2 control-label">useCase</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="useCase" id="useCase" value="RETENTION"/>
        </div>
      </div>
      <div class="form-group">
        <label for="simTechnology" class="col-sm-2 control-label">simTechnology</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="simTechnology" id="simTechnology" value="NFC"/>
        </div>
      </div>
      <div class="form-group">
        <label for="AppleCare" class="col-sm-2 control-label">AppleCare</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="AppleCare" id="AppleCare" value="false"/>
        </div>
      </div>
      <div class="form-group">
        <label for="channel" class="col-sm-2 control-label">channel</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="channel" id="channel" value="RESELLER_ONLINE"/>
        </div>
      </div>
      <div class="form-group">
        <label for="context" class="col-sm-2 control-label">context</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="context" id="context" value="ONLINE"/>
        </div>
      </div>
      <div class="form-group">
        <label for="productName" class="col-sm-2 control-label">productName</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="productName" id="productName" value="N_NATEL RES L"/>
        </div>
      </div>
      <div class="form-group">
        <label for="newContractStartDate" class="col-sm-2 control-label">newContractStartDate</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="newContractStartDate" id="newContractStartDate" value=""""),_display_(Seq[Any](/*211.113*/DateTime/*211.121*/.now.plusMonths(2).toYearMonthDay())),format.raw/*211.156*/(""""/>
        </div>
      </div>
      <div class="form-group">
        <label for="language" class="col-sm-2 control-label">language</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="language" id="language" value="FR"/>
        </div>
      </div>
      <div class="form-group">
        <label for="originIpAddress" class="col-sm-2 control-label">originIpAddress</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="originIpAddress" id="originIpAddress" value=""""),_display_(Seq[Any](/*223.103*/request/*223.110*/.remoteAddress)),format.raw/*223.124*/(""""/>
        </div>
      </div>
      <div class="form-group">
        <label for="contactChannel" class="col-sm-2 control-label">contactChannel</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="contactChannel" id="contactChannel" value="E-Mail"/>
        </div>
      </div>
      <h6>oneTimeContact</h6>
      <div class="form-group">
        <label for="cellularPhoneNumber" class="col-sm-2 control-label">cellularPhoneNumber</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="cellularPhoneNumber" id="cellularPhoneNumber" value="+41790000000"/>
        </div>
      </div>
      <div class="form-group">
        <label for="emailAddress" class="col-sm-2 control-label">emailAddress</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="emailAddress" id="emailAddress" value="abcd@bcdefg.ch"/>
        </div>
      </div>
      <div class="form-group">
        <label for="firstName" class="col-sm-2 control-label">firstName</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="firstName" id="firstName" value="Alexander"/>
        </div>
      </div>
      <div class="form-group">
        <label for="lastName" class="col-sm-2 control-label">lastName</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="lastName" id="lastName" value="Meier"/>
        </div>
      </div>
      <div class="form-group">
        <label for="title" class="col-sm-2 control-label">title</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" name="title" id="title" value="Mr."/>
        </div>
      </div>

      <input type="button" class="btn btn-default" value="Submit Order" OnClick="javascript: getContractInfo('order', $(this.form).serialize())"/>    
    </form>
    <div id="response-order"></div>

  </div><!-- panel-heading -->
</div><!-- panel -->

""")))})),format.raw/*271.2*/("""
"""))}
    }
    
    def render(backend:String,subscriptionKey:String,msisdn:String,productName:String,error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(backend,subscriptionKey,msisdn,productName,error)(request)
    
    def f:((String,String,String,String,Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (backend,subscriptionKey,msisdn,productName,error) => (request) => apply(backend,subscriptionKey,msisdn,productName,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:51 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/consent/online3rdparty/subscription.scala.html
                    HASH: 55b60fd17fa028c69f6c13bd43ce9f4bd0b0861d
                    MATRIX: 668->1|1045->173|1075->288|1112->291|1165->336|1204->338|1281->379|1296->385|1347->414|1457->496|1486->497|1562->546|1590->547|1653->582|1682->583|1776->641|1805->648|1848->664|1876->665|1945->706|1974->707|2068->765|2105->780|2145->784|2174->791|2217->807|2245->808|2307->842|2336->843|2408->887|2437->888|2524->948|2552->949|2587->957|2615->958|2766->1073|2781->1079|2841->1117|3020->1261|3048->1280|3088->1282|3283->1441|3297->1446|3323->1450|3377->1473|3482->1542|3497->1548|3554->1583|3791->1784|3819->1790|3950->1885|3987->1900|4114->1991|4147->2002|10678->8495|10697->8503|10756->8538|11357->9101|11375->9108|11413->9122|13495->11173
                    LINES: 19->1|29->1|31->7|32->8|32->8|32->8|34->10|34->10|34->10|38->14|38->14|40->16|40->16|42->18|42->18|43->19|43->19|44->20|44->20|46->22|46->22|47->23|47->23|47->23|47->23|48->24|48->24|50->26|50->26|52->28|52->28|54->30|54->30|56->32|56->32|63->39|63->39|63->39|70->46|70->46|70->46|73->49|73->49|73->49|75->51|81->57|81->57|81->57|89->65|89->65|93->69|93->69|97->73|97->73|235->211|235->211|235->211|247->223|247->223|247->223|295->271
                    -- GENERATED --
                */
            