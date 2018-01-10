package com.foxy.impl

import com.foxy.Tree

/**
  * Created by Sem Babenko.
  */
class BTree[K, V] extends Tree[K, V] {

  var root: Node[K, V] = null

  override def put(key: K, value: V): Unit =
    root match {
      case null => root = new Node[K, V](key, value)
      case _ => newNode(key, value)
    }

  private def newNode(key: K, value: V): Unit = {
    val newNode = new Node[K, V](key, value)

    key match {
      case x: Comparable[K] => compare(x, newNode, root)
    }
  }

  private def compare(key: Comparable[K], newNode: Node[K, V], existNode: Node[K, V]): Unit = {

    key.compareTo(existNode.key) match {
      case 1 => initOrLookup(key, newNode, existNode, () => existNode.right, () => existNode.right = newNode)
      case -1 => initOrLookup(key, newNode, existNode, () => existNode.left, () => existNode.left = newNode)
      case 0 => existNode.value = newNode.value
    }
  }

  private def initOrLookup(key: Comparable[K], newNode: Node[K, V], existNode: Node[K, V], supply: () => Node[K, V], init: () => Unit): Unit = {
    supply.apply() match {
      case null => init()
      case _ => compare(key, newNode, supply.apply())
    }
  }



}
