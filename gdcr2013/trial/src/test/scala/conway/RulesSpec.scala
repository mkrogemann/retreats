package conway

import org.scalatest.{FunSpec, Matchers}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RulesSpec extends FunSpec with Matchers {

  describe("Rules") {

    describe("apply") {

      it ("returns true for three live neighbors") {
        Rules(neighbors = 3, alive = false) should be(true)
      }

      it ("returns true if Cell is alive and has two live neighbors") {
        Rules(neighbors = 2, alive = true) should be(true)
      }

      it ("return false for more than three live neighbors") {
        Rules(neighbors = 4, alive = false) should be(false)
      }

      it ("return false for less than two live neighbors") {
        Rules(neighbors = 1, alive = false) should be(false)
      }
    }

  }

}
