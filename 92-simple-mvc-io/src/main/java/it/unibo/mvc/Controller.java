package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */

public class Controller implements java.io.Serializable {
    private static final long serialVersionUID = 1;
    private static final String DEFAULTPATH = System.getProperty("user.home")
        + System.getProperty("file.separator")
        + "output.txt";
    private File consideredFile = new File(DEFAULTPATH);

    public File getFile() {
        return this.consideredFile;
    }
    public void setFile(final File passedFile) {
        this.consideredFile =  passedFile;
    }
    public String getFilePath() {
        return this.consideredFile.getPath();
    }
    public void writeAString(final String inputPassed) throws FileNotFoundException {
        try (PrintStream p = new PrintStream(consideredFile, StandardCharsets.UTF_8)) {
            p.println(inputPassed);
        } catch (IOException ioException) {
            System.out.println("An error during write the file: " + ioException.getMessage()); // NOPMD
            ioException.getStackTrace(); // NOPMD: allowed as this is just an exercise
        }
    }


}
