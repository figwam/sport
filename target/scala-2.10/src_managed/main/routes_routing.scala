// @SOURCE:/Users/alex/workspace/sport/demapi/conf/routes
// @HASH:cdfe309b41813797d347d20c1905321b58b2b4c7
// @DATE:Sun Sep 06 16:09:49 CEST 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:10
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:11
private[this] lazy val controllers_Application_theme1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("th/"),DynamicPart("theme", """[^/]+""",true))))
        

// @LINE:14
private[this] lazy val controllers_Application_login2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:15
private[this] lazy val controllers_Application_authenticate3 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:16
private[this] lazy val controllers_Application_logout4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:19
private[this] lazy val controllers_Assets_at5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:22
private[this] lazy val controllers_Application_consent6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent"))))
        

// @LINE:23
private[this] lazy val controllers_ConsentVerifyAddress_index7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/verifyaddress"))))
        

// @LINE:24
private[this] lazy val controllers_ConsentVerifyAddress_form8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/verifyaddress/form"))))
        

// @LINE:25
private[this] lazy val controllers_ConsentVerifyAddress_submit9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/verifyaddress/submit"))))
        

// @LINE:26
private[this] lazy val controllers_ConsentVerifyAddress_summary10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/verifyaddress/summary"))))
        

// @LINE:28
private[this] lazy val controllers_ConsentToken_index11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/tokenInfo"))))
        

// @LINE:29
private[this] lazy val controllers_ConsentToken_consentRedirect12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/tokenInfo/consentRedirect"))))
        

// @LINE:30
private[this] lazy val controllers_ConsentToken_consentCallbackResponseTypeCode13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/tokenInfo/consentCallback/code"))))
        

// @LINE:31
private[this] lazy val controllers_ConsentToken_consentCallbackResponseTypeToken14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/tokenInfo/consentCallback/token"))))
        

// @LINE:34
private[this] lazy val controllers_ConsentPayment_login15 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/payment/login"))))
        

// @LINE:35
private[this] lazy val controllers_ConsentPayment_index16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/payment/index"))))
        

// @LINE:36
private[this] lazy val controllers_ConsentPayment_reserve17 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/payment/reserve"))))
        

// @LINE:37
private[this] lazy val controllers_ConsentPayment_pay18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/payment/pay"))))
        

// @LINE:39
private[this] lazy val controllers_PaymentV2_index19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2"))))
        

// @LINE:40
private[this] lazy val controllers_PaymentV2_transactions20 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/transactions"))))
        

// @LINE:41
private[this] lazy val controllers_PaymentV2_transactionsselfcare21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/transactions/selfcare"))))
        

// @LINE:42
private[this] lazy val controllers_PaymentV2_transactionscallback22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/transactions/callback"))))
        

// @LINE:43
private[this] lazy val controllers_PaymentV2_transactionspartneragent23 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/transactions/partneragent"))))
        

// @LINE:44
private[this] lazy val controllers_PaymentV2_partneragentconsentRedirect24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/transactions/partneragentRedirect"))))
        

// @LINE:45
private[this] lazy val controllers_PaymentV2_pay25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay"))))
        

// @LINE:46
private[this] lazy val controllers_PaymentV2_payselfcare26 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay/selfcare"))))
        

// @LINE:47
private[this] lazy val controllers_PaymentV2_payselfcareStep227 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay/selfcare2"))))
        

// @LINE:48
private[this] lazy val controllers_PaymentV2_paypartneragent28 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay/partneragent"))))
        

// @LINE:49
private[this] lazy val controllers_PaymentV2_paypartneragentRedirect29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay/partneragentRedirect"))))
        

// @LINE:50
private[this] lazy val controllers_PaymentV2_paypartneragentApigeeCall30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/pay/partneragent"))))
        

// @LINE:51
private[this] lazy val controllers_PaymentV2_refund31 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentv2/refund"))))
        

// @LINE:54
private[this] lazy val controllers_Location_index32 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/location/"))))
        

// @LINE:55
private[this] lazy val controllers_Location_consentCallback33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/location/consentCallback"))))
        

