package com.foxy.impl {

  /**
    * Created by Sem Babenko.
    */
  class Node[K, V](var key : K = null, var value : V = null,
                   var left : Node[K, V] = null,
                   var right : Node[K, V] = null,
                   var parent : Node[K, V] = null) {

    def right(node : Node[K, V]): Node[K, V] = {
      right = node
      this
    }
    def left(node: Node[K, V]): Node[K, V] = {
      left = node
      this
    }
    def parent(node: Node[K, V]): Node[K, V] = {
      parent = node
      this
    }
    def key(key: K): Node[K, V] = {
      this.key = key
      this
    }
    def value(value: V) : Node[K, V] = {
      this.value = value
      this
    }

  }

}
