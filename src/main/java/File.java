import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class File{
    public String allConvertToByt(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        return content;
    }

}



