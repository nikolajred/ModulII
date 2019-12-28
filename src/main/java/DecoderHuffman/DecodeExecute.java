package DecoderHuffman;

public class DecodeExecute {
    private final byte ENCODING_TABLE_SIZE = 127;
    private String[] encodingArray;

    public DecodeExecute() {
    }

    public String extract(String compressed, String[] newEncodingArray) {
        String decompressed = "";
        String current = "";
        String delta = "";
        encodingArray = newEncodingArray;

        for (int i = 0; i < 8; i++)
            delta += compressed.charAt(i);
        int ADDED_ZEROES = Integer.parseInt(delta, 2);

        for (int i = 8, l = compressed.length() - ADDED_ZEROES; i < l; i++) {

            current += compressed.charAt(i);
            for (int j = 0; j < ENCODING_TABLE_SIZE; j++) {
                if (current.equals(encodingArray[j])) {
                    decompressed += (char) j;
                    current = "";
                }
            }
        }

        return decompressed;
    }

}

