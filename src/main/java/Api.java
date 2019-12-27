import java.io.FileWriter;
import java.io.IOException;

public class Api {
    public static void main(String[] args) throws IOException {
        EncodDecodHuffman code = new EncodDecodHuffman();


        File file = new File();
        String path = args[0];
        String test = file.allConvertToByt(path);
        System.out.println("Original Text = " + test);
        String string = code.encode(test);
        code.decode(string);
        StringBuilder stringBuilder =  code.decode(string);
        String decodeFile = stringBuilder.toString();

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            writer.write(string + "\n");
            writer.write(decodeFile);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
