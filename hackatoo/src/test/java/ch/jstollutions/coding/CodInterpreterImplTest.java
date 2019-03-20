package ch.jstollutions.coding;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodInterpreterImplTest {

    @Test
    public void checkValidProgram() {
        CodInterpreter codInterpreter = new CodInterpreterImpl();

        boolean result = codInterpreter.checkValidProgram("+++---.->++<");
        assertTrue(result);

         result = codInterpreter.checkValidProgram("++uuu---.->++<");
        assertFalse(result);


    }

    @Test
    public void loadProgram() {
        CodInterpreter codInterpreter = new CodInterpreterImpl();

  String loadedProgram =  codInterpreter.loadProgram("testcodlin.txt");
  System.out.println(loadedProgram);

        assertNotNull(loadedProgram);


    }

    @Test
    public void run() {
    }
}