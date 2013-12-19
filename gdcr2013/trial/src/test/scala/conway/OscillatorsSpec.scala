package conway

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}

class OscillatorsSpec extends FeatureSpec with GivenWhenThen with Matchers {

  info("As a user of ScalaGol")
  info("I should be able to specify games that represent Oscillators")
  info("And be able to verify that the cells oscillate between two or more states")

  feature("Oscillators") {

    scenario("Blinker, an oscillator with period 2") {

      Given("a Game with this initial state")

      /*
        |     |
        |     |
        | ooo |
        |     |
        |     |
      */

      val game = new Game(5, 5)

      When("the next generation is computed")
      val first_generation = game.evolve(
        Map(
          (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false, (5,1) -> false,
          (1,2) -> false, (2,2) -> false, (3,2) -> false, (4,2) -> false, (5,2) -> false,
          (1,3) -> false, (2,3) -> true,  (3,3) -> true,  (4,3) -> true,  (5,3) -> false,
          (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> false, (5,4) -> false,
          (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false
        )
      )

      Then("the game should be in this state")

      /*
        |     |
        |  o  |
        |  o  |
        |  o  |
        |     |
      */

      first_generation should be(
        Map(
          (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false, (5,1) -> false,
          (1,2) -> false, (2,2) -> false, (3,2) -> true,  (4,2) -> false, (5,2) -> false,
          (1,3) -> false, (2,3) -> false, (3,3) -> true,  (4,3) -> false, (5,3) -> false,
          (1,4) -> false, (2,4) -> false, (3,4) -> true,  (4,4) -> false, (5,4) -> false,
          (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false
        )

      )

      When("the next generation is computed")
      val second_generation = game.evolve(first_generation)

      Then("the game should be in this state")

      /*
        |     |
        |     |
        | ooo |
        |     |
        |     |
      */

      second_generation should be(
        Map(
          (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false, (5,1) -> false,
          (1,2) -> false, (2,2) -> false, (3,2) -> false, (4,2) -> false, (5,2) -> false,
          (1,3) -> false, (2,3) -> true,  (3,3) -> true,  (4,3) -> true,  (5,3) -> false,
          (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> false, (5,4) -> false,
          (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false
        )
      )
    }

  }

}
