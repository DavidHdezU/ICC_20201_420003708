import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Writer {
    public interface Minuscula {
        public void minus(String g);
    }

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("hola.txt"));
            for(String string = lines){
                String row[] = string.split(",");
                System.out.println("x" + row[0]+ " y" + row[1]);
            }
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}