package forcomp
import Anagrams._

object ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  
  val x = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> x  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val y = List(('r', 1))                          //> y  : List[(Char, Int)] = List((r,1))
  
  val a = List(2, 4, 6)                           //> a  : List[Int] = List(2, 4, 6)
  val b = List(4, 3, 2)                           //> b  : List[Int] = List(4, 3, 2)
  
  for {
    i <- a
    j <- b
  } yield (j)                                     //> res0: List[Int] = List(4, 3, 2, 4, 3, 2, 4, 3, 2)
  
  Map().updated(3, 4)                             //> res1: scala.collection.immutable.Map[Int,Int] = Map(3 -> 4)
  
  wordAnagrams("asdf")                            //> res2: List[forcomp.Anagrams.Word] = List()
  sentenceAnagrams(List("i", "love", "you"))      //> res3: List[forcomp.Anagrams.Sentence] = List(List(Io, Lev, you), List(Io, yo
                                                  //| u, Lev), List(Lev, Io, you), List(Lev, you, Io), List(olive, you), List(you,
                                                  //|  Io, Lev), List(you, Lev, Io), List(you, olive))
  
  
  val cur = combinations(sentenceOccurrences(List("I", "I")))
                                                  //> cur  : List[forcomp.Anagrams.Occurrences] = List(List(), List((i,1)), List((
                                                  //| i,2)))
  cur.tail.head                                   //> res4: forcomp.Anagrams.Occurrences = List((i,1))
  val words = dictionaryByOccurrences(List(('a', 1), ('e', 1), ('t', 1)))
                                                  //> words  : List[forcomp.Anagrams.Word] = List(ate, eat, tea)



  List(('a', 1), ('e', 1), ('t', 1)) == List(('a', 1), ('e', 1), ('t', 1))
                                                  //> res5: Boolean = true
}