// @LINE:56
private[this] lazy val controllers_Location_getDeviceLocation34 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/location/device/pull"))))
        

// @LINE:57
private[this] lazy val controllers_Location_getDeviceIndex35 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/location/devices"))))
        

// @LINE:60
private[this] lazy val controllers_Online3rdParty_index36 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/"))))
        

// @LINE:61
private[this] lazy val controllers_Online3rdParty_consentCallback37 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/consentCallback"))))
        

// @LINE:62
private[this] lazy val controllers_Online3rdParty_subscription38 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/subscription"))))
        

// @LINE:63
private[this] lazy val controllers_Online3rdParty_segment39 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/segment"))))
        

// @LINE:64
private[this] lazy val controllers_Online3rdParty_birthdate40 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/birthdate"))))
        

// @LINE:65
private[this] lazy val controllers_Online3rdParty_simcards41 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/simcards"))))
        

// @LINE:66
private[this] lazy val controllers_Online3rdParty_retention42 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/retention"))))
        

// @LINE:67
private[this] lazy val controllers_Online3rdParty_eligibility43 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/eligibility"))))
        

// @LINE:68
private[this] lazy val controllers_Online3rdParty_order44 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/online3rdparty/order"))))
        

// @LINE:71
private[this] lazy val controllers_PaymentsFlowPartnerAgent_index45 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowpartneragent"))))
        

// @LINE:72
private[this] lazy val controllers_PaymentsFlowPartnerAgent_consentRedirect46 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowpartneragent/consentRedirect"))))
        

// @LINE:73
private[this] lazy val controllers_PaymentsFlowPartnerAgent_consentCallback47 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowpartneragent/consentCallback"))))
        

// @LINE:75
private[this] lazy val controllers_PaymentsFlowSelfcare_index48 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowselfcare/"))))
        

// @LINE:76
private[this] lazy val controllers_PaymentsFlowSelfcare_consentCallback49 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowselfcare/consentCallback"))))
        

// @LINE:77
private[this] lazy val controllers_PaymentsFlowSelfcare_savePaymentAmount50 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/paymentsflowselfcare/saveAmount"))))
        

// @LINE:79
private[this] lazy val controllers_Calling_index51 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/call"))))
        

// @LINE:80
private[this] lazy val controllers_Calling_consetCallback52 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("consent/call/consentCallback"))))
        

// @LINE:83
private[this] lazy val controllers_Application_javascriptRoutes53 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("javascriptRoutes"))))
        

// @LINE:84
private[this] lazy val controllers_ConsentVerifyAddress_getOauthProviders54 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("javascript/oauth-providers.js"))))
        

// @LINE:87
private[this] lazy val controllers_Application_messaging55 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messaging"))))
        

// @LINE:88
private[this] lazy val controllers_SmsSender_form56 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messaging/sms"))))
        

// @LINE:89
private[this] lazy val controllers_SmsSender_send57 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("messaging/sms"))))
        

// @LINE:92
private[this] lazy val controllers_Application_mobile58 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile"))))
        

// @LINE:93
private[this] lazy val controllers_MobileCapacity_form59 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile/capacity"))))
        

// @LINE:94
private[this] lazy val controllers_MobileCapacity_withoutAPI60 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile/capacity/withoutAPI"))))
        

// @LINE:95
private[this] lazy val controllers_MobileCapacity_withAPI61 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile/capacity/withAPI"))))
        

// @LINE:96
private[this] lazy val controllers_MobileCapacity_gaucheWithAPI62 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile/capacity/gaucheWithAPI"))))
        

// @LINE:97
private[this] lazy val controllers_MobileCapacity_gaucheWithoutAPI63 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mobile/capacity/gaucheWithoutAPI"))))
        

// @LINE:100
private[this] lazy val controllers_Application_authenticateSwisscom64 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/authenticateSwisscom"))))
        

// @LINE:101
private[this] lazy val controllers_SSOMock_index65 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/sso"))))
        

// @LINE:102
private[this] lazy val controllers_SSOMock_indexTopLeft66 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/iframetopleft"))))
        

// @LINE:103
private[this] lazy val controllers_SSOMock_indexLeft67 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/iframeleft"))))
        

// @LINE:106
private[this] lazy val controllers_ConsentMock_index68 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/consent"))))
        

// @LINE:107
private[this] lazy val controllers_ConsentMock_submit69 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("mock/consent"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """th/$theme<[^/]+>""","""controllers.Application.theme(theme:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.authenticate"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent""","""controllers.Application.consent(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/verifyaddress""","""controllers.ConsentVerifyAddress.index(backend:String, response_type:String, app:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/verifyaddress/form""","""controllers.ConsentVerifyAddress.form"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/verifyaddress/submit""","""controllers.ConsentVerifyAddress.submit"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/verifyaddress/summary""","""controllers.ConsentVerifyAddress.summary(firstName:String, backend:String, response_type:String, app:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/tokenInfo""","""controllers.ConsentToken.index(backend:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/tokenInfo/consentRedirect""","""controllers.ConsentToken.consentRedirect(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/tokenInfo/consentCallback/code""","""controllers.ConsentToken.consentCallbackResponseTypeCode(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/tokenInfo/consentCallback/token""","""controllers.ConsentToken.consentCallbackResponseTypeToken(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/payment/login""","""controllers.ConsentPayment.login(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/payment/index""","""controllers.ConsentPayment.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/payment/reserve""","""controllers.ConsentPayment.reserve(token:String, amount:String, transaction_id:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/payment/pay""","""controllers.ConsentPayment.pay(token:String, amount:String, transaction_id:String, reserved:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2""","""controllers.PaymentV2.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/transactions""","""controllers.PaymentV2.transactions(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/transactions/selfcare""","""controllers.PaymentV2.transactionsselfcare(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/transactions/callback""","""controllers.PaymentV2.transactionscallback(backend:String, flow:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/transactions/partneragent""","""controllers.PaymentV2.transactionspartneragent(backend:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/transactions/partneragentRedirect""","""controllers.PaymentV2.partneragentconsentRedirect(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay""","""controllers.PaymentV2.pay(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay/selfcare""","""controllers.PaymentV2.payselfcare(backend:String, flow:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay/selfcare2""","""controllers.PaymentV2.payselfcareStep2(backend:String, flow:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay/partneragent""","""controllers.PaymentV2.paypartneragent(backend:String, flow:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay/partneragentRedirect""","""controllers.PaymentV2.paypartneragentRedirect(backend:String, flow:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/pay/partneragent""","""controllers.PaymentV2.paypartneragentApigeeCall(backend:String, flow:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentv2/refund""","""controllers.PaymentV2.refund(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/location/""","""controllers.Location.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/location/consentCallback""","""controllers.Location.consentCallback(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/location/device/pull""","""controllers.Location.getDeviceLocation(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/location/devices""","""controllers.Location.getDeviceIndex(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/""","""controllers.Online3rdParty.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/consentCallback""","""controllers.Online3rdParty.consentCallback(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/subscription""","""controllers.Online3rdParty.subscription(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/segment""","""controllers.Online3rdParty.segment(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/birthdate""","""controllers.Online3rdParty.birthdate(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/simcards""","""controllers.Online3rdParty.simcards(subscriptionKey:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/retention""","""controllers.Online3rdParty.retention(subscriptionKey:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/eligibility""","""controllers.Online3rdParty.eligibility(subscriptionKey:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/online3rdparty/order""","""controllers.Online3rdParty.order(subscriptionKey:String, backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowpartneragent""","""controllers.PaymentsFlowPartnerAgent.index(backend:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowpartneragent/consentRedirect""","""controllers.PaymentsFlowPartnerAgent.consentRedirect(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowpartneragent/consentCallback""","""controllers.PaymentsFlowPartnerAgent.consentCallback(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowselfcare/""","""controllers.PaymentsFlowSelfcare.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowselfcare/consentCallback""","""controllers.PaymentsFlowSelfcare.consentCallback(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/paymentsflowselfcare/saveAmount""","""controllers.PaymentsFlowSelfcare.savePaymentAmount()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/call""","""controllers.Calling.index(backend:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """consent/call/consentCallback""","""controllers.Calling.consetCallback()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascriptRoutes""","""controllers.Application.javascriptRoutes"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """javascript/oauth-providers.js""","""controllers.ConsentVerifyAddress.getOauthProviders(backend:String, app:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messaging""","""controllers.Application.messaging"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messaging/sms""","""controllers.SmsSender.form"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """messaging/sms""","""controllers.SmsSender.send"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile""","""controllers.Application.mobile"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile/capacity""","""controllers.MobileCapacity.form"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile/capacity/withoutAPI""","""controllers.MobileCapacity.withoutAPI"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile/capacity/withAPI""","""controllers.MobileCapacity.withAPI"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile/capacity/gaucheWithAPI""","""controllers.MobileCapacity.gaucheWithAPI"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mobile/capacity/gaucheWithoutAPI""","""controllers.MobileCapacity.gaucheWithoutAPI"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/authenticateSwisscom""","""controllers.Application.authenticateSwisscom"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/sso""","""controllers.SSOMock.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/iframetopleft""","""controllers.SSOMock.indexTopLeft"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/iframeleft""","""controllers.SSOMock.indexLeft"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/consent""","""controllers.ConsentMock.index"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """mock/consent""","""controllers.ConsentMock.submit""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:10
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:11
case controllers_Application_theme1(params) => {
   call(params.fromPath[String]("theme", None)) { (theme) =>
        invokeHandler(controllers.Application.theme(theme), HandlerDef(this, "controllers.Application", "theme", Seq(classOf[String]),"GET", """""", Routes.prefix + """th/$theme<[^/]+>"""))
   }
}
        

// @LINE:14
case controllers_Application_login2(params) => {
   call { 
        invokeHandler(controllers.Application.login, HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ Authentication""", Routes.prefix + """login"""))
   }
}
        

// @LINE:15
case controllers_Application_authenticate3(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate, HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """login"""))
   }
}
        

// @LINE:16
case controllers_Application_logout4(params) => {
   call { 
        invokeHandler(controllers.Application.logout, HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:19
case controllers_Assets_at5(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:22
case controllers_Application_consent6(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Application.consent(backend), HandlerDef(this, "controllers.Application", "consent", Seq(classOf[String]),"GET", """Consent""", Routes.prefix + """consent"""))
   }
}
        

// @LINE:23
case controllers_ConsentVerifyAddress_index7(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("response_type", None), params.fromQuery[String]("app", None)) { (backend, response_type, app) =>
        invokeHandler(controllers.ConsentVerifyAddress.index(backend, response_type, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "index", Seq(classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/verifyaddress"""))
   }
}
        

// @LINE:24
case controllers_ConsentVerifyAddress_form8(params) => {
   call { 
        invokeHandler(controllers.ConsentVerifyAddress.form, HandlerDef(this, "controllers.ConsentVerifyAddress", "form", Nil,"GET", """""", Routes.prefix + """consent/verifyaddress/form"""))
   }
}
        

// @LINE:25
case controllers_ConsentVerifyAddress_submit9(params) => {
   call { 
        invokeHandler(controllers.ConsentVerifyAddress.submit, HandlerDef(this, "controllers.ConsentVerifyAddress", "submit", Nil,"POST", """""", Routes.prefix + """consent/verifyaddress/submit"""))
   }
}
        

// @LINE:26
case controllers_ConsentVerifyAddress_summary10(params) => {
   call(params.fromQuery[String]("firstName", None), params.fromQuery[String]("backend", None), params.fromQuery[String]("response_type", None), params.fromQuery[String]("app", None)) { (firstName, backend, response_type, app) =>
        invokeHandler(controllers.ConsentVerifyAddress.summary(firstName, backend, response_type, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "summary", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/verifyaddress/summary"""))
   }
}
        

// @LINE:28
case controllers_ConsentToken_index11(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentToken.index(backend), HandlerDef(this, "controllers.ConsentToken", "index", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/tokenInfo"""))
   }
}
        

// @LINE:29
case controllers_ConsentToken_consentRedirect12(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentToken.consentRedirect(backend), HandlerDef(this, "controllers.ConsentToken", "consentRedirect", Seq(classOf[String]),"POST", """""", Routes.prefix + """consent/tokenInfo/consentRedirect"""))
   }
}
        

