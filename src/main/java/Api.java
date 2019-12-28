import java.io.*;

public class Api {
    public static String path;
    public static void main(String[] args) throws IOException {
        EncodDecodHuffman code = new EncodDecodHuffman();


        File file = new File();
        String path = args[0];

        if (path.charAt(path.length() - 3) == '.' && path.charAt(path.length() - 2) == 'h' && path.charAt(path.length() - 1) == 'f') {
            String string = file.allConvertToByt(path);
            StringBuilder stringBuilder = code.decode(string);
            String decodeFile = stringBuilder.toString();
            writerDecodeText(decodeFile);
        } else {
            String test = file.allConvertToByt(path);
            String string = code.encode(test);
            StringToByteArray stringToByteArray = new StringToByteArray();
            writerEncodeCod(stringToByteArray.stringToByteArray(string));

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
        FileOutputStream fos = new FileOutputStream("encode.hf");
        fos.write(bytesArray);
        fos.close();
    }

}
