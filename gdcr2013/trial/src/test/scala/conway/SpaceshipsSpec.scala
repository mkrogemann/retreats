package conway

import org.scalatest.{Matchers, GivenWhenThen, FeatureSpec}

class SpaceshipsSpec extends FeatureSpec with GivenWhenThen with Matchers {

  info("As a user of ScalaGol")
  info("I should be able to specify games that represent Spaceships")
  info("And be able to verify that the active cells travel across the grid and the original shape is repeated periodically")

  feature("Spaceships") {

    scenario("5-cell Glider") {

      Given("a Game with this initial state")

      /*
        |   o  |
        | o o  |
        |  oo  |
        |      |
        |      |
      */

      val game = new Game(6, 6)
      val initial_state = Map(
        (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> true,  (5,1) -> false, (6,1) -> false,
        (1,2) -> false, (2,2) -> true,  (3,2) -> false, (4,2) -> true,  (5,2) -> false, (6,2) -> false,
        (1,3) -> false, (2,3) -> false, (3,3) -> true,  (4,3) -> true,  (5,3) -> false, (6,3) -> false,
        (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> false, (5,4) -> false, (6,4) -> false,
        (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false, (6,5) -> false
      )

      When("the next generation is computed")
      val first_generation = game.evolve(initial_state)

      Then("the game should be in this state")

      /*
        |  o   |
        |   oo |
        |  oo  |
        |      |
        |      |
      */

      first_generation should be (Map(
        (1,1) -> false, (2,1) -> false, (3,1) -> true,  (4,1) -> false, (5,1) -> false, (6,1) -> false,
        (1,2) -> false, (2,2) -> false, (3,2) -> false, (4,2) -> true,  (5,2) -> true,  (6,2) -> false,
        (1,3) -> false, (2,3) -> false, (3,3) -> true,  (4,3) -> true,  (5,3) -> false, (6,3) -> false,
        (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> false, (5,4) -> false, (6,4) -> false,
        (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false, (6,5) -> false
      ))

      When("the next generation is computed")
      val second_generation = game.evolve(first_generation)

      Then("the game should be in this state")

      /*
        |   o  |
        |    o |
        |  ooo |
        |      |
        |      |
      */

      second_generation should be (Map(
        (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> true,  (5,1) -> false, (6,1) -> false,
        (1,2) -> false, (2,2) -> false, (3,2) -> false, (4,2) -> false, (5,2) -> true,  (6,2) -> false,
        (1,3) -> false, (2,3) -> false, (3,3) -> true,  (4,3) -> true,  (5,3) -> true,  (6,3) -> false,
        (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> false, (5,4) -> false, (6,4) -> false,
        (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false, (6,5) -> false
      ))

      When("the next generation is computed")
      val third_generation = game.evolve(second_generation)

      Then("the game should be in this state")

      /*
        |      |
        |  o o |
        |   oo |
        |   o  |
        |      |
      */

      third_generation should be (Map(
        (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false, (5,1) -> false, (6,1) -> false,
        (1,2) -> false, (2,2) -> false, (3,2) -> true,  (4,2) -> false, (5,2) -> true,  (6,2) -> false,
        (1,3) -> false, (2,3) -> false, (3,3) -> false, (4,3) -> true,  (5,3) -> true,  (6,3) -> false,
        (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> true,  (5,4) -> false, (6,4) -> false,
        (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false, (6,5) -> false
      ))

      When("the next generation is computed")
      val fourth_generation = game.evolve(third_generation)

      Then("the game should be in this state")

      /*
        |      |
        |    o |
        |  o o |
        |   oo |
        |      |
      */

      fourth_generation should be (Map(
        (1,1) -> false, (2,1) -> false, (3,1) -> false, (4,1) -> false, (5,1) -> false, (6,1) -> false,
        (1,2) -> false, (2,2) -> false, (3,2) -> false, (4,2) -> false, (5,2) -> true,  (6,2) -> false,
        (1,3) -> false, (2,3) -> false, (3,3) -> true,  (4,3) -> false, (5,3) -> true,  (6,3) -> false,
        (1,4) -> false, (2,4) -> false, (3,4) -> false, (4,4) -> true,  (5,4) -> true,  (6,4) -> false,
        (1,5) -> false, (2,5) -> false, (3,5) -> false, (4,5) -> false, (5,5) -> false, (6,5) -> false
      ))

    }

  }


}
