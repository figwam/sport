package controllers

import play.api.data.Form
import play.api.data.Forms.{mapping, _}
import play.api.libs.json._
import play.api.mvc.{Action, Controller}
import views.html

case class CapacityInfo(downloadRate: String, uploadRate: String, downloadRatio: String, uploadRatio: String, expectedDownload: String, expectedUpload: String, throttling: String, color: String)

object MobileCapacity extends Controller {
  
  var capacityForm: Form[CapacityInfo] = Form(
  mapping(
    "downloadRate" -> nonEmptyText,
    "uploadRate" -> nonEmptyText,
    "downloadRatio" -> nonEmptyText,
    "uploadRatio" -> nonEmptyText,
    "expectedDownload" -> nonEmptyText,
    "expectedUpload" -> nonEmptyText,
    "throttling" -> nonEmptyText,
    "color" -> nonEmptyText)(CapacityInfo.apply)(CapacityInfo.unapply))
  
  def form = Action { implicit request =>
    Ok(html.mobile.capacity.form(request));
  }

  def gaucheWithoutAPI = Action { implicit request =>
    val downloadRateExpected = "60.00"
    val uploadRateExpected = "15.00"
    val throttling = "..."

    val downloadRate = "..."
    val uploadRate = "..."

    val downloadRatio = "..."
    val uploadRatio = "..."

    val color = "#FFFFFF"

    capacityForm = capacityForm.fill(CapacityInfo(downloadRate, uploadRate, downloadRatio, uploadRatio, downloadRateExpected, uploadRateExpected, throttling, color))
    Ok(html.mobile.capacity.gaugeWithoutAPI(capacityForm));
  }

  def gaucheWithAPI = Action { implicit request =>
    var result = ApigeeCallouts.getTokenWithClientCredential();
    if (result.isLeft) {
      val error = result.left.get
      Ok(html.mobile.capacity.gaugeWithAPI(null, Some(error)))
    } else {
        val accessToken = result.right.get

        result = ApigeeCallouts.getMobileCapacity(accessToken)
      var something = ""
        if (result.isLeft) {
          val error = result.left.get
          Ok(html.mobile.capacity.gaugeWithAPI(null, Some(error)))
        } else {
          val capacities = result.right.get

          val downloadRateExpected = BigDecimal(extractValue(capacities, "maximumBitRateDownload").toDouble / 1000000).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString
          val uploadRateExpected = BigDecimal(extractValue(capacities, "maximumBitRateUpload").toDouble / 1000000).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString
          val throttling = "speed-throttled" //extractValue(capacities, "throttlingStatus")

          val downloadRate = "13.27"
          val uploadRate = "1.86"

          val downloadRatio = BigDecimal(100 / downloadRateExpected.toDouble * downloadRate.toDouble).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString
          val uploadRatio = BigDecimal(100 / uploadRateExpected.toDouble * uploadRate.toDouble).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString

          val color = getColor(downloadRatio)

          capacityForm = capacityForm.fill(CapacityInfo("...", "...", "...", "...", downloadRateExpected, uploadRateExpected, throttling, "#FFFFFF"))

          Ok(html.mobile.capacity.gaugeWithAPI(capacityForm, None)).withSession(session
            + ("downloadRateExpected" -> downloadRateExpected)
            + ("uploadRateExpected" -> uploadRateExpected)
            + ("throttling" -> throttling)
            + ("downloadRate" -> downloadRate)
            + ("uploadRate" -> uploadRate)
            + ("downloadRatio" -> downloadRatio)
            + ("uploadRatio" -> uploadRatio)
            + ("color" -> color))
        }
    }
  }

  def withoutAPI = Action { implicit request =>
    val downloadRateExpected = "60.00"
    val uploadRateExpected = "15.00"
    val throttling = "normal"

    val downloadRate = "4.27"
    val uploadRate = "0.93"

    val downloadRatio = BigDecimal(100 / downloadRateExpected.toDouble * downloadRate.toDouble).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString
    val uploadRatio = BigDecimal(100 / uploadRateExpected.toDouble * uploadRate.toDouble).setScale(2, BigDecimal.RoundingMode.HALF_UP).toString

    val color = getColor(downloadRatio)

    capacityForm = capacityForm.fill(CapacityInfo(downloadRate, uploadRate, downloadRatio, uploadRatio, downloadRateExpected, uploadRateExpected, throttling, color))

    Ok(html.mobile.capacity.withoutAPI(capacityForm));
  }
    
  def withAPI = Action { implicit request =>
    val downloadRateExpected = request.session.get("downloadRateExpected").getOrElse("k.A.")
    val uploadRateExpected = request.session.get("uploadRateExpected").getOrElse("k.A.")
    val throttling = request.session.get("throttling").getOrElse("k.A.")
    val downloadRate = request.session.get("downloadRate").getOrElse("k.A.")
    val uploadRate = request.session.get("uploadRate").getOrElse("k.A.")
    val downloadRatio = request.session.get("downloadRatio").getOrElse("k.A.")
    val uploadRatio = request.session.get("uploadRatio").getOrElse("k.A.")
    val color = request.session.get("color").getOrElse("#FFFFFF")

    capacityForm = capacityForm.fill(CapacityInfo(downloadRate, uploadRate, downloadRatio, uploadRatio, downloadRateExpected, uploadRateExpected, throttling, color))

    Ok(html.mobile.capacity.withAPI(capacityForm))
  }
  
  def extractValue(string: String, key: String): String = {
    val json = Json.parse(string)
    val value = (json.as[JsArray].value.last \ key).as[String]    
    return value
  }
  
  def getColor(string: String): String = {
    val ratio = string.toDouble;
    if (ratio <= 25) {
      return "#FF704D"
    } else if (ratio <= 75) {
      return "#FFC68D"
    } else {
      return "#CCFFCC"
    }
  }
  
}