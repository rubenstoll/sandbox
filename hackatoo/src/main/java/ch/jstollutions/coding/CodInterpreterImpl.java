package ch.jstollutions.coding;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class CodInterpreterImpl implements CodInterpreter {

    final static Charset ENCODING = StandardCharsets.UTF_8;

    @Override
    public Boolean checkValidProgram(String code) {

        boolean result = false;
        for (char c : code.toCharArray()) {
            if (c != '>' && c != '<' && c != '+' && c != '-' && c != '.') {
                return false;
            } else {
                result = true;
            }

        }

        return result;
    }

    @Override
    public String loadProgram(String filename) {

        StringBuffer program = new StringBuffer();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filename)).getFile());
        Path path = Paths.get(file.getPath());

        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {

            String line;
            while ((line = reader.readLine()) != null) {
                program.append(line);
            }

        } catch (IOException e) {
            // handle error
            e.printStackTrace();
        }
        return program.toString();
    }

    @Override
    public RunResult run(String code) {

        return null;
    }

}
