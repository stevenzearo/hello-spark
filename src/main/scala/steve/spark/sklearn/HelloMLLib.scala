package steve.spark.sklearn

import org.apache.spark.ml.attribute.Attribute
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.LinearDataGenerator

import scala.collection.{immutable, mutable}


/**
 * @author steve
 */
object HelloMLLib {
  def main(args: Array[String]): Unit = {
    val list: mutable.Seq[LabeledPoint] = LinearDataGenerator.generateLinearInput(1, Array(1), Array(1), Array(1), 100, 100, 0, 1).toBuffer
    val buffer: mutable.Seq[(Double, Double)] = list.map(value => (value.features.apply(0), value.label)).toBuffer
    buffer.foreach(x => println(x._1 + "*1 + 1 = " + (x._1*1 + 1) + "\t\t\t" + x._2))
  }
}
