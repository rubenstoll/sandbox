package ch.jstollutions.coding;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodInterpreterImplTest {

    @Test
    public void checkValidProgram() {
        CodInterpreter codInterpreter = new CodInterpreterImpl();

        boolean result = codInterpreter.checkValidProgram("+++---.->++<");
        assertTrue(result);

        result = codInterpreter.checkValidProgram("++uuu---.->++<");
//        assertThat(result, is(Boolean.FALSE));


    }

    @Test
    public void loadProgram() {
        CodInterpreter codInterpreter = new CodInterpreterImpl();

        String loadedProgram = codInterpreter.loadProgram("testcodlin.txt");
        System.out.println(loadedProgram);

//        assertThat(loadedProgram, is(not(nullValue())));
//        assertThat(loadedProgram, containsString("++"));

    }

    @Test
    public void run() {
    }
}