// @LINE:30
case controllers_ConsentToken_consentCallbackResponseTypeCode13(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentToken.consentCallbackResponseTypeCode(backend), HandlerDef(this, "controllers.ConsentToken", "consentCallbackResponseTypeCode", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/tokenInfo/consentCallback/code"""))
   }
}
        

// @LINE:31
case controllers_ConsentToken_consentCallbackResponseTypeToken14(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentToken.consentCallbackResponseTypeToken(backend), HandlerDef(this, "controllers.ConsentToken", "consentCallbackResponseTypeToken", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/tokenInfo/consentCallback/token"""))
   }
}
        

// @LINE:34
case controllers_ConsentPayment_login15(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentPayment.login(backend), HandlerDef(this, "controllers.ConsentPayment", "login", Seq(classOf[String]),"GET", """Consent payment""", Routes.prefix + """consent/payment/login"""))
   }
}
        

// @LINE:35
case controllers_ConsentPayment_index16(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.ConsentPayment.index(backend), HandlerDef(this, "controllers.ConsentPayment", "index", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/payment/index"""))
   }
}
        

// @LINE:36
case controllers_ConsentPayment_reserve17(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[String]("amount", None), params.fromQuery[String]("transaction_id", None), params.fromQuery[String]("backend", None)) { (token, amount, transaction_id, backend) =>
        invokeHandler(controllers.ConsentPayment.reserve(token, amount, transaction_id, backend), HandlerDef(this, "controllers.ConsentPayment", "reserve", Seq(classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/payment/reserve"""))
   }
}
        

