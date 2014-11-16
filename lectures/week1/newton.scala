def abs(x: Double) = if (x < 0) -x else x

def isGoodEnough(guess: Double, x: Double) = (guess * guess - x) < 0.001

def improve(guess: Double, x: Double) = (guess + x / guess) / 2

def sqrtIter(guess: Double, x: Double): Double = {
  if (isGoodEnough(guess, x))
    guess
  else
    //println(guess)
    sqrtIter(improve(guess, x), x)
}

def sqrt(x: Double) = sqrtIter(1.0, x)

//sqrt(2.0)
sqrt(1e-6)
