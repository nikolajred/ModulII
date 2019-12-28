package DecoderHuffman;

import java.io.File;
import java.io.IOException;
import java.io.EOFException;
import java.util.logging.Logger;

public class DecoderHuffman {

    private static final byte SIZE_OF_ENCODING_TABLE = 127;
    private static Logger log = Logger.getLogger(DecoderHuffman.class.getName());
    public void decode(String filePath, String tablePath) throws IOException {
        DecodeExecute operator = new DecodeExecute();
        File compressedFile = new File(filePath),
                tableFile = new File(tablePath),
                extractedFile = new File(filePath + ".txt");
        String compressed = "";
        String[] encodingArray = new String[SIZE_OF_ENCODING_TABLE];

        try (FileReader fi = new FileReader(compressedFile)) {
            byte b;
            while (true) {
                b = fi.readByte();
                compressed += String.format("%8s", Integer.toBinaryString(b & 0xff)).replace(" ", "0");
            }
        } catch (EOFException e) {

        }

        try (FileReader fi = new FileReader(tableFile)) {
            fi.readLine();
            encodingArray[(byte) '\n'] = fi.readLine();
            while (true) {
                String s = fi.readLine();
                if (s == null)
                    throw new EOFException();
                encodingArray[(byte) s.charAt(0)] = s.substring(1, s.length());
            }
        } catch (EOFException ignore) {
        }

        extractedFile.createNewFile();
        try (FileWriter fo = new FileWriter(extractedFile)) {
            fo.writeString(operator.extract(compressed, encodingArray));
        }
        log.info("Path to decoded file is " + extractedFile.getAbsolutePath());

    }

}
