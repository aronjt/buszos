package edu.progmatic.oobase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
       try{
           TravelByBus a=new TravelByBus();
           a.kiOlvasEsFeltolt();
          // a.lastPax();
           // a.vegigUtazok();
          // a.jegyBevetel();
           //a.utolsoElottiMegallo();
       }
       catch(IOException e){
            System.out.println("hiba a mainben");
        }

    }
}



