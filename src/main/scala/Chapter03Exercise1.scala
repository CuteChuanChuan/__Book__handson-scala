def flexibleFizzBuzz(x: String => Unit): Unit = {
  for (i <- Range.inclusive(1, 100)) {
    x(
      if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
      else if (i % 3 == 0) "Fizz"
      else if (i % 5 == 0) "Buzz"
      else i.toString
    )
  }
}

flexibleFizzBuzz(s => {})
flexibleFizzBuzz(s => println(s))

var i = 0
val output = new Array[String](100)
flexibleFizzBuzz(x =>
  output(i) = x
  i += 1
)

output