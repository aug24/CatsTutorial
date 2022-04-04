import ClockPosition._
//import cats.implicits._
//import cats.kernel.Semigroup

object ClockPositionTutorialApp extends App {

  val cp0 = ClockPosition.build(99)
  println(cp0)

//  val cp1 = Semigroup.combine(ClockPosition(6), ClockPosition(10))
//  println(cp1)
//
//  val cp2 = ClockPosition(7) |+| ClockPosition(11)
//  println(cp2)

  val cp3 = noon + ClockPosition(9) + ClockPosition(8) + ClockPosition(3)
  println(cp3)
}
