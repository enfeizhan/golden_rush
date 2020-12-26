package RDDBasics
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object CreatingSparkContext {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("My First Application")
    sparkConf.setMaster("local")
    val sc = new SparkContext(sparkConf)
    val array = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    val arrayRDD = sc.parallelize(array, 2)
    println("Num of elements is RDD: ", arrayRDD.count())
    arrayRDD.foreach(println)
  }
}
