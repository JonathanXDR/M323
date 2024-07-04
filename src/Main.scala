import scala.Predef.->
import scala.annotation.tailrec


// The play field gets handled as follow:
//
//              COLUMN
//      0  1  2  3  4  5  6  7
//      -------------------------
//    0 | x
//    1 |     x
// R  2 |
// O  3 |        x
// W  4 |
//    5 |
//    6 |
//    7 |
//
// Coordinates -> (Column, Row)
//             -> (  X   ,  Y )

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
      case None => {
        /* TODO */
        return currQueens
      }
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
    val rows = Range.inclusive(0, 7).toList
    val columns = Range.inclusive(0, 7).toList

    // Position available -> Return Position
    rows.foreach(row => {
      columns.foreach(column => {
        if (!hasQueenInRow(row, currQueens)
          && !hasQueenInColumn(column, currQueens)
          && !hasQueenDiagonally((column, row), currQueens)
        )
          return Some(column, row)
      })
    })
    // No Position available
    return None
  }

  def hasQueenInRow(row: Int, queens: List[(Int, Int)]): Boolean = {
    queens.foreach(queen => {
      if (queen._2 == row)
        return true
    })
    return false
  }

  def hasQueenInColumn(column: Int, queens: List[(Int, Int)]): Boolean = {
    queens.foreach(queen => {
      if (queen._1 == column)
        return true
    })
    return false
  }

  def hasQueenDiagonally(position: (Int, Int), queens: List[(Int, Int)]): Boolean = {
    queens.foreach(queen => {
      // Check if queen is diagonally of position
      // Diagonally when -> x1−x2 = y1−y2, so:
      if (norm(position._1 - queen._1) == norm(position._2 - queen._2))
        return true
    })
    return false
  }

  def norm(number: Int) = {
    if (number >= 0)
      number
    else
      number * -1
  }
}