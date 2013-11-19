package streams

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import Bloxorz._

@RunWith(classOf[JUnitRunner])
class BloxorzSuite extends FunSuite {

  trait SolutionChecker extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }

  trait Level1 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooToo
      |------ooo-""".stripMargin

    val optsolution = List(Right, Right, Down, Right, Right, Right, Down)
  }

  trait Level2 extends SolutionChecker {
      /* terrain for level 1*/

    val level =
    """ooo-------
      |oSoooo----
      |ooooooooo-
      |-ooooooooo
      |-----ooooo
      |-T----ooo-""".stripMargin

    val optsolution = List()
  }

  test("terrain function level 1") {
    new Level1 {
      assert(terrain(Pos(0,0)), "0,0")
      assert(terrain(Pos(0,1)), "0,1")
      assert(terrain(Pos(0,2)), "0,2")
      assert(!terrain(Pos(0,3)), "0,3")
      assert(terrain(Pos(1,0)), "1,0")
      assert(terrain(Pos(1,1)), "1,1")
      assert(terrain(Pos(1,2)), "1,2")
      assert(!terrain(Pos(4,11)), "4,11")
      assert(!terrain(Pos(-1,0)), "-1,0")
      assert(terrain(Pos(4,7)), "4,7")
      
    }
  }

  test("findChar level 1") {
    new Level1 {
      assert(startPos == Pos(1,1))
    }
  }
  
  test("isStanding") {
    new Level1 {
     assert(Block(Pos(2, 3), Pos(2, 3)).isStanding)
     assert(!Block(Pos(2, 3), Pos(3, 3)).isStanding)
    }
  }

  test("neighborsWithHistory") {
    new Level1 {
      assert(neighborsWithHistory(Block(Pos(1,1),Pos(1,1)), List(Left,Up)).toSet ==
        Set((Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)), (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))))
    }
  }
  
  test("newNeighborsOnly") {
    new Level1 {
      assert(newNeighborsOnly(
		Set(
		  (Block(Pos(1,2),Pos(1,3)), List(Right,Left,Up)),
		  (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
		).toStream,
		
		Set(Block(Pos(1,2),Pos(1,3)), Block(Pos(1,1),Pos(1,1)))
	  ) ==  Set(
    (Block(Pos(2,1),Pos(3,1)), List(Down,Left,Up))
  ).toStream)
    }
  }

  test("pathsFromStart") {
    new Level1 {
      assert(pathsFromStart.tail.head._1 != startBlock)
    }
  }

  test("optimal solution length for level 2") {
    new Level2 {
      assert(solution.length == optsolution.length)
    }
  }
}
