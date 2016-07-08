/**
  * Created by JRGv89 on 30/6/16.
  */

import scala.util.matching.Regex

class Board() {
  var squares: List[Square] = List.tabulate(9)(n => {
    new Square(n, (n + 1).toString, false)
  })

  val winningPositions = List(
    List(0, 1, 2),
    List(3, 4, 5),
    List(6, 7, 8),
    List(0, 3, 6),
    List(1, 4, 7),
    List(2, 5, 8),
    List(0, 4, 8),
    List(6, 4, 2)
  )

  def isFinish: Boolean = {
    val state = winningPositions.filter(checkLine)
    if (state.isEmpty)
      false
    else
      true
  }

  def whoIsTheWinner(): String = {
    val state = winningPositions.filter(checkLine)
    if (state.isEmpty)
      "0"
    else if (squares(state.head.head).value.equals("X")) "1" else "2"
  }

  def allowNext(): Boolean = {
    val next = squares.filter(_.moved == false)
    if (next.isEmpty)
      false
    else
      true
  }

  def checkLine(line: List[Int]): Boolean = {
    if (squares(line.head).value.equals(squares(line(1)).value)
      && squares(line.head).value.equals(squares(line(2)).value))
      true
    else
      false
  }

  def move(squarePosition: Int, value: Int): Unit = {
    squares(squarePosition - 1).value = if (value == 1) "X" else "O"
    squares(squarePosition - 1).moved = true
  }


  def isMoveCorrect(move: String): Boolean = {
    val _move = new Regex("[1-9]+") findFirstIn move match {
      case Some(s) => Some(s).get.toInt
      case None => 0
    }
    if (_move <= 0 || _move > 9)
      false
    else !squares(_move - 1).moved

  }

  def printBoard(): Unit = {
    println("+-----+-----+-----+")
    println("|     |     |     |")
    println("|  %s  |  %s  |  %s  |".format(squares.head.value, squares(1).value, squares(2).value))
    println("|     |     |     |")
    println("+-----+-----+-----+")
    println("|     |     |     |")
    println("|  %s  |  %s  |  %s  |".format(squares(3).value, squares(4).value, squares(5).value))
    println("|     |     |     |")
    println("+-----+-----+-----+")
    println("|     |     |     |")
    println("|  %s  |  %s  |  %s  |".format(squares(6).value, squares(7).value, squares(8).value))
    println("|     |     |     |")
    println("+-----+-----+-----+")
  }
}
