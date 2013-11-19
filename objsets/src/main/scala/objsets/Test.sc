package objsets

object Test {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
                                                  //> google  : List[String] = List(android, Android, galaxy, Galaxy, nexus, Nexus
                                                  //| )
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")
                                                  //> apple  : List[String] = List(ios, iOS, iphone, iPhone, ipad, iPad)
  lazy val googleTweets: TweetSet = TweetReader.allTweets.filter(tweet => google.exists(item => tweet.text.contains(item)))
                                                  //> googleTweets: => objsets.TweetSet
  lazy val appleTweets: TweetSet = TweetReader.allTweets.filter(tweet => apple.exists(item => tweet.text.contains(item)))
                                                  //> appleTweets: => objsets.TweetSet
  
  val t1 = new Tweet("bob", "im the best", 3)     //> t1  : objsets.Tweet = User: bob
                                                  //| Text: im the best [3]
  val t2 = new Tweet("jim", "hi", 10)             //> t2  : objsets.Tweet = User: jim
                                                  //| Text: hi [10]
  val t3 = new Tweet("sue", "ksjkd", 2)           //> t3  : objsets.Tweet = User: sue
                                                  //| Text: ksjkd [2]
  val t4 = new Tweet("tom", "heelo", 13)          //> t4  : objsets.Tweet = User: tom
                                                  //| Text: heelo [13]
  val t5 = new Tweet("alf", "asdf", 30)           //> t5  : objsets.Tweet = User: alf
                                                  //| Text: asdf [30]
  
  val ts = new Empty incl t1 incl t5 incl t2 incl t3 incl t4
                                                  //> ts  : objsets.TweetSet = objsets.NonEmpty@1660bb22
  ts.contains(t1)                                 //> res0: Boolean = true
  val filtered = ts.filter(tweet => tweet.retweets > 10)
                                                  //> filtered  : objsets.TweetSet = objsets.NonEmpty@bf020af
  filtered.contains(t1)                           //> res1: Boolean = false
  filtered.contains(t2)                           //> res2: Boolean = false
  filtered.contains(t3)                           //> res3: Boolean = false
  filtered.contains(t4)                           //> res4: Boolean = true
  filtered.contains(t5)                           //> res5: Boolean = true
  
   
  (googleTweets union appleTweets).mostRetweeted  //> res6: objsets.Tweet = User: gizmodo
                                                  //| Text: iPhone 5's brain dissected. Guess what, it's made by Samsung. http://t
                                                  //| .co/wSyjvpDc [321]
}