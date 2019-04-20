package com.zjx.algorithm.link;

public class LinkMain {

    public static void main(String[] args) {
        LinkNode root = new LinkNode(1);
        root.next = new LinkNode(2);
        root.next.next = new LinkNode(3);
        root.next.next.next = new LinkNode(4);
        LinkProblem linkProblem = new LinkProblem();
        LinkNode result = linkProblem.reversedList2(root);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
