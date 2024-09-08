package LocalDevelopment

object MergeSrot extends App {
  def mergeSrot[T: Ordering](items: IndexedSeq[T]): IndexedSeq[T] = {
    if (items.length <= 1) items
    else {
      val (left, right) = items.splitAt(n = items.length / 2)
      val (sortedLeft, sortedRight) = (mergeSrot(left), mergeSrot(right))
      var (leftIdx, rightIdx) = (0, 0)
      val output = IndexedSeq.newBuilder[T]
      
      while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
        val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
          case (true, false) => true
          case (false, true) => false
          case (true, true) => Ordering[T].lt(sortedLeft(leftIdx), sortedRight(rightIdx))
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
  println(mergeSrot(Vector("banana", "apple", "durian", "cabbage")).mkString(", "))
}
