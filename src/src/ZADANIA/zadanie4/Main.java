package src.ZADANIA.zadanie4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        Path path = Paths.get("src/ZADANIA");
        File file = new File("src/ZADANIA");
//        path.toFile().lastModified()

        findLastAndFirstToBeModifiedFile(file);
    }

    private static void findLastAndFirstToBeModifiedFile(File file) {
        try (Stream<Path> walk = Files.walk(file.toPath())) {
            TreeMap<Long, ArrayList<File>> collect = walk.map(Path::toFile)
                    .collect(Collectors.toMap(
                            File::lastModified,
                            x -> new ArrayList<>(List.of(x)),
                            (x1, x2) -> {
                                x1.addAll(x2);
                                return x1;
                            },
                            TreeMap::new));

            ArrayList<File> firstToBeModified = collect.get(collect.firstKey());
            ArrayList<File> lastModified = collect.get(collect.lastKey());
            System.out.printf("firstToBeModified: %s%nlastModified: %s%n", firstToBeModified, lastModified);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
