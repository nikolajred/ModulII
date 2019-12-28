package DecoderHuffman;

public class Node {
    private int frequency;
    private char character;
    private Node leftChild;
    private Node rightChild;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;

    }

    public Node() {

    }

    public void addChild(Node newNode) {
        if (leftChild == null) {
            leftChild = newNode;
        } else if (leftChild.getFrequency() <= newNode.getFrequency()) {
            rightChild = newNode;
        } else {
            rightChild = leftChild;
            leftChild = newNode;
        }
        frequency +=newNode.getFrequency();
    }


    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getFrequency() {
        return frequency;
    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}

