import java.io.IOException;
        import java.io.PrintWriter;
        import java.io.File;


public class VocabularyTable {


    public void writervocabularyTable(String vocabularyTable) throws IOException {
        File file = new File("vocabularyTable.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.print(vocabularyTable);
        printWriter.close();

    }
}
