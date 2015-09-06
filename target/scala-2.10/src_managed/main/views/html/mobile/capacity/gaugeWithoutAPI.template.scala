
package views.html.mobile.capacity

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
object gaugeWithoutAPI extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[CapacityInfo],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(capacityForm: Form[CapacityInfo])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.101*/("""

"""),format.raw/*6.1*/("""
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <meta http-equiv="refresh" content="5; url="""),_display_(Seq[Any](/*12.53*/routes/*12.59*/.MobileCapacity.withoutAPI)),format.raw/*12.85*/("""" />
        <title>Speed test in progress...</title>
            <!-- START for gauche mechanism //-->
        <script type="text/javascript" src="http://mbostock.github.com/d3/d3.js"></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*16.46*/routes/*16.52*/.Assets.at("javascripts/gauge.js"))),format.raw/*16.86*/(""""></script>
        <script>

        var gauges = [];

        function createGauge(name, label, min, max)
        """),format.raw/*22.9*/("""{"""),format.raw/*22.10*/("""
            var config =
            """),format.raw/*24.13*/("""{"""),format.raw/*24.14*/("""
                size: 240,
                label: label,
                min: undefined != min ? min : 0,
                max: undefined != max ? max : 100,
                minorTicks: 5,
                currentValue: 0
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/("""

            var range = config.max - config.min;
            config.redZones = ["""),format.raw/*34.32*/("""{"""),format.raw/*34.33*/(""" from: config.min + range*0, to: config.min + range*0.55 """),format.raw/*34.90*/("""}"""),format.raw/*34.91*/("""];
            config.yellowZones = ["""),format.raw/*35.35*/("""{"""),format.raw/*35.36*/(""" from: config.min + range*0.55, to: config.min + range*0.75 """),format.raw/*35.96*/("""}"""),format.raw/*35.97*/("""];
            config.greenZones = ["""),format.raw/*36.34*/("""{"""),format.raw/*36.35*/(""" from: config.min + range*0.75, to: config.max """),format.raw/*36.82*/("""}"""),format.raw/*36.83*/("""];

            gauges[name] = new Gauge(name + "GaugeContainer", config);
            gauges[name].render();
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/("""

        function createGauges()
        """),format.raw/*43.9*/("""{"""),format.raw/*43.10*/("""
            createGauge("download", "Down Mbit/s",0,60);
            createGauge("upload", "Up Mbit/s",0,15);
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""

        function updateGauges()
        """),format.raw/*49.9*/("""{"""),format.raw/*49.10*/("""
            for (var key in gauges)
            """),format.raw/*51.13*/("""{"""),format.raw/*51.14*/("""
                if(key=="download") """),format.raw/*52.37*/("""{"""),format.raw/*52.38*/("""
                    var range = gauges[key].config.max - gauges[key].config.min;
                    var value = gauges[key].config.currentValue + range/1000 + addRandomValue(gauges[key],range);
                    if (value + 55 > gauges[key].config.max) value = gauges[key].config.max - 55;
                    else if (value < gauges[key].config.min) value = gauges[key].config.min;
                    gauges[key].config.currentValue = value;
                    gauges[key].redraw(value);
                """),format.raw/*59.17*/("""}"""),format.raw/*59.18*/(""" else if(key=="upload") """),format.raw/*59.42*/("""{"""),format.raw/*59.43*/("""
                    var range = gauges[key].config.max - gauges[key].config.min;
                    var value = gauges[key].config.currentValue + range/1000 + addRandomValue(gauges[key],range);
                    if (value + 14 > gauges[key].config.max) value = gauges[key].config.max - 14;
                    else if (value < gauges[key].config.min) value = gauges[key].config.min;
                    gauges[key].config.currentValue = value;
                    gauges[key].redraw(value);
                """),format.raw/*66.17*/("""}"""),format.raw/*66.18*/("""
            """),format.raw/*67.13*/("""}"""),format.raw/*67.14*/("""
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/("""

        function addRandomValue(gauge, range)
        """),format.raw/*71.9*/("""{"""),format.raw/*71.10*/("""
            var value = range/100 * Math.random();
            if (Math.random() < 0.40) value = -value;
            return value;
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""

        function initialize()
        """),format.raw/*78.9*/("""{"""),format.raw/*78.10*/("""
            createGauges();
            setInterval(updateGauges, 10);
        """),format.raw/*81.9*/("""}"""),format.raw/*81.10*/("""

    </script>
    <!-- END for gauche mechanism //-->

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href=""""),_display_(Seq[Any](/*87.38*/routes/*87.44*/.Assets.at("images/favicon.ico"))),format.raw/*87.76*/("""">
    <script src=""""),_display_(Seq[Any](/*88.19*/routes/*88.25*/.Assets.at("javascripts/jquery-2.1.0.min.js"))),format.raw/*88.70*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*89.19*/routes/*89.25*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*89.67*/(""""></script>
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*90.42*/routes/*90.48*/.Assets.at("javascripts/jso.js"))),format.raw/*90.80*/(""""></script>
    <!-- Get by URL query -->
    """),_display_(Seq[Any](/*92.6*/defining(request.session.get("theme").getOrElse("null"))/*92.62*/ { theme =>_display_(Seq[Any](format.raw/*92.73*/("""
        """),_display_(Seq[Any](/*93.10*/if(theme.equalsIgnoreCase("demapi") || theme.equalsIgnoreCase("darky") || theme.equalsIgnoreCase("united") || theme.equalsIgnoreCase("cyborg"))/*93.153*/ {_display_(Seq[Any](format.raw/*93.155*/("""
            <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*94.74*/routes/*94.80*/.Assets.at("stylesheets/libs/bootstrap-" + theme + "-theme.min.css"))),format.raw/*94.148*/("""">
        """)))}/*95.11*/else/*95.16*/{_display_(Seq[Any](format.raw/*95.17*/("""
            <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*96.74*/routes/*96.80*/.Assets.at("stylesheets/libs/bootstrap-demapi-theme.min.css"))),format.raw/*96.141*/("""">
        """)))})),format.raw/*97.10*/("""
    """)))})),format.raw/*98.6*/("""

    </head>

    <body onload="initialize()">
        <!-- Static navbar -->
        <div class="navbar navbar-default" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href=""""),_display_(Seq[Any](/*113.52*/routes/*113.58*/.Application.index())),format.raw/*113.78*/("""">
                        <img src=""""),_display_(Seq[Any](/*114.36*/routes/*114.42*/.Assets.at("images/swisscom_demoapi_banner_transp.png"))),format.raw/*114.97*/("""" height="20em"/>
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*120.39*/routes/*120.45*/.Application.messaging)),format.raw/*120.67*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*120.117*/Messages/*120.125*/.get("section.messaging"))),format.raw/*120.150*/(""" <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*122.47*/routes/*122.53*/.SmsSender.form)),format.raw/*122.68*/("""">"""),_display_(Seq[Any](/*122.71*/Messages/*122.79*/.get("section.messaging.sms"))),format.raw/*122.108*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*126.39*/routes/*126.45*/.Application.mobile)),format.raw/*126.64*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*126.114*/Messages/*126.122*/.get("section.mobile"))),format.raw/*126.144*/(""" <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*128.47*/routes/*128.53*/.MobileCapacity.form)),format.raw/*128.73*/("""">"""),_display_(Seq[Any](/*128.76*/Messages/*128.84*/.get("section.mobile.capacity"))),format.raw/*128.115*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*132.39*/routes/*132.45*/.Application.consent("int"))),format.raw/*132.72*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*132.122*/Messages/*132.130*/.get("section.consent"))),format.raw/*132.153*/("""
                                test<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*135.47*/routes/*135.53*/.ConsentVerifyAddress.index("mock", "", "manual"))),format.raw/*135.102*/("""">"""),_display_(Seq[Any](/*135.105*/Messages/*135.113*/.get("section.consent.verifyaddress"))),format.raw/*135.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*136.47*/routes/*136.53*/.ConsentVerifyAddress.index("int", "code", "manual"))),format.raw/*136.105*/("""">"""),_display_(Seq[Any](/*136.108*/Messages/*136.116*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*136.169*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*137.47*/routes/*137.53*/.ConsentVerifyAddress.index("int", "code", "automatic"))),format.raw/*137.108*/("""">"""),_display_(Seq[Any](/*137.111*/Messages/*137.119*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*137.175*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*138.47*/routes/*138.53*/.ConsentVerifyAddress.index("int", "token", "manual"))),format.raw/*138.106*/("""">"""),_display_(Seq[Any](/*138.109*/Messages/*138.117*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*138.170*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*139.47*/routes/*139.53*/.ConsentVerifyAddress.index("int", "token", "automatic"))),format.raw/*139.109*/("""">"""),_display_(Seq[Any](/*139.112*/Messages/*139.120*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*139.176*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*140.47*/routes/*140.53*/.ConsentVerifyAddress.index("int", "code", "manual40"))),format.raw/*140.107*/("""">"""),_display_(Seq[Any](/*140.110*/Messages/*140.118*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*140.173*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*141.47*/routes/*141.53*/.ConsentVerifyAddress.index("int", "code", "automatic40"))),format.raw/*141.110*/("""">"""),_display_(Seq[Any](/*141.113*/Messages/*141.121*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*141.179*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*142.47*/routes/*142.53*/.ConsentPayment.login("int"))),format.raw/*142.81*/("""">"""),_display_(Seq[Any](/*142.84*/Messages/*142.92*/.get("section.consent.payment"))),format.raw/*142.123*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*143.47*/routes/*143.53*/.PaymentV2.index("int"))),format.raw/*143.76*/("""">"""),_display_(Seq[Any](/*143.79*/Messages/*143.87*/.get("section.consent.paymentv2"))),format.raw/*143.120*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*144.47*/routes/*144.53*/.Online3rdParty.index("int"))),format.raw/*144.81*/("""">"""),_display_(Seq[Any](/*144.84*/Messages/*144.92*/.get("section.consent.Online3rdParty"))),format.raw/*144.130*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*145.47*/routes/*145.53*/.Calling.index("int"))),format.raw/*145.74*/("""">"""),_display_(Seq[Any](/*145.77*/Messages/*145.85*/.get("section.consent.Call"))),format.raw/*145.113*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*146.47*/routes/*146.53*/.PaymentsFlowPartnerAgent.index("int"))),format.raw/*146.91*/("""">"""),_display_(Seq[Any](/*146.94*/Messages/*146.102*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*146.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*147.47*/routes/*147.53*/.PaymentsFlowSelfcare.index("int"))),format.raw/*147.87*/("""">"""),_display_(Seq[Any](/*147.90*/Messages/*147.98*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*147.142*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*148.47*/routes/*148.53*/.ConsentToken.index("int"))),format.raw/*148.79*/("""">"""),_display_(Seq[Any](/*148.82*/Messages/*148.90*/.get("section.consent.verifytokencreation"))),format.raw/*148.133*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*152.39*/routes/*152.45*/.Application.consent("ext"))),format.raw/*152.72*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*152.122*/Messages/*152.130*/.get("section.consent"))),format.raw/*152.153*/("""
                                prod<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*155.47*/routes/*155.53*/.ConsentVerifyAddress.index("ext", "code", "manual"))),format.raw/*155.105*/("""">"""),_display_(Seq[Any](/*155.108*/Messages/*155.116*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*155.169*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*156.47*/routes/*156.53*/.ConsentVerifyAddress.index("ext", "code", "automatic"))),format.raw/*156.108*/("""">"""),_display_(Seq[Any](/*156.111*/Messages/*156.119*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*156.175*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*157.47*/routes/*157.53*/.ConsentVerifyAddress.index("ext", "token", "manual"))),format.raw/*157.106*/("""">"""),_display_(Seq[Any](/*157.109*/Messages/*157.117*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*157.170*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*158.47*/routes/*158.53*/.ConsentVerifyAddress.index("ext", "token", "automatic"))),format.raw/*158.109*/("""">"""),_display_(Seq[Any](/*158.112*/Messages/*158.120*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*158.176*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*159.47*/routes/*159.53*/.ConsentVerifyAddress.index("ext", "code", "manual40"))),format.raw/*159.107*/("""">"""),_display_(Seq[Any](/*159.110*/Messages/*159.118*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*159.173*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*160.47*/routes/*160.53*/.ConsentVerifyAddress.index("ext", "code", "automatic40"))),format.raw/*160.110*/("""">"""),_display_(Seq[Any](/*160.113*/Messages/*160.121*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*160.179*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*161.47*/routes/*161.53*/.ConsentPayment.login("ext"))),format.raw/*161.81*/("""">"""),_display_(Seq[Any](/*161.84*/Messages/*161.92*/.get("section.consent.payment"))),format.raw/*161.123*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*162.47*/routes/*162.53*/.PaymentV2.index("ext"))),format.raw/*162.76*/("""">"""),_display_(Seq[Any](/*162.79*/Messages/*162.87*/.get("section.consent.paymentv2"))),format.raw/*162.120*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*163.47*/routes/*163.53*/.Online3rdParty.index("ext"))),format.raw/*163.81*/("""">"""),_display_(Seq[Any](/*163.84*/Messages/*163.92*/.get("section.consent.Online3rdParty"))),format.raw/*163.130*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*164.47*/routes/*164.53*/.Calling.index("ext"))),format.raw/*164.74*/("""">"""),_display_(Seq[Any](/*164.77*/Messages/*164.85*/.get("section.consent.Call"))),format.raw/*164.113*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*165.47*/routes/*165.53*/.PaymentsFlowPartnerAgent.index("ext"))),format.raw/*165.91*/("""">"""),_display_(Seq[Any](/*165.94*/Messages/*165.102*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*165.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*166.47*/routes/*166.53*/.PaymentsFlowSelfcare.index("ext"))),format.raw/*166.87*/("""">"""),_display_(Seq[Any](/*166.90*/Messages/*166.98*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*166.142*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*167.47*/routes/*167.53*/.ConsentToken.index("ext"))),format.raw/*167.79*/("""">"""),_display_(Seq[Any](/*167.82*/Messages/*167.90*/.get("section.consent.verifytokencreation"))),format.raw/*167.133*/("""</a></li>
                            </ul>
                        </li>
                        """),_display_(Seq[Any](/*170.26*/if(request.host.equalsIgnoreCase("localhost:9000") || request.host.equalsIgnoreCase("127.0.0.1:9000"))/*170.128*/ {_display_(Seq[Any](format.raw/*170.130*/("""
                            <li class="dropdown">
                                <a href=""""),_display_(Seq[Any](/*172.43*/routes/*172.49*/.Application.consent("local"))),format.raw/*172.78*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*172.128*/Messages/*172.136*/.get("section.consent"))),format.raw/*172.159*/("""
                                    local<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href=""""),_display_(Seq[Any](/*175.51*/routes/*175.57*/.ConsentVerifyAddress.index("mock", "", "manual"))),format.raw/*175.106*/("""">"""),_display_(Seq[Any](/*175.109*/Messages/*175.117*/.get("section.consent.verifyaddress"))),format.raw/*175.154*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*176.51*/routes/*176.57*/.ConsentVerifyAddress.index("local", "code", "manual"))),format.raw/*176.111*/("""">"""),_display_(Seq[Any](/*176.114*/Messages/*176.122*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*176.175*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*177.51*/routes/*177.57*/.ConsentVerifyAddress.index("local", "code", "automatic"))),format.raw/*177.114*/("""">"""),_display_(Seq[Any](/*177.117*/Messages/*177.125*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*177.181*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*178.51*/routes/*178.57*/.ConsentVerifyAddress.index("local", "token", "manual"))),format.raw/*178.112*/("""">"""),_display_(Seq[Any](/*178.115*/Messages/*178.123*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*178.176*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*179.51*/routes/*179.57*/.ConsentVerifyAddress.index("local", "token", "automatic"))),format.raw/*179.115*/("""">"""),_display_(Seq[Any](/*179.118*/Messages/*179.126*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*179.182*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*180.51*/routes/*180.57*/.ConsentVerifyAddress.index("local", "code", "manual40"))),format.raw/*180.113*/("""">"""),_display_(Seq[Any](/*180.116*/Messages/*180.124*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*180.179*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*181.51*/routes/*181.57*/.ConsentVerifyAddress.index("local", "code", "automatic40"))),format.raw/*181.116*/("""">"""),_display_(Seq[Any](/*181.119*/Messages/*181.127*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*181.185*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*182.51*/routes/*182.57*/.ConsentPayment.login("local"))),format.raw/*182.87*/("""">"""),_display_(Seq[Any](/*182.90*/Messages/*182.98*/.get("section.consent.payment"))),format.raw/*182.129*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*183.51*/routes/*183.57*/.PaymentV2.index("local"))),format.raw/*183.82*/("""">"""),_display_(Seq[Any](/*183.85*/Messages/*183.93*/.get("section.consent.paymentv2"))),format.raw/*183.126*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*184.51*/routes/*184.57*/.Online3rdParty.index("local"))),format.raw/*184.87*/("""">"""),_display_(Seq[Any](/*184.90*/Messages/*184.98*/.get("section.consent.Online3rdParty"))),format.raw/*184.136*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*185.51*/routes/*185.57*/.Calling.index("local"))),format.raw/*185.80*/("""">"""),_display_(Seq[Any](/*185.83*/Messages/*185.91*/.get("section.consent.Call"))),format.raw/*185.119*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*186.51*/routes/*186.57*/.PaymentsFlowPartnerAgent.index("local"))),format.raw/*186.97*/("""">"""),_display_(Seq[Any](/*186.100*/Messages/*186.108*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*186.156*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*187.51*/routes/*187.57*/.PaymentsFlowSelfcare.index("local"))),format.raw/*187.93*/("""">"""),_display_(Seq[Any](/*187.96*/Messages/*187.104*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*187.148*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*188.51*/routes/*188.57*/.ConsentToken.index("local"))),format.raw/*188.85*/("""">"""),_display_(Seq[Any](/*188.88*/Messages/*188.96*/.get("section.consent.verifytokencreation"))),format.raw/*188.139*/("""</a></li>
                                </ul>
                            </li>
                        """)))})),format.raw/*191.26*/("""
                    </ul>
                    <ul class="nav navbar-nav nav-pills pull-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Theme<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*197.47*/routes/*197.53*/.Application.theme("default"))),format.raw/*197.82*/("""">default</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*198.47*/routes/*198.53*/.Application.theme("darky"))),format.raw/*198.80*/("""">darky</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*199.47*/routes/*199.53*/.Application.theme("united"))),format.raw/*199.81*/("""">united</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*200.47*/routes/*200.53*/.Application.theme("cyborg"))),format.raw/*200.81*/("""">cyborg</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container -->
        </div><!-- div navigation -->

        <div class="container">

            <img src=""""),_display_(Seq[Any](/*210.24*/routes/*210.30*/.Assets.at("images/speedtest.png"))),format.raw/*210.64*/("""" width="150" />
            <br>
            <br>
            <span id="downloadGaugeContainer"></span>
            <span id="uploadGaugeContainer"></span>
            <br>
            <br>

            <p>
                <h4>This is the result WITHOUT the Mobile Network Information API</h4>
            </p>

            <table class="table table-bordered">
                <tr><td colspan="3"><b>Swisscom</b></td></tr>
                <tr bgcolor="""),_display_(Seq[Any](/*224.30*/capacityForm("color")/*224.51*/.value)),format.raw/*224.57*/("""><td width="33%">Download Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*224.144*/capacityForm("downloadRate")/*224.172*/.value)),format.raw/*224.178*/("""</td><td><b>"""),_display_(Seq[Any](/*224.191*/capacityForm("downloadRatio")/*224.220*/.value)),format.raw/*224.226*/("""%</b> of expected Speed</td></tr>
                <tr bgcolor="""),_display_(Seq[Any](/*225.30*/capacityForm("color")/*225.51*/.value)),format.raw/*225.57*/("""><td width="33%">Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*225.142*/capacityForm("uploadRate")/*225.168*/.value)),format.raw/*225.174*/("""</td><td><b>"""),_display_(Seq[Any](/*225.187*/capacityForm("uploadRatio")/*225.214*/.value)),format.raw/*225.220*/("""%</b> of expected Speed</td></tr>
            </table>

            <p>
                <h4>This is what was expected with 4G</h4>
            </p>

            <table class="table table-bordered">
                <tr><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*233.132*/capacityForm("expectedDownload")/*233.164*/.value)),format.raw/*233.170*/("""<br>"""),_display_(Seq[Any](/*233.175*/capacityForm("expectedUpload")/*233.205*/.value)),format.raw/*233.211*/("""</td><td></td></tr>
            </table>

        </div>

    </body>

</html>"""))}
    }
    
    def render(capacityForm:Form[CapacityInfo],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(capacityForm)(request)
    
    def f:((Form[CapacityInfo]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (capacityForm) => (request) => apply(capacityForm)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/capacity/gaugeWithoutAPI.scala.html
                    HASH: 64bffa599721cdac3cd82d52bcd59660c0028f25
                    MATRIX: 640->1|899->100|927->168|1213->418|1228->424|1276->450|1552->690|1567->696|1623->730|1766->846|1795->847|1861->885|1890->886|2151->1119|2180->1120|2290->1202|2319->1203|2404->1260|2433->1261|2498->1298|2527->1299|2615->1359|2644->1360|2708->1396|2737->1397|2812->1444|2841->1445|2986->1563|3015->1564|3084->1606|3113->1607|3259->1726|3288->1727|3357->1769|3386->1770|3463->1819|3492->1820|3557->1857|3586->1858|4125->2369|4154->2370|4206->2394|4235->2395|4774->2906|4803->2907|4844->2920|4873->2921|4909->2930|4938->2931|5021->2987|5050->2988|5217->3128|5246->3129|5313->3169|5342->3170|5449->3250|5478->3251|5681->3418|5696->3424|5750->3456|5807->3477|5822->3483|5889->3528|5955->3558|5970->3564|6034->3606|6123->3659|6138->3665|6192->3697|6274->3744|6339->3800|6388->3811|6434->3821|6587->3964|6628->3966|6738->4040|6753->4046|6844->4114|6875->4127|6888->4132|6927->4133|7037->4207|7052->4213|7136->4274|7180->4286|7217->4292|7911->4949|7927->4955|7970->4975|8045->5013|8061->5019|8139->5074|8429->5327|8445->5333|8490->5355|8578->5405|8597->5413|8646->5438|8811->5566|8827->5572|8865->5587|8905->5590|8923->5598|8976->5627|9171->5785|9187->5791|9229->5810|9317->5860|9336->5868|9382->5890|9547->6018|9563->6024|9606->6044|9646->6047|9664->6055|9719->6086|9914->6244|9930->6250|9980->6277|10068->6327|10087->6335|10134->6358|10335->6522|10351->6528|10424->6577|10465->6580|10484->6588|10545->6625|10638->6681|10654->6687|10730->6739|10771->6742|10790->6750|10867->6803|10960->6859|10976->6865|11055->6920|11096->6923|11115->6931|11195->6987|11288->7043|11304->7049|11381->7102|11422->7105|11441->7113|11518->7166|11611->7222|11627->7228|11707->7284|11748->7287|11767->7295|11847->7351|11940->7407|11956->7413|12034->7467|12075->7470|12094->7478|12173->7533|12266->7589|12282->7595|12363->7652|12404->7655|12423->7663|12505->7721|12598->7777|12614->7783|12665->7811|12705->7814|12723->7822|12778->7853|12871->7909|12887->7915|12933->7938|12973->7941|12991->7949|13048->7982|13141->8038|13157->8044|13208->8072|13248->8075|13266->8083|13328->8121|13421->8177|13437->8183|13481->8204|13521->8207|13539->8215|13591->8243|13684->8299|13700->8305|13761->8343|13801->8346|13820->8354|13892->8402|13985->8458|14001->8464|14058->8498|14098->8501|14116->8509|14184->8553|14277->8609|14293->8615|14342->8641|14382->8644|14400->8652|14467->8695|14662->8853|14678->8859|14728->8886|14816->8936|14835->8944|14882->8967|15083->9131|15099->9137|15175->9189|15216->9192|15235->9200|15312->9253|15405->9309|15421->9315|15500->9370|15541->9373|15560->9381|15640->9437|15733->9493|15749->9499|15826->9552|15867->9555|15886->9563|15963->9616|16056->9672|16072->9678|16152->9734|16193->9737|16212->9745|16292->9801|16385->9857|16401->9863|16479->9917|16520->9920|16539->9928|16618->9983|16711->10039|16727->10045|16808->10102|16849->10105|16868->10113|16950->10171|17043->10227|17059->10233|17110->10261|17150->10264|17168->10272|17223->10303|17316->10359|17332->10365|17378->10388|17418->10391|17436->10399|17493->10432|17586->10488|17602->10494|17653->10522|17693->10525|17711->10533|17773->10571|17866->10627|17882->10633|17926->10654|17966->10657|17984->10665|18036->10693|18129->10749|18145->10755|18206->10793|18246->10796|18265->10804|18337->10852|18430->10908|18446->10914|18503->10948|18543->10951|18561->10959|18629->11003|18722->11059|18738->11065|18787->11091|18827->11094|18845->11102|18912->11145|19048->11244|19161->11346|19203->11348|19333->11441|19349->11447|19401->11476|19489->11526|19508->11534|19555->11557|19769->11734|19785->11740|19858->11789|19899->11792|19918->11800|19979->11837|20076->11897|20092->11903|20170->11957|20211->11960|20230->11968|20307->12021|20404->12081|20420->12087|20501->12144|20542->12147|20561->12155|20641->12211|20738->12271|20754->12277|20833->12332|20874->12335|20893->12343|20970->12396|21067->12456|21083->12462|21165->12520|21206->12523|21225->12531|21305->12587|21402->12647|21418->12653|21498->12709|21539->12712|21558->12720|21637->12775|21734->12835|21750->12841|21833->12900|21874->12903|21893->12911|21975->12969|22072->13029|22088->13035|22141->13065|22181->13068|22199->13076|22254->13107|22351->13167|22367->13173|22415->13198|22455->13201|22473->13209|22530->13242|22627->13302|22643->13308|22696->13338|22736->13341|22754->13349|22816->13387|22913->13447|22929->13453|22975->13476|23015->13479|23033->13487|23085->13515|23182->13575|23198->13581|23261->13621|23302->13624|23321->13632|23393->13680|23490->13740|23506->13746|23565->13782|23605->13785|23624->13793|23692->13837|23789->13897|23805->13903|23856->13931|23896->13934|23914->13942|23981->13985|24121->14092|24519->14453|24535->14459|24587->14488|24689->14553|24705->14559|24755->14586|24855->14649|24871->14655|24922->14683|25023->14747|25039->14753|25090->14781|25413->15067|25429->15073|25486->15107|25976->15560|26007->15581|26036->15587|26161->15674|26200->15702|26230->15708|26281->15721|26321->15750|26351->15756|26451->15819|26482->15840|26511->15846|26634->15931|26671->15957|26701->15963|26752->15976|26790->16003|26820->16009|27187->16338|27230->16370|27260->16376|27303->16381|27344->16411|27374->16417
                    LINES: 19->1|27->1|29->6|35->12|35->12|35->12|39->16|39->16|39->16|45->22|45->22|47->24|47->24|54->31|54->31|57->34|57->34|57->34|57->34|58->35|58->35|58->35|58->35|59->36|59->36|59->36|59->36|63->40|63->40|66->43|66->43|69->46|69->46|72->49|72->49|74->51|74->51|75->52|75->52|82->59|82->59|82->59|82->59|89->66|89->66|90->67|90->67|91->68|91->68|94->71|94->71|98->75|98->75|101->78|101->78|104->81|104->81|110->87|110->87|110->87|111->88|111->88|111->88|112->89|112->89|112->89|113->90|113->90|113->90|115->92|115->92|115->92|116->93|116->93|116->93|117->94|117->94|117->94|118->95|118->95|118->95|119->96|119->96|119->96|120->97|121->98|136->113|136->113|136->113|137->114|137->114|137->114|143->120|143->120|143->120|143->120|143->120|143->120|145->122|145->122|145->122|145->122|145->122|145->122|149->126|149->126|149->126|149->126|149->126|149->126|151->128|151->128|151->128|151->128|151->128|151->128|155->132|155->132|155->132|155->132|155->132|155->132|158->135|158->135|158->135|158->135|158->135|158->135|159->136|159->136|159->136|159->136|159->136|159->136|160->137|160->137|160->137|160->137|160->137|160->137|161->138|161->138|161->138|161->138|161->138|161->138|162->139|162->139|162->139|162->139|162->139|162->139|163->140|163->140|163->140|163->140|163->140|163->140|164->141|164->141|164->141|164->141|164->141|164->141|165->142|165->142|165->142|165->142|165->142|165->142|166->143|166->143|166->143|166->143|166->143|166->143|167->144|167->144|167->144|167->144|167->144|167->144|168->145|168->145|168->145|168->145|168->145|168->145|169->146|169->146|169->146|169->146|169->146|169->146|170->147|170->147|170->147|170->147|170->147|170->147|171->148|171->148|171->148|171->148|171->148|171->148|175->152|175->152|175->152|175->152|175->152|175->152|178->155|178->155|178->155|178->155|178->155|178->155|179->156|179->156|179->156|179->156|179->156|179->156|180->157|180->157|180->157|180->157|180->157|180->157|181->158|181->158|181->158|181->158|181->158|181->158|182->159|182->159|182->159|182->159|182->159|182->159|183->160|183->160|183->160|183->160|183->160|183->160|184->161|184->161|184->161|184->161|184->161|184->161|185->162|185->162|185->162|185->162|185->162|185->162|186->163|186->163|186->163|186->163|186->163|186->163|187->164|187->164|187->164|187->164|187->164|187->164|188->165|188->165|188->165|188->165|188->165|188->165|189->166|189->166|189->166|189->166|189->166|189->166|190->167|190->167|190->167|190->167|190->167|190->167|193->170|193->170|193->170|195->172|195->172|195->172|195->172|195->172|195->172|198->175|198->175|198->175|198->175|198->175|198->175|199->176|199->176|199->176|199->176|199->176|199->176|200->177|200->177|200->177|200->177|200->177|200->177|201->178|201->178|201->178|201->178|201->178|201->178|202->179|202->179|202->179|202->179|202->179|202->179|203->180|203->180|203->180|203->180|203->180|203->180|204->181|204->181|204->181|204->181|204->181|204->181|205->182|205->182|205->182|205->182|205->182|205->182|206->183|206->183|206->183|206->183|206->183|206->183|207->184|207->184|207->184|207->184|207->184|207->184|208->185|208->185|208->185|208->185|208->185|208->185|209->186|209->186|209->186|209->186|209->186|209->186|210->187|210->187|210->187|210->187|210->187|210->187|211->188|211->188|211->188|211->188|211->188|211->188|214->191|220->197|220->197|220->197|221->198|221->198|221->198|222->199|222->199|222->199|223->200|223->200|223->200|233->210|233->210|233->210|247->224|247->224|247->224|247->224|247->224|247->224|247->224|247->224|247->224|248->225|248->225|248->225|248->225|248->225|248->225|248->225|248->225|248->225|256->233|256->233|256->233|256->233|256->233|256->233
                    -- GENERATED --
                */
            