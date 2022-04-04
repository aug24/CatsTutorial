import cats.Show
import cats.implicits.toShow

object CatAreaTutorial extends App {

  trait Area[A] {
    def area(a: A): Double
  }

  case class Rectangle(width: Double, length: Double)

  case class Circle(radius: Double)

  implicit val rectangleArea: Area[Rectangle] = (a: Rectangle) => a.width * a.length

  implicit val circleArea: Area[Circle] = (a: Circle) => Math.PI * (a.radius * a.radius)

  implicit class AreaSugar[A](a: A) {
    def areaOf(implicit shape: Area[A]): Double = shape.area(a)
  }

  implicit val rectangleShow: Show[Rectangle] = Show.show((r:Rectangle) =>
    s"Rectangle with width ${r.width} and length ${r.length}")

  implicit val circleShow: Show[Circle] = Show.show((c:Circle) =>
    s"Circle with radius ${c.radius}")

  val myBox = Rectangle(3d, 2d)
  println("--------- rectangle ----------")
  println(myBox.show)
  println(myBox.areaOf)

  val myCircle = Circle(3)
  println("--------- circle ----------")
  println(myCircle.show)
  println(myCircle.areaOf)
}
