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

    key match {
      case x: Comparable[K] => compare(x, newNode, root)
    }
  }

  private def compare(key: Comparable[K], newNode: Node[K, V], existNode: Node[K, V]): Unit = {

    key.compareTo(existNode.key) match {
      case 1 => initOrLookup(key, newNode, existNode, () => existNode.right)
      case -1 => initOrLookup(key, newNode, existNode, () => existNode.right)
      case 0 => existNode.value = newNode.value
    }
  }

  private def initOrLookup(key: Comparable[K], newNode: Node[K, V], existNode: Node[K, V], supply: () => Node[K, V]): Unit = {
    supply.apply() match {
      case null => existNode.right = newNode
      case nextNode :_ => compare(key, newNode, nextNode)
    }
  }



}
