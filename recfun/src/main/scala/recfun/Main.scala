package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) {
      1
    }
    else {
      pascal(c-1, r-1) + pascal(c, r-1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balance_parenthese(chars: List[Char], i: Int): Boolean = {
      if (chars.isEmpty) {
        i == 0
      }
      else if (i < 0) {
        /* For the ')' starts */
        false
      }
      else if (chars.head == '(') {
        //println((i+1).toString)
        balance_parenthese(chars.tail, i+1)
      }
      else if (chars.head == ')') {
        //println((i-1).toString)
        balance_parenthese(chars.tail, i-1)
      }
      else {
        balance_parenthese(chars.tail, i)
      }
    }

    //println()
    balance_parenthese(chars, 0)
  }

  /**
   * Exercise 3
   * Solution from the Book SCIP:
   * http://mitpress.mit.edu/sicp/full-text/book/book-Z-H-11.html
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    val desc_coins = coins.sorted.reverse
    /** 
     * Sorting in desceding order is not necessary, just for easy understanding.
     * */

    def count_change(money: Int, desc_coins: List[Int]): Int = {
      if (money == 0) {
        1
      }
      else if (desc_coins.isEmpty || money < 0) {
        0
      }
      else {
        count_change(money, desc_coins.tail) + 
        count_change(money - desc_coins.head, desc_coins)
      }
    }

    count_change(money, desc_coins)
  }
}
