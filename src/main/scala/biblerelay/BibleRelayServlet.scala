package biblerelay

import org.scalatra._

import scala.collection.mutable

class BibleRelayServlet extends ScalatraServlet {
  val pattern = """<meta property="og:description" content=""""
  val simpleCache = mutable.Map.empty[String, Option[String]]

  get("/api/bible/:version/:book/:chapter/:verse") {
    val version = params("version")
    val book = params("book")
    val chapter = params("chapter").toInt
    val verse = params("verse").toInt

    val url = s"https://www.biblegateway.com/passage/?search=$book+$chapter%3A$verse&version=$version"

    val cacheKey = request.getRequestURI

    simpleCache.get(cacheKey) match {
      case Some(Some(v)) => v
      case Some(None) => "Not Found"
      case None =>
        val r = requests.get(url)
        val result = r.lines.find(_.startsWith(pattern)).map(v => v.substring(pattern.length, v.length - 3))
        simpleCache.put(cacheKey, result)
        result.getOrElse("Not Found")
    }
  }

}
