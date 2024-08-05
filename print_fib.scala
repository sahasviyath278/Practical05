package practical_5

object print_fib {
  def run(): Unit = {
    def printFibonacci(n: Int): Unit = {
      def fibonacci(n: Int): Int = {
        if (n <= 1) n
        else fibonacci(n - 1) + fibonacci(n - 2)
      }

      for (i <- 0 until n) {
        print(fibonacci(i) + " ")
      }
    }

    print("Enter the number of terms: ")
    val n = scala.io.StdIn.readInt()
    printFibonacci(n)
    println()
  }
}
