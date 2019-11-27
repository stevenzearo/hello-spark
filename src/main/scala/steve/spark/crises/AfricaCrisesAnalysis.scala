package steve.spark.crises

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import steve.conf.Conf

/**
 * @author steve
 */
class AfricaCrisesAnalysis {
  def main(args: Array[String]): Unit = {
    Conf.loadProperties("spark.properties")
    val inputPath: String = Conf.getProperty("crises.inputPath")
    val outputPath: String = Conf.getProperty("=C:/Users/steve/IdeaProjects/hello/src/main/resources/output/out2")
    val conf: SparkConf = new SparkConf()
    conf.setMaster("local[1]").setAppName("AfricaCrisesAnalysis")
    val sparkContext: SparkContext = new SparkContext()
    val linesRdd: RDD[String] = sparkContext.textFile(inputPath)
    
  }
}
