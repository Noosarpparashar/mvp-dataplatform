import org.apache.spark.sql.SparkSession
object firstObject {

  def main(args: Array[String]): Unit = {
    val spark:SparkSession = SparkSession.builder()
      .master("local[*]").appName("SparkByExamples.com")
      .getOrCreate()
    import spark.implicits._
    val columns = Seq("language","users_count")
    val data = Seq(("Java", "20000"), ("Python", "100000"), ("Scala", "3000"))
    val rdd = spark.sparkContext.parallelize(data)
    val dfFromRDD1 = rdd.toDF("language","users_count")
    dfFromRDD1.show()
  }
}