// @LINE:37
case controllers_ConsentPayment_pay18(params) => {
   call(params.fromQuery[String]("token", None), params.fromQuery[String]("amount", None), params.fromQuery[String]("transaction_id", None), params.fromQuery[String]("reserved", None), params.fromQuery[String]("backend", None)) { (token, amount, transaction_id, reserved, backend) =>
        invokeHandler(controllers.ConsentPayment.pay(token, amount, transaction_id, reserved, backend), HandlerDef(this, "controllers.ConsentPayment", "pay", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/payment/pay"""))
   }
}
        

// @LINE:39
case controllers_PaymentV2_index19(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.index(backend), HandlerDef(this, "controllers.PaymentV2", "index", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2"""))
   }
}
        

// @LINE:40
case controllers_PaymentV2_transactions20(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.transactions(backend), HandlerDef(this, "controllers.PaymentV2", "transactions", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/transactions"""))
   }
}
        

// @LINE:41
case controllers_PaymentV2_transactionsselfcare21(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.transactionsselfcare(backend), HandlerDef(this, "controllers.PaymentV2", "transactionsselfcare", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/transactions/selfcare"""))
   }
}
        

// @LINE:42
case controllers_PaymentV2_transactionscallback22(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.transactionscallback(backend, flow), HandlerDef(this, "controllers.PaymentV2", "transactionscallback", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/transactions/callback"""))
   }
}
        

// @LINE:43
case controllers_PaymentV2_transactionspartneragent23(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.transactionspartneragent(backend), HandlerDef(this, "controllers.PaymentV2", "transactionspartneragent", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/transactions/partneragent"""))
   }
}
        

// @LINE:44
case controllers_PaymentV2_partneragentconsentRedirect24(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.partneragentconsentRedirect(backend), HandlerDef(this, "controllers.PaymentV2", "partneragentconsentRedirect", Seq(classOf[String]),"POST", """""", Routes.prefix + """consent/paymentv2/transactions/partneragentRedirect"""))
   }
}
        

// @LINE:45
case controllers_PaymentV2_pay25(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.pay(backend), HandlerDef(this, "controllers.PaymentV2", "pay", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/pay"""))
   }
}
        

// @LINE:46
case controllers_PaymentV2_payselfcare26(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.payselfcare(backend, flow), HandlerDef(this, "controllers.PaymentV2", "payselfcare", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/pay/selfcare"""))
   }
}
        

