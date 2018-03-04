package com.foxy


import com.foxy.impl.BTree

/**
  * Created by Sem Babenko.
  */
class BTreeTest extends BaseTest {

  /*
              1
             / \
            0   2

   */
  "Put operation " should "add elements" in {
    val tree :Tree[Int, Int] = new BTree()
    tree.put(1, 1)
    tree.put(2, 2)
    tree.put(0, 0)
    tree.height() should equal(2)
  }

}
