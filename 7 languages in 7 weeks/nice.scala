class Person(val firstName: String)

trait Nice {
  def greet() = println("Greetings!")
}

class Character(override val firstName: String) extends Person(firstName) with Nice

val flanders = new Character("Ned")
flanders.greet()
