package com.foxy.impl

import com.foxy.Tree

import scala.collection.mutable.ListBuffer

/**
  * Created by Sem Babenko.
  */
class BTree[K, V] extends Tree[K, V] {

  var root: Node[K, V] = null

  override def height(): Int = {
    val list = new ListBuffer[Int]()
    calculateHeight(root, list, -1)
    list.max
  }

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

  private def calculateHeight(node: Node[K, V], list: ListBuffer[Int], deep: Int): Unit = {
    val lDeep = deep + 1
    list += lDeep
    if (node.right != null) {
      calculateHeight(node.right, list, lDeep)
    }
    if(node.left != null) {
      calculateHeight(node.left, list, lDeep)
    }
  }

  private def selfBalancing(): Unit = {

  }

}
