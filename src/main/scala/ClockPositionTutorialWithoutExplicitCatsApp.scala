import ClockPosition._

object ClockPositionTutorialWithoutExplicitCatsApp extends App {

  val cp0 = ClockPosition.build(99)
  println(cp0)

  val cp3 = noon + ClockPosition(9) + ClockPosition(8) + ClockPosition(3)
  println(cp3)

  val cp4 = noon + noon + ClockPosition(2) + ClockPosition(10)
  println(cp4)

  val cp5 = Seq(1, 4, 7, 9, 11)
    .map(a => ClockPosition.build(a))
    .fold(noon)(_ + _)
  println(cp5)

}
