package conway

class Game(val width: Int, val height: Int) {

  def evolve(current_gen: Map[(Int,Int), Boolean]): Map[(Int,Int), Boolean] = {
    current_gen map { case (k, v) => k -> Rules(neighbors(current_gen, k._1, k._2), alive = v) }
  }

  def neighbors(current_gen: Map[(Int,Int), Boolean], x: Int,y: Int): Int = {
    var num_alive = 0
    (x-1 to x+1).map( col =>
      (y-1 to y+1).map( row =>
        {
          val value = current_gen.get(wrap_or_get_key(col,row))
          value match {
            case Some(true) => num_alive += 1
            case _ =>
          }
        }
      )
    )
    if (current_gen.get((x,y)) == Some(true)) { // don't count myself
      num_alive -= 1
    }
    num_alive
  }

  private def wrap_or_get_key(x: Int,y: Int): (Int,Int) = {
    val wrapped_x = if (x < 1) this.width else if (x > this.width) 1 else x
    val wrapped_y = if (y < 1) this.height else if (y > this.height) 1 else y
    (wrapped_x, wrapped_y)
  }

}
