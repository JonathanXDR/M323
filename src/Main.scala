import scala.Predef.->

object Main {
  def main(args: Array[String]): Unit = {
    val queenPositionsList = placeQueens()
  }

  def placeQueens(): List[List[(Int, Int)]] = {
    return List()
  }

  def placeQueen(currQueens : List[(Int, Int)]): List[(Int, Int)] = {
    // Abbruch Statement
    if (currQueens.length == 8)
      return currQueens

    // PlaceQueen

    // Recursive call with new queen

  }
}