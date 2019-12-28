package DecoderHuffman;

import java.util.ArrayList;//да-да, очередь будет на базе списка

class PriorityQueue {
    private ArrayList<BinaryTreeBuilder> data;//список очереди
    private int nElems;//кол-во элементов в очереди

    public PriorityQueue() {
        data = new ArrayList<BinaryTreeBuilder>();
        nElems = 0;
    }

    public void insert(BinaryTreeBuilder newTree) {//вставка
        if (nElems == 0)
            data.add(newTree);
        else {
            for (int i = 0; i < nElems; i++) {
                if (data.get(i).getFrequency() > newTree.getFrequency()) {//если частота вставляемого дерева меньше
                    data.add(i, newTree);//чем част. текущего, то cдвигаем все деревья на позициях справа на 1 ячейку
                    break;//затем ставим новое дерево на позицию текущего
                }
                if (i == nElems - 1)
                    data.add(newTree);
            }
        }
        nElems++;//увеличиваем кол-во элементов на 1
    }

    public BinaryTreeBuilder remove() {//удаление из очереди
        BinaryTreeBuilder tmp = data.get(0);//копируем удаляемый элемент
        data.remove(0);//собственно, удаляем
        nElems--;//уменьшаем кол-во элементов на 1
        return tmp;//возвращаем удаленный элемент(элемент с наименьшей частотой)
    }
}