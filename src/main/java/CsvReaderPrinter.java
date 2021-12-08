import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import entities.Department;
import entities.Human;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class which is describing methods for reading data from CSV-file and printing it
 * @author Nikita Safonov, student of AMM VSU, 3rd year, 3rd group
 * @see Department
 * @see Human
 */
public class CsvReaderPrinter {

    private static String csvFilePath = "C://Users/User/IdeaProjects/lab4/src/main/resources/foreign_names.csv";
    private static char separator = ';';
    private static List<Human> persons = new ArrayList<>();

    /**
     * Method for reading data from CSV-file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws CsvValidationException
     */
    public void readFromCSV() {
        try (FileReader in = new FileReader(csvFilePath)) {
            CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();
            CSVReader reader = new CSVReaderBuilder(in).withCSVParser(parser).withSkipLines(1).build();
            if (reader == null) {
                throw new FileNotFoundException(csvFilePath);
            }
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Human person = new Human(Integer.valueOf(nextLine[0]), nextLine[1], nextLine[2], new Department(nextLine[4]), Integer.valueOf(nextLine[5]), nextLine[4]);
                persons.add(person);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for printing of read data
     */
    public void printCSVData() {
        for(int i = 0; i < persons.size(); i++){
            System.out.print(persons.get(i).getID() + "\t \t");
            System.out.print(persons.get(i).getName() + "\t \t");
            System.out.print(persons.get(i).getGender() + "\t \t");
            System.out.print(persons.get(i).getBirthday() + "\t \t");
            System.out.print(persons.get(i).getDepartment().getID() + "\t \t");
            System.out.print(persons.get(i).getDepartment().getTitle() + "\t \t");
            System.out.print(persons.get(i).getSalary() + "\t \t");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CsvReaderPrinter reader = new CsvReaderPrinter();
        reader.readFromCSV();
        reader.printCSVData();
    }
}
