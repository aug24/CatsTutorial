import cats.Monoid
import cats.implicits._


case class ClockPosition(hour: Int)

case object ClockPosition {
  def build(a: Int): ClockPosition = {
    val clockPosition = a % 12
    if (clockPosition == 0) ClockPosition(12) else ClockPosition(clockPosition)
  }

  val noon = ClockPosition(12)

  implicit object ClockPositionMonoid extends Monoid[ClockPosition] {
    override def empty: ClockPosition = noon

    override def combine(x: ClockPosition, y: ClockPosition): ClockPosition = ClockPosition.build(x.hour + y.hour)
  }

  implicit class ClockPositionSugar(clockPosition1: ClockPosition) {
    def `+`(implicit clockPosition2: ClockPosition): ClockPosition = clockPosition1 |+| clockPosition2
  }
}

