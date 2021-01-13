package RDDBasics
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.functions


object CreatingSparkContext {
  def homestateMap_(state: String): String = {
    if (state == "victoria") {
      return "vic"
    } else if (state == "newsouthwales") {
      return "nsw"
    } else if (state == "queensland") {
      return "qld"
    } else if (state == "southaustralia") {
      return "sa"
    } else if (state == "westernaustralia") {
      return "wa"
    } else if (state == "australiacapitalterritory") {
      return "act"
    } else if (state == "tasmania") {
      return "tas"
    } else if (state == "northernterritory") {
      return "nt"
    } else {
      return state
    }
  }

  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf()
    sparkConf.setAppName("My First Application")
    sparkConf.setMaster("local")
    val sc = new SparkContext(sparkConf)
    var dat = sc.read.format("csv").option("header", "true").load("customer.csv")
    dat = dat.select("lastname", "firstname", "suburb", "homestate", "postcode", "mobilephonenumber", "emailaddress", "addressline")
    dat = dat.withColumn("lastname", where(col("lastname") == 0 | col("lastname") == "0").otherwise(col("lastname")))
    dat = dat.withColumn("lastname", regexp_replace(lower(col("lastname")), "[^a-z]", ""))
    dat = dat.withColumn("homestate", where(col("homestate") == 0 | col("homestate") == "0").otherwise(col("homestate")))
    val homestateMap = udf(homestateMap_ _)
    dat = dat.withColumn("homestate1", regexp_replace(lower(col("homestate")), "[^a-z]", ""))
    dat = dat.withColumn("homestate2", homestateMap(col("homestate1")))
  }
}
