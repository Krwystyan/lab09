package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * This class implements the interface Controller.
 * {@link Controller}
 *
 */
public final class SimpleController implements Controller {
    private final List<String> history;
    private String currentString;

    /**
     * Builds a new SimpleController for the program.
     */
    public SimpleController() {
        this.history = new ArrayList<>();
    }    
    @Override
    public void setNextString(final String passed) {
        Objects.requireNonNull(passed, "The message passed is null, that's not acceptable");
        this.currentString = passed;
        history.add(currentString);
    }
    @Override
    public String getNextString() {
        return Objects.requireNonNull(this.currentString, "There's no nextString to print, set one first");
    }
    @Override
    public List<String> getHistory() {
        return Objects.requireNonNull(this.history, "There's no history cause no string have been print");
    }
    @Override
    public void printCurrentString() {
        Objects.requireNonNull(this.currentString, "Can't print a null string, set one first");
        System.out.println("The current string is: " + this.currentString); //NOPMD: is only an exercise
    }
}
