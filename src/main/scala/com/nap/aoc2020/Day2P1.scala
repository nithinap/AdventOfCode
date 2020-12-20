package com.nap.aoc2020

import scala.io.StdIn.readLine

object Day2P1 {
    
    def validate(x: String): Boolean = {
        val arr = x.split(": ")
        val req = arr(0).split(" ")
        val alpha = req(1)(0)
        val mm = req(0).split("-").map(_.toInt)
        val (min, max) = (mm(0), mm(1))
        
        val impressions = arr(1).filter(_ == alpha).size
        (impressions >= min && impressions <= max)
    }
    
    def main(args: Array[String]) {
        val nums = Iterator.continually(readLine).takeWhile(_ != null)
        val res = nums.filter(validate).size
        println(res)
    }
}