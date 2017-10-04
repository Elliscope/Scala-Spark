package com.myCompany.scala

import org.apache.hadoop.io.Text
import org.apache.hadoop.io.IntWritable
import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf,SparkContext}

object MaxPrice {
  def main(args: Array[String]){
    val conf = new SparkConf().setAppName("Read Sequence File")
    val sc = new SparkContext(conf)

    //Create Sequence File
//    val data = sc.parallelize(List(("Key1",1),("Key2",2),("Key3",3)));
//    data.saveAsSequenceFile("file:/Users/mifang/Documents/Spark/spark-2.2.0-bin-hadoop2.7/tmp/seq-output");

    //Read Sequence File from the location created above
    val result = sc.sequenceFile("file:/Users/mifang/Documents/Spark/spark-2.2.0-bin-hadoop2.7/tmp/seq-output/part-00000", classOf[Text], classOf[IntWritable]). map{case (x, y) => (x.toString, y.get())};
    result.collect;
    result.saveAsTextFile(args(1));

//    sc.textFile(args(0))
//      .map(_.split(","))
//      .map(rec => ((rec(0).split("-"))(0).toInt, rec(1).toFloat))
//      .reduceByKey((a,b) => Math.max(a,b))
//      .saveAsTextFile(args(1))
  }
}

