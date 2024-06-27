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
    val n = 8

    val start = System.currentTimeMillis()

    val queenPositionsList = findAllSolutions(n)

    val end = System.currentTimeMillis()
    println(s"Execution Time: ${end - start}ms")

    printSolutions(queenPositionsList, n)
  }

  /**
   * Finds all combinations of n queens on a n x n field
   *
   * @param n The size of the grid and amount of queens that will be placed on it
   * @return A list of all possible solutions
   */
  def findAllSolutions(n: Int): List[List[(Int, Int)]] =
    findQueenSolutions(currQueens = List(), foundSolutions = List(), n = n)

  def findQueenSolutions(currQueens: List[(Int, Int)], continueFromRow: Int = 0, foundSolutions: List[List[(Int, Int)]], n: Int): List[List[(Int, Int)]] = {
    // When 8 queens are placed on the same field is that a solution
    val nFoundSolutions = if (currQueens.length == n) currQueens :: foundSolutions else foundSolutions

    // Try to get a position for a queen in the next column
    val availablePosition = getNextPosition(currQueens, continueFromRow, n)

    availablePosition match {
      case None => {
        // -> Queen cant be placed

        // Abort Statement
        if (currQueens.isEmpty) {
          return foundSolutions
        }

        // If there is no position, continue the process from the last queen
        findQueenSolutions(currQueens.tail, currQueens.head._2 + 1, nFoundSolutions, n)
      }
      case Some(position) => {
        // -> Queen can be placed

        // New list with queen
        val newQueens = position :: currQueens

        // Recursive call with new queen
        findQueenSolutions(currQueens = newQueens, foundSolutions = nFoundSolutions, n = n)
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
  def getNextPosition(currQueens: List[(Int, Int)], continueFromRow: Int, n: Int): Option[(Int, Int)] = {
    val rows = continueFromRow until n
    val nextColumn = if (currQueens.nonEmpty) currQueens.head._1 + 1 else 0

    // Find row that meets requirements
    val row = rows.find(row => {
      !hasQueenInRow(row, currQueens) && !hasQueenDiagonally((nextColumn, row), currQueens) && !hasQueenInColumn(nextColumn, currQueens)
    })

    row match {
      case Some(value) => {
        // Position available -> Return Position
        Some(nextColumn, value)
      }
      // No position available
      case None => None
    }
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

  def printSolutions(solutions: List[List[(Int, Int)]], n: Int): Unit = {
    val rows = 0 until n
    val columns = 0 until n
    for (solution <- solutions) {
      for (row <- rows) {
        for (column <- columns) {
          if (solution.contains((column, row)))
            print(" X ")
          else print(" . ")
        }
        println()
      }
      println("-----------------------")
    }
  }
}