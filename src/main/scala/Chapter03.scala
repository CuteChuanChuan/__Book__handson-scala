object Chapter03 {
  private def fizzBuzz(): Unit =
    for (i <- Range.inclusive(1, 100)) {
      println(
        if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
        else if (i % 3 == 0) "Fizz"
        else if (i % 5 == 0) "Buzz"
        else i
      )
    }
  
  private def fizzBuzzYield(): Seq[Any] = {
    for (i <- Range.inclusive(1, 100)) yield {
      if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
      else if (i % 3 == 0) "Fizz"
      else if (i % 5 == 0) "Buzz"
      else i
    }
  }
  
  private def yieldToCreateNewCollection: Array[Int] = {
    val originalArray = Array(1, 2, 3, 4)
    val arrayYielded = for (i <- originalArray if i % 2 == 0) yield i * i
    arrayYielded
  }
  
  private def hello(title: String, firstName: String, lastName: Option[String]): Unit = {
    lastName match {
      case Some(lastName) => println(s"Hello, $title. $lastName")
      case None => println(s"Hello $firstName")
    }
  }
  
  
  
  def main(args: Array[String]): Unit = {
    fizzBuzz()
    hello("Mr", "John", None)
    hello("Mr", "John", Some("Doe"))
    println(yieldToCreateNewCollection.mkString(", "))
    println(fizzBuzzYield().mkString(", "))
  }
}
