import cats.{Monoid, Show}
import cats.implicits._
//import cats.Show
//import cats.implicits.toShow

case class ClockPosition(hour: Int) {
  override def toString = this.show
}


case object ClockPosition {

  def build(a: Int): ClockPosition = {
    val clockPosition = a % 12
    if (clockPosition == 0) ClockPosition(12) else ClockPosition(clockPosition)
  }

  implicit val clockShow: Show[ClockPosition] = Show.show((cp:ClockPosition) => s"Clock showing ${cp.hour} o'Clock")

  val noon = ClockPosition(12)

  implicit object ClockPositionMonoid extends Monoid[ClockPosition] {
    override def empty: ClockPosition = noon

    override def combine(x: ClockPosition, y: ClockPosition): ClockPosition = ClockPosition.build(x.hour + y.hour)
  }

  implicit class ClockPositionSugar(clockPosition1: ClockPosition) {
    def `+`(implicit clockPosition2: ClockPosition): ClockPosition = clockPosition1 |+| clockPosition2
  }
}

