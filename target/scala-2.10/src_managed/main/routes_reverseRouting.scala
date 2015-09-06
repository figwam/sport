// @SOURCE:/Users/alex/workspace/sport/demapi/conf/routes
// @HASH:cdfe309b41813797d347d20c1905321b58b2b4c7
// @DATE:Sun Sep 06 16:09:49 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:107
// @LINE:106
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:84
// @LINE:83
// @LINE:80
// @LINE:79
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
package controllers {

// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
class ReverseLocation {
    

// @LINE:56
def getDeviceLocation(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/location/device/pull" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:57
def getDeviceIndex(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/location/devices" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:54
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/location/" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:55
def consentCallback(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/location/consentCallback" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:73
// @LINE:72
// @LINE:71
class ReversePaymentsFlowPartnerAgent {
    

// @LINE:72
def consentRedirect(backend:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/paymentsflowpartneragent/consentRedirect" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:71
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentsflowpartneragent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:73
def consentCallback(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentsflowpartneragent/consentCallback" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:80
// @LINE:79
class ReverseCalling {
    

// @LINE:80
def consetCallback(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/call/consentCallback")
}
                                                

// @LINE:79
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/call" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseConsentToken {
    

// @LINE:30
def consentCallbackResponseTypeCode(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/tokenInfo/consentCallback/code" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:31
def consentCallbackResponseTypeToken(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/tokenInfo/consentCallback/token" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:29
def consentRedirect(backend:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/tokenInfo/consentRedirect" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:28
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/tokenInfo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
class ReverseMobileCapacity {
    

// @LINE:96
def gaucheWithAPI(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile/capacity/gaucheWithAPI")
}
                                                

// @LINE:95
def withAPI(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile/capacity/withAPI")
}
                                                

// @LINE:93
def form(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile/capacity")
}
                                                

// @LINE:97
def gaucheWithoutAPI(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile/capacity/gaucheWithoutAPI")
}
                                                

// @LINE:94
def withoutAPI(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile/capacity/withoutAPI")
}
                                                
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseConsentPayment {
    

// @LINE:36
def reserve(token:String, amount:String, transaction_id:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/payment/reserve" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[String]].unbind("amount", amount)), Some(implicitly[QueryStringBindable[String]].unbind("transaction_id", transaction_id)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:34
def login(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/payment/login" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:37
def pay(token:String, amount:String, transaction_id:String, reserved:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/payment/pay" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("token", token)), Some(implicitly[QueryStringBindable[String]].unbind("amount", amount)), Some(implicitly[QueryStringBindable[String]].unbind("transaction_id", transaction_id)), Some(implicitly[QueryStringBindable[String]].unbind("reserved", reserved)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:35
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/payment/index" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReversePaymentV2 {
    

// @LINE:39
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:48
def paypartneragent(backend:String, flow:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/pay/partneragent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                

// @LINE:46
def payselfcare(backend:String, flow:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/pay/selfcare" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                

// @LINE:44
def partneragentconsentRedirect(backend:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/paymentv2/transactions/partneragentRedirect" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:43
def transactionspartneragent(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/transactions/partneragent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:45
def pay(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/pay" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:51
def refund(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/refund" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:41
def transactionsselfcare(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/transactions/selfcare" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:47
def payselfcareStep2(backend:String, flow:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/paymentv2/pay/selfcare2" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                

// @LINE:40
def transactions(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/transactions" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:49
def paypartneragentRedirect(backend:String, flow:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/paymentv2/pay/partneragentRedirect" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                

// @LINE:50
def paypartneragentApigeeCall(backend:String, flow:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/paymentv2/pay/partneragent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                

// @LINE:42
def transactionscallback(backend:String, flow:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentv2/transactions/callback" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("flow", flow)))))
}
                                                
    
}
                          

// @LINE:103
// @LINE:102
// @LINE:101
class ReverseSSOMock {
    

// @LINE:103
def indexLeft(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mock/iframeleft")
}
                                                

// @LINE:101
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mock/sso")
}
                                                

// @LINE:102
def indexTopLeft(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mock/iframetopleft")
}
                                                
    
}
                          

// @LINE:89
// @LINE:88
class ReverseSmsSender {
    

// @LINE:89
def send(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "messaging/sms")
}
                                                

// @LINE:88
def form(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "messaging/sms")
}
                                                
    
}
                          

// @LINE:77
// @LINE:76
// @LINE:75
class ReversePaymentsFlowSelfcare {
    

// @LINE:77
def savePaymentAmount(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentsflowselfcare/saveAmount")
}
                                                

// @LINE:75
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentsflowselfcare/" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:76
def consentCallback(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/paymentsflowselfcare/consentCallback" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:100
// @LINE:92
// @LINE:87
// @LINE:83
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:92
def mobile(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mobile")
}
                                                

// @LINE:22
def consent(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:11
def theme(theme:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "th/" + implicitly[PathBindable[String]].unbind("theme", dynamicString(theme)))
}
                                                

// @LINE:87
def messaging(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "messaging")
}
                                                

// @LINE:16
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:100
def authenticateSwisscom(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mock/authenticateSwisscom")
}
                                                

// @LINE:15
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:10
def index(): Call = {
   Call("GET", _prefix)
}
                                                

// @LINE:83
def javascriptRoutes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "javascriptRoutes")
}
                                                

// @LINE:14
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
class ReverseOnline3rdParty {
    

// @LINE:60
def index(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:65
def simcards(subscriptionKey:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/simcards" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("subscriptionKey", subscriptionKey)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:63
def segment(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/segment" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:66
def retention(subscriptionKey:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/retention" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("subscriptionKey", subscriptionKey)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:68
def order(subscriptionKey:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/order" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("subscriptionKey", subscriptionKey)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:64
def birthdate(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/birthdate" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:67
def eligibility(subscriptionKey:String, backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/eligibility" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("subscriptionKey", subscriptionKey)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:61
def consentCallback(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/consentCallback" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                

// @LINE:62
def subscription(backend:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/online3rdparty/subscription" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)))))
}
                                                
    
}
                          

// @LINE:84
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseConsentVerifyAddress {
    

// @LINE:84
def getOauthProviders(backend:String, app:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "javascript/oauth-providers.js" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("app", app)))))
}
                                                

// @LINE:25
def submit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "consent/verifyaddress/submit")
}
                                                

// @LINE:24
def form(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/verifyaddress/form")
}
                                                

// @LINE:26
def summary(firstName:String, backend:String, response_type:String, app:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/verifyaddress/summary" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("firstName", firstName)), Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("response_type", response_type)), Some(implicitly[QueryStringBindable[String]].unbind("app", app)))))
}
                                                

// @LINE:23
def index(backend:String, response_type:String, app:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "consent/verifyaddress" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("backend", backend)), Some(implicitly[QueryStringBindable[String]].unbind("response_type", response_type)), Some(implicitly[QueryStringBindable[String]].unbind("app", app)))))
}
                                                
    
}
                          

// @LINE:107
// @LINE:106
class ReverseConsentMock {
    

// @LINE:106
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "mock/consent")
}
                                                

// @LINE:107
def submit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "mock/consent")
}
                                                
    
}
                          
}
                  


// @LINE:107
// @LINE:106
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:84
// @LINE:83
// @LINE:80
// @LINE:79
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
package controllers.javascript {

// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
class ReverseLocation {
    

// @LINE:56
def getDeviceLocation : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Location.getDeviceLocation",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/location/device/pull" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:57
def getDeviceIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Location.getDeviceIndex",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/location/devices" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:54
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Location.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/location/" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:55
def consentCallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Location.consentCallback",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/location/consentCallback" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:73
// @LINE:72
// @LINE:71
class ReversePaymentsFlowPartnerAgent {
    

// @LINE:72
def consentRedirect : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowPartnerAgent.consentRedirect",
   """
      function(backend) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowpartneragent/consentRedirect" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:71
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowPartnerAgent.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowpartneragent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:73
def consentCallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowPartnerAgent.consentCallback",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowpartneragent/consentCallback" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:80
// @LINE:79
class ReverseCalling {
    

// @LINE:80
def consetCallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Calling.consetCallback",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/call/consentCallback"})
      }
   """
)
                        

// @LINE:79
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Calling.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/call" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseConsentToken {
    

// @LINE:30
def consentCallbackResponseTypeCode : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentToken.consentCallbackResponseTypeCode",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/tokenInfo/consentCallback/code" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:31
def consentCallbackResponseTypeToken : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentToken.consentCallbackResponseTypeToken",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/tokenInfo/consentCallback/token" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:29
def consentRedirect : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentToken.consentRedirect",
   """
      function(backend) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/tokenInfo/consentRedirect" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:28
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentToken.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/tokenInfo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
class ReverseMobileCapacity {
    

// @LINE:96
def gaucheWithAPI : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MobileCapacity.gaucheWithAPI",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile/capacity/gaucheWithAPI"})
      }
   """
)
                        

// @LINE:95
def withAPI : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MobileCapacity.withAPI",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile/capacity/withAPI"})
      }
   """
)
                        

// @LINE:93
def form : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MobileCapacity.form",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile/capacity"})
      }
   """
)
                        

// @LINE:97
def gaucheWithoutAPI : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MobileCapacity.gaucheWithoutAPI",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile/capacity/gaucheWithoutAPI"})
      }
   """
)
                        

// @LINE:94
def withoutAPI : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.MobileCapacity.withoutAPI",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile/capacity/withoutAPI"})
      }
   """
)
                        
    
}
              

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseConsentPayment {
    

// @LINE:36
def reserve : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentPayment.reserve",
   """
      function(token,amount,transaction_id,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/payment/reserve" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("amount", amount), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("transaction_id", transaction_id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:34
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentPayment.login",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/payment/login" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:37
def pay : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentPayment.pay",
   """
      function(token,amount,transaction_id,reserved,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/payment/pay" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("token", token), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("amount", amount), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("transaction_id", transaction_id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("reserved", reserved), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:35
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentPayment.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/payment/index" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReversePaymentV2 {
    

// @LINE:39
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:48
def paypartneragent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.paypartneragent",
   """
      function(backend,flow) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay/partneragent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        

// @LINE:46
def payselfcare : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.payselfcare",
   """
      function(backend,flow) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay/selfcare" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        

// @LINE:44
def partneragentconsentRedirect : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.partneragentconsentRedirect",
   """
      function(backend) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/transactions/partneragentRedirect" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:43
def transactionspartneragent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.transactionspartneragent",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/transactions/partneragent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:45
def pay : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.pay",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:51
def refund : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.refund",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/refund" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:41
def transactionsselfcare : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.transactionsselfcare",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/transactions/selfcare" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:47
def payselfcareStep2 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.payselfcareStep2",
   """
      function(backend,flow) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay/selfcare2" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        

// @LINE:40
def transactions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.transactions",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/transactions" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:49
def paypartneragentRedirect : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.paypartneragentRedirect",
   """
      function(backend,flow) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay/partneragentRedirect" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        

// @LINE:50
def paypartneragentApigeeCall : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.paypartneragentApigeeCall",
   """
      function(backend,flow) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/pay/partneragent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        

// @LINE:42
def transactionscallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentV2.transactionscallback",
   """
      function(backend,flow) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentv2/transactions/callback" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("flow", flow)])})
      }
   """
)
                        
    
}
              

// @LINE:103
// @LINE:102
// @LINE:101
class ReverseSSOMock {
    

// @LINE:103
def indexLeft : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SSOMock.indexLeft",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/iframeleft"})
      }
   """
)
                        

// @LINE:101
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SSOMock.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/sso"})
      }
   """
)
                        

// @LINE:102
def indexTopLeft : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SSOMock.indexTopLeft",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/iframetopleft"})
      }
   """
)
                        
    
}
              

// @LINE:89
// @LINE:88
class ReverseSmsSender {
    

// @LINE:89
def send : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmsSender.send",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "messaging/sms"})
      }
   """
)
                        

// @LINE:88
def form : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.SmsSender.form",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messaging/sms"})
      }
   """
)
                        
    
}
              

// @LINE:77
// @LINE:76
// @LINE:75
class ReversePaymentsFlowSelfcare {
    

// @LINE:77
def savePaymentAmount : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowSelfcare.savePaymentAmount",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowselfcare/saveAmount"})
      }
   """
)
                        

