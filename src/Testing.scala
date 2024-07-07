import Main.findSolutions
import Main.getNextPosition
import Main.printSolutions
import Main.zipAndMapTogether

object Testing extends App {
  def testValidFindSolutions(): Unit = {
    val res1 = findSolutions(n = 8)
    val res2 = findSolutions(n = 8)
    val res3 = findSolutions(n = 8)
    val res4 = findSolutions(n = 8)
    val res5 = findSolutions(n = 8)
    val res6 = findSolutions(n = 8)
    val res7 = findSolutions(n = 8)

    val allEqual = (res1 == res2) && (res2 == res3) && (res3 == res4) &&
      (res4 == res5) && (res5 == res6) && (res6 == res7)

    if (allEqual)
      println("Test passed for valid inputs")
    else
      println("Test failed for valid inputs")
  }

  // Generated Code
  def testInvalidFindSolutions(): Unit = {
    try {
      findSolutions(n = -1)
      println("Test failed for findSolutions with n = -1 (expected exception)")
    } catch {
      case _: IllegalArgumentException => println("Test passed for findSolutions with n = -1")
      case _: Throwable => println("Test failed for findSolutions with n = -1 (unexpected exception type)")
    }

    try {
      findSolutions(n = 0)
      println("Test failed for findSolutions with n = 0 (expected exception)")
    } catch {
      case _: IllegalArgumentException => println("Test passed for findSolutions with n = 0")
      case _: Throwable => println("Test failed for findSolutions with n = 0 (unexpected exception type)")
    }
  }

  def testInvalidGetNextPosition(): Unit = {
    try {
      getNextPosition(List(), -5, -5)
      println("Test failed for getNextPosition with negative n (expected exception)")
    } catch {
      case _: IllegalArgumentException => println("Test passed for getNextPosition with negative n")
      case _: Throwable => println("Test failed for getNextPosition with negative n (unexpected exception type)")
    }

    try {
      getNextPosition(List(), 0, 0)
      println("Test failed for getNextPosition with n = 0 (expected exception)")
    } catch {
      case _: IllegalArgumentException => println("Test passed for getNextPosition with n = 0")
      case _: Throwable => println("Test failed for getNextPosition with n = 0 (unexpected exception type)")
    }
  }

  def testEdgeCasesGetNextPosition(): Unit = {
    try {
      val result = getNextPosition(List(), 0, 8)
      println(s"Test passed for getNextPosition with empty queens list, result: $result")
    } catch {
      case _: Throwable => println("Test failed for getNextPosition with empty queens list (unexpected exception)")
    }

    try {
      val result = getNextPosition(List((0, 0)), -1, 8)
      println(s"Test passed for getNextPosition with negative continueFromRow, result: $result")
    } catch {
      case _: Throwable => println("Test failed for getNextPosition with negative continueFromRow (unexpected exception)")
    }
  }

  def testPrintSolutions(): Unit = {
    try {
      printSolutions(List(List((0, 0), (1, 2), (2, 4), (3, 6))), 8, 3)
      println("Test passed for printSolutions with valid input")
    } catch {
      case _: Throwable => println("Test failed for printSolutions with valid input (unexpected exception)")
    }

    try {
      printSolutions(List(), 8, 3)
      println("Test passed for printSolutions with empty solutions list")
    } catch {
      case _: Throwable => println("Test failed for printSolutions with empty solutions list (unexpected exception)")
    }
  }

  def testZipAndMapTogether(): Unit = {
    try {
      val result = zipAndMapTogether(List(List("a", "b"), List("c", "d")), { case (a, b) => a + b })
      println(s"Test passed for zipAndMapTogether with valid input, result: $result")
    } catch {
      case _: Throwable => println("Test failed for zipAndMapTogether with valid input (unexpected exception)")
    }

    try {
      val result = zipAndMapTogether(List(List("a", "b")), { case (a, b) => a + b })
      println(s"Test passed for zipAndMapTogether with single list, result: $result")
    } catch {
      case _: Throwable => println("Test failed for zipAndMapTogether with single list (unexpected exception)")
    }
  }

  testValidFindSolutions()
  testInvalidFindSolutions()
  testInvalidGetNextPosition()
  testEdgeCasesGetNextPosition()
  testPrintSolutions()
  testZipAndMapTogether()
}
