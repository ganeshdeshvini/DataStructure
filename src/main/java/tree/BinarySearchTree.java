package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void add(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            // if it is the first Node
            root = newNode;
        } else {
            // if it is the subsequent Node
            Node currentNode = root;
            while (true) {
                if (data < currentNode.data) {
                    //if it doesn't contain any LEFT node & exit the loop
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    //if it doesn't contain any RIGHT node & exit the loop
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    boolean lookup(int data) {
        Node current = root;
        while (current != null) {
            if (current.data == data) {
                return true;
            } else if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    //     9
    //  4      20
    //1   6  15   25
    // [9, 4, 20, 1, 6, 15, 25]
    List<Integer> breadthFirstSearchIterativeBFS() {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            list.add(currentNode.data);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return list;
    }

    List<Integer> breadthFirstSearchRecursiveBFS() {
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        breadthFirstSearch(queue, list);
        return list;
    }

    private List<Integer> breadthFirstSearch(Queue<Node> queue, List<Integer> list) {
        if (queue.isEmpty()) {
            return list;
        }
        Node currentNode = queue.remove();
        list.add(currentNode.data);
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        return breadthFirstSearch(queue, list);
    }

    //     9
    //  4      20
    //1   6  15   25
    // [1, 4, 6, 9, 15, 20, 25]
    List<Integer> inOrderTraversalRecursiveDFS() {
        List<Integer> list = new ArrayList<>();
        inOrderTraversalDFS(this.root, list);
        return list;
    }

    List<Integer> inOrderTraversalDFS(Node currentNode, List<Integer> list) {
        if (currentNode.left != null) {
            inOrderTraversalDFS(currentNode.left, list);
        }
        list.add(currentNode.data);
        if (currentNode.right != null) {
            inOrderTraversalDFS(currentNode.right, list);
        }
        return list;
    }

    //     9
    //  4      20
    //1   6  15   25
    // [9, 4, 1, 6, 20, 15, 25]
    List<Integer> preOrderTraversalRecursiveDFS() {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalDFS(this.root, list);
        return list;
    }

    List<Integer> preOrderTraversalDFS(Node currentNode, List<Integer> list) {
        list.add(currentNode.data);
        if (currentNode.left != null) {
            preOrderTraversalDFS(currentNode.left, list);
        }
        if (currentNode.right != null) {
            preOrderTraversalDFS(currentNode.right, list);
        }
        return list;
    }

    //     9
    //  4      20
    //1   6  15   25
    // [1, 6, 4, 15, 25, 20, 9]
    List<Integer> postOrderTraversalRecursiveDFS() {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalDFS(this.root, list);
        return list;
    }

    List<Integer> postOrderTraversalDFS(Node currentNode, List<Integer> list) {
        if (currentNode.left != null) {
            postOrderTraversalDFS(currentNode.left, list);
        }
        if (currentNode.right != null) {
            postOrderTraversalDFS(currentNode.right, list);
        }
        list.add(currentNode.data);
        return list;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(9);
        binarySearchTree.add(4);
        binarySearchTree.add(20);
        binarySearchTree.add(1);
        binarySearchTree.add(6);
        binarySearchTree.add(15);
        binarySearchTree.add(25);
        System.out.println(binarySearchTree.lookup(6));
        System.out.println(binarySearchTree.lookup(16));
        System.out.println("BFS Iterative" + binarySearchTree.breadthFirstSearchIterativeBFS());
        System.out.println("BFS Recursive: " + binarySearchTree.breadthFirstSearchRecursiveBFS());
        System.out.println("IN-ORDER Recursive" + binarySearchTree.inOrderTraversalRecursiveDFS());
        System.out.println("PRE-ORDER Recursive" + binarySearchTree.preOrderTraversalRecursiveDFS());
        System.out.println("POST-ORDER Recursive" + binarySearchTree.postOrderTraversalRecursiveDFS());
    }
}