// @LINE:75
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowSelfcare.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowselfcare/" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:76
def consentCallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.PaymentsFlowSelfcare.consentCallback",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/paymentsflowselfcare/consentCallback" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:100
// @LINE:92
// @LINE:87
// @LINE:83
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:92
def mobile : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.mobile",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mobile"})
      }
   """
)
                        

// @LINE:22
def consent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.consent",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:11
def theme : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.theme",
   """
      function(theme) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "th/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("theme", encodeURIComponent(theme))})
      }
   """
)
                        

// @LINE:87
def messaging : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.messaging",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "messaging"})
      }
   """
)
                        

// @LINE:16
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:100
def authenticateSwisscom : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticateSwisscom",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/authenticateSwisscom"})
      }
   """
)
                        

// @LINE:15
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:10
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:83
def javascriptRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.javascriptRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascriptRoutes"})
      }
   """
)
                        

// @LINE:14
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
class ReverseOnline3rdParty {
    

// @LINE:60
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.index",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:65
def simcards : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.simcards",
   """
      function(subscriptionKey,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/simcards" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("subscriptionKey", subscriptionKey), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:63
def segment : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.segment",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/segment" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:66
def retention : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.retention",
   """
      function(subscriptionKey,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/retention" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("subscriptionKey", subscriptionKey), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:68
def order : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.order",
   """
      function(subscriptionKey,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/order" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("subscriptionKey", subscriptionKey), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:64
def birthdate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.birthdate",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/birthdate" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:67
def eligibility : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.eligibility",
   """
      function(subscriptionKey,backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/eligibility" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("subscriptionKey", subscriptionKey), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:61
def consentCallback : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.consentCallback",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/consentCallback" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        

// @LINE:62
def subscription : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Online3rdParty.subscription",
   """
      function(backend) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/online3rdparty/subscription" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend)])})
      }
   """
)
                        
    
}
              

// @LINE:84
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseConsentVerifyAddress {
    

// @LINE:84
def getOauthProviders : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentVerifyAddress.getOauthProviders",
   """
      function(backend,app) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "javascript/oauth-providers.js" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("app", app)])})
      }
   """
)
                        

// @LINE:25
def submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentVerifyAddress.submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/verifyaddress/submit"})
      }
   """
)
                        

// @LINE:24
def form : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentVerifyAddress.form",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/verifyaddress/form"})
      }
   """
)
                        

// @LINE:26
def summary : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentVerifyAddress.summary",
   """
      function(firstName,backend,response_type,app) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/verifyaddress/summary" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("firstName", firstName), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("response_type", response_type), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("app", app)])})
      }
   """
)
                        

// @LINE:23
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentVerifyAddress.index",
   """
      function(backend,response_type,app) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "consent/verifyaddress" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("backend", backend), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("response_type", response_type), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("app", app)])})
      }
   """
)
                        
    
}
              

// @LINE:107
// @LINE:106
class ReverseConsentMock {
    

// @LINE:106
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentMock.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/consent"})
      }
   """
)
                        

// @LINE:107
def submit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ConsentMock.submit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mock/consent"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:107
// @LINE:106
// @LINE:103
// @LINE:102
// @LINE:101
// @LINE:100
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
// @LINE:92
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:84
// @LINE:83
// @LINE:80
// @LINE:79
// @LINE:77
// @LINE:76
// @LINE:75
// @LINE:73
// @LINE:72
// @LINE:71
// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
package controllers.ref {


// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
class ReverseLocation {
    

// @LINE:56
def getDeviceLocation(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Location.getDeviceLocation(backend), HandlerDef(this, "controllers.Location", "getDeviceLocation", Seq(classOf[String]), "GET", """""", _prefix + """consent/location/device/pull""")
)
                      

// @LINE:57
def getDeviceIndex(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Location.getDeviceIndex(backend), HandlerDef(this, "controllers.Location", "getDeviceIndex", Seq(classOf[String]), "GET", """""", _prefix + """consent/location/devices""")
)
                      

// @LINE:54
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Location.index(backend), HandlerDef(this, "controllers.Location", "index", Seq(classOf[String]), "GET", """Consent Location""", _prefix + """consent/location/""")
)
                      

// @LINE:55
def consentCallback(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Location.consentCallback(backend), HandlerDef(this, "controllers.Location", "consentCallback", Seq(classOf[String]), "GET", """""", _prefix + """consent/location/consentCallback""")
)
                      
    
}
                          

// @LINE:73
// @LINE:72
// @LINE:71
class ReversePaymentsFlowPartnerAgent {
    

// @LINE:72
def consentRedirect(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowPartnerAgent.consentRedirect(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "consentRedirect", Seq(classOf[String]), "POST", """""", _prefix + """consent/paymentsflowpartneragent/consentRedirect""")
)
                      

// @LINE:71
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowPartnerAgent.index(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "index", Seq(classOf[String]), "GET", """Consent paymenets flows. 2015-02-16 Amancio""", _prefix + """consent/paymentsflowpartneragent""")
)
                      

// @LINE:73
def consentCallback(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowPartnerAgent.consentCallback(backend), HandlerDef(this, "controllers.PaymentsFlowPartnerAgent", "consentCallback", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentsflowpartneragent/consentCallback""")
)
                      
    
}
                          

// @LINE:80
// @LINE:79
class ReverseCalling {
    

// @LINE:80
def consetCallback(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Calling.consetCallback(), HandlerDef(this, "controllers.Calling", "consetCallback", Seq(), "GET", """""", _prefix + """consent/call/consentCallback""")
)
                      

// @LINE:79
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Calling.index(backend), HandlerDef(this, "controllers.Calling", "index", Seq(classOf[String]), "GET", """""", _prefix + """consent/call""")
)
                      
    
}
                          

// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
class ReverseConsentToken {
    

// @LINE:30
def consentCallbackResponseTypeCode(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentToken.consentCallbackResponseTypeCode(backend), HandlerDef(this, "controllers.ConsentToken", "consentCallbackResponseTypeCode", Seq(classOf[String]), "GET", """""", _prefix + """consent/tokenInfo/consentCallback/code""")
)
                      

// @LINE:31
def consentCallbackResponseTypeToken(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentToken.consentCallbackResponseTypeToken(backend), HandlerDef(this, "controllers.ConsentToken", "consentCallbackResponseTypeToken", Seq(classOf[String]), "GET", """""", _prefix + """consent/tokenInfo/consentCallback/token""")
)
                      

// @LINE:29
def consentRedirect(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentToken.consentRedirect(backend), HandlerDef(this, "controllers.ConsentToken", "consentRedirect", Seq(classOf[String]), "POST", """""", _prefix + """consent/tokenInfo/consentRedirect""")
)
                      

// @LINE:28
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentToken.index(backend), HandlerDef(this, "controllers.ConsentToken", "index", Seq(classOf[String]), "GET", """""", _prefix + """consent/tokenInfo""")
)
                      
    
}
                          

// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:93
class ReverseMobileCapacity {
    

// @LINE:96
def gaucheWithAPI(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MobileCapacity.gaucheWithAPI(), HandlerDef(this, "controllers.MobileCapacity", "gaucheWithAPI", Seq(), "GET", """""", _prefix + """mobile/capacity/gaucheWithAPI""")
)
                      

// @LINE:95
def withAPI(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MobileCapacity.withAPI(), HandlerDef(this, "controllers.MobileCapacity", "withAPI", Seq(), "GET", """""", _prefix + """mobile/capacity/withAPI""")
)
                      

// @LINE:93
def form(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MobileCapacity.form(), HandlerDef(this, "controllers.MobileCapacity", "form", Seq(), "GET", """""", _prefix + """mobile/capacity""")
)
                      

// @LINE:97
def gaucheWithoutAPI(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MobileCapacity.gaucheWithoutAPI(), HandlerDef(this, "controllers.MobileCapacity", "gaucheWithoutAPI", Seq(), "GET", """""", _prefix + """mobile/capacity/gaucheWithoutAPI""")
)
                      

// @LINE:94
def withoutAPI(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.MobileCapacity.withoutAPI(), HandlerDef(this, "controllers.MobileCapacity", "withoutAPI", Seq(), "GET", """""", _prefix + """mobile/capacity/withoutAPI""")
)
                      
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
class ReverseConsentPayment {
    

// @LINE:36
def reserve(token:String, amount:String, transaction_id:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentPayment.reserve(token, amount, transaction_id, backend), HandlerDef(this, "controllers.ConsentPayment", "reserve", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """consent/payment/reserve""")
)
                      

// @LINE:34
def login(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentPayment.login(backend), HandlerDef(this, "controllers.ConsentPayment", "login", Seq(classOf[String]), "GET", """Consent payment""", _prefix + """consent/payment/login""")
)
                      

// @LINE:37
def pay(token:String, amount:String, transaction_id:String, reserved:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentPayment.pay(token, amount, transaction_id, reserved, backend), HandlerDef(this, "controllers.ConsentPayment", "pay", Seq(classOf[String], classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """consent/payment/pay""")
)
                      

// @LINE:35
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentPayment.index(backend), HandlerDef(this, "controllers.ConsentPayment", "index", Seq(classOf[String]), "GET", """""", _prefix + """consent/payment/index""")
)
                      
    
}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
class ReversePaymentV2 {
    

// @LINE:39
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.index(backend), HandlerDef(this, "controllers.PaymentV2", "index", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2""")
)
                      

// @LINE:48
def paypartneragent(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.paypartneragent(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragent", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/paymentv2/pay/partneragent""")
)
                      

// @LINE:46
def payselfcare(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.payselfcare(backend, flow), HandlerDef(this, "controllers.PaymentV2", "payselfcare", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/paymentv2/pay/selfcare""")
)
                      

// @LINE:44
def partneragentconsentRedirect(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.partneragentconsentRedirect(backend), HandlerDef(this, "controllers.PaymentV2", "partneragentconsentRedirect", Seq(classOf[String]), "POST", """""", _prefix + """consent/paymentv2/transactions/partneragentRedirect""")
)
                      

// @LINE:43
def transactionspartneragent(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.transactionspartneragent(backend), HandlerDef(this, "controllers.PaymentV2", "transactionspartneragent", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2/transactions/partneragent""")
)
                      

// @LINE:45
def pay(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.pay(backend), HandlerDef(this, "controllers.PaymentV2", "pay", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2/pay""")
)
                      

// @LINE:51
def refund(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.refund(backend), HandlerDef(this, "controllers.PaymentV2", "refund", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2/refund""")
)
                      

// @LINE:41
def transactionsselfcare(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.transactionsselfcare(backend), HandlerDef(this, "controllers.PaymentV2", "transactionsselfcare", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2/transactions/selfcare""")
)
                      

// @LINE:47
def payselfcareStep2(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.payselfcareStep2(backend, flow), HandlerDef(this, "controllers.PaymentV2", "payselfcareStep2", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """consent/paymentv2/pay/selfcare2""")
)
                      

// @LINE:40
def transactions(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.transactions(backend), HandlerDef(this, "controllers.PaymentV2", "transactions", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentv2/transactions""")
)
                      

// @LINE:49
def paypartneragentRedirect(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.paypartneragentRedirect(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragentRedirect", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """consent/paymentv2/pay/partneragentRedirect""")
)
                      

// @LINE:50
def paypartneragentApigeeCall(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.paypartneragentApigeeCall(backend, flow), HandlerDef(this, "controllers.PaymentV2", "paypartneragentApigeeCall", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """consent/paymentv2/pay/partneragent""")
)
                      

// @LINE:42
def transactionscallback(backend:String, flow:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentV2.transactionscallback(backend, flow), HandlerDef(this, "controllers.PaymentV2", "transactionscallback", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/paymentv2/transactions/callback""")
)
                      
    
}
                          

// @LINE:103
// @LINE:102
// @LINE:101
class ReverseSSOMock {
    

// @LINE:103
def indexLeft(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SSOMock.indexLeft(), HandlerDef(this, "controllers.SSOMock", "indexLeft", Seq(), "GET", """""", _prefix + """mock/iframeleft""")
)
                      

// @LINE:101
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SSOMock.index(), HandlerDef(this, "controllers.SSOMock", "index", Seq(), "GET", """""", _prefix + """mock/sso""")
)
                      

// @LINE:102
def indexTopLeft(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SSOMock.indexTopLeft(), HandlerDef(this, "controllers.SSOMock", "indexTopLeft", Seq(), "GET", """""", _prefix + """mock/iframetopleft""")
)
                      
    
}
                          

// @LINE:89
// @LINE:88
class ReverseSmsSender {
    

// @LINE:89
def send(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmsSender.send(), HandlerDef(this, "controllers.SmsSender", "send", Seq(), "POST", """""", _prefix + """messaging/sms""")
)
                      

// @LINE:88
def form(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.SmsSender.form(), HandlerDef(this, "controllers.SmsSender", "form", Seq(), "GET", """""", _prefix + """messaging/sms""")
)
                      
    
}
                          

// @LINE:77
// @LINE:76
// @LINE:75
class ReversePaymentsFlowSelfcare {
    

// @LINE:77
def savePaymentAmount(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowSelfcare.savePaymentAmount(), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "savePaymentAmount", Seq(), "GET", """""", _prefix + """consent/paymentsflowselfcare/saveAmount""")
)
                      

// @LINE:75
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowSelfcare.index(backend), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "index", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentsflowselfcare/""")
)
                      

// @LINE:76
def consentCallback(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.PaymentsFlowSelfcare.consentCallback(backend), HandlerDef(this, "controllers.PaymentsFlowSelfcare", "consentCallback", Seq(classOf[String]), "GET", """""", _prefix + """consent/paymentsflowselfcare/consentCallback""")
)
                      
    
}
                          

// @LINE:100
// @LINE:92
// @LINE:87
// @LINE:83
// @LINE:22
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
class ReverseApplication {
    

// @LINE:92
def mobile(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.mobile(), HandlerDef(this, "controllers.Application", "mobile", Seq(), "GET", """Mobile""", _prefix + """mobile""")
)
                      

// @LINE:22
def consent(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.consent(backend), HandlerDef(this, "controllers.Application", "consent", Seq(classOf[String]), "GET", """Consent""", _prefix + """consent""")
)
                      

// @LINE:11
def theme(theme:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.theme(theme), HandlerDef(this, "controllers.Application", "theme", Seq(classOf[String]), "GET", """""", _prefix + """th/$theme<[^/]+>""")
)
                      

// @LINE:87
def messaging(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.messaging(), HandlerDef(this, "controllers.Application", "messaging", Seq(), "GET", """Messaging""", _prefix + """messaging""")
)
                      

// @LINE:16
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:100
def authenticateSwisscom(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticateSwisscom(), HandlerDef(this, "controllers.Application", "authenticateSwisscom", Seq(), "GET", """ SSO Mock""", _prefix + """mock/authenticateSwisscom""")
)
                      

// @LINE:15
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:10
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:83
def javascriptRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.javascriptRoutes(), HandlerDef(this, "controllers.Application", "javascriptRoutes", Seq(), "GET", """Implicit OAuth Ajax""", _prefix + """javascriptRoutes""")
)
                      

// @LINE:14
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ Authentication""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:68
// @LINE:67
// @LINE:66
// @LINE:65
// @LINE:64
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:60
class ReverseOnline3rdParty {
    

// @LINE:60
def index(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.index(backend), HandlerDef(this, "controllers.Online3rdParty", "index", Seq(classOf[String]), "GET", """Consent payment""", _prefix + """consent/online3rdparty/""")
)
                      

// @LINE:65
def simcards(subscriptionKey:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.simcards(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "simcards", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/simcards""")
)
                      

