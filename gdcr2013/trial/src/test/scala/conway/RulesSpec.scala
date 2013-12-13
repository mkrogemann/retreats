package conway

import org.scalatest.{Matchers, FlatSpec}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RulesSpec extends FlatSpec with Matchers {

  "Rules" should "return true for three live neighbors" in {
    Rules(neighbors = 3, alive = false) should be(true)
  }

  "Rules" should "return true if Cell is alive and has two live neighbors" in {
    Rules(neighbors = 2, alive = true) should be(true)
  }

  "Rules" should "return false for more than three live neighbors" in {
    Rules(neighbors = 4, alive = false) should be(false)
  }

  "Rules" should "return false for less than two live neighbors" in {
    Rules(neighbors = 1, alive = false) should be(false)
  }

}
