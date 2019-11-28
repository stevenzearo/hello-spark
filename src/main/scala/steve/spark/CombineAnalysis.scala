package steve.spark

import org.apache.spark.rdd.RDD

import scala.collection.immutable

/**
 * @author steve
 */
object CombineAnalysis {
  def groupByValueCount[T](stringRDD: RDD[String], countIndex: Int, groupIndexes: Int*): RDD[T] = {
    stringRDD.map((line: String) => {
      val values = line.split(",")
      val key: immutable.Seq[String] = groupIndexes.map((index: Int) => {
        values(index)
      }).toList
      (key, values(countIndex))
    })
    groupIndexes.length
    return null
  }
}
