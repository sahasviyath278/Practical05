package practical_5

object inventoryManagement {
  def run(): Unit = {
    val products = get_product_list()
    print_product_list(products)
    val total_count = get_total_count(products)
    println(s"Total number of products: $total_count")
  }

  def get_product_list(): List[String] = {
    var product_list: List[String] = List()
    var product_name: String = ""
    println("Enter the product names. Enter 'done' to stop.")
    while (true && product_name != "done") {
      print("Enter the product name: ")
      product_name = scala.io.StdIn.readLine()
      product_list = product_name :: product_list
    }
    println()
    product_list = product_list.tail
    product_list
  }
  def print_product_list(product_list: List[String]): Unit = {
    product_list.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
    println()
  }
  def get_total_count(product_list: List[String]): Int = {
    product_list.length
  }
}
