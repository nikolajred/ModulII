package DecoderHuffman;

public class HuffmanTree {
    private final byte ENCODING_TABLE_SIZE = 127;
    private String myString;
    private BinaryTreeBuilder huffmanTree;
    private int[] freqArray;//частотная таблица
    private String[] encodingArray;//кодировочная таблица


    //----------------constructor----------------------
    public HuffmanTree(String newString) {
        myString = newString;

        freqArray = new int[ENCODING_TABLE_SIZE];
        fillFrequenceArray();

        huffmanTree = getHuffmanTree();

        encodingArray = new String[ENCODING_TABLE_SIZE];
        fillEncodingArray(huffmanTree.getRoot(), "", "");
    }

    //--------------------frequence array------------------------
    private void fillFrequenceArray() {
        for (int i = 0; i < myString.length(); i++) {
            freqArray[(int)myString.charAt(i)]++;
        }
    }

    public int[] getFrequenceArray() {
        return freqArray;
    }

    //------------------------huffman tree creation------------------
    private BinaryTreeBuilder getHuffmanTree() {
        PriorityQueue pq = new PriorityQueue();
        //алгоритм описан выше
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {//если символ существует в строке
                Node newNode = new Node((char) i, freqArray[i]);//то создать для него Node
                BinaryTreeBuilder newTree = new BinaryTreeBuilder(newNode);//а для Node создать BinaryTree
                pq.insert(newTree);//вставить в очередь
            }
        }

        while (true) {
            BinaryTreeBuilder tree1 = pq.remove();//извлечь из очереди первое дерево.

            try {
                BinaryTreeBuilder tree2 = pq.remove();//извлечь из очереди второе дерево

                Node newNode = new Node();//создать новый Node
                newNode.addChild(tree1.getRoot());//сделать его потомками два извлеченных дерева
                newNode.addChild(tree2.getRoot());

                pq.insert(new BinaryTreeBuilder(newNode));
            } catch (IndexOutOfBoundsException e) {//осталось одно дерево в очереди
                return tree1;
            }
        }
    }

    public BinaryTreeBuilder getTree() {
        return huffmanTree;
    }

    //-------------------encoding array------------------
    void fillEncodingArray(Node node, String codeBefore, String direction) {//заполнить кодировочную таблицу
        if (node.isLeaf()) {
            encodingArray[(int)node.getCharacter()] = codeBefore + direction;
        } else {
            fillEncodingArray(node.getLeftChild(), codeBefore + direction, "0");
            fillEncodingArray(node.getRightChild(), codeBefore + direction, "1");
        }
    }

    String[] getEncodingArray() {
        return encodingArray;
    }

    public void displayEncodingArray() {//для отладки
        fillEncodingArray(huffmanTree.getRoot(), "", "");

        System.out.println("======================Encoding table====================");
        for (int i = 0; i < ENCODING_TABLE_SIZE; i++) {
            if (freqArray[i] != 0) {
                System.out.print((char)i + " ");
                System.out.println(encodingArray[i]);
            }
        }
        System.out.println("========================================================");
    }
    //-----------------------------------------------------
    String getOriginalString() {
        return myString;
    }
}
