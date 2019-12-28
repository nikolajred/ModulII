import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BytConvertToString {
    public String bytConvertToString(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }

}



