package DuplicatesRemover
import scala.io.Source

object DuplicatesRemover {
  def main(args: Array[String]): Unit = {
    val filename: String = args(0)
    val textSource = Source.fromFile(filename)
    val fileContents: String = textSource.mkString
    textSource.close()
    println(fileContents)
    // println(System.getProperty("user.dir"))
  }
}