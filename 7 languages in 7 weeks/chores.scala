def doChore(chore: String) = chore match {
  case "A" => "AAA"
  case "B" => "BBB"
  case _ => "other"
}

println(doChore("B"))
println(doChore("D"))