// @LINE:63
def segment(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.segment(backend), HandlerDef(this, "controllers.Online3rdParty", "segment", Seq(classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/segment""")
)
                      

// @LINE:66
def retention(subscriptionKey:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.retention(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "retention", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/retention""")
)
                      

// @LINE:68
def order(subscriptionKey:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.order(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "order", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/order""")
)
                      

// @LINE:64
def birthdate(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.birthdate(backend), HandlerDef(this, "controllers.Online3rdParty", "birthdate", Seq(classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/birthdate""")
)
                      

// @LINE:67
def eligibility(subscriptionKey:String, backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.eligibility(subscriptionKey, backend), HandlerDef(this, "controllers.Online3rdParty", "eligibility", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/eligibility""")
)
                      

// @LINE:61
def consentCallback(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.consentCallback(backend), HandlerDef(this, "controllers.Online3rdParty", "consentCallback", Seq(classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/consentCallback""")
)
                      

// @LINE:62
def subscription(backend:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Online3rdParty.subscription(backend), HandlerDef(this, "controllers.Online3rdParty", "subscription", Seq(classOf[String]), "GET", """""", _prefix + """consent/online3rdparty/subscription""")
)
                      
    
}
                          

// @LINE:84
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
class ReverseConsentVerifyAddress {
    

// @LINE:84
def getOauthProviders(backend:String, app:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentVerifyAddress.getOauthProviders(backend, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "getOauthProviders", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """javascript/oauth-providers.js""")
)
                      

// @LINE:25
def submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentVerifyAddress.submit(), HandlerDef(this, "controllers.ConsentVerifyAddress", "submit", Seq(), "POST", """""", _prefix + """consent/verifyaddress/submit""")
)
                      

// @LINE:24
def form(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentVerifyAddress.form(), HandlerDef(this, "controllers.ConsentVerifyAddress", "form", Seq(), "GET", """""", _prefix + """consent/verifyaddress/form""")
)
                      

// @LINE:26
def summary(firstName:String, backend:String, response_type:String, app:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentVerifyAddress.summary(firstName, backend, response_type, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "summary", Seq(classOf[String], classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """consent/verifyaddress/summary""")
)
                      

// @LINE:23
def index(backend:String, response_type:String, app:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentVerifyAddress.index(backend, response_type, app), HandlerDef(this, "controllers.ConsentVerifyAddress", "index", Seq(classOf[String], classOf[String], classOf[String]), "GET", """""", _prefix + """consent/verifyaddress""")
)
                      
    
}
                          

// @LINE:107
// @LINE:106
class ReverseConsentMock {
    

// @LINE:106
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentMock.index(), HandlerDef(this, "controllers.ConsentMock", "index", Seq(), "GET", """ Consent Mock""", _prefix + """mock/consent""")
)
                      

// @LINE:107
def submit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ConsentMock.submit(), HandlerDef(this, "controllers.ConsentMock", "submit", Seq(), "POST", """""", _prefix + """mock/consent""")
)
                      
    
}
                          
}
        
    