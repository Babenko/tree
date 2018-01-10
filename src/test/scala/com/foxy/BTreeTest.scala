package com.foxy

import java.util

import com.foxy.impl.BTree

/**
  * Created by Sem Babenko.
  */
class BTreeTest extends BaseTest {

  "Put operation " should "add elements" in {
    val tree :Tree[Int, Int] = new BTree()
    tree.put(1, 1)
    tree.put(2, 2)
    tree.put(0, 0)
  }

}
