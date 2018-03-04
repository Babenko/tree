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



  /*
            5
          /   \
         2     7
        / \   / \
       0   3 6   10
      / \
         1
 */
  "Height " should "available" in {
    val tree :Tree[Int, Int] = new BTree()
    tree.put(5, 5)
    tree.put(2, 2)
    tree.put(0, 0)
    tree.put(3, 3)
    tree.put(1, 1)
    tree.put(7, 7)
    tree.put(10, 10)
    tree.put(6, 6)
    tree.height() should equal(4)
  }

}
