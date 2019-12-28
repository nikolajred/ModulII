package DecoderHuffman;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Closeable;
import java.util.logging.Logger;

public class FileWriter implements Closeable {

    private File outputFile;
    private FileOutputStream fileOutputStream;
    private static Logger log = Logger.getLogger(FileWriter.class.getName());

    public FileWriter(File file) throws FileNotFoundException {
        outputFile = file;
        fileOutputStream = new FileOutputStream(outputFile);
    }

    public void writeByte(byte msg) throws IOException {
        fileOutputStream.write(msg);
    }

    public void writeBytes(byte[] msg) throws IOException {
        fileOutputStream.write(msg);
    }

    public void writeString(String msg) {
        try (PrintWriter pw = new PrintWriter(outputFile)) {
            pw.write(msg);
        } catch (FileNotFoundException e) {
            log.warning("Wrong path, or file is not exist");
        }
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();
    }

    public void finalize() throws IOException {
        close();
    }
}
