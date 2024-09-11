package LocalDevelopment

import scala.annotation.tailrec

object BinarySearch extends App {
  
  private def binarySearch[T: Ordering](sorted: IndexedSeq[T], target: T): Boolean = {
    // find middle -> target < middle => left part; target > middle => right part
    // create left and right bound; move corresponding bound based on comparison result
    // until left bound not < right bound
    @tailrec
    def binarySearch0(start: Int, end: Int): Boolean = {
      if (start == end) false
      else {
        val middleIdx = (start + end) / 2
        val middleItem = sorted(middleIdx)
        val comparison = Ordering[T].compare(target, middleItem)
        if (comparison == 0) true
        else if (comparison < 0) binarySearch0(start = start, end = middleIdx)
        else  binarySearch0(start = middleIdx + 1, end = end)
      }
    }
    binarySearch0(0, sorted.length)
  }
  
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 3)) == true)
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 9)) == true)
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 7)) == true)
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 8)) == false)
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 2)) == false)
  assert(pprint.log(binarySearch(Array(1, 3, 7, 9, 13), 100)) == false)
  assert(pprint.log(binarySearch(Vector("i", "am", "cow", "hear", "me", "moo"), "cow")) == true)
  assert(pprint.log(binarySearch(Vector("i", "am", "cow", "hear", "me", "moo"), "moo")) == true)
  assert(pprint.log(binarySearch(Vector("i", "am", "cow", "hear", "me", "moo"), "horse")) == false)
  
}
