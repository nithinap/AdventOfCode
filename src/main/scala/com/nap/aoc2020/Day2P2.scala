package com.nap.aoc2020

import scala.io.StdIn.readLine
import scala.collection.mutable.HashSet

object Day2P2 {
    
    def validate(x: String): Boolean = {
        
        def scont(s: String, ch: Char, i: Int) = {
            if(s.length > i)
                s(i) == ch
            else false
        }
        
        val arr = x.split(": ")
        val req = arr(0).split(" ")
        val alpha = req(1)(0)
        val mm = req(0).split("-").map(_.toInt)
        val (p1, p2) = (mm(0)-1, mm(1)-1)
        
        val str = arr(1)
        val r1 = scont(str, alpha, p1)
        val r2 = scont(str, alpha, p2)
        val res = (r1 || r2) && !(r1 && r2)
        //println(str + " " + alpha + " " + p1 + " "+ p2 + " == " + r1 + " " + r2 + " | " +res)
        res
        
    }
    
    def main(args: Array[String]) {
        val nums = Iterator.continually(readLine).takeWhile(_ != null)
        val res = nums.filter(validate).size
        println(res)
    }
}