// @LINE:47
case controllers_PaymentV2_payselfcareStep227(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.payselfcareStep2(backend, flow), HandlerDef(this, "controllers.PaymentV2", "payselfcareStep2", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """consent/paymentv2/pay/selfcare2"""))
   }
}
        

// @LINE:48
case controllers_PaymentV2_paypartneragent28(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.paypartneragent(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragent", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/pay/partneragent"""))
   }
}
        

// @LINE:49
case controllers_PaymentV2_paypartneragentRedirect29(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.paypartneragentRedirect(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragentRedirect", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """consent/paymentv2/pay/partneragentRedirect"""))
   }
}
        

// @LINE:50
case controllers_PaymentV2_paypartneragentApigeeCall30(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("flow", None)) { (backend, flow) =>
        invokeHandler(controllers.PaymentV2.paypartneragentApigeeCall(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragentApigeeCall", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """consent/paymentv2/pay/partneragent"""))
   }
}
        

// @LINE:51
case controllers_PaymentV2_refund31(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentV2.refund(backend), HandlerDef(this, "controllers.PaymentV2", "refund", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentv2/refund"""))
   }
}
        

// @LINE:54
case controllers_Location_index32(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Location.index(backend), HandlerDef(this, "controllers.Location", "index", Seq(classOf[String]),"GET", """Consent Location""", Routes.prefix + """consent/location/"""))
   }
}
        

// @LINE:55
case controllers_Location_consentCallback33(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Location.consentCallback(backend), HandlerDef(this, "controllers.Location", "consentCallback", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/location/consentCallback"""))
   }
}
        

// @LINE:56
case controllers_Location_getDeviceLocation34(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Location.getDeviceLocation(backend), HandlerDef(this, "controllers.Location", "getDeviceLocation", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/location/device/pull"""))
   }
}
        

// @LINE:57
case controllers_Location_getDeviceIndex35(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Location.getDeviceIndex(backend), HandlerDef(this, "controllers.Location", "getDeviceIndex", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/location/devices"""))
   }
}
        

// @LINE:60
case controllers_Online3rdParty_index36(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Online3rdParty.index(backend), HandlerDef(this, "controllers.Online3rdParty", "index", Seq(classOf[String]),"GET", """Consent payment""", Routes.prefix + """consent/online3rdparty/"""))
   }
}
        

// @LINE:61
case controllers_Online3rdParty_consentCallback37(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Online3rdParty.consentCallback(backend), HandlerDef(this, "controllers.Online3rdParty", "consentCallback", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/consentCallback"""))
   }
}
        

// @LINE:62
case controllers_Online3rdParty_subscription38(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Online3rdParty.subscription(backend), HandlerDef(this, "controllers.Online3rdParty", "subscription", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/subscription"""))
   }
}
        

// @LINE:63
case controllers_Online3rdParty_segment39(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Online3rdParty.segment(backend), HandlerDef(this, "controllers.Online3rdParty", "segment", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/segment"""))
   }
}
        

// @LINE:64
case controllers_Online3rdParty_birthdate40(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Online3rdParty.birthdate(backend), HandlerDef(this, "controllers.Online3rdParty", "birthdate", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/birthdate"""))
   }
}
        

// @LINE:65
case controllers_Online3rdParty_simcards41(params) => {
   call(params.fromQuery[String]("subscriptionKey", None), params.fromQuery[String]("backend", None)) { (subscriptionKey, backend) =>
        invokeHandler(controllers.Online3rdParty.simcards(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "simcards", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/simcards"""))
   }
}
        

// @LINE:66
case controllers_Online3rdParty_retention42(params) => {
   call(params.fromQuery[String]("subscriptionKey", None), params.fromQuery[String]("backend", None)) { (subscriptionKey, backend) =>
        invokeHandler(controllers.Online3rdParty.retention(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "retention", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/retention"""))
   }
}
        

// @LINE:67
case controllers_Online3rdParty_eligibility43(params) => {
   call(params.fromQuery[String]("subscriptionKey", None), params.fromQuery[String]("backend", None)) { (subscriptionKey, backend) =>
        invokeHandler(controllers.Online3rdParty.eligibility(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "eligibility", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/eligibility"""))
   }
}
        

