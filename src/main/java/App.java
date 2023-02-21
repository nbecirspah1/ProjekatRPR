
import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;
import java.sql.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;



public class App {
    /**
     * Definisanje varijabli za opcije
     */
    private static final Option addUser = new Option("u", "add-user", false, "Adding new user to RPRProjekaBaza database\"");
    private static final Option getItems = new Option("getI", "get-items", false, "Printing all items from RPRProjekaBaza database\"");
    private static final Option getCategories = new Option("getC", "get-categories",false, "Printing all categories from RPRProjekaBaza database");

    /**
     *
     * @param options
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar quote-maker.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }


}