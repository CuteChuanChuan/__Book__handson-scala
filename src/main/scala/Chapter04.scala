object Chapter04 extends App {
  
  private def stdDev(a: Array[Double]): Double = {
    val mean = a.foldLeft(0.0)(_ + _) / a.length
    val squareErrors = a.map(_ - mean).map(x => x * x)
    math.sqrt(squareErrors.foldLeft(0.0)(_ + _) / a.length)
  }
  
  println(stdDev(Array(1, 2, 3)))
  
}
