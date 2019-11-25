package steve.scala.crises

import java.io.{File, FileWriter}
import scala.collection.mutable.Buffer
import scala.io.{BufferedSource, Source}
import steve.conf.Conf

/**
 * @author steve
 */
object AfricanCrisesAnalysis {
    private var inputFile: File = _
    private var outputFile: File = _

    def main(args: Array[String]): Unit = {
        init()
        val inputSource: BufferedSource = Source.fromFile(inputFile)
        val lines: Iterator[String] = inputSource.getLines()
        val head: Array[String] = lines.next().split(",")
        val values: Buffer[String] = lines.toBuffer
        head.foreach(println(_: String))
        val rowNums: Int = values.count(!(_: String).isEmpty)
//        println(values.head)
//        println(s"rowNums:$rowNums")
        val caseStrings: Buffer[String] = values.map((_: String).split(",")(0)).toBuffer
        SingleFeatureAnalysis.load_data(caseStrings)
        val caseValueCounts: Buffer[(String, Int)] = SingleFeatureAnalysis.value_counts()
        output_data(caseValueCounts)
        inputSource.close()
    }

    def init(): Unit = {
        Conf.loadProperties("spark.properties")
        val inputPath: String = Conf.getProperty("crises.inputPath")
        val inputFile: File = new File(inputPath)
        if (!inputFile.exists()) {
            println(s"$inputPath not found!")
            System.exit(1)
        }
        val outputPath: String = Conf.getProperty("crises.scala.outputPath")
        val outputFile: File = new File(outputPath)
        this.inputFile = inputFile
        this.outputFile = outputFile
    }

    def output_data[A <: Any](data: Buffer[A]): Unit = {
        if (data == null) return
        val writer: FileWriter = new FileWriter(outputFile)
        data.foreach((value: A) => writer.write(value.toString + "\n"))
        writer.close()
    }
}
