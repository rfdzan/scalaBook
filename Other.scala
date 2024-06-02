package Other
import scala.collection.mutable.ArrayBuffer

def varIsMutable =
  var myInt = 3
  myInt = 4
  println(myInt)

def bigInts =
  var myBigInt = BigDecimal(109123.908102380)
  println(myBigInt)

def aList =
  var arrayBuf = ArrayBuffer[Int]()
  val myVec = Vector(1, 2, 3, 4, 5)
  myVec.foreach(i => arrayBuf.append(i))
  println(arrayBuf)

enum Coord[Int]:
  case X(value: Int)
  case Y(value: Int)

def matchMain =
  val newCoord = Coord.X(4)
  val otherCoord = Coord.X(5)
  val newCoordval = newCoord match
    case Coord.X(value) => value
    case Coord.Y(value) => value
  println("matchMain")
  println(newCoordval)
