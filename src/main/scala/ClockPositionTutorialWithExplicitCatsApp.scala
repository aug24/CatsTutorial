import ClockPosition._
import cats.implicits._
import cats.kernel.Semigroup


object ClockPositionTutorialWithExplicitCatsApp extends App {


  val cp1 = Semigroup.combine(ClockPosition(6), ClockPosition(10))
  println(cp1)

  val cp2 = ClockPosition(7) |+| ClockPosition(11)
  println(cp2)

}
