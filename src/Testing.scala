import Main.findAllSolutions

object Testing extends App {
  // findAllSolutions()

  val res1 = findAllSolutions(8)
  val res2 = findAllSolutions(8)
  val res3 = findAllSolutions(8)
  val res4 = findAllSolutions(8)
  val res5 = findAllSolutions(8)
  val res6 = findAllSolutions(8)
  val res7 = findAllSolutions(8)

  val allEqual = (res1 == res2) && (res2 == res3) && (res3 == res4) &&
    (res4 == res5) && (res5 == res6) && (res6 == res7)

  if(allEqual)
    println("Test passed")
  else
    println("Test failed")
}
