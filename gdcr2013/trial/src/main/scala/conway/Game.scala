package conway

class Game(val width: Int, val height: Int) {

  var game_state: Map[(Int,Int), Boolean] = initial_state()

  def this(game_state: Map[(Int,Int), Boolean]) {
    this(game_state.keys.maxBy(_._1)._1, game_state.keys.maxBy(_._2)._2)
    this.game_state = initial_state(game_state)
  }

  def initial_state(map: Map[(Int,Int), Boolean] = Map()): Map[(Int,Int), Boolean] = {
    val state = collection.mutable.Map[(Int,Int), Boolean]()
    (1 to this.width).map( x =>
      (1 to this.height).map( y =>
        {
          val key = (x,y)
          val cell_state = map.get(key)
          cell_state match {
            case Some(boolean) => state += key -> cell_state.get
            case _ => state += key -> false
          }
        }
      )
    )
    state.toMap
  }

  def evolve(current_gen: Map[(Int,Int), Boolean]): Map[(Int,Int), Boolean] = {
    var next_gen = collection.mutable.Map[(Int,Int), Boolean] ()
    current_gen.foreach( p => next_gen += p._1 -> Rules(neighbors(p._1._1, p._1._2), alive = p._2) )
    next_gen.toMap
  }

  def neighbors(x: Int,y: Int): Int = {
    var num_alive = 0
    (x-1 to x+1).map( col =>
      (y-1 to y+1).map( row =>
        {
          val value = game_state.get(wrap_or_get_key(col,row))
          value match {
            case Some(true) => num_alive += 1
            case _ =>
          }
        }
      )
    )
    if (game_state.get((x,y)) == Some(true)) {
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
