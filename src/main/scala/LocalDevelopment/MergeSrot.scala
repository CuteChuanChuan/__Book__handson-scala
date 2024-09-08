package LocalDevelopment

object MergeSrot extends App {
  def mergeSrot(items: Array[Int]): Array[Int] = {
    if (items.length <= 1) items
    else {
      val (left, right) = items.splitAt(n = items.length / 2)
      val (sortedLeft, sortedRight) = (mergeSrot(left), mergeSrot(right))
      var (leftIdx, rightIdx) = (0, 0)
      val output = Array.newBuilder[Int]
      
      while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
        val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
          case (true, false) => true
          case (false, true) => false
          case (true, true) => sortedLeft(leftIdx) < sortedRight(rightIdx)
        }
        if (takeLeft) {
          output += sortedLeft(leftIdx)
          leftIdx += 1
        } else {
          output += sortedRight(rightIdx)
          rightIdx += 1
        }
      }
      output.result()
    }
  }
  
  println(mergeSrot(Array(77, 2, 654, 99, 0 , 28, 43, 1023, 37)).mkString(", "))
}
