import scala.actors.Actor

case object Poke
case object Feed

class Kid(name: String) extends Actor {
  def act() {
    loop {
      react {
        case Poke => {
          println(name+" POKE start")
          println(name+" POKE finish")
        }
        case Feed => {
          println(name+" FEED start")
          println(name+" FEED finish")
        }
      }
    }
  }
}

val bart = new Kid("bart").start
val lisa = new Kid("lisa").start

bart ! Poke
lisa ! Poke
bart ! Feed
lisa ! Feed
