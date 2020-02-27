/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 27/02/20
 *   Time: 8:33 AM
 */

package definition;

import adt.BinaryTreeADT;

public class BinaryTree<E> implements BinaryTreeADT<E> {

    private Node<E> root;
    private int noOfNodes=0;

    public boolean add(E data) {
        root=addRecursive(root,data);
        noOfNodes++;
        return true;
    }

    private Node<E> addRecursive(Node<E> currentroot, E data) {
        if (currentroot == null)
        {
            return new Node<E>(data);
        }
        if ((Integer) data < (Integer) currentroot.getData()) {
            currentroot.leftChild = addRecursive(currentroot.getLeftChild(), data);
        } else if ((Integer) data > (Integer) currentroot.getData())
        {
            currentroot.rightChild = addRecursive(currentroot.rightChild, data);
        }
        return currentroot;

    }

    public boolean isEmpty() {
        return root == null;
    }


    private static class Node<E> {
        private E data;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<E> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<E> rightChild) {
            this.rightChild = rightChild;
        }
    }
}
