import DecoderHuffman.DecoderHuffman;
import EncoderHuffman.EncoderHuffman;

import java.io.*;
import java.util.logging.Logger;

public class Api {
    public static String path;
    public static String pathTable;
    private static Logger log = Logger.getLogger(EncodDecodHuffman.class.getName());

    public static void main(String[] args) throws IOException {
        EncodDecodHuffman code = new EncodDecodHuffman();


        BytConvertToString converter = new BytConvertToString();
        path = args[0];


        if (path.charAt(path.length() - 3) == '.' && path.charAt(path.length() - 2) == 'h' && path.charAt(path.length() - 1) == 'f') {
            try {
                pathTable = args[1];
                DecoderHuffman decoderHuffman = new DecoderHuffman();
                decoderHuffman.decode(path, pathTable);
            } catch (Exception e) {
                log.warning("Decoding wont be execute without encoding table, pleas enter encoding table as second argument");
            }

        } else {

            /*String test = converter.bytConvertToString(path);
            String string = code.encode(test);
            StringToByteArray strToByteArray = new StringToByteArray();
            writerEncodeCod(strToByteArray.stringToByteArray(string));

            EncodDecodHuffman encodDecodHuffman = new EncodDecodHuffman();
            VocabularyTable vocabularyTable = new VocabularyTable();
            vocabularyTable.writervocabularyTable(encodDecodHuffman.getVocabularyTable());*/
            EncoderHuffman encoderHuffman = new EncoderHuffman();
            encoderHuffman.encode(path);
        }
    }

    public static void writerDecodeText(String decodeFile) throws FileNotFoundException {
        try (FileWriter writer = new FileWriter("decode.txt", false)) {
            writer.write(decodeFile);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public static void writerEncodeCod(byte[] bytesArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("encode.hf");
        fileOutputStream.write(bytesArray);
        fileOutputStream.close();
    }

}
