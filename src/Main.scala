// The play field gets handled as follow:
//
//              COLUMN
//        0  1  2  3  4  5  6  7
//      +------------------------+
//    0 | x (0/0)                |
//    1 |    x (1/1)             |
// R  2 |                        |
// O  3 |       x (2/3)          |
// W  4 |                        |
//    5 |                        |
//    6 |                        |
//    7 |                        |
//      +------------------------+
//
// Coordinates -> (Column, Row)
//             -> (  X   ,  Y )

object Main {
  def main(args: Array[String]): Unit = {
    val queenPositionsList = findAllSolutions()
    printSolutions(queenPositionsList)
  }

  def findAllSolutions(): List[List[(Int, Int)]] =
    findQueenSolutions(currQueens = List(), foundSolutions = List())

  def findQueenSolutions(currQueens: List[(Int, Int)], continueFromRow: Int = 0, foundSolutions: List[List[(Int, Int)]]): List[List[(Int, Int)]] = {
    // When 8 queens are placed on the same field is that a solution
    val nFoundSolutions = if (currQueens.length == 8) currQueens :: foundSolutions else foundSolutions

    // Try to get a position for a queen in the next column
    val availablePosition = getNextPosition(currQueens, continueFromRow)

    availablePosition match {
      case None => {
        // -> Queen cant be placed

        // Abort Statement
        if (currQueens.isEmpty) {
          return foundSolutions
        }

        // If there is no position, continue the process from the last queen
        return findQueenSolutions(currQueens.tail, currQueens.head._2 + 1, nFoundSolutions)
      }
      case Some(position) => {
        // -> Queen can be placed

        // New list with queen
        val newQueens = position :: currQueens

        // Recursive call with new queen
        return findQueenSolutions(currQueens = newQueens, foundSolutions = nFoundSolutions)
      }
    }
  }

  /**
   * Get the next available Position of a queen in the next column. The Column gets indicated from the column position of the head element from currQueens increased by 1. If currQueen is empty the column position is 0.
   *
   * @param currQueens      The already existing queens where the new Queen should fit in
   * @param continueFromRow The row where the search should start
   * @return None if no position is available or the (x, y) of the point.
   */
  def getNextPosition(currQueens: List[(Int, Int)], continueFromRow: Int): Option[(Int, Int)] = {
    val rows = continueFromRow to 7
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

  def hasQueenInRow(row: Int, queens: List[(Int, Int)]): Boolean =
    queens.exists(_._2 == row)

  def hasQueenInColumn(column: Int, queens: List[(Int, Int)]): Boolean =
    queens.exists(_._1 == column)

  def hasQueenDiagonally(position: (Int, Int), queens: List[(Int, Int)]): Boolean =
    queens.exists(queen =>
      // Diagonally when -> |x1−x2| = |y1−y2|, so:
      Math.abs(position._1 - queen._1) == Math.abs(position._2 - queen._2)
    )

  def printSolutions(solutions: List[List[(Int, Int)]]): Unit = {
    /* TODO */
  }
}