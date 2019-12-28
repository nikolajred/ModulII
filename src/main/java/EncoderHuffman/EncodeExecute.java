package EncoderHuffman;

import DecoderHuffman.*;

public class EncodeExecute {

    private HuffmanTree mainHuffmanTree;
    private String myString;
    private int[] freqArray;
    private String[] encodingArray;


    public EncodeExecute(HuffmanTree MainHuffmanTree) {
        this.mainHuffmanTree = MainHuffmanTree;

        myString = mainHuffmanTree.getOriginalString();

        encodingArray = mainHuffmanTree.getEncodingArray();

        freqArray = mainHuffmanTree.getFrequenceArray();
    }


    private String getCompressedString() {
        String compressed = "";
        String intermidiate = "";

        for (int i = 0; i < myString.length(); i++) {
            intermidiate += encodingArray[myString.charAt(i)];
        }

        byte counter = 0;
        for (int length = intermidiate.length(), delta = 8 - length % 8;
             counter < delta; counter++) {
            intermidiate += "0";
        }

        compressed = String.format("%8s", Integer.toBinaryString(counter & 0xff)).replace(" ", "0") + intermidiate;

        return compressed;
    }


    public byte[] getBytedMsg() {
        StringBuilder compressedString = new StringBuilder(getCompressedString());
        byte[] compressedBytes = new byte[compressedString.length() / 8];
        for (int i = 0; i < compressedBytes.length; i++) {
            compressedBytes[i] = (byte) Integer.parseInt(compressedString.substring(i * 8, (i + 1) * 8), 2);
        }
        return compressedBytes;
    }


    public String getEncodingTable() {
        String enc = "";
        for (int i = 0; i < encodingArray.length; i++) {
            if (freqArray[i] != 0)
                enc += (char) i + encodingArray[i] + '\n';
        }
        return enc;
    }


}

