package com.nap.aoc2020

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object D3P1 {

  case class Position(x: Int, y: Int)

  def hasTree(paths: Seq[String], pos: Position): Boolean = {
    paths(pos.y).charAt(pos.x) == '#'
  }

  @tailrec
  def countTrees(paths: Seq[String], pos: Position, maxPos: Position, count: Long, step: Position): Long = {
    if (pos.y >= maxPos.y - 1) {
      if(hasTree(paths, pos)) count + 1
      else count
    } else {
      val newPos = Position((pos.x + step.x) % maxPos.x, pos.y + step.y)
      if(hasTree(paths, pos)) countTrees(paths, newPos, maxPos, count+1, step)
      else countTrees(paths, newPos, maxPos, count, step)
    }
  }

  def main(args: Array[String]): Unit = {
    // val paths = Iterator.continually(readLine).takeWhile(_ != null).toSeq
    val paths = scala.io.Source.fromInputStream(getClass.getResourceAsStream("/d3p1.txt")).getLines().toSeq

    val ymax = paths.size
    val xmax = paths(0).length
    val maxPos = Position(xmax , ymax)
    val step1 = Position(3, 1)

    val res = countTrees(paths, Position(0, 0), maxPos, 0, step1)
    print(res)
  }
}
