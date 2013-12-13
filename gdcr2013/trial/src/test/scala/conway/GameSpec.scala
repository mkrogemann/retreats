package conway

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, FunSpec}

@RunWith(classOf[JUnitRunner])
class GameSpec extends FunSpec with Matchers {

  describe ("Game") {

    describe ("constructor") {

      it ("takes values for width and height") {
        val game = new Game(7,5)
        game.width should be(7)
        game.height should be(5)
      }

      it ("optionally takes a Map representing the initial Game state") {
        val map = Map((1,1) -> true, (2,1) -> false, (3,1) -> true, (4,1) -> false,
                      (1,2) -> true, (2,2) -> true, (3,2) -> false, (4,2) -> true,
                      (1,3) -> false, (2,3) -> true, (3,3) -> false, (4,3)-> true)
        val game = new Game(map)
        game.width should be(4)
        game.height should be(3)
      }
    }

    describe ("neighbors") {

      it ("returns the number of living neighbors") {
        val current_gen = Map((1,1) -> true, (2,1) -> false, (3,1) -> true, (4,1) -> false,
                              (1,2) -> false, (2,2) -> true, (3,2) -> false, (4,2) -> true,
                              (1,3) -> false, (2,3) -> true, (3,3) -> false, (4,3) -> true)
        val game = new Game(current_gen)
        game.neighbors(3,2) should be(5)
        game.neighbors(2,2) should be(3)
        game.neighbors(4,2) should be(3)
        game.neighbors(2,1) should be(4)
      }

    }

    describe ("evolve") {

      it ("evolves the game") {
        val current_gen = Map((1,1) -> true, (2,1) -> false, (3,1) -> true, (4,1) -> false,
                              (1,2) -> false, (2,2) -> true, (3,2) -> false, (4,2) -> true,
                              (1,3) -> false, (2,3) -> true, (3,3) -> false, (4,3) -> true)
        val game = new Game(current_gen)
        val expected_next_gen = Map((1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false,
                                    (1,2) -> false, (2,2) -> true, (3,2) -> false, (4,2) -> true,
                                    (1,3) -> false, (2,3) -> true, (3,3) -> false, (4,3) -> true)
        val next_gen = game.evolve(current_gen)
        next_gen should equal(expected_next_gen)
      }

    }

  }

}