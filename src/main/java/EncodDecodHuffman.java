import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class EncodDecodHuffman {

    public Map<Character, String> charPrefixHashMap = new HashMap<>();
    public Node root;
    public static String vocabularyTable;


    public Node buildTree(Map<Character, Integer> freq) {

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        Set<Character> keySet = freq.keySet();
        for (Character character : keySet) {

            Node node = new Node();
            node.data = character;
            node.frequency = freq.get(character);
            node.leftChild = null;
            node.rightChild = null;
            priorityQueue.offer(node);
        }
        assert priorityQueue.size() > 0;

        while (priorityQueue.size() > 1) {

            Node x = priorityQueue.peek();
            priorityQueue.poll();
            Node y = priorityQueue.peek();
            priorityQueue.poll();
            Node sum = new Node();
            sum.frequency = x.frequency + y.frequency;
            sum.data = '-';
            sum.leftChild = x;
            sum.rightChild = y;
            root = sum;

            priorityQueue.offer(sum);
        }

        return priorityQueue.poll();
    }


    public void setPrefixCodes(Node node, StringBuilder prefix) {

        if (node != null) {
            if (node.leftChild == null && node.rightChild == null) {
                charPrefixHashMap.put(node.data, prefix.toString());

            } else {
                prefix.append('0');
                setPrefixCodes(node.leftChild, prefix);
                prefix.deleteCharAt(prefix.length() - 1);

                prefix.append('1');
                setPrefixCodes(node.rightChild, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

    }

    public String encode(String test) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < test.length(); i++) {
            if (!freq.containsKey(test.charAt(i))) {
                freq.put(test.charAt(i), 0);
            }
            freq.put(test.charAt(i), freq.get(test.charAt(i)) + 1);
        }

        System.out.println("Character Frequency Map = " + freq);
        root = buildTree(freq);

        setPrefixCodes(root, new StringBuilder());

        vocabularyTable = "Character vocabulary Map = " + charPrefixHashMap;
        System.out.println(vocabularyTable);
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i);
            stringBuilder.append(charPrefixHashMap.get(c));
        }
        System.out.println("Encoded: " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String getVocabularyTable() {
        vocabularyTable = vocabularyTable.substring(26).replace('{', ' ').replace('}', ' ').trim();
        return vocabularyTable;
    }


    public StringBuilder decode(String string) {

        StringBuilder stringBuilder = new StringBuilder();

        Node temp = root;
        for (int i = 0; i < string.length(); i++) {
            int j = Integer.parseInt(String.valueOf(string.charAt(i)));

            if (j == 0) {
                temp = temp.leftChild;
                if (temp.leftChild == null && temp.rightChild == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
            if (j == 1) {
                temp = temp.rightChild;
                if (temp.leftChild == null && temp.rightChild == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
        }
        System.out.println("Decoded string is " + stringBuilder.toString());
        return stringBuilder;

    }


}



