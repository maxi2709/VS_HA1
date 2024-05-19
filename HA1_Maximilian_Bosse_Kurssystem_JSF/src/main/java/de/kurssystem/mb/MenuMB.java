package de.kurssystem.mb;

import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("menueMB")
@SessionScoped
public class MenuMB implements Serializable {

    private static final long serialVersionUID = 80091724090907065L;
    
    // Counter Seitenwechsel
    private int pageCounter = 0;

    public String starteEventVw() {
        counterErhoehen();
        return "EVENTVW_MENUE";
    }

    public String starteUserVw() {
        counterErhoehen();
        return "USERVW_MENUE";
    }

    public int getPageCounter() {
        return pageCounter;
    }

    public void setPageCounter(int pageCounter) {
        this.pageCounter = pageCounter;
    }

    public void counterErhoehen() {
        this.pageCounter++;
    }
}
