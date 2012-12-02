/**
 * Created with IntelliJ IDEA.
 * User: luft
 * Date: 12/1/12
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
object ParallelPrimes extends Benchmark {
  val name = "Parallel Sieve of Sundaram"

  def sundaram(to: Int) = {
    val n = (to - 2)/2
    val nonPrimes = (1 to n).par flatMap(i => (i to (n - i) / (2 * i + 1)).par map (j => i+j+(2*i*j)))
    2 +: ((1 to n).par diff nonPrimes map (2*_+1))
  }

  def execute(n: Int) = {
    sundaram(n).length
  }

}
