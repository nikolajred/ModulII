package DecoderHuffman;

class BinaryTreeBuilder {
    private Node root;

    public BinaryTreeBuilder() {
        root = new Node();
    }

    public BinaryTreeBuilder(Node root) {
        this.root = root;
    }

    public int getFrequency() {
        return root.getFrequency();
    }

    public Node getRoot() {
        return root;
    }
}
