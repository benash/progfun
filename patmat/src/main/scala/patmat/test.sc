package patmat

object test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  Huffman.times(Nil).isEmpty                      //> res0: Boolean = true
  val freqs = Huffman.times(Huffman.string2Chars("This function computes for each unique character in the list `chars` the number of"))
                                                  //> freqs  : List[(Char, Int)] = List((T,1), (h,6), (i,5), (s,4), ( ,13), (f,3),
                                                  //|  (u,5), (n,5), (c,6), (t,6), (o,4), (m,2), (p,1), (e,7), (r,5), (a,4), (q,1)
                                                  //| , (l,1), (`,2), (b,1))
  val leaves = Huffman.makeOrderedLeafList(freqs) //> leaves  : List[patmat.Huffman.Leaf] = List(Leaf(b,1), Leaf(l,1), Leaf(q,1), 
                                                  //| Leaf(p,1), Leaf(T,1), Leaf(`,2), Leaf(m,2), Leaf(f,3), Leaf(a,4), Leaf(o,4),
                                                  //|  Leaf(s,4), Leaf(r,5), Leaf(n,5), Leaf(u,5), Leaf(i,5), Leaf(t,6), Leaf(c,6)
                                                  //| , Leaf(h,6), Leaf(e,7), Leaf( ,13))
  Huffman.until(Huffman.singleton, Huffman.combine)(leaves)
                                                  //> res1: List[patmat.Huffman.CodeTree] = List(Fork(Fork(Fork(Leaf(e,7),Fork(Lea
                                                  //| f(a,4),Leaf(o,4),List(a, o),8),List(e, a, o),15),Fork(Fork(Leaf(s,4),Fork(Le
                                                  //| af(m,2),Fork(Leaf(T,1),Fork(Leaf(q,1),Leaf(p,1),List(q, p),2),List(T, q, p),
                                                  //| 3),List(m, T, q, p),5),List(s, m, T, q, p),9),Fork(Leaf(u,5),Leaf(i,5),List(
                                                  //| u, i),10),List(s, m, T, q, p, u, i),19),List(e, a, o, s, m, T, q, p, u, i),3
                                                  //| 4),Fork(Fork(Fork(Leaf(r,5),Leaf(n,5),List(r, n),10),Fork(Leaf(t,6),Leaf(c,6
                                                  //| ),List(t, c),12),List(r, n, t, c),22),Fork(Fork(Leaf(h,6),Fork(Leaf(f,3),For
                                                  //| k(Fork(Leaf(b,1),Leaf(l,1),List(b, l),2),Leaf(`,2),List(b, l, `),4),List(f, 
                                                  //| b, l, `),7),List(h, f, b, l, `),13),Leaf( ,13),List(h, f, b, l, `,  ),26),Li
                                                  //| st(r, n, t, c, h, f, b, l, `,  ),48),List(e, a, o, s, m, T, q, p, u, i, r, n
                                                  //| , t, c, h, f, b, l, `,  ),82))
  Huffman.createCodeTree(Huffman.string2Chars("If you are able to "))
                                                  //> res2: patmat.Huffman.CodeTree = Fork(Fork(Fork(Fork(Leaf(b,1),Leaf(r,1),List
                                                  //| (b, r),2),Fork(Leaf(t,1),Leaf(l,1),List(t, l),2),List(b, r, t, l),4),Fork(Fo
                                                  //| rk(Leaf(f,1),Leaf(I,1),List(f, I),2),Fork(Leaf(u,1),Leaf(y,1),List(u, y),2),
                                                  //| List(f, I, u, y),4),List(b, r, t, l, f, I, u, y),8),Fork(Leaf( ,5),Fork(Leaf
                                                  //| (o,2),Fork(Leaf(e,2),Leaf(a,2),List(e, a),4),List(o, e, a),6),List( , o, e, 
                                                  //| a),11),List(b, r, t, l, f, I, u, y,  , o, e, a),19)
  Huffman.decodedSecret                           //> res3: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  
  List(1, 2, 3, 4) ::: List(5, 6, 7, 8)           //> res4: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)
  Huffman.decode(Huffman.frenchCode, Huffman.encode(Huffman.frenchCode)(Huffman.decodedSecret))
                                                  //> res5: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
  Huffman.decode(Huffman.frenchCode, Huffman.quickEncode(Huffman.frenchCode)(Huffman.decodedSecret))
                                                  //> res6: List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)

  
}