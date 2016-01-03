import java.io.{File, StringWriter}
import java.util

import groovy.json.JsonSlurper
import groovy.text.markup.{MarkupTemplateEngine, TemplateConfiguration}
import play.api.libs.json.Json

/**
  * http://www.groovy-lang.org/json.html
  * http://docs.groovy-lang.org/latest/html/documentation/template-engines.html#_the_markuptemplateengine
  **/
object MainApp extends App {
  val config = new TemplateConfiguration()
  val engine = new MarkupTemplateEngine(config)
  case class Whoopsie(a: String, b: Option[Int]) {
  }
  implicit val w = Json.writes[Whoopsie]
  val template = engine.createTemplate(new File("hah.tpl").toURI.toURL)
  val model = new util.HashMap[String, Any]()
  import collection.JavaConverters._
  val ls = List(Whoopsie("a", Some(2)), Whoopsie("b", None))
  model.put("oopsie", new JsonSlurper().parseText(Json.toJson(ls).toString))
  val output = template.make(model)
  val sw = new StringWriter()
  output.writeTo(sw)

  println(sw)
}