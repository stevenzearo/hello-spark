package steve.spark.hello.test.property

import java.io.{File, FileInputStream}
import java.util.Properties

/**
 * @author steve
 */
object PropertyTest {
    def main(args: Array[String]): Unit = {
        val conf = new Properties
        val filePath = new File(PropertyTest.getClass.getClassLoader.getResource("spark.properties").getPath)
        if (!filePath.exists) {
            printf(s"file not found, name = %s", filePath.getAbsolutePath)
            System.exit(1)
        }
        conf.load(new FileInputStream(filePath))
        println(conf.get("inputPath"))
    }
}
