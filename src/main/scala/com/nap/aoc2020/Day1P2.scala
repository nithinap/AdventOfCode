package com.nap.aoc2020

import scala.io.StdIn.readLine

object Day1P2 {
    def findPair(sum: Int, arr: Seq[Int], i: Int, j:Int): (Int, Int) = {
        if(i >= j) (-1, -1)
        else {
            val cur = arr(i) + arr(j)
            
            if(cur == sum) (i, j)
            else if(cur > sum) findPair(sum, arr, i, j-1)
            else findPair(sum, arr, i+1, j)
        }
    }

    def main(args: Array[String]) {
        val target = 2020

        val nums = Iterator.continually(readLine).takeWhile(_ != null).toSeq.dropRight(1).map(_.toInt).sorted
        var p1: Int = 0
        var p2: Int = 0
        
        val ans = nums.zipWithIndex.find(x => 
                if(x._2 < nums.length - 2) {
                    val ret = findPair(target - x._1, nums, x._2 + 1, nums.length - 1)
                    ret match {
                        case (-1, -1) => false
                        case (a, b) => 
                            p1 = nums(a)
                            p2 = nums(b)
                            true
                            
                        case default => false
                    }
                    
                }
                else false
            )
        
        if (ans.isDefined)    {
            println(ans)
            println(p1 * p2 * nums(ans.get._2))
        }
    }
}