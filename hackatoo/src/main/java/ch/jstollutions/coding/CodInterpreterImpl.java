package ch.jstollutions.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

        String program = "";
        Path path = Paths.get(filename);

        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)) {

            String line = null;
            while ((line = reader.readLine()) != null) {
                program.concat(line);
            }

        } catch (IOException e) {
            // handle error
            e.printStackTrace();
        }
        return program;
    }

    @Override
    public RunResult run(String code) {

        return null;
    }

}
