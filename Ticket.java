package edu.progmatic.oobase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Ticket {


    private int sit;
    private int from;
    private int to;
    private int soldTickets;
    private int distanceOfLine;
    private int price;

    public Ticket( int sit, int from, int to) {

        this.sit = sit;
        this.from = from;
        this.to = to;
    }

    public int getSit() {
        return sit;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }


}


