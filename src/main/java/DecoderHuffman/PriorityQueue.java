package DecoderHuffman;

import java.util.ArrayList;

class PriorityQueue {
    private ArrayList<BinaryTreeBuilder> data;
    private int nElems;

    public PriorityQueue() {
        data = new ArrayList<BinaryTreeBuilder>();
        nElems = 0;
    }

    public void insert(BinaryTreeBuilder newTree) {
        if (nElems == 0)
            data.add(newTree);
        else {
            for (int i = 0; i < nElems; i++) {
                if (data.get(i).getFrequency() > newTree.getFrequency()) {
                    data.add(i, newTree);
                    break;
                }
                if (i == nElems - 1)
                    data.add(newTree);
            }
        }
        nElems++;
    }

    public BinaryTreeBuilder remove() {
        BinaryTreeBuilder tmp = data.get(0);
        data.remove(0);
        nElems--;
        return tmp;
    }
}