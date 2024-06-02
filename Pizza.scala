package PizzaPackage
import CrustSize.*
import CrustType.*
import Topping.*

// model the pizza
case class Pizza(
  crustSize: CrustSize,
  crustType: CrustType,
  toppings: Seq[Topping]
)

enum CrustSize:
  case Small, Medium, Large
enum CrustType:
  case Thin, Thick, Regular
enum Topping:
  case Cheese, Pepperoni, BlackOlives, GreenOlives, Onions

object Pizza:
  def price(p: Pizza): Double =
    calculatePrice(p.crustType, p.crustSize, p.toppings, toppingPrice, crustPrice)

  def calculatePrice(crustType: CrustType, crustSize: CrustSize, toppings: Seq[Topping], f: Topping => Double, g: (CrustType, CrustSize) => Double): Double =
    g(crustType, crustSize) + toppings.map(f).sum()     

  def toppingPrice(t: Topping): Double =
    t match
      case Cheese      => 0.35
      case BlackOlives => 0.45
      case GreenOlives => 0.77
      case Onions      => 0.20
      case Pepperoni   => 0.5

  def crustPrice(crustType: CrustType, crustSize: CrustSize): Double =
    (crustSize, crustType) match
      case (Small, _)       => 0.25
      case (Medium, _)      => 0.35
      case (Large, Thin)    => 0.50
      case (Large, Regular) => 1.00
      case (Large, Thick)   => 1.15
  // export toppingPrice, crustPrice

def mainPizza =
  val myPizza = Pizza(
    CrustSize.Large,
    CrustType.Thick,
    Vector(Topping.Cheese, Topping.Pepperoni, Topping.Onions, Topping.BlackOlives)
  )
  Pizza.price(myPizza)
