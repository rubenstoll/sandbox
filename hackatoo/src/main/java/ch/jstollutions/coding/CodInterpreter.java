package ch.jstollutions.coding;

public interface CodInterpreter {


        Boolean checkValidProgram(String code);

        String loadProgram(String filename);

        RunResult run(String code);

}
