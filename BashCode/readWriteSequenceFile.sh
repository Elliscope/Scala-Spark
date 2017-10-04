#!/bin/bash



#Variable Assignment
#ATTENTION: SPACE CANT BE ADDED
mavenProjectPath='/Users/mifang/Documents/Spark/Scala-Spark/myScalaSpark10'


sparkPath='/Users/mifang/Documents/Spark/spark-2.2.0-bin-hadoop2.7 '
jarFilePath='/Users/mifang/Documents/Spark/Scala-Spark/myScalaSpark10/target/myScalaSpark1.0-1.0.jar'

argIndex1='/Users/mifang/Documents/Spark/Scala-Spark/myScalaSpark10/table.csv'
argIndex2='/Users/mifang/Documents/Spark/Scala-Spark/myScalaSpark10/output2'
className = 'com.myCompany.scala.MaxPrice'

#Compile the scala program
cd $mavenProjectPath 
pwd
mvn package 


# #Initial the Spark Query with the command
cd $sparkPath

./bin/spark-submit \
--class com.myCompany.scala.MaxPrice \
--master local \
$jarFilePath  \
$argIndex1 \
$argIndex2



# ./bin/spark-submit \
#  --class com.myCompany.scala.MaxPrice \
#  --master local \
#  /Users/mifang/Documents/AwsScala/ScalaExample/myScalaSpark10/target/myScalaSpark1.0-1.0.jar  \
 # /Users/mifang/Documents/AwsScala/ScalaExample/myScalaSpark10/table.csv /
 # /Users/mifang/Documents/AwsScala/ScalaExample/myScalaSpark10/output1