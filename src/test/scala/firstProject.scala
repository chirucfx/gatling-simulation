import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.core.structure.ScenarioBuilder

class firstProject extends Simulation
{

  val httpProtocol = http.baseUrl("http://w3schools.com")

  val scn = scenario("Basic Simulation").exec(http("SQL Course").get("/sql/default.asp")).pause(5)

  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
}