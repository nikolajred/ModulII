public class Node implements Comparable<Node> {
    int frequency;
    char data;
    Node leftChild;
    Node rightChild;

    public int compareTo(Node node) {
        return frequency - node.frequency;
    }
}