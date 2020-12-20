package com.nap.aoc2020

import scala.io.StdIn.readLine
import scala.collection.mutable.HashSet

object Day1P1 {
    def add(x:Int, y:Int) = x + y;

    def main(args: Array[String]) {
        val s = new HashSet[Int]
        val checkOrPut: String => Boolean = x => {
            if(s.contains(2020 - x.toInt)) true
            else {
                s add x.toInt
                false
            }
        }
        val nums = Iterator.continually(readLine).takeWhile(_ != null)
        val res = nums.find(checkOrPut)
        
        val ans = res match {
            case Some(x) => x.toInt * (2020 - x.toInt)
            case _ => 0
        }
        
        println(ans)
    }
}