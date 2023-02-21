package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
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
   // private static final Option addCategory = new Option("c","add-category",false, "Adding new category to quote-maker database");

    private static final Option userEmailDefinition = new Option(null, "userEmail",false, "Defining user");
    private static final Option userPasswordDefinition = new Option(null, "userPassword",false, "Defining user");

    //private static final Option categoryDefinition = new Option(null, "category",false, "Defining category for next added quote");


    /**
     *
     * @param options
     */
    public static void printFormattedOptions(Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar ProjekatRPR.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }

    /**
     *
     * @return
     */
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addUser);
        options.addOption(getItems);
        options.addOption(getCategories);
        options.addOption(userEmailDefinition);
        options.addOption(userPasswordDefinition);
        return options;
    }

    public static Kategorija searchThroughCategories(List<Kategorija> listOfCategories, String categoryName) {

        Kategorija category = null;
        category = listOfCategories.stream().filter(cat -> cat.getName().toLowerCase().equals(categoryName.toLowerCase())).findAny().get();
        return category;

    }

    public static void main(String[] args) throws Exception {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl = commandLineParser.parse(options, args);

        if((cl.hasOption(addUser.getOpt()) || cl.hasOption(addUser.getLongOpt())) && cl.hasOption((userEmailDefinition.getLongOpt())) &&  cl.hasOption((userPasswordDefinition.getLongOpt()))){}
        KupacManager user = new KupacManager();
        Kupac kupac = new Kupac();
       // kupac.setEmail(cl.getArgList().get(0));
        //kupac.setPassword(cl.getArgList().get(0));
        try{
            user.add(kupac);
            System.out.println("You successfully added quote to database!");

        }catch(ProjekatException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }

        }


    }
