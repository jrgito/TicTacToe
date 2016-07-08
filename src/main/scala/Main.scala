import scala.util.Random

/**
  * Created by JRGv89 on 28/6/16.
  */
object Main extends App {

  var finish = false
  var turn: Int = 0
  var board = new Board()
  val random = new Random()
  turn = random.nextInt(2) + 1

  while (board.allowNext() && !finish) {
    board.printBoard()
    val move = scanTurn(turn)
    if (board.isMoveCorrect(move)) {
      board.move(move.toInt, turn)
      finish = board.isFinish
      turn = changeTurn(turn)
    }else{
      println("wrong move!!")
    }
  }
  printFinishGame()

  def changeTurn(turn: Int): Int = {
    if (turn == 1) 2 else 1
  }

  def printTurn(turn: Int): Unit = {
    println("-------------------")
    println("Player " + turn + " turn")
  }

  def scanTurn(turn: Int): String = {
    val move = scala.io.StdIn.readLine("Player " + turn + " turn -> ")
    println("-------------------")
    println()
    move
  }

  def printFinishGame() = {
    board.printBoard()
    val winner = board.whoIsTheWinner()
    println("-------------------")
    if (winner.equals("0"))
      println("The game is a draw")
    else {
      println("The winner is " + winner)
    }
    println("-------------------")
  }

}
