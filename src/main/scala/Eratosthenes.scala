/**
 * Created with IntelliJ IDEA.
 * User: luft
 * Date: 12/1/12
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
object Eratosthenes extends Benchmark {
  val name = "Sieve of Eratosthenes"

  def eratosthenes(toNum: Int) = {
    def sieveHelp(r: IndexedSeq[Int]): Stream[Int] = {
      if(r.isEmpty)
        Stream.empty
      else
        r.head #:: sieveHelp(r.tail.filterNot(_ % r.head == 0))
    }
    sieveHelp(2 +: (3 to toNum by 2))
  }

  def execute(n: Int) = eratosthenes(n).toList.length
}
