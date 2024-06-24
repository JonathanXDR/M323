import scala.Predef.->

object Main {
  def main(args: Array[String]): Unit = {
    val queenPositionsList = placeQueens()
  }

  def placeQueens(): List[List[(Int, Int)]] = {
    /* TODO  */
    return List(placeQueen(List()))
  }

  def placeQueen(currQueens: List[(Int, Int)]): List[(Int, Int)] = {
    // Abort Statement
    if (currQueens.length == 8)
      return currQueens

    // PlaceQueen
    val availablePosition = getAvailableQueenPosition(currQueens)

    availablePosition match {
      // case None  => /* TODO */
      case Some(position) => {
        // New list with queen
        val newQueens = position :: currQueens

        // Recursive call with new queen
        placeQueen(newQueens)
      }
    }
  }

  def getAvailableQueenPosition(currQueens: List[(Int, Int)]): Option[(Int, Int)] = {
    /* TODO */

    // Position available -> Return Position
    return Some(1, 1)

    // No Position available
    return None
  }
}