// @LINE:68
case controllers_Online3rdParty_order44(params) => {
   call(params.fromQuery[String]("subscriptionKey", None), params.fromQuery[String]("backend", None)) { (subscriptionKey, backend) =>
        invokeHandler(controllers.Online3rdParty.order(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "order", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """consent/online3rdparty/order"""))
   }
}
        

// @LINE:71
case controllers_PaymentsFlowPartnerAgent_index45(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentsFlowPartnerAgent.index(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "index", Seq(classOf[String]),"GET", """Consent paymenets flows. 2015-02-16 Amancio""", Routes.prefix + """consent/paymentsflowpartneragent"""))
   }
}
        

// @LINE:72
case controllers_PaymentsFlowPartnerAgent_consentRedirect46(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentsFlowPartnerAgent.consentRedirect(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "consentRedirect", Seq(classOf[String]),"POST", """""", Routes.prefix + """consent/paymentsflowpartneragent/consentRedirect"""))
   }
}
        

// @LINE:73
case controllers_PaymentsFlowPartnerAgent_consentCallback47(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentsFlowPartnerAgent.consentCallback(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "consentCallback", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentsflowpartneragent/consentCallback"""))
   }
}
        

// @LINE:75
case controllers_PaymentsFlowSelfcare_index48(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentsFlowSelfcare.index(backend), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "index", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentsflowselfcare/"""))
   }
}
        

// @LINE:76
case controllers_PaymentsFlowSelfcare_consentCallback49(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.PaymentsFlowSelfcare.consentCallback(backend), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "consentCallback", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/paymentsflowselfcare/consentCallback"""))
   }
}
        

// @LINE:77
case controllers_PaymentsFlowSelfcare_savePaymentAmount50(params) => {
   call { 
        invokeHandler(controllers.PaymentsFlowSelfcare.savePaymentAmount(), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "savePaymentAmount", Nil,"GET", """""", Routes.prefix + """consent/paymentsflowselfcare/saveAmount"""))
   }
}
        

// @LINE:79
case controllers_Calling_index51(params) => {
   call(params.fromQuery[String]("backend", None)) { (backend) =>
        invokeHandler(controllers.Calling.index(backend), HandlerDef(this, "controllers.Calling", "index", Seq(classOf[String]),"GET", """""", Routes.prefix + """consent/call"""))
   }
}
        

// @LINE:80
case controllers_Calling_consetCallback52(params) => {
   call { 
        invokeHandler(controllers.Calling.consetCallback(), HandlerDef(this, "controllers.Calling", "consetCallback", Nil,"GET", """""", Routes.prefix + """consent/call/consentCallback"""))
   }
}
        

// @LINE:83
case controllers_Application_javascriptRoutes53(params) => {
   call { 
        invokeHandler(controllers.Application.javascriptRoutes, HandlerDef(this, "controllers.Application", "javascriptRoutes", Nil,"GET", """Implicit OAuth Ajax""", Routes.prefix + """javascriptRoutes"""))
   }
}
        

// @LINE:84
case controllers_ConsentVerifyAddress_getOauthProviders54(params) => {
   call(params.fromQuery[String]("backend", None), params.fromQuery[String]("app", None)) { (backend, app) =>
        invokeHandler(controllers.ConsentVerifyAddress.getOauthProviders(backend, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "getOauthProviders", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """javascript/oauth-providers.js"""))
   }
}
        

// @LINE:87
case controllers_Application_messaging55(params) => {
   call { 
        invokeHandler(controllers.Application.messaging, HandlerDef(this, "controllers.Application", "messaging", Nil,"GET", """Messaging""", Routes.prefix + """messaging"""))
   }
}
        

// @LINE:88
case controllers_SmsSender_form56(params) => {
   call { 
        invokeHandler(controllers.SmsSender.form, HandlerDef(this, "controllers.SmsSender", "form", Nil,"GET", """""", Routes.prefix + """messaging/sms"""))
   }
}
        

// @LINE:89
case controllers_SmsSender_send57(params) => {
   call { 
        invokeHandler(controllers.SmsSender.send, HandlerDef(this, "controllers.SmsSender", "send", Nil,"POST", """""", Routes.prefix + """messaging/sms"""))
   }
}
        

// @LINE:92
case controllers_Application_mobile58(params) => {
   call { 
        invokeHandler(controllers.Application.mobile, HandlerDef(this, "controllers.Application", "mobile", Nil,"GET", """Mobile""", Routes.prefix + """mobile"""))
   }
}
        

// @LINE:93
case controllers_MobileCapacity_form59(params) => {
   call { 
        invokeHandler(controllers.MobileCapacity.form, HandlerDef(this, "controllers.MobileCapacity", "form", Nil,"GET", """""", Routes.prefix + """mobile/capacity"""))
   }
}
        

// @LINE:94
case controllers_MobileCapacity_withoutAPI60(params) => {
   call { 
        invokeHandler(controllers.MobileCapacity.withoutAPI, HandlerDef(this, "controllers.MobileCapacity", "withoutAPI", Nil,"GET", """""", Routes.prefix + """mobile/capacity/withoutAPI"""))
   }
}
        

// @LINE:95
case controllers_MobileCapacity_withAPI61(params) => {
   call { 
        invokeHandler(controllers.MobileCapacity.withAPI, HandlerDef(this, "controllers.MobileCapacity", "withAPI", Nil,"GET", """""", Routes.prefix + """mobile/capacity/withAPI"""))
   }
}
        

// @LINE:96
case controllers_MobileCapacity_gaucheWithAPI62(params) => {
   call { 
        invokeHandler(controllers.MobileCapacity.gaucheWithAPI, HandlerDef(this, "controllers.MobileCapacity", "gaucheWithAPI", Nil,"GET", """""", Routes.prefix + """mobile/capacity/gaucheWithAPI"""))
   }
}
        

// @LINE:97
case controllers_MobileCapacity_gaucheWithoutAPI63(params) => {
   call { 
        invokeHandler(controllers.MobileCapacity.gaucheWithoutAPI, HandlerDef(this, "controllers.MobileCapacity", "gaucheWithoutAPI", Nil,"GET", """""", Routes.prefix + """mobile/capacity/gaucheWithoutAPI"""))
   }
}
        

// @LINE:100
case controllers_Application_authenticateSwisscom64(params) => {
   call { 
        invokeHandler(controllers.Application.authenticateSwisscom, HandlerDef(this, "controllers.Application", "authenticateSwisscom", Nil,"GET", """ SSO Mock""", Routes.prefix + """mock/authenticateSwisscom"""))
   }
}
        

// @LINE:101
case controllers_SSOMock_index65(params) => {
   call { 
        invokeHandler(controllers.SSOMock.index, HandlerDef(this, "controllers.SSOMock", "index", Nil,"GET", """""", Routes.prefix + """mock/sso"""))
   }
}
        

// @LINE:102
case controllers_SSOMock_indexTopLeft66(params) => {
   call { 
        invokeHandler(controllers.SSOMock.indexTopLeft, HandlerDef(this, "controllers.SSOMock", "indexTopLeft", Nil,"GET", """""", Routes.prefix + """mock/iframetopleft"""))
   }
}
        

// @LINE:103
case controllers_SSOMock_indexLeft67(params) => {
   call { 
        invokeHandler(controllers.SSOMock.indexLeft, HandlerDef(this, "controllers.SSOMock", "indexLeft", Nil,"GET", """""", Routes.prefix + """mock/iframeleft"""))
   }
}
        

// @LINE:106
case controllers_ConsentMock_index68(params) => {
   call { 
        invokeHandler(controllers.ConsentMock.index, HandlerDef(this, "controllers.ConsentMock", "index", Nil,"GET", """ Consent Mock""", Routes.prefix + """mock/consent"""))
   }
}
        

// @LINE:107
case controllers_ConsentMock_submit69(params) => {
   call { 
        invokeHandler(controllers.ConsentMock.submit, HandlerDef(this, "controllers.ConsentMock", "submit", Nil,"POST", """""", Routes.prefix + """mock/consent"""))
   }
}
        
}

}
     