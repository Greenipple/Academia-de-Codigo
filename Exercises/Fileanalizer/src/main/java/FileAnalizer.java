import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

public class FileAnalizer {


    private String fileName = Main.FILE_PATH;



    public String[] getWords(String fileName) throws IOException {

       return Files
               .readString(Path.of(fileName))
               .split("\\W+");

    }
    public long countWords(String fileName) throws IOException {

      return Files.lines(Paths.get(fileName))
      .map(line -> line.split("\\W+"))
      .flatMap(Arrays::stream).count();
    }

    public Optional<String> getFirstWordLongerThan(String fileName, int length) throws IOException {
        Optional<String> result = Optional.of((Files.lines(Path.of(fileName))
                .map(line -> line.split("\\W+"))
                .flatMap(Arrays::stream)
                .filter(words -> words.length() > length)
                .findFirst().orElse("No such word found")));
        return result;
    }

  

}
