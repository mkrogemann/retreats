package conway

object Rules {
  def apply(neighbors: Int, alive: Boolean) = {
    neighbors match {
      case 3 => true
      case 2 => alive
      case _ => false
    }
  }
}
