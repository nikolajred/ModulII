import java.io.*;

public class Api {
    public static String path;
    public static void main(String[] args) throws IOException {
        EncodDecodHuffman code = new EncodDecodHuffman();


        BytConvertToString converter = new BytConvertToString();
        String path = args[0];

        if (path.charAt(path.length() - 3) == '.' && path.charAt(path.length() - 2) == 'h' && path.charAt(path.length() - 1) == 'f') {
            String string = converter.bytConvertToString(path);
            StringBuilder stringBuilder = code.decode(string);
            String decodeFile = stringBuilder.toString();
            writerDecodeText(decodeFile);
        } else {
            String test = converter.bytConvertToString(path);
            String string = code.encode(test);
            StringToByteArray strToByteArray = new StringToByteArray();
            writerEncodeCod(strToByteArray.stringToByteArray(string));

            EncodDecodHuffman encodDecodHuffman = new EncodDecodHuffman();
            VocabularyTable vocabularyTable = new VocabularyTable();
            vocabularyTable.writervocabularyTable(encodDecodHuffman.getVocabularyTable());



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

    public static void writerEncodeCod(byte [] bytesArray) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("encode.hf");
        fileOutputStream.write(bytesArray);
        fileOutputStream.close();
    }

}
