package steve.conf

import org.junit.Test


/**
 * @author steve
 */

class ConfTest{
    @Test
    def test(): Unit = {
        Conf.loadProperties("spark.properties")
        val inputPath: String = Conf.getProperty("hello.inputPath")
        println(inputPath)
    }
}
