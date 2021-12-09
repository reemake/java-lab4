import entities.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import csvReaderPrinter.CsvReaderPrinter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderPrinterTest {

    CsvReaderPrinter reader;

    @BeforeEach
    void setUp() {
        reader = new CsvReaderPrinter("C://Users/User/IdeaProjects/lab4/src/main/resources/foreign_names.csv",  ';', new ArrayList<>());
    }

    @Test
    void ifAllLinesBeenReadTest() {
        reader.readFromCSV();
        int expectedValue = reader.getPersons().get(reader.getPersons().size()-1).getDepartment().getID();
        int actualValue = 25898;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void ifSomeLineIsNullTest() {
        reader.readFromCSV();
        boolean notNull = true;
        for (int i = 0; i < reader.getPersons().size(); i++) {
            if(!checkNotNull(reader.getPersons().get(i)))
                notNull = false;
        }

        assertTrue(notNull);
    }

    private boolean checkNotNull(Human person) {
        return person.getID() != 0 && person.getName() != null && person.getGender() != null && person.getBirthday() != null && person.getDepartment() != null && person.getSalary() != 0;
    }
}