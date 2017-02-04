package task3;


import lombok.SneakyThrows;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class EncodingConversion {
    @SneakyThrows
    public static void main(String[] args) {

        List<String> lines = Files.readAllLines(Paths.get("D:\\test6"), StandardCharsets.UTF_8);
        Files.write(Paths.get("D:\\test7.txt"), lines, StandardCharsets.UTF_16);

    }
}
