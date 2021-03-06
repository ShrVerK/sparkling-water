package water.sparkling.itest.local

import org.apache.spark.examples.h2o.DeepLearningDemoWithoutExtension
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import water.sparkling.itest.{IntegTestStopper, IntegTestHelper, LocalTest}

@RunWith(classOf[JUnitRunner])
class DeepLearningDemoWithoutExtSuite extends FunSuite with IntegTestHelper {

  test("Launch DeepLearningDemoWithoutExtension", LocalTest) {
    launch("water.sparkling.itest.local.DeepLearningDemoWithoutExtTest",
      env {
        sparkMaster("local-cluster[3,2,2048]")
        conf("spark.executor.memory", "2g")
        conf("spark.driver.memory", "2g")
      }
    )
  }
}

object DeepLearningDemoWithoutExtTest extends IntegTestStopper{
  def main(args: Array[String]): Unit = exitOnException{
    DeepLearningDemoWithoutExtension.main(args)
  }
}