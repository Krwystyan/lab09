package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {
    void setNextString(final String x);
    String getNextString();
    List<String> getHistory();
    void printCurrentString();
}
