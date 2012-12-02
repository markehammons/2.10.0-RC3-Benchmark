/**
 * Created with IntelliJ IDEA.
 * User: luft
 * Date: 12/1/12
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
object Bench extends App {
  def test(v: Benchmark, n: Int, times: Int) = {
    def runTest() = {
      System.gc()
      val start = System.currentTimeMillis()
      v.execute(n)
      System.currentTimeMillis() - start
    }

    def createReport(measurementType: String, data: Seq[Long]) {
      printf("\t%s results: \n\t\tAverage: \t%fms\n\t\tMedian: \t%dms\n\t\tMode: \t\t%dms\n\n",
        measurementType,
        ((data sum) / data.length.toDouble),
        (data sorted) apply (data.length / 2),
        ((data map (v => (data count (v == _)) -> v)) sortBy (_._1)).last._2
      )
    }

    val cold = (0 to times).map(x => runTest())
    val warm = (0 to times).map(x => runTest())

    println(v.name + "\n" + "_" * (v.name.length+10) + "\n")

    createReport("Cold", cold)
    createReport("Warm", warm)
  }

  test(Sundaram, 3000000, 60)
  test(Eratosthenes, 75000, 30)
  //test(ParallelPrimes, 3000000, 10)

}
