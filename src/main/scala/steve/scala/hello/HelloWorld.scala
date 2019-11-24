package steve.scala.hello

import java.io.{File, FileWriter}
import scala.collection.mutable.Buffer
import scala.io.{BufferedSource, Source}
import steve.conf.Conf

/**
 * @author steve
 */
object HelloWorld {
    def main(args: Array[String]): Unit = {
        Conf.loadProperties("spark.properties")
        val inputPath: String = Conf.getProperty("hello.inputPath")
        val outputPath: String = Conf.getProperty("hello.scala.outputPath")
        val inputFile: File = new File(inputPath)
        val outputFile: File = new File(outputPath)
        if (!inputFile.exists()) {
            printf(s"file not found, path = %s", inputPath)
            System.exit(1)
        }
        if (outputFile.exists()) {
            printf(s"file already exist, path = %s", inputPath)
            System.exit(1)
        }
        outputFile.createNewFile()
        val inputSource: BufferedSource = Source.fromFile(inputPath)
        val lines: Buffer[String] = inputSource.getLines().toBuffer
        val wordCounts: Buffer[(String, Int)] = lines.map((_: String).split(" "))
                .flatMap((_: Array[String]).map((_: String).trim))
                .map(((_: String), 1))
                .groupBy((_: (String, Int))._1)
                .map((wordMap: (String, Buffer[(String, Int)])) => (wordMap._1, wordMap._2.map((_: (String, Int))._2).sum))
                .toBuffer
                .sortBy(-(_: (String, Int))._2)


        val writer: FileWriter = new FileWriter(outputFile)
        wordCounts.foreach((values: (String, Int)) => writer.write(values.toString() + "\n"))
        inputSource.close()
        writer.close()
    }
}
