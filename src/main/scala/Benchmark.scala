/**
 * Created with IntelliJ IDEA.
 * User: luft
 * Date: 12/1/12
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 */
abstract class Benchmark {
  val name: String
  def execute(n: Int): Int

}
