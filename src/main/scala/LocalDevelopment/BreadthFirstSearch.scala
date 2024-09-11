package LocalDevelopment

object BreadthFirstSearch extends App {
  private def search[T](start: T, graph: Map[T, Seq[T]]): Set[T] = {
    val seen = collection.mutable.Set(start)
    val queue = collection.mutable.ArrayDeque(start)
    while (queue.nonEmpty) {
      val current = queue.removeHead()
      for (next <- graph(current) if !seen.contains(next)) {
        seen.add(next)
        queue.append(next)
      }
    }
    seen.to(Set)
  }
  
  private def searchPath[T](start: T, graph: Map[T, Seq[T]]): Map[T, List[T]] = {
    val seen = collection.mutable.Map(start -> List(start))
    val queue = collection.mutable.ArrayDeque(start -> List(start))
    while (queue.nonEmpty) {
      val (current, path) = queue.removeHead()
      for (next <- graph(current) if !seen.contains(next)) {
        val newPath = next :: path
        seen(next) = newPath
        queue.append((next, newPath))
      }
    }
    println(seen)
    seen.toMap
  }
  
  def shortestPath[T](start: T, dest: T, graph: Map[T, Seq[T]]) : Seq[T] = {
    val shortestReversedPaths = searchPath(start, graph)
    shortestReversedPaths(dest).reverse
  }
  
  println(search(start = "c", graph = Map("a" -> Seq("b", "c"), "b" -> Seq("a"), "c" -> Seq("b"))))
  println(search(start = "a", graph = Map("a" -> Seq("b", "c"), "b" -> Seq("c", "d"), "c" -> Seq("d"), "d" -> Seq())))
  println(search(start = "c", graph = Map("a" -> Seq("b", "c"), "b" -> Seq("c", "d"), "c" -> Seq("d"), "d" -> Seq())))
  println(shortestPath(start = "a", dest = "d", graph = Map("a" -> Seq("b", "c"), "b" -> Seq("c", "d"), "c" -> Seq("d"), "d" -> Seq())))
}
