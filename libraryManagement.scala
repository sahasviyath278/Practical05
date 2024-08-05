package practical_5

case class Book(title: String, author: String, ISBN: String)

object libraryManagement {
  def run(): Unit = {

    var book_list: Set[Book] = Set(
      Book("The Great Gatsby", "F. Scott Fitzgerald", "9780"),
      Book("To Kill a Mockingbird", "Harper Lee", "9781"),
      Book("1984", "George Orwell", "9745")
    )
    display_books_by_author(book_list)
    add_book(book_list)
    book_list = remove_book(book_list)
    check_existence(book_list)
    display_library(book_list)
    search_book_by_title(book_list)
  }

  def add_book(book_list: Set[Book]): Set[Book] = {
    print("Enter the book title: ")
    val title = scala.io.StdIn.readLine()
    print("Enter the author name: ")
    val author = scala.io.StdIn.readLine()
    print("Enter the ISBN: ")
    val ISBN = scala.io.StdIn.readLine()
    book_list + Book(title, author, ISBN)
    book_list
  }
  def remove_book(book_list: Set[Book]): Set[Book] = {
    print("Enter the book ISBN to remove: ")
    val ISBN = scala.io.StdIn.readLine()
    book_list.filterNot(_.ISBN == ISBN)
  }
  def check_existence(book_list: Set[Book]): Unit = {
    print("Enter the book ISBN to check: ")
    val ISBN = scala.io.StdIn.readLine()
    if (book_list.exists(_.ISBN == ISBN)) {
      println("Book exists.")
    } else {
      println("Book does not exist.")
    }
  }

  def display_library(book_list: Set[Book]): Unit = {
    println("Library Collection:")
    book_list.foreach(book =>
      println(
        s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.ISBN}"
      )
    )
  }

  def search_book_by_title(book_list: Set[Book]): Unit = {
    print("Enter the book title to search: ")
    val title = scala.io.StdIn.readLine()
    val matchingBooks =
      book_list.filter(_.title.toLowerCase == title.toLowerCase)
    if (matchingBooks.nonEmpty) {
      println("Matching Books:")
      matchingBooks.foreach(book =>
        println(
          s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.ISBN}"
        )
      )
    } else {
      println("No matching books found.")
    }
  }

  def display_books_by_author(book_list: Set[Book]): Unit = {
    print("Enter the author name to search: ")
    val author = scala.io.StdIn.readLine()
    val booksByAuthor =
      book_list.filter(_.author.toLowerCase == author.toLowerCase)
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book =>
        println(
          s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.ISBN}"
        )
      )
    } else {
      println(s"No books found by $author.")
    }
  }
}
