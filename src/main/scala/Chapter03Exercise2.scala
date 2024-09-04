class Msg(val id: Int, val parent: Option[Int], val txt: String)

def printMessages(messages: Seq[Msg]): Unit = {
  def printFrag(parent: Option[Int], indent: String): Unit = {
    for (m <- messages if m.parent == parent) {
      println(s"$indent#${m.id} ${m.txt}")
      printFrag(Some(m.id), indent + "    ")
    }
  }

  printFrag(None, "")
}

