import scala.actors.Actor
import scala.io.Source
import Actor._

object PageLoader {
  def getPageSize(url: String) = Source.fromURL(url).mkString.length
}

val urls = List("http://www.google.com", "http://www.bing.com", "http://www.yahoo.com")

def timeMethod(method: () => Unit) = {
  val start = System.nanoTime
  method()
  val finish = System.nanoTime
  println("Took: "+(finish - start)/1000000+" millis")
}

def getPageSizeSequantially() = {
  for (url <- urls) {
    println("size for "+url+" : "+PageLoader.getPageSize(url))
  }
}

def getPageSizeConcurrently() = {
  val caller = self

  for (url <- urls) {
    actor { caller ! (url, PageLoader.getPageSize(url) ) }
  }

  for (i <- 1 to urls.size) {
    receive {
      case(url, size) => println("size for "+url+" : "+size)
    }
  }
}

println("Sequantial:")
timeMethod { getPageSizeSequantially }

println("Concurrent:")
timeMethod { getPageSizeConcurrently }
