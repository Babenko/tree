package com.foxy.impl

import com.foxy.Tree

/**
  * Created by Sem Babenko.
  */
class BTree[K, V] extends Tree[K, V] {

  val root: Node[K, V] = new Node

  override def put(key: K, value: V): Unit =
    root.value match {
      case Nil => root.key(key).value(value)
      case _ =>
    }

  private def newNode(key: K, value: V): Unit = {
    val newNode = new Node[K, V](key, value)

    value match {
      case Comparable =>
    }
  }

  private def compare(key: Comparable[K], newNode: Node[K, V], currentNode: Node[K, V]): Unit = {
    key.compareTo(currentNode.key) match {
      case 1 => compare(key, newNode,)
    }
  }



}
