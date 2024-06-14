import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.core.structure.PopulationBuilder

class firstProject extends Simulation
{

  val httpProtocol = http.baseUrl("http://w3schools.com")

  val scn = scenario("Basic Simulation").exec(http("SQL Course").get("/sql/default.asp")).pause(5)

  setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
    .assertions(
      global.responseTime.max.lt(100),  // Max response time should be less than 500 ms
      global.successfulRequests.percent.gt(95)  // More than 95% requests should be successful
    )
}