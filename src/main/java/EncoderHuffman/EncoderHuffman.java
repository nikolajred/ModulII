package EncoderHuffman;

import DecoderHuffman.*;

import java.io.File;
import java.nio.charset.MalformedInputException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;


public class EncoderHuffman {
    private static Logger log = Logger.getLogger(EncoderHuffman.class.getName());

    public void encode(String stringPath) throws IOException {
        List<String> stringList;
        File inputFile = new File(stringPath);
        String s = "";
        File compressedFile, table;

        try {
            stringList = Files.readAllLines(Paths.get(inputFile.getAbsolutePath()));
        } catch (NoSuchFileException e) {
            log.warning("Wrong path, or such a file does not exist!");

            return;
        } catch (MalformedInputException e) {
            log.warning("Current file encoding is not supported");
            return;
        }

        for (String item : stringList) {
            s += item;
            s += '\n';
        }

        EncodeExecute execute = new EncodeExecute(new HuffmanTree(s));

        compressedFile = new File(inputFile.getAbsolutePath() + ".hf");
        compressedFile.createNewFile();
        try (FileWriter fo = new FileWriter(compressedFile)) {
            fo.writeBytes(execute.getBytedMsg());
        }
        table = new File(inputFile.getAbsolutePath() + ".encodeTable.txt");
        table.createNewFile();
        try (FileWriter fo = new FileWriter(table)) {
            fo.writeString(execute.getEncodingTable());
        }
        log.info("It's path to the encoded file: " + compressedFile.getAbsolutePath());
        log.info("It's path to the encode table: " + table.getAbsolutePath());

    }

}
