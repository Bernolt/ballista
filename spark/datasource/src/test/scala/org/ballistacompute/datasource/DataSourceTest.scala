package io.andygrove.ballista.spark

import org.junit.{Ignore, Test}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.apache.spark.sql.functions._

class DataSourceTest {

  @Test
  @Ignore
  def testSomething() {

    val spark = SparkSession.builder()
      .master("local[*]")
      .getOrCreate()

    val df = spark.read
      .format("io.andygrove.ballista.spark.datasource")
      .option("table", "/home/andy/git/andygrove/arrow/cpp/submodules/parquet-testing/data/alltypes_plain.parquet")
      .option("host", "127.0.0.1")
      .option("port", "50051")
      .load()

    df.printSchema()

    val results = df.collect()
    results.foreach(println)

  }

}
