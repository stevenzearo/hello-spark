package steve.scala.crises

import scala.collection.mutable.Buffer

/**
 * @author steve
 */
object SingleFeatureAnalysis {
    private var dataStrings: Buffer[String] = _

    def load_data(dataStrings: Buffer[String]): Unit = {
        this.dataStrings = dataStrings
    }

    def value_counts(): Buffer[(String, Int)] = {
        if (dataStrings.isEmpty) return null
        dataStrings.map(((_: String), 1))
                .groupBy((_: (String, Int))._1)
                .map((group: (String, Buffer[(String, Int)])) => (group._1, group._2.reduce((v1, v2) => (v1._1, v1._2 + v2._2))._2))
                .toBuffer.sortBy((_: (String, Int))._1.toInt)
    }
}
