/**
 * Created with IntelliJ IDEA.
 * User: luft
 * Date: 12/1/12
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
object Sundaram extends Benchmark {
  val name = "Sieve of Sundaram"

  def sundaram(toNum: Int) = {
    val n = (toNum - 2)/2
    val nonPrimes = for (i <- 1 to n; j <- i to (n - i) / (2 * i + 1)) yield i+j+(2*i*j)
    2 +:((1 to n) diff nonPrimes map (2*_+1))
  }

  def execute(n: Int) = sundaram(n).length
}
