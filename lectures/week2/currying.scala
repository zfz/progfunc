/* */
def sumInts(a: Int, b: Int): Int = 
  if (a > b) 0 else a + sumInts(a+1, b)
println(sumInts(3,5))

def cube(x: Int): Int = x * x * x
def sumCubes(a: Int, b: Int): Int = 
  if (a > b) 0 else cube(a) + sumCubes(a+1, b)
println(sumCubes(3,4))


/* */
def sum(f: Int => Int, a: Int, b: Int): Int = {
  if (a > b) 0
  else f(a) + sum(f, a+1, b)
}
def sumCubes1(a: Int, b: Int) = sum(x => x * x * x, a, b)
println(sumCubes1(3,4))


/* */
def sum1(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int = 
    if (a > b) 0
    else f(a) + sumF(a+1, b)
  sumF
}
def sumCubes2 = sum1(x => x * x * x)
println(sumCubes2(3,4))


/* sum2 is equavalent to sum1 */
def sum2(f: Int => Int)(a: Int, b: Int): Int = 
  if (a > b) 0 else f(a) + sum2(f)(a+1, b)
//def sumCubes3 = sum2(x => x * x * x)
//println(sumCubes3(3,4))
/* not work */
println(sum2(x => x * x * x)(3,4))
