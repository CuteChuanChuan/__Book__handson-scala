package LocalDevelopment

class Trie {
  class Node(var hasValue: Boolean,
             var children: collection.mutable.Map[Char, Node] = collection.mutable.Map())
  val root = new Node(false)
  
  def add(s: String): Unit = {
    var current = root
    for (c <- s) current = current.children.getOrElseUpdate(c, new Node(false))
    current.hasValue = true
  }
  
  def contain(s: String): Boolean = {
    var current = Option(root)
    for (c <- s if current.nonEmpty) current = current.get.children.get(c)
    current.exists(_.hasValue)
  }
  
  def prefixesMatchingString0(s: String): Set[Int] = {
    var current = Option(root)
    val output = Set.newBuilder[Int]
    for ((c, i) <- s.zipWithIndex if current.nonEmpty) {
      if (current.get.hasValue) output += i
      current = current.get.children.get(c)
    }
    if (current.exists(_.hasValue)) output += s.length
    output.result()
  }
  
  def prefixesMatchingString(s: String): Set[String] = {
    prefixesMatchingString0(s).map(s.substring(0, _))
  }
  
  def stringMatchingPrefix(s: String): Set[String] = {
    var current = Option(root)
    for (c <- s if current.nonEmpty) current = current.get.children.get(c)
    if (current.isEmpty) Set()
    else {
      val output = Set.newBuilder[String]
      def recurse(current: Node, path: List[Char]): Unit = {
        if (current.hasValue) output += (s + path.reverse.mkString)
        for ((c, n) <- current.children) recurse(n, c :: path)
      }
      recurse(current.get, Nil)
      output.result()
    }
  }
  
}


object TrieApp extends App {
  private val trie = new Trie
  trie.add("mango")
  trie.add("mandarin")
  trie.add("map")
  trie.add("man")
  
  println(trie.contain("mango"))
  println(trie.contain("mang"))
  println(trie.contain("man"))
  println(trie.contain("mandarin"))
  println(trie.contain("mandarine"))
  
  println(trie.prefixesMatchingString0("mani"))
  println(trie.prefixesMatchingString("mangod"))
  println(trie.stringMatchingPrefix("man"))
}