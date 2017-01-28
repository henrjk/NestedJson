import org.json4s._
import org.json4s.native.JsonMethods._
import org.scalatest.{Matchers, WordSpec}


object NestedJsonSpec {
  case class Data(important_field: String, pi: Double)

  implicit val formats = DefaultFormats // Brings in default date formats etc.

  def extract(source: JsonInput) : Data = {
    parse(source).transformField({
      case JField("interesting_stuff", jv) => ("pi", jv \ "pi")
    }).extract[Data]
  }
}

class NestedJsonSpec extends WordSpec with Matchers {
  import NestedJsonSpec._

    // [Extract fields in nested json using Scala's json4s - Stack Overflow](http://stackoverflow.com/questions/37801363/extract-fields-in-nested-json-using-scalas-json4s)
    "Extract fields in nested json" should {
      "extract partial information and raise nested fields" in {
        val json = """{
                     |    "important_field" : "info",
                     |    "some_junk" : 12345,
                     |    "interesting_stuff" : {
                     |        "pi" : 3.14,
                     |        "e" : 2.72
                     |    }
                     |}""".stripMargin

        val data = extract(json)
        data shouldBe Data("info", 3.14)
      }
    }
}
