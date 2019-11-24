package steve.spark.hello

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import steve.conf.Conf

/**
 * @author steve
 */
object HelloWorld {
    def main(args: Array[String]): Unit = {
/*
        if (args.length < 2) {
            println("please set input file and output file")
            System.exit(1)
        }
*/

        Conf.loadProperties("spark.properties")
        val inputPath: String = Conf.getProperty("hello.inputPath")
        val outputPath: String = Conf.getProperty("hello.spark.outputPath")
        val sparkConf: SparkConf = new SparkConf().setMaster("local[1]").setAppName("HelloSpark")
        val sc: SparkContext = new SparkContext(sparkConf)
        val input: RDD[String] = sc.textFile(inputPath)
        val worlds: RDD[String] = input.flatMap((_: String).split(" "))
        val counts: RDD[(String, Int)] = worlds.map(((_: String), 1)).reduceByKey((_: Int) + (_: Int)).sortBy((_: (String, Int))._2)
        val str: String = Console.readLine() // for watching job at worker node (port: 4041)
        counts.saveAsTextFile(outputPath)
        sc.stop()
    }
}
