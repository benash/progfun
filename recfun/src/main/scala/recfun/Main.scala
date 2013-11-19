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
    def propPascal(c: Int, r: => Int): Int =
      if (c == 0) 1
      else pascal(c - 1, r - 1) + pascal(c, r - 1)

    if (c > r / 2) propPascal(r - c, r)
    else propPascal(c, r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceRest(n: Int, chars: List[Char]): Boolean =
      if (n < 0)
        false
      else if (chars.isEmpty)
        n == 0
      else if (chars.head == '(')
        balanceRest(n + 1, chars.tail)
      else if (chars.head == ')')
        balanceRest(n - 1, chars.tail)
      else balanceRest(n, chars.tail)
      
    balanceRest(0, chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    
      if (money == 0) 1
      else if (coins.isEmpty) 0
      else if (coins.head <= money)
        countChange(money - coins.head, coins) +
        countChange(money, coins.tail)
      else countChange(money, coins.tail)
  }
}
