
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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,play.api.mvc.Request[play.api.mvc.AnyContent],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html)(implicit request: play.api.mvc.Request[play.api.mvc.AnyContent]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

import play.i18n.Messages

import controllers.Application


Seq[Any](format.raw/*1.97*/("""

"""),format.raw/*6.1*/("""
<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*11.17*/title)),format.raw/*11.22*/("""</title>
        <meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- <link rel="shortcut icon" href=""""),_display_(Seq[Any](/*14.41*/routes/*14.47*/.Assets.at("images/favicon.ico"))),format.raw/*14.79*/(""""> -->

      	<meta http-equiv="content-type" content="text/html; charset=UTF-8">

		<!-- Get by URL query -->
		"""),_display_(Seq[Any](/*19.4*/defining(request.session.get("theme").getOrElse("null"))/*19.60*/ { theme=>_display_(Seq[Any](format.raw/*19.70*/("""
			"""),_display_(Seq[Any](/*20.5*/if(theme.equalsIgnoreCase("demapi")
				|| theme.equalsIgnoreCase("darky")
				|| theme.equalsIgnoreCase("united")
				|| theme.equalsIgnoreCase("cyborg"))/*23.41*/{_display_(Seq[Any](format.raw/*23.42*/("""
	        	<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*24.72*/routes/*24.78*/.Assets.at("stylesheets/libs/bootstrap-"+theme+"-theme.min.css"))),format.raw/*24.142*/("""">
	        """)))}/*25.12*/else/*25.17*/{_display_(Seq[Any](format.raw/*25.18*/("""
	        	<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*26.72*/routes/*26.78*/.Assets.at("stylesheets/libs/bootstrap-demapi-theme.min.css"))),format.raw/*26.139*/("""">
	        """)))})),format.raw/*27.11*/("""
        """)))})),format.raw/*28.10*/("""

  		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

  		<!--[if lt IE 9]>
  			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
  		<![endif]-->
  		<link href=""""),_display_(Seq[Any](/*35.18*/routes/*35.24*/.Assets.at("stylesheets/styles.css"))),format.raw/*35.60*/("""" rel="stylesheet">
    </head>

    <body>
    <!-- Static navbar -->
     <body>
<nav class="navbar navbar-trans navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Gymix</a>
    </div>
    <div class="navbar-collapse collapse" id="navbar-collapsible">
      <ul class="nav navbar-nav navbar-left">
        <li><a href="#section1">Sport für Alle</a></li>
        <li><a href="#section2">Was ist Gymix?</a></li>
        <li><a href="#section3">Angebote</a></li>
        <li><a href="#section4">Kontakt</a></li>
        <li>&nbsp;</li>
      </ul>
    </div>
  </div>
</nav>

<section class="container-fluid" id="section1">
  	<h1 class="text-center v-center">Sport jederzeit, überall</h1>

  	<div class="container">
      <div class="row">
          <div class="col-sm-4">
            <div class="row">
              <div class="col-sm-10 col-sm-offset-2 text-center"><h3>Flexibel</h3>
                <p>Sport für Alle, volle Flexibilität: Entscheiden Sie selbst Wann, Wohin und zu Welcher Sportart Sie heute gehen möchten.</p><i class="fa fa-cloud fa-5x"></i></div>
            </div>
          </div>
          <div class="col-sm-4 text-center">
            <div class="row">
              <div class="col-sm-10 col-sm-offset-1 text-center"><h3>Einfach</h3><p>Ein einfaches und unkompliziertes Abonnement bei Gymix emöglicht Ihnen mehrere Sportclubs zu besuchen.</p><i class="fa fa-smile-o fa-5x"></i></div>
            </div>
          </div>
          <div class="col-sm-4 text-center">
            <div class="row">
              <div class="col-sm-10 text-center"><h3>Unverbindlich</h3><p>Ein unkomliziertes Abbonement Model gibt Ihnen die volle Freiheit. Kündigungfristen gehören der Vergangenheit an.</p><i class="fa fa-star fa-5x"></i></div>
            </div>
          </div>
      </div><!--/row-->
    <div class="row"><br></div>
  </div><!--/container-->
</section>

<section class="container-fluid" id="section2">
  <div class="row">
  	<div class="col-sm-8 col-sm-offset-2 text-center">
        <h1>Was ist Gymix?</h1>
        <br>
		<p class="lead">Gymix ist ein Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</p>
        <br>
      	<i style="font-size:120px" class="fa fa-cloud fa-5x"></i>
    </div>
  </div>
</section>

<!--
<section class="container-fluid" id="section3">
	<h1 class="text-center">Gymix macht Spass!</h1>
    <div class="row">
      <div class="col-sm-6 col-sm-offset-3">
        <h3 class="text-center">Vertical scrolling has become a popular and lasting trend in Web design.</h3>
        <div class="row">
          <div class="col-xs-4 col-xs-offset-1">Some brand-tacular designs even have home page content that is taller that 12,000 pixels. That's a lotta content.</div>
          <div class="col-xs-2"></div>
          <div class="col-xs-4 text-right">Anyhoo, this is just some random blurb of text, and Bootply.com is a playground and code editor for Bootstrap.</div>
        </div>
        <p class="text-center">
          <img src="/assets/example/img_mtnpeople.png" class="img-responsive center-block ">
        </p>
      </div>
   </div>
</section>

<section class="container-fluid" id="section4">
	<h2 class="text-center">Change this Content. Change the world.</h2>
    <div class="row">
      <div class="col-sm-8 col-sm-offset-2">
      <img src="/assets/example/bg_smartphones.jpg" class="img-responsive center-block ">
      <p class="text-center">Images will scale down proportionately as browser width narrows.</p>
      </div>
    </div>
</section>
-->
<section class="container-fluid" id="section5">
  <div class="col-sm-10 col-sm-offset-1">
    <div class="container">
    <div class="row">
      <div class="col-sm-4 col-xs-12">
            <div class="list-group">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Basic</h2>
                <h6>Free to get started</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 100 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 3 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 4</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-primary btn-lg btn-block">Get Started</button>
              </a>
            </div>
      </div><!--/left-->

      <div class="col-sm-4 col-xs-12">
            <div class="list-group text-center">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Better</h2>
                <h6>Most popular plan</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 200 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 5 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 6</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Feature</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-default btn-lg btn-block">$10 per month</button>
              </a>
            </div>
      </div><!--/middle-->

      <div class="col-sm-4 col-xs-12">
            <div class="list-group text-right">
              <a href="#" class="list-group-item active">
                <h2 class="list-group-item-heading">Best</h2>
                <h6>For enterprise grade</h6>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 100 - more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 2 - this is more about this</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 8 GB</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Option 10</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Unlimited</p>
              </a>
              <a href="#" class="list-group-item">
                <p class="list-group-item-text">Unlimited</p>
              </a>
              <a href="#" class="list-group-item">
                <button class="btn btn-default btn-lg btn-block">$20 per month</button>
              </a>
            </div>
      </div><!--/right-->

    </div><!--/row-->
    </div><!--/container-->
  </div>
</section>

<section class="container-fluid" id="section6">
	<h2 class="text-center">Do you see what I mean?</h2>
    <p class="text-center lead">Add some compelling information here</p>
    <!--<img src="/assets/example/bg_iphone.png" class="img-responsive center-block ">-->

</section>

<section class="container" id="section7">
	<h1 class="text-center">Social Media Fascination</h1>
    <div class="row">
      <!--fontawesome icons-->
      <div class="col-sm-1 col-sm-offset-2 col-xs-4 text-center">
       <i class="fa fa-github fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-foursquare fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       	<i class="fa fa-facebook fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-pinterest fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-google-plus fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-twitter fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-dribbble fa-4x"></i>
      </div>
      <div class="col-sm-1 col-xs-4 text-center">
       <i class="fa fa-instagram fa-4x"></i>
      </div>
  </div><!--/row-->
  <div class="row">
  	<div class="col-md-12 text-center">
      <br><br>
      <p>
    	<a href="#">subscribe now</a>
      </p>
    </div>
  </div>
</section>

<footer id="footer">
  <div class="container">
    <div class="row">
      <div class="col-xs-6 col-sm-6 col-md-3 column">
          <h4>Information</h4>
          <ul class="nav">
            <li><a href="about-us.html">Products</a></li>
            <li><a href="about-us.html">Services</a></li>
            <li><a href="about-us.html">Benefits</a></li>
            <li><a href="elements.html">Developers</a></li>
          </ul>
        </div>
      <div class="col-xs-6 col-md-3 column">
          <h4>Follow Us</h4>
          <ul class="nav">
            <li><a href="#">Twitter</a></li>
            <li><a href="#">Facebook</a></li>
            <li><a href="#">Google+</a></li>
            <li><a href="#">Pinterest</a></li>
          </ul>
      </div>
      <div class="col-xs-6 col-md-3 column">
          <h4>Contact Us</h4>
          <ul class="nav">
            <li><a href="#">Email</a></li>
            <li><a href="#">Headquarters</a></li>
            <li><a href="#">Management</a></li>
            <li><a href="#">Support</a></li>
          </ul>
      </div>
      <div class="col-xs-6 col-md-3 column">
          <h4>Customer Service</h4>
          <ul class="nav">
            <li><a href="#">About Us</a></li>
            <li><a href="#">Delivery Information</a></li>
            <li><a href="#">Privacy Policy</a></li>
            <li><a href="#">Terms &amp; Conditions</a></li>
          </ul>
      </div>
    </div><!--/row-->
  </div>
</footer>

	<!-- script references -->
		<script src=""""),_display_(Seq[Any](/*319.17*/routes/*319.23*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*319.65*/(""""></script>
      	<script type="text/javascript" src=""""),_display_(Seq[Any](/*320.45*/routes/*320.51*/.Assets.at("javascripts/jso.js"))),format.raw/*320.83*/(""""></script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src=""""),_display_(Seq[Any](/*322.17*/routes/*322.23*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*322.65*/(""""></script>
		<script src=""""),_display_(Seq[Any](/*323.17*/routes/*323.23*/.Assets.at("javascripts/scripts.js"))),format.raw/*323.59*/(""""></script>
	</body>
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html,request:play.api.mvc.Request[play.api.mvc.AnyContent]): play.api.templates.HtmlFormat.Appendable = apply(title)(content)(request)
    
    def f:((String) => (Html) => (play.api.mvc.Request[play.api.mvc.AnyContent]) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => (request) => apply(title)(content)(request)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Sep 06 19:29:32 CEST 2015
                    SOURCE: /Users/alex/workspace/sport/demapi/app/views/main.scala.html
                    HASH: 499afcbc97414c54ab3220b09a6e0e85cbb489e7
                    MATRIX: 606->1|870->96|898->174|986->226|1013->231|1217->399|1232->405|1286->437|1436->552|1501->608|1549->618|1589->623|1753->778|1792->779|1900->851|1915->857|2002->921|2034->935|2047->940|2086->941|2194->1013|2209->1019|2293->1080|2338->1093|2380->1103|2655->1342|2670->1348|2728->1384|14335->12954|14351->12960|14416->13002|14509->13058|14525->13064|14580->13096|14730->13209|14746->13215|14811->13257|14876->13285|14892->13291|14951->13327
                    LINES: 19->1|27->1|29->6|34->11|34->11|37->14|37->14|37->14|42->19|42->19|42->19|43->20|46->23|46->23|47->24|47->24|47->24|48->25|48->25|48->25|49->26|49->26|49->26|50->27|51->28|58->35|58->35|58->35|342->319|342->319|342->319|343->320|343->320|343->320|345->322|345->322|345->322|346->323|346->323|346->323
                    -- GENERATED --
                */
            