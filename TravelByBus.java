package edu.progmatic.oobase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class TravelByBus {

    int[] tomb;
    Ticket[] jegytomb;
    Ticket jegy;
    private int soldTickets;
    private int distanceOfLine;
    private int price;

    public void kiOlvasEsFeltolt() throws FileNotFoundException {
        try {
            String path = "C:\\Users\\PJ\\IdeaProjects\\src\\edu\\progmatic\\oobase\\eladott.txt";
            Scanner sc = new Scanner(new File(path));

            int i = 0;
            while (sc.hasNext()) {
                sc.nextInt();
                i++;
            }

            tomb = new int[i];
            jegytomb = new Ticket[(i) / 3];   //az elso sort nem szamitjuk bele, igy minden jegynek egy sore lesz a peldanyban.
            sc = new Scanner(new File(path));

            for (int j = 0; j < tomb.length; j++) {
                switch (j) {
                    case 0:
                        tomb[0] = sc.nextInt();
                        soldTickets = tomb[0];
                        break;
                    case 1:
                        tomb[1] = sc.nextInt();
                        distanceOfLine = tomb[1];
                        break;
                    case 2:
                        tomb[2] = sc.nextInt();
                        price = tomb[2];
                        break;
                }
            }


            for (int k = 3; k < tomb.length; k++) {
                tomb[k] = sc.nextInt();
            }
            //tomb beolvasva es feltoltve a fajlbol.

            for (int j = 3; j <= (tomb.length - 3); j += 3) {
                jegy = new Ticket(tomb[j], tomb[j + 1], tomb[j + 2]);   //a jegytomb feltoltese a jegy objektumokkal
                jegytomb[j / 3] = jegy;
            }
            //System.out.println(jegytomb[113].getSit() + "hey");         //a jegytomb 0 rol indul es 113 az utolso tagja


        } catch (
                IOException e) {
            System.out.println("IO hiba");
        }
    }

    /*
    Adja meg a legutolsó jegyvásárló ülésének sorszámát és az általa beutazott távolságot!
    A kívánt adatokat a képernyőn jelenítse meg!
     */
    public void lastPax() {

        System.out.println("Adja meg a legutolsó jegyvásárló ülésének sorszámát és az általa beutazott távolságot!\n" +
                "    A kívánt adatokat a képernyőn jelenítse meg!");
        int ules = jegytomb[jegytomb.length - 1].getSit();
        int tav = jegytomb[jegytomb.length - 1].getTo() - jegytomb[jegytomb.length - 1].getFrom();

        System.out.println("az utolso jegyvasarol, a " + ules + "szeken ult, es " + tav + " km tavott utazott.");
    }



    /*
Listázza ki, kik utazták végig a teljes utat! Az utasok sorszámát egy-egy szóközzel
elválasztva írja a képernyőre!
     */

    public void vegigUtazok() {
        System.out.println("Listázza ki, kik utazták végig a teljes utat! Az utasok sorszámát egy-egy szóközzel\n" +
                "elválasztva írja a képernyőre!");
        for (int i = 1; i < jegytomb.length - 1; i++) {
            if (jegytomb[i].getTo() == distanceOfLine && jegytomb[i].getFrom() == 0)
                System.out.print("akik vegigutazzak az utat: " + jegytomb[i].getSit() + " ");

        }
    }

 /*
Határozza meg, hogy a jegyekből mennyi bevétele származott a társaságnak!
Az eredményt írja a képernyőre!
  */
    public void jegyBevetel(){
        System.out.println("Határozza meg, hogy a jegyekből mennyi bevétele származott a társaságnak!\n" +
                "Az eredményt írja a képernyőre!");
        int sum=0;
        for (int i = 1; i < jegytomb.length-1; i++) {
            int a=((jegytomb[i].getTo()-jegytomb[i].getFrom())/10)*tomb[2];
            sum+=hulyenKerekit(a);

        }
        System.out.println("a vallalat osszes jegybevetele: "+sum);
    }

    public int hulyenKerekit(int a){
        switch(a%10){
            case 1:
                a-=1;
                break;
            case 2:
                a-=2;
                break;
            case 6:
                a-=6;
                break;
            case 7:
                a-=7;
                break;


            case 3:
                a+=7;
                break;
            case 4:
                a+=6;
                break;
            case 8:
                a+=2;
                break;
            case 9:
                a+=1;
                break;
        }
        return a;
    }


/*
Írja a képernyőre, hogy a busz végállomást megelőző utolsó megállásánál hányan szálltak
fel és le!
 */

    public void utolsoElottiMegallo(){ //eloszor megkeresi az linedistance masodik legnagyobb elemet;
        int seged=0;
        int [] segedtomb=new int[jegytomb.length];
        for (int j = 1; j < jegytomb.length; j++) {
            segedtomb[j]=jegytomb[j].getTo();
           //System.out.println(segedtomb.length);
        }

       // int min=jegytomb[1].getTo();

        for (int i = 0; i < segedtomb.length-1; i++) {
            for (int j = 0; j < segedtomb.length-1; j++) {

                if(segedtomb[j]<segedtomb[j+1]){
                     seged=segedtomb[j+1];
                    segedtomb[j+1]=segedtomb[j];            //min rendezes jegytimb[].getTo ra
                    segedtomb[j]=seged;
                }
            }
        }
        int utolsoElottiMegallo=0;
        for (int f = 0; f<segedtomb.length ; f++) {    //elol lesznek a nagyok
            if(segedtomb[f]!=segedtomb[0]) {            //megnezem mi az utolso elotti megallo
                utolsoElottiMegallo=segedtomb[f];
                break;
            }
        }
        int leszallok=0;
        int felszallok=0;
        for (int i = 1; i < jegytomb.length; i++) {
            if(jegytomb[i].getTo()==utolsoElottiMegallo){
                leszallok++;
            }
            if(jegytomb[i].getFrom()==utolsoElottiMegallo){
                felszallok++;
            }

        }
        System.out.println("Az utolso elotti megalloban: "+leszallok+" szallnak le, es "+felszallok+" szallnak fel.us");
    }

}
