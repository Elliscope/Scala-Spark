package com.myCompany.scala


import org.apache.hadoop.io.Text
import org.apache.hadoop.io.IntWritable

import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf,SparkContext}

object MaxPrice {
  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("Max Price")
    val sc = new SparkContext(conf)

    //need to get the absolute path
    val result = sc.sequenceFile("output/part-00000", classOf[Text], classOf[IntWritable]). map{case (x, y) => (x.toString, y.get())};
    result.collect;
    result.saveAsTextFile(args(1));

//    sc.textFile(args(0))
//      .map(_.split(","))
//      .map(rec => ((rec(0).split("-"))(0).toInt, rec(1).toFloat))
//      .reduceByKey((a,b) => Math.max(a,b))
//      .saveAsTextFile(args(1))

    val babyNames = sc.textFile("")
  }
}
//Writing as Sequence File
//val data = sc.parallelize(List(("key1", 1), ("Kay2", 2), ("Key3", 2)))
// data.saveAsSequenceFile("/tmp/output_location")



//Reading Sequence File
//val result = sc.sequenceFile("/tmp/seq-output/part-00001", classOf[Text], classOf[IntWritable]). map{case (x, y) => (x.toString, y.get())};
//result.collect;