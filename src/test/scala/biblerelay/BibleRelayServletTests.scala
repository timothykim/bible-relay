package biblerelay

import org.scalatra.test.scalatest._

class BibleRelayServletTests extends ScalatraFunSuite {

  addServlet(classOf[BibleRelayServlet], "/*")

  test("GET / on BibleRelayServlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
