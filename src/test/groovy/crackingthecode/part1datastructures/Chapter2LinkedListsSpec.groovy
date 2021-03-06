package crackingthecode.part1datastructures

import api.Node
import spock.lang.Specification

class Chapter2LinkedListsSpec extends Specification {

    Chapter2LinkedLists chapter2LinkedLists

    def "setup"() {
        chapter2LinkedLists = new Chapter2LinkedLists()
    }

    def "2.1 - removeDuplicates - buffer"() {
        given:
        Node<Integer> node = new Node<>(1)
        node.next = new Node<>(0)
        node.next.next = new Node<>(1)
        node.next.next.next = new Node<>(4)
        node.next.next.next.next = new Node<>(5)
        node.next.next.next.next.next = new Node<>(4)

        when:
        chapter2LinkedLists.removeDuplicates(null)
        chapter2LinkedLists.removeDuplicates(node)

        then:
        node.value == 1
        node.next.value == 0
        node.next.next.value == 4
        node.next.next.next.value == 5
    }

    def "2.1 - removeDuplicates - no buffer"() {
        given:
        Node<Integer> node = new Node<>(1)
        node.next = new Node<>(0)
        node.next.next = new Node<>(1)
        node.next.next.next = new Node<>(4)
        node.next.next.next.next = new Node<>(5)
        node.next.next.next.next.next = new Node<>(4)

        when:
        chapter2LinkedLists.removeDuplicates2(null)
        chapter2LinkedLists.removeDuplicates2(node)

        then:
        node.value == 1
        node.next.value == 0
        node.next.next.value == 4
        node.next.next.next.value == 5
    }

    def "2.1 - removeDuplicates2 - no buffer - online"() {
        given:
        Node<Integer> node = new Node<>(1)
        node.next = new Node<>(0)
        node.next.next = new Node<>(1)
        node.next.next.next = new Node<>(4)
        node.next.next.next.next = new Node<>(5)
        node.next.next.next.next.next = new Node<>(4)

        when:
        chapter2LinkedLists.removeDuplicates3(null)
        chapter2LinkedLists.removeDuplicates3(node)

        then:
        node.value == 1
        node.next.value == 0
        node.next.next.value == 4
        node.next.next.next.value == 5
    }

    def "2.1 - deleteDupsC - book"() {
        given:
        Node<Integer> node = new Node<>(1)
        node.next = new Node<>(0)
        node.next.next = new Node<>(1)
        node.next.next.next = new Node<>(4)
        node.next.next.next.next = new Node<>(5)
        node.next.next.next.next.next = new Node<>(4)

        when:
        chapter2LinkedLists.deleteDupsC(null)
        chapter2LinkedLists.deleteDupsC(node)

        then:
        node.value == 1
        node.next.value == 0
        node.next.next.value == 4
        node.next.next.next.value == 5
    }

    def "2.2 - findNthLastElement"() {
        Node<Integer> node = new Node<>(0)
        node.next = new Node<>(1)
        node.next.next = new Node<>(2)
        node.next.next.next = new Node<>(3)
        node.next.next.next.next = new Node<>(4)
        node.next.next.next.next.next = new Node<>(5)

        expect:
        chapter2LinkedLists.findNthLastElement(null, 6) == null
        chapter2LinkedLists.findNthLastElement(node, 0) == null
        chapter2LinkedLists.findNthLastElement(node, 6).value == 0
        chapter2LinkedLists.findNthLastElement(node, 5).value == 1
        chapter2LinkedLists.findNthLastElement(node, 4).value == 2
        chapter2LinkedLists.findNthLastElement(node, 3).value == 3
        chapter2LinkedLists.findNthLastElement(node, 2).value == 4
        chapter2LinkedLists.findNthLastElement(node, 1).value == 5
    }

    def "2.3 - deleteMiddleNode"() {
        given:
        Node<Character> node1 = new Node<>('a' as Character)
        node1.next = new Node<>('b' as Character)
        node1.next.next = new Node<>('c' as Character)
        node1.next.next.next = new Node<>('d' as Character)
        node1.next.next.next.next = new Node<>('e' as Character)

        when:
        chapter2LinkedLists.deleteMiddleNode(null)
        chapter2LinkedLists.deleteMiddleNode(node1.next.next)

        then:
        node1.value == 'a'
        node1.next.value == 'b'
        node1.next.next.value == 'd'
        node1.next.next.next.value == 'e'
    }

    def "2.4 - addTwoLists"() {
        given:
        // book
        // 315 + 592 = 808
        Node<Integer> book1 = new Node<>(3)
        book1.next = new Node<>(1)
        book1.next.next = new Node<>(5)

        Node<Integer> book2 = new Node<>(5)
        book2.next = new Node<>(9)
        book2.next.next = new Node<>(2)

        // programming geeks
        // 342 + 465 = 807
        Node<Integer> pg = new Node<>(2)
        pg.next = new Node<>(4)
        pg.next.next = new Node<>(3)

        Node<Integer> pg2 = new Node<>(5)
        pg2.next = new Node<>(6)
        pg2.next.next = new Node<>(4)

        // from 3 to 4 digits
        // 999 + 999 = 1998
        Node<Integer> nine = new Node<>(9)
        nine.next = new Node<>(9)
        nine.next.next = new Node<>(9)

        expect:
        chapter2LinkedLists.addTwoLists(null, nine) == null
        chapter2LinkedLists.addTwoLists(nine, null) == null
        chapter2LinkedLists.addTwoLists(null, null) == null

        Node<Integer> result = chapter2LinkedLists.addTwoLists(book1, book2)
        result.value == 8
        result.next.value == 0
        result.next.next.value == 8

        Node<Integer> result2 = chapter2LinkedLists.addTwoLists(pg, pg2)
        result2.value == 7
        result2.next.value == 0
        result2.next.next.value == 8

        Node<Integer> result3 = chapter2LinkedLists.addTwoLists(nine, nine)
        result3.value == 8
        result3.next.value == 9
        result3.next.next.value == 9
        result3.next.next.next.value == 1
    }

    //           D -> E
    //           |    |
    // A -> B -> C  <-
    // input: A -> B -> C -> D -> E -> C [the same C as earlier]
    def "2.5 - getCircular - true"() {
        given:
        Node<Integer> nodeA = new Node<>(0)
        Node<Integer> nodeB = new Node<>(1)
        Node<Integer> nodeC = new Node<>(2)
        Node<Integer> nodeD = new Node<>(3)
        Node<Integer> nodeE = new Node<>(4)

        nodeA.next = nodeB
        nodeB.next = nodeC
        nodeC.next = nodeD
        nodeD.next = nodeE
        nodeE.next = nodeC

        when:
        Node<Integer> nullResult = chapter2LinkedLists.getCircular(null)
        Node<Integer> result = chapter2LinkedLists.getCircular(nodeA)

        then:
        nullResult == null
        result.value == 3
    }

    def "2.5 - getCircular - false"() {
        given:
        //       n4 <- n3
        //        |     |
        // n0 -> n1 -> n2
        Node<Integer> node0 = new Node<>(0)
        Node<Integer> node1 = new Node<>(1)
        Node<Integer> node2 = new Node<>(2)
        Node<Integer> node3 = new Node<>(3)
        Node<Integer> node4 = new Node<>(4)

        node0.next = node1
        node1.next = node2
        node2.next = node3
        node3.next = node4

        when:
        Node<Integer> nullResult = chapter2LinkedLists.getCircular(null)
        Node<Integer> result = chapter2LinkedLists.getCircular(node0)

        then:
        nullResult == null
        result == null
    }
}
