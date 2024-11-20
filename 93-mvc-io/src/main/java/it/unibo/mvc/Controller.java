package it.unibo.mvc;

import java.util.List;

/**
 * Simple interface for an controller.
 */
public interface Controller {
    /**
     * @param x is the next string to print in the stdio.
     * @throws NullPointerException if the passed string is null.
     */
    void setNextString(String x);
    /**
     * 
     * @return the next string to print in the stdio.
     * @throws NullPointerException if the current string is unset at that moment.
     */
    String getNextString();
    /**
     * 
     * @return a List that contains all String that have been printed all a long the program.
     * @throws NullPointerException if during all program no string have been printed.
     */
    List<String> getHistory();
    /**
     *  print in the stdio the current string.
     * @throws NullPointerException if the current string is unset at that moment.
     */
    void printCurrentString();
}
