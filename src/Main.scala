import scala.::
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
    val queenPositionsList = getAllPossibleFields()
    val a = 0
  }

  def getAllPossibleFields(): List[List[(Int, Int)]] = {
    /* TODO  */
    val firstField = getQueens(List())
    return List(firstField)
  }

  def getQueens(currQueens: List[(Int, Int)], continueFromRow: Int = 0): List[(Int, Int)] = {
    // Abort Statement
    if (currQueens.length == 8)
      return currQueens

    // PlaceQueen
    val availablePosition = getAvailableQueenPositionInNextColumn(currQueens, continueFromRow)

    availablePosition match {
      case None => {
        // If there is no position, repeat the process, but without the last queen
        return getQueens(currQueens.tail, currQueens.head._2 + 1)
      }
      case Some(position) => {
        // New list with queen
        val newQueens = position :: currQueens

        // Recursive call with new queen
        return getQueens(newQueens)
      }
    }
  }

  def getAvailableQueenPositionInNextColumn(currQueens: List[(Int, Int)], continueFromRow: Int): Option[(Int, Int)] = {
    /* TODO */
    val rows = Range.inclusive(continueFromRow, 7).toList
    val nextColumn = if (currQueens.nonEmpty) currQueens.head._1 + 1 else 0

    // Position available -> Return Position
    rows.foreach(row => {
      if (!hasQueenInRow(row, currQueens)
        && !hasQueenInColumn(nextColumn, currQueens)
        && !hasQueenDiagonally((nextColumn, row), currQueens)
      )
        return Some(nextColumn, row)
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

  def hasQueenInColumn(column: Int, queens: List[(Int, Int)]): Boolean =
    queens.exists(_._1 == column)


  def hasQueenDiagonally(position: (Int, Int), queens: List[(Int, Int)]): Boolean =
    queens.exists(queen =>
      // Check if queen is diagonally of position
      // Diagonally when -> x1−x2 = y1−y2, so:
      Math.abs(position._1 - queen._1) == Math.abs(position._2 - queen._2)
    )
}