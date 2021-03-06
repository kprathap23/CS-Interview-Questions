package questions.treeheap

import api.TreeNode
import spock.lang.Specification

class TreeHeightSpec extends Specification {

    TreeNode<Integer> tree = new TreeNode<>(26)
    TreeNode<Integer> subTree = new TreeNode<>(10)
    TreeNode<Integer> balancedTree = new TreeNode<>(0)
    TreeNode<Integer> balancedTree2 = new TreeNode<>(0)
    TreeNode<Integer> unbalancedTree = new TreeNode<>(5)

    def "setup"() {
        balancedTree.right = new TreeNode<Integer>(10)
        balancedTree.right.left = new TreeNode<Integer>(10)
        balancedTree.right.right = new TreeNode<Integer>(10)
        balancedTree.left = new TreeNode<Integer>(1)
        balancedTree.left.left = new TreeNode<Integer>(12)
        balancedTree.left.right = new TreeNode<Integer>(2)

        balancedTree2.right = new TreeNode<Integer>(10)
        balancedTree2.right.left = new TreeNode<Integer>(10)
        balancedTree2.left = new TreeNode<Integer>(1)
        balancedTree2.left.right = new TreeNode<Integer>(2)

        unbalancedTree.right = new TreeNode<Integer>(10)
        unbalancedTree.left = new TreeNode<Integer>(1)
        unbalancedTree.left.left = new TreeNode<Integer>(12)
        unbalancedTree.left.left.left = new TreeNode<Integer>(12)

        subTree.right = new TreeNode<Integer>(6)
        subTree.left = new TreeNode<Integer>(4)
        subTree.left.right = new TreeNode<Integer>(30)

        tree.right = new TreeNode<Integer>(3)
        tree.right.right = new TreeNode<Integer>(3)
        tree.left = new TreeNode<Integer>(10)
        tree.left.left = new TreeNode<Integer>(4)
        tree.left.left.right = new TreeNode<Integer>(30)
        tree.left.right = new TreeNode<Integer>(6)
    }

    def "getHeight"() {
        given:
        TreeHeight treeHeight = new TreeHeight()

        expect:
        treeHeight.getHeight(null) == 0
        treeHeight.getHeight(balancedTree) == 3
        treeHeight.getHeight(balancedTree2) == 3
        treeHeight.getHeight(unbalancedTree) == -1
    }

    def "getMinHeight"() {
        given:
        TreeHeight treeHeight = new TreeHeight()

        expect:
        treeHeight.getMinHeight(null) == 0
        treeHeight.getMinHeight(balancedTree) == 3
        treeHeight.getMinHeight(balancedTree2) == 2
        treeHeight.getMinHeight(unbalancedTree) == 2
    }

    def "getMaxHeight"() {
        given:
        TreeHeight treeHeight = new TreeHeight()

        expect:
        treeHeight.getMaxHeight(null) == 0
        treeHeight.getMaxHeight(balancedTree) == 3
        treeHeight.getMaxHeight(balancedTree2) == 3
        treeHeight.getMaxHeight(unbalancedTree) == 4
    }
}
