import cats.Monoid
import cats.implicits._
import cats.kernel.Semigroup

object ClockPositionTutorial extends App {

  case class ClockPosition(hour: Int)

  case object ClockPosition {
    def build(a: Int): ClockPosition = {
      val clockPosition = a % 12
      if (clockPosition == 0) ClockPosition(12) else ClockPosition(clockPosition)
    }
  }

  val cp0 = ClockPosition.build(99)
  println(cp0)




  implicit object ClockPositionMonoid extends Monoid[ClockPosition] {
    override def empty: ClockPosition = ClockPosition(12)
    override def combine(x: ClockPosition, y: ClockPosition): ClockPosition = ClockPosition.build(x.hour + y.hour)
  }

  val cp1 = Semigroup.combine(ClockPosition(6), ClockPosition(10))
  println(cp1)

  val cp2 = ClockPosition(7) |+| ClockPosition(11)
  println(cp2)




  implicit class ClockPositionSugar(clockPosition1: ClockPosition) {
    def `+`(implicit clockPosition2: ClockPosition):ClockPosition = clockPosition1 |+| clockPosition2
  }

  val cp3 = ClockPositionMonoid.empty + ClockPosition(9)
  println(cp3)
}
