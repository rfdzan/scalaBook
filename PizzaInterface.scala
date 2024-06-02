package PizzaInterface:
  import PizzaPackage.{Pizza, Topping, CrustType, CrustSize}
  import PizzaPackage.Topping.*
  import PizzaPackage.Pizza.{crustPrice, toppingPrice,calculatePrice}

  trait MakePizza:
    def create(ct: CrustType, cs: CrustSize, t: Seq[Topping]): Pizza
    def price(p: Pizza): Double

  object DeliverPizza extends MakePizza:
    def create(ct: CrustType, cs: CrustSize, t: Seq[Topping]): Pizza = 
      Pizza(cs, ct, t)
    def price(p: Pizza): Double =
      calculatePrice(p.crustType, p.crustSize, p.toppings, toppingPrice, crustPrice)
  end DeliverPizza

  def mainPizzaWithInterface: Double =
    val pizza = DeliverPizza.create(CrustType.Thick, CrustSize.Large, Vector(Cheese, Onions, Pepperoni))
    DeliverPizza.price(pizza)






