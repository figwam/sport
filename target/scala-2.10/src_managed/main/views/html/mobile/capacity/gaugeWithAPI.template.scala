
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
object gaugeWithAPI extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Form[CapacityInfo],Option[String],play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(capacityForm: Form[CapacityInfo], error: Option[String])(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import play.api.Play


Seq[Any](format.raw/*1.124*/("""

"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/if(error.isDefined)/*7.21*/ {_display_(Seq[Any](format.raw/*7.23*/("""
    """),_display_(Seq[Any](/*8.6*/main("An error occured...")/*8.33*/ {_display_(Seq[Any](format.raw/*8.35*/("""
    <div class="alert alert-dismissable alert-danger">
        Error: """),format.raw/*10.16*/("""{"""),_display_(Seq[Any](/*10.18*/error/*10.23*/.get)),format.raw/*10.27*/("""}"""),format.raw/*10.28*/("""
    </div>""")))})),format.raw/*11.12*/("""
""")))}/*12.3*/else/*12.8*/{_display_(Seq[Any](format.raw/*12.9*/("""

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <meta http-equiv="refresh" content="6; url="""),_display_(Seq[Any](/*19.53*/routes/*19.59*/.MobileCapacity.withAPI)),format.raw/*19.82*/("""" />
        <title>Speed test in progress...</title>
            <!-- START for gauche mechanism //-->
        <script type="text/javascript" src="http://mbostock.github.com/d3/d3.js"></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*23.46*/routes/*23.52*/.Assets.at("javascripts/gauge.js"))),format.raw/*23.86*/(""""></script>
        <script>

        var gauges = [];

        function createGauge(name, label, min, max)
        """),format.raw/*29.9*/("""{"""),format.raw/*29.10*/("""
            var config =
            """),format.raw/*31.13*/("""{"""),format.raw/*31.14*/("""
                size: 240,
                label: label,
                min: undefined != min ? min : 0,
                max: undefined != max ? max : 100,
                minorTicks: 5,
                currentValue: 0
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/("""

            var range = config.max - config.min;
            config.redZones = ["""),format.raw/*41.32*/("""{"""),format.raw/*41.33*/(""" from: config.min + range*0, to: config.min + range*0.55 """),format.raw/*41.90*/("""}"""),format.raw/*41.91*/("""];
            config.yellowZones = ["""),format.raw/*42.35*/("""{"""),format.raw/*42.36*/(""" from: config.min + range*0.55, to: config.min + range*0.75 """),format.raw/*42.96*/("""}"""),format.raw/*42.97*/("""];
            config.greenZones = ["""),format.raw/*43.34*/("""{"""),format.raw/*43.35*/(""" from: config.min + range*0.75, to: config.max """),format.raw/*43.82*/("""}"""),format.raw/*43.83*/("""];

            gauges[name] = new Gauge(name + "GaugeContainer", config);
            gauges[name].render();
        """),format.raw/*47.9*/("""}"""),format.raw/*47.10*/("""

        function createGauges()
        """),format.raw/*50.9*/("""{"""),format.raw/*50.10*/("""
            createGauge("download", "Down Mbit/s",0,15);
            createGauge("upload", "Up Mbit/s",0,2);
        """),format.raw/*53.9*/("""}"""),format.raw/*53.10*/("""

        function updateGauges()
        """),format.raw/*56.9*/("""{"""),format.raw/*56.10*/("""
            for (var key in gauges)
            """),format.raw/*58.13*/("""{"""),format.raw/*58.14*/("""
                if(key=="download") """),format.raw/*59.37*/("""{"""),format.raw/*59.38*/("""
                    var range = gauges[key].config.max - gauges[key].config.min;
                    var value = gauges[key].config.currentValue + range/1000 + addRandomValue(gauges[key],range);
                    if (value + 1.8 > gauges[key].config.max) value = gauges[key].config.max - 1.8;
                    else if (value < gauges[key].config.min) value = gauges[key].config.min;
                    gauges[key].config.currentValue = value;
                    gauges[key].redraw(value);
                """),format.raw/*66.17*/("""}"""),format.raw/*66.18*/(""" else if(key=="upload") """),format.raw/*66.42*/("""{"""),format.raw/*66.43*/("""
                    var range = gauges[key].config.max - gauges[key].config.min;
                    var value = gauges[key].config.currentValue + range/1000 + addRandomValue(gauges[key],range);
                    if (value + 0.15 > gauges[key].config.max) value = gauges[key].config.max - 0.15;
                    else if (value < gauges[key].config.min) value = gauges[key].config.min;
                    gauges[key].config.currentValue = value;
                    gauges[key].redraw(value);
                """),format.raw/*73.17*/("""}"""),format.raw/*73.18*/("""
            """),format.raw/*74.13*/("""}"""),format.raw/*74.14*/("""
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""

        function addRandomValue(gauge, range)
        """),format.raw/*78.9*/("""{"""),format.raw/*78.10*/("""
            var value = range/100 * Math.random();
            if (Math.random() < 0.40) value = -value;
            return value;
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/("""

        function initialize()
        """),format.raw/*85.9*/("""{"""),format.raw/*85.10*/("""
            createGauges();
            setInterval(updateGauges, 10);
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/("""

    </script>
    <!-- END for gauche mechanism //-->

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href=""""),_display_(Seq[Any](/*94.38*/routes/*94.44*/.Assets.at("images/favicon.ico"))),format.raw/*94.76*/("""">
    <script src=""""),_display_(Seq[Any](/*95.19*/routes/*95.25*/.Assets.at("javascripts/jquery-2.1.0.min.js"))),format.raw/*95.70*/(""""></script>
    <script src=""""),_display_(Seq[Any](/*96.19*/routes/*96.25*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*96.67*/(""""></script>
    <script type="text/javascript" src=""""),_display_(Seq[Any](/*97.42*/routes/*97.48*/.Assets.at("javascripts/jso.js"))),format.raw/*97.80*/(""""></script>
    <!-- Get by URL query -->
    """),_display_(Seq[Any](/*99.6*/defining(request.session.get("theme").getOrElse("null"))/*99.62*/ { theme =>_display_(Seq[Any](format.raw/*99.73*/("""
        """),_display_(Seq[Any](/*100.10*/if(theme.equalsIgnoreCase("demapi") || theme.equalsIgnoreCase("darky") || theme.equalsIgnoreCase("united") || theme.equalsIgnoreCase("cyborg"))/*100.153*/ {_display_(Seq[Any](format.raw/*100.155*/("""
            <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*101.74*/routes/*101.80*/.Assets.at("stylesheets/libs/bootstrap-" + theme + "-theme.min.css"))),format.raw/*101.148*/("""">
        """)))}/*102.11*/else/*102.16*/{_display_(Seq[Any](format.raw/*102.17*/("""
            <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*103.74*/routes/*103.80*/.Assets.at("stylesheets/libs/bootstrap-demapi-theme.min.css"))),format.raw/*103.141*/("""">
        """)))})),format.raw/*104.10*/("""
    """)))})),format.raw/*105.6*/("""

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
                    <a class="navbar-brand" href=""""),_display_(Seq[Any](/*120.52*/routes/*120.58*/.Application.index())),format.raw/*120.78*/("""">
                        <img src=""""),_display_(Seq[Any](/*121.36*/routes/*121.42*/.Assets.at("images/swisscom_demoapi_banner_transp.png"))),format.raw/*121.97*/("""" height="20em"/>
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*127.39*/routes/*127.45*/.Application.messaging)),format.raw/*127.67*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*127.117*/Messages/*127.125*/.get("section.messaging"))),format.raw/*127.150*/(""" <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*129.47*/routes/*129.53*/.SmsSender.form)),format.raw/*129.68*/("""">"""),_display_(Seq[Any](/*129.71*/Messages/*129.79*/.get("section.messaging.sms"))),format.raw/*129.108*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*133.39*/routes/*133.45*/.Application.mobile)),format.raw/*133.64*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*133.114*/Messages/*133.122*/.get("section.mobile"))),format.raw/*133.144*/(""" <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*135.47*/routes/*135.53*/.MobileCapacity.form)),format.raw/*135.73*/("""">"""),_display_(Seq[Any](/*135.76*/Messages/*135.84*/.get("section.mobile.capacity"))),format.raw/*135.115*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*139.39*/routes/*139.45*/.Application.consent("int"))),format.raw/*139.72*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*139.122*/Messages/*139.130*/.get("section.consent"))),format.raw/*139.153*/("""
                                test<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*142.47*/routes/*142.53*/.ConsentVerifyAddress.index("mock", "", "manual"))),format.raw/*142.102*/("""">"""),_display_(Seq[Any](/*142.105*/Messages/*142.113*/.get("section.consent.verifyaddress"))),format.raw/*142.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*143.47*/routes/*143.53*/.ConsentVerifyAddress.index("int", "code", "manual"))),format.raw/*143.105*/("""">"""),_display_(Seq[Any](/*143.108*/Messages/*143.116*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*143.169*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*144.47*/routes/*144.53*/.ConsentVerifyAddress.index("int", "code", "automatic"))),format.raw/*144.108*/("""">"""),_display_(Seq[Any](/*144.111*/Messages/*144.119*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*144.175*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*145.47*/routes/*145.53*/.ConsentVerifyAddress.index("int", "token", "manual"))),format.raw/*145.106*/("""">"""),_display_(Seq[Any](/*145.109*/Messages/*145.117*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*145.170*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*146.47*/routes/*146.53*/.ConsentVerifyAddress.index("int", "token", "automatic"))),format.raw/*146.109*/("""">"""),_display_(Seq[Any](/*146.112*/Messages/*146.120*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*146.176*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*147.47*/routes/*147.53*/.ConsentVerifyAddress.index("int", "code", "manual40"))),format.raw/*147.107*/("""">"""),_display_(Seq[Any](/*147.110*/Messages/*147.118*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*147.173*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*148.47*/routes/*148.53*/.ConsentVerifyAddress.index("int", "code", "automatic40"))),format.raw/*148.110*/("""">"""),_display_(Seq[Any](/*148.113*/Messages/*148.121*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*148.179*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*149.47*/routes/*149.53*/.ConsentPayment.login("int"))),format.raw/*149.81*/("""">"""),_display_(Seq[Any](/*149.84*/Messages/*149.92*/.get("section.consent.payment"))),format.raw/*149.123*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*150.47*/routes/*150.53*/.PaymentV2.index("int"))),format.raw/*150.76*/("""">"""),_display_(Seq[Any](/*150.79*/Messages/*150.87*/.get("section.consent.paymentv2"))),format.raw/*150.120*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*151.47*/routes/*151.53*/.Online3rdParty.index("int"))),format.raw/*151.81*/("""">"""),_display_(Seq[Any](/*151.84*/Messages/*151.92*/.get("section.consent.Online3rdParty"))),format.raw/*151.130*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*152.47*/routes/*152.53*/.Calling.index("int"))),format.raw/*152.74*/("""">"""),_display_(Seq[Any](/*152.77*/Messages/*152.85*/.get("section.consent.Call"))),format.raw/*152.113*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*153.47*/routes/*153.53*/.PaymentsFlowPartnerAgent.index("int"))),format.raw/*153.91*/("""">"""),_display_(Seq[Any](/*153.94*/Messages/*153.102*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*153.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*154.47*/routes/*154.53*/.PaymentsFlowSelfcare.index("int"))),format.raw/*154.87*/("""">"""),_display_(Seq[Any](/*154.90*/Messages/*154.98*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*154.142*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*155.47*/routes/*155.53*/.ConsentToken.index("int"))),format.raw/*155.79*/("""">"""),_display_(Seq[Any](/*155.82*/Messages/*155.90*/.get("section.consent.verifytokencreation"))),format.raw/*155.133*/("""</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href=""""),_display_(Seq[Any](/*159.39*/routes/*159.45*/.Application.consent("ext"))),format.raw/*159.72*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*159.122*/Messages/*159.130*/.get("section.consent"))),format.raw/*159.153*/("""
                                prod<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*162.47*/routes/*162.53*/.ConsentVerifyAddress.index("ext", "code", "manual"))),format.raw/*162.105*/("""">"""),_display_(Seq[Any](/*162.108*/Messages/*162.116*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*162.169*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*163.47*/routes/*163.53*/.ConsentVerifyAddress.index("ext", "code", "automatic"))),format.raw/*163.108*/("""">"""),_display_(Seq[Any](/*163.111*/Messages/*163.119*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*163.175*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*164.47*/routes/*164.53*/.ConsentVerifyAddress.index("ext", "token", "manual"))),format.raw/*164.106*/("""">"""),_display_(Seq[Any](/*164.109*/Messages/*164.117*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*164.170*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*165.47*/routes/*165.53*/.ConsentVerifyAddress.index("ext", "token", "automatic"))),format.raw/*165.109*/("""">"""),_display_(Seq[Any](/*165.112*/Messages/*165.120*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*165.176*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*166.47*/routes/*166.53*/.ConsentVerifyAddress.index("ext", "code", "manual40"))),format.raw/*166.107*/("""">"""),_display_(Seq[Any](/*166.110*/Messages/*166.118*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*166.173*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*167.47*/routes/*167.53*/.ConsentVerifyAddress.index("ext", "code", "automatic40"))),format.raw/*167.110*/("""">"""),_display_(Seq[Any](/*167.113*/Messages/*167.121*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*167.179*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*168.47*/routes/*168.53*/.ConsentPayment.login("ext"))),format.raw/*168.81*/("""">"""),_display_(Seq[Any](/*168.84*/Messages/*168.92*/.get("section.consent.payment"))),format.raw/*168.123*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*169.47*/routes/*169.53*/.PaymentV2.index("ext"))),format.raw/*169.76*/("""">"""),_display_(Seq[Any](/*169.79*/Messages/*169.87*/.get("section.consent.paymentv2"))),format.raw/*169.120*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*170.47*/routes/*170.53*/.Online3rdParty.index("ext"))),format.raw/*170.81*/("""">"""),_display_(Seq[Any](/*170.84*/Messages/*170.92*/.get("section.consent.Online3rdParty"))),format.raw/*170.130*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*171.47*/routes/*171.53*/.Calling.index("ext"))),format.raw/*171.74*/("""">"""),_display_(Seq[Any](/*171.77*/Messages/*171.85*/.get("section.consent.Call"))),format.raw/*171.113*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*172.47*/routes/*172.53*/.PaymentsFlowPartnerAgent.index("ext"))),format.raw/*172.91*/("""">"""),_display_(Seq[Any](/*172.94*/Messages/*172.102*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*172.150*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*173.47*/routes/*173.53*/.PaymentsFlowSelfcare.index("ext"))),format.raw/*173.87*/("""">"""),_display_(Seq[Any](/*173.90*/Messages/*173.98*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*173.142*/("""</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*174.47*/routes/*174.53*/.ConsentToken.index("ext"))),format.raw/*174.79*/("""">"""),_display_(Seq[Any](/*174.82*/Messages/*174.90*/.get("section.consent.verifytokencreation"))),format.raw/*174.133*/("""</a></li>
                            </ul>
                        </li>
                        """),_display_(Seq[Any](/*177.26*/if(request.host.equalsIgnoreCase("localhost:9000") || request.host.equalsIgnoreCase("127.0.0.1:9000"))/*177.128*/ {_display_(Seq[Any](format.raw/*177.130*/("""
                            <li class="dropdown">
                                <a href=""""),_display_(Seq[Any](/*179.43*/routes/*179.49*/.Application.consent("local"))),format.raw/*179.78*/("""" class="dropdown-toggle" data-toggle="dropdown">"""),_display_(Seq[Any](/*179.128*/Messages/*179.136*/.get("section.consent"))),format.raw/*179.159*/("""
                                    local<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href=""""),_display_(Seq[Any](/*182.51*/routes/*182.57*/.ConsentVerifyAddress.index("mock", "", "manual"))),format.raw/*182.106*/("""">"""),_display_(Seq[Any](/*182.109*/Messages/*182.117*/.get("section.consent.verifyaddress"))),format.raw/*182.154*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*183.51*/routes/*183.57*/.ConsentVerifyAddress.index("local", "code", "manual"))),format.raw/*183.111*/("""">"""),_display_(Seq[Any](/*183.114*/Messages/*183.122*/.get("section.consent.verifyaddress.manual.authcode"))),format.raw/*183.175*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*184.51*/routes/*184.57*/.ConsentVerifyAddress.index("local", "code", "automatic"))),format.raw/*184.114*/("""">"""),_display_(Seq[Any](/*184.117*/Messages/*184.125*/.get("section.consent.verifyaddress.automatic.authcode"))),format.raw/*184.181*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*185.51*/routes/*185.57*/.ConsentVerifyAddress.index("local", "token", "manual"))),format.raw/*185.112*/("""">"""),_display_(Seq[Any](/*185.115*/Messages/*185.123*/.get("section.consent.verifyaddress.manual.implicit"))),format.raw/*185.176*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*186.51*/routes/*186.57*/.ConsentVerifyAddress.index("local", "token", "automatic"))),format.raw/*186.115*/("""">"""),_display_(Seq[Any](/*186.118*/Messages/*186.126*/.get("section.consent.verifyaddress.automatic.implicit"))),format.raw/*186.182*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*187.51*/routes/*187.57*/.ConsentVerifyAddress.index("local", "code", "manual40"))),format.raw/*187.113*/("""">"""),_display_(Seq[Any](/*187.116*/Messages/*187.124*/.get("section.consent.verifyaddress.manual40.authcode"))),format.raw/*187.179*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*188.51*/routes/*188.57*/.ConsentVerifyAddress.index("local", "code", "automatic40"))),format.raw/*188.116*/("""">"""),_display_(Seq[Any](/*188.119*/Messages/*188.127*/.get("section.consent.verifyaddress.automatic40.authcode"))),format.raw/*188.185*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*189.51*/routes/*189.57*/.ConsentPayment.login("local"))),format.raw/*189.87*/("""">"""),_display_(Seq[Any](/*189.90*/Messages/*189.98*/.get("section.consent.payment"))),format.raw/*189.129*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*190.51*/routes/*190.57*/.PaymentV2.index("local"))),format.raw/*190.82*/("""">"""),_display_(Seq[Any](/*190.85*/Messages/*190.93*/.get("section.consent.paymentv2"))),format.raw/*190.126*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*191.51*/routes/*191.57*/.Online3rdParty.index("local"))),format.raw/*191.87*/("""">"""),_display_(Seq[Any](/*191.90*/Messages/*191.98*/.get("section.consent.Online3rdParty"))),format.raw/*191.136*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*192.51*/routes/*192.57*/.Calling.index("local"))),format.raw/*192.80*/("""">"""),_display_(Seq[Any](/*192.83*/Messages/*192.91*/.get("section.consent.Call"))),format.raw/*192.119*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*193.51*/routes/*193.57*/.PaymentsFlowPartnerAgent.index("local"))),format.raw/*193.97*/("""">"""),_display_(Seq[Any](/*193.100*/Messages/*193.108*/.get("section.consent.PaymentsFlowPartnerAgent"))),format.raw/*193.156*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*194.51*/routes/*194.57*/.PaymentsFlowSelfcare.index("local"))),format.raw/*194.93*/("""">"""),_display_(Seq[Any](/*194.96*/Messages/*194.104*/.get("section.consent.PaymentsFlowSelfcare"))),format.raw/*194.148*/("""</a></li>
                                    <li><a href=""""),_display_(Seq[Any](/*195.51*/routes/*195.57*/.ConsentToken.index("local"))),format.raw/*195.85*/("""">"""),_display_(Seq[Any](/*195.88*/Messages/*195.96*/.get("section.consent.verifytokencreation"))),format.raw/*195.139*/("""</a></li>
                                </ul>
                            </li>
                        """)))})),format.raw/*198.26*/("""
                    </ul>
                    <ul class="nav navbar-nav nav-pills pull-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Theme<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""""),_display_(Seq[Any](/*204.47*/routes/*204.53*/.Application.theme("default"))),format.raw/*204.82*/("""">default</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*205.47*/routes/*205.53*/.Application.theme("darky"))),format.raw/*205.80*/("""">darky</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*206.47*/routes/*206.53*/.Application.theme("united"))),format.raw/*206.81*/("""">united</a></li>
                                <li><a href=""""),_display_(Seq[Any](/*207.47*/routes/*207.53*/.Application.theme("cyborg"))),format.raw/*207.81*/("""">cyborg</a></li>
                            </ul>
                        </li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div><!--/.container -->
        </div><!-- div navigation -->

        <div class="container">

            <img src=""""),_display_(Seq[Any](/*217.24*/routes/*217.30*/.Assets.at("images/speedtest.png"))),format.raw/*217.64*/("""" width="150" />
            <br>
            <br>

            <span id="downloadGaugeContainer"></span>
            <span id="uploadGaugeContainer"></span>
            <br>
            <br>

            <p>
                <h4>This is the result WITH the Mobile Network Information API</h4>
            </p>

            <table class="table table-bordered">
                <tr><td colspan="3"><b>Swisscom</b></td></tr>
                <tr bgcolor="""),_display_(Seq[Any](/*232.30*/capacityForm("color")/*232.51*/.value)),format.raw/*232.57*/("""><td width="33%">Download Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*232.144*/capacityForm("downloadRate")/*232.172*/.value)),format.raw/*232.178*/("""</td><td><b>"""),_display_(Seq[Any](/*232.191*/capacityForm("downloadRatio")/*232.220*/.value)),format.raw/*232.226*/("""%</b> of expected Speed</td></tr>
                <tr bgcolor="""),_display_(Seq[Any](/*233.30*/capacityForm("color")/*233.51*/.value)),format.raw/*233.57*/("""><td width="33%">Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*233.142*/capacityForm("uploadRate")/*233.168*/.value)),format.raw/*233.174*/("""</td><td><b>"""),_display_(Seq[Any](/*233.187*/capacityForm("uploadRatio")/*233.214*/.value)),format.raw/*233.220*/("""%</b> of expected Speed</td></tr>
            </table>

            <p>
                <h4>This is what was expected from your subscription</h4>
            </p>

            <table class="table table-bordered">
                <tr><td width="33%">Download Speed (MBit/s)<br>Upload Speed (MBit/s)</td><td width="33%" style="text-align:right">"""),_display_(Seq[Any](/*241.132*/capacityForm("expectedDownload")/*241.164*/.value)),format.raw/*241.170*/("""<br>"""),_display_(Seq[Any](/*241.175*/capacityForm("expectedUpload")/*241.205*/.value)),format.raw/*241.211*/("""</td><td>Throttling Status: <b>"""),_display_(Seq[Any](/*241.243*/capacityForm("throttling")/*241.269*/.value)),format.raw/*241.275*/("""</b></td></tr>
            </table>

        </div>

    </body>

</html>

""")))})))}
    }
    
    def render(capacityForm:Form[CapacityInfo],error:Option[String],request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(capacityForm,error)(request)
    
    def f:((Form[CapacityInfo],Option[String]) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (capacityForm,error) => (request) => apply(capacityForm,error)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 16:09:52 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/mobile/capacity/gaugeWithAPI.scala.html
                    HASH: d3ba21946653ccf2ab2706e3f15205858aba6860
                    MATRIX: 652->1|934->123|962->191|998->193|1025->212|1064->214|1104->220|1139->247|1178->249|1277->320|1315->322|1329->327|1355->331|1384->332|1428->344|1448->347|1460->352|1498->353|1785->604|1800->610|1845->633|2121->873|2136->879|2192->913|2335->1029|2364->1030|2430->1068|2459->1069|2720->1302|2749->1303|2859->1385|2888->1386|2973->1443|3002->1444|3067->1481|3096->1482|3184->1542|3213->1543|3277->1579|3306->1580|3381->1627|3410->1628|3555->1746|3584->1747|3653->1789|3682->1790|3827->1908|3856->1909|3925->1951|3954->1952|4031->2001|4060->2002|4125->2039|4154->2040|4695->2553|4724->2554|4776->2578|4805->2579|5348->3094|5377->3095|5418->3108|5447->3109|5483->3118|5512->3119|5595->3175|5624->3176|5791->3316|5820->3317|5887->3357|5916->3358|6023->3438|6052->3439|6255->3606|6270->3612|6324->3644|6381->3665|6396->3671|6463->3716|6529->3746|6544->3752|6608->3794|6697->3847|6712->3853|6766->3885|6848->3932|6913->3988|6962->3999|7009->4009|7163->4152|7205->4154|7316->4228|7332->4234|7424->4302|7456->4315|7470->4320|7510->4321|7621->4395|7637->4401|7722->4462|7767->4474|7805->4480|8499->5137|8515->5143|8558->5163|8633->5201|8649->5207|8727->5262|9017->5515|9033->5521|9078->5543|9166->5593|9185->5601|9234->5626|9399->5754|9415->5760|9453->5775|9493->5778|9511->5786|9564->5815|9759->5973|9775->5979|9817->5998|9905->6048|9924->6056|9970->6078|10135->6206|10151->6212|10194->6232|10234->6235|10252->6243|10307->6274|10502->6432|10518->6438|10568->6465|10656->6515|10675->6523|10722->6546|10923->6710|10939->6716|11012->6765|11053->6768|11072->6776|11133->6813|11226->6869|11242->6875|11318->6927|11359->6930|11378->6938|11455->6991|11548->7047|11564->7053|11643->7108|11684->7111|11703->7119|11783->7175|11876->7231|11892->7237|11969->7290|12010->7293|12029->7301|12106->7354|12199->7410|12215->7416|12295->7472|12336->7475|12355->7483|12435->7539|12528->7595|12544->7601|12622->7655|12663->7658|12682->7666|12761->7721|12854->7777|12870->7783|12951->7840|12992->7843|13011->7851|13093->7909|13186->7965|13202->7971|13253->7999|13293->8002|13311->8010|13366->8041|13459->8097|13475->8103|13521->8126|13561->8129|13579->8137|13636->8170|13729->8226|13745->8232|13796->8260|13836->8263|13854->8271|13916->8309|14009->8365|14025->8371|14069->8392|14109->8395|14127->8403|14179->8431|14272->8487|14288->8493|14349->8531|14389->8534|14408->8542|14480->8590|14573->8646|14589->8652|14646->8686|14686->8689|14704->8697|14772->8741|14865->8797|14881->8803|14930->8829|14970->8832|14988->8840|15055->8883|15250->9041|15266->9047|15316->9074|15404->9124|15423->9132|15470->9155|15671->9319|15687->9325|15763->9377|15804->9380|15823->9388|15900->9441|15993->9497|16009->9503|16088->9558|16129->9561|16148->9569|16228->9625|16321->9681|16337->9687|16414->9740|16455->9743|16474->9751|16551->9804|16644->9860|16660->9866|16740->9922|16781->9925|16800->9933|16880->9989|16973->10045|16989->10051|17067->10105|17108->10108|17127->10116|17206->10171|17299->10227|17315->10233|17396->10290|17437->10293|17456->10301|17538->10359|17631->10415|17647->10421|17698->10449|17738->10452|17756->10460|17811->10491|17904->10547|17920->10553|17966->10576|18006->10579|18024->10587|18081->10620|18174->10676|18190->10682|18241->10710|18281->10713|18299->10721|18361->10759|18454->10815|18470->10821|18514->10842|18554->10845|18572->10853|18624->10881|18717->10937|18733->10943|18794->10981|18834->10984|18853->10992|18925->11040|19018->11096|19034->11102|19091->11136|19131->11139|19149->11147|19217->11191|19310->11247|19326->11253|19375->11279|19415->11282|19433->11290|19500->11333|19636->11432|19749->11534|19791->11536|19921->11629|19937->11635|19989->11664|20077->11714|20096->11722|20143->11745|20357->11922|20373->11928|20446->11977|20487->11980|20506->11988|20567->12025|20664->12085|20680->12091|20758->12145|20799->12148|20818->12156|20895->12209|20992->12269|21008->12275|21089->12332|21130->12335|21149->12343|21229->12399|21326->12459|21342->12465|21421->12520|21462->12523|21481->12531|21558->12584|21655->12644|21671->12650|21753->12708|21794->12711|21813->12719|21893->12775|21990->12835|22006->12841|22086->12897|22127->12900|22146->12908|22225->12963|22322->13023|22338->13029|22421->13088|22462->13091|22481->13099|22563->13157|22660->13217|22676->13223|22729->13253|22769->13256|22787->13264|22842->13295|22939->13355|22955->13361|23003->13386|23043->13389|23061->13397|23118->13430|23215->13490|23231->13496|23284->13526|23324->13529|23342->13537|23404->13575|23501->13635|23517->13641|23563->13664|23603->13667|23621->13675|23673->13703|23770->13763|23786->13769|23849->13809|23890->13812|23909->13820|23981->13868|24078->13928|24094->13934|24153->13970|24193->13973|24212->13981|24280->14025|24377->14085|24393->14091|24444->14119|24484->14122|24502->14130|24569->14173|24709->14280|25107->14641|25123->14647|25175->14676|25277->14741|25293->14747|25343->14774|25443->14837|25459->14843|25510->14871|25611->14935|25627->14941|25678->14969|26001->15255|26017->15261|26074->15295|26562->15746|26593->15767|26622->15773|26747->15860|26786->15888|26816->15894|26867->15907|26907->15936|26937->15942|27037->16005|27068->16026|27097->16032|27220->16117|27257->16143|27287->16149|27338->16162|27376->16189|27406->16195|27788->16539|27831->16571|27861->16577|27904->16582|27945->16612|27975->16618|28045->16650|28082->16676|28112->16682
                    LINES: 19->1|27->1|29->6|30->7|30->7|30->7|31->8|31->8|31->8|33->10|33->10|33->10|33->10|33->10|34->11|35->12|35->12|35->12|42->19|42->19|42->19|46->23|46->23|46->23|52->29|52->29|54->31|54->31|61->38|61->38|64->41|64->41|64->41|64->41|65->42|65->42|65->42|65->42|66->43|66->43|66->43|66->43|70->47|70->47|73->50|73->50|76->53|76->53|79->56|79->56|81->58|81->58|82->59|82->59|89->66|89->66|89->66|89->66|96->73|96->73|97->74|97->74|98->75|98->75|101->78|101->78|105->82|105->82|108->85|108->85|111->88|111->88|117->94|117->94|117->94|118->95|118->95|118->95|119->96|119->96|119->96|120->97|120->97|120->97|122->99|122->99|122->99|123->100|123->100|123->100|124->101|124->101|124->101|125->102|125->102|125->102|126->103|126->103|126->103|127->104|128->105|143->120|143->120|143->120|144->121|144->121|144->121|150->127|150->127|150->127|150->127|150->127|150->127|152->129|152->129|152->129|152->129|152->129|152->129|156->133|156->133|156->133|156->133|156->133|156->133|158->135|158->135|158->135|158->135|158->135|158->135|162->139|162->139|162->139|162->139|162->139|162->139|165->142|165->142|165->142|165->142|165->142|165->142|166->143|166->143|166->143|166->143|166->143|166->143|167->144|167->144|167->144|167->144|167->144|167->144|168->145|168->145|168->145|168->145|168->145|168->145|169->146|169->146|169->146|169->146|169->146|169->146|170->147|170->147|170->147|170->147|170->147|170->147|171->148|171->148|171->148|171->148|171->148|171->148|172->149|172->149|172->149|172->149|172->149|172->149|173->150|173->150|173->150|173->150|173->150|173->150|174->151|174->151|174->151|174->151|174->151|174->151|175->152|175->152|175->152|175->152|175->152|175->152|176->153|176->153|176->153|176->153|176->153|176->153|177->154|177->154|177->154|177->154|177->154|177->154|178->155|178->155|178->155|178->155|178->155|178->155|182->159|182->159|182->159|182->159|182->159|182->159|185->162|185->162|185->162|185->162|185->162|185->162|186->163|186->163|186->163|186->163|186->163|186->163|187->164|187->164|187->164|187->164|187->164|187->164|188->165|188->165|188->165|188->165|188->165|188->165|189->166|189->166|189->166|189->166|189->166|189->166|190->167|190->167|190->167|190->167|190->167|190->167|191->168|191->168|191->168|191->168|191->168|191->168|192->169|192->169|192->169|192->169|192->169|192->169|193->170|193->170|193->170|193->170|193->170|193->170|194->171|194->171|194->171|194->171|194->171|194->171|195->172|195->172|195->172|195->172|195->172|195->172|196->173|196->173|196->173|196->173|196->173|196->173|197->174|197->174|197->174|197->174|197->174|197->174|200->177|200->177|200->177|202->179|202->179|202->179|202->179|202->179|202->179|205->182|205->182|205->182|205->182|205->182|205->182|206->183|206->183|206->183|206->183|206->183|206->183|207->184|207->184|207->184|207->184|207->184|207->184|208->185|208->185|208->185|208->185|208->185|208->185|209->186|209->186|209->186|209->186|209->186|209->186|210->187|210->187|210->187|210->187|210->187|210->187|211->188|211->188|211->188|211->188|211->188|211->188|212->189|212->189|212->189|212->189|212->189|212->189|213->190|213->190|213->190|213->190|213->190|213->190|214->191|214->191|214->191|214->191|214->191|214->191|215->192|215->192|215->192|215->192|215->192|215->192|216->193|216->193|216->193|216->193|216->193|216->193|217->194|217->194|217->194|217->194|217->194|217->194|218->195|218->195|218->195|218->195|218->195|218->195|221->198|227->204|227->204|227->204|228->205|228->205|228->205|229->206|229->206|229->206|230->207|230->207|230->207|240->217|240->217|240->217|255->232|255->232|255->232|255->232|255->232|255->232|255->232|255->232|255->232|256->233|256->233|256->233|256->233|256->233|256->233|256->233|256->233|256->233|264->241|264->241|264->241|264->241|264->241|264->241|264->241|264->241|264->241
                    -- GENERATED --
                */
            