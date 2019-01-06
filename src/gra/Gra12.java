package gra;

import  java.io.*;

class Stan{
    private int x; // pozycja biezaca
    private int y;
    private int popX;  // pozycja poprzednia
    private int popY;
    void wPrawo(){ popX = x; popY = y; x++; }
    void wLewo(){ popX = x;  popY = y; x--; }
    void wGore(){ popY = y; popX = x; y++; }
    void wDol(){ popY = y;  popX = x; y--; }
    private int punkty;  // punktacja
    boolean koniec = false;  // koniec = true gdy osiagnieto

    public int getPunkty(){
        return punkty;
    }

    public void setPunkty(int zmiana){
        this.punkty = punkty + zmiana ;
    }

    // pole wyjsciowe i gracz chce skonczyc
    int x() { return x ; }
    int y() { return y ; }

    // powrot na poprzednia pozycje
    void wroc() {
        x = popX;
        y = popY;
    }

    String opisSlepy() {
        return  punkty + "punktow ";
    }

    // podaje: x,y, punkty
    String opis() {
        return "(" + x + "," + y + ")  " + punkty + "punktow\n" ;}


    // UZUPELNIC EWENTUALNIE O WIECEJ POTRZEBNYCH METOD
    Stan(int xPocz, int yPocz, int pPocz) {
        x = xPocz;
        y = yPocz;
        punkty = pPocz;
    }
}

abstract class Pole{
    static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    static char czytajZnak(){
        //  czyta jeden znak z klawiatury, pomija znak konca linii
        int c = '\0';
        try {
            String linia = br.readLine();   //czytanie 1 linijki z klawiatury
            if (linia.length()>0) c = linia.charAt(0); // pobranie jednego znaku
        }catch (IOException e){}
        return (char)c;
    }

    abstract String komentarz() ;
    // daje napis zawierajacy komentarz charakterystyczny dla danego pola

    static String komentarz = "Test";

    void ruch(Stan s){
        // "ruch" modyfikuje stan s zgodnie z regulami danego pola
        System.out.print(komentarz()) ;
        System.out.println(s.opis()) ;
        System.out.print("Jaki ruch? [g,d,l,p] ") ;
        switch (czytajZnak()) {
            case 'g' : s.wGore(); break;
            case 'd' : s.wDol(); break;
            case 'l' : s.wLewo(); break;
            case 'p' : s.wPrawo(); break;
            case 'q' : System.out.println("Awaryjny koniec gry.");
                s.koniec = true; break;
        }
    }
}

class Sciana extends Pole{
 // wypisuje komentarz i wraca na poprzednie miejsce, odejmuje jeden punkt
  String komentarz(){ return "Sciana! Zostajesz na tym samym miejscu. "; }
  void ruch(Stan s){
      s.setPunkty(-1);
      s.wroc();
      super.ruch(s);
      //zmniejsz punkty

  }
}

class ZwyklePole extends Pole{
    // jak Pole, ponadto powinna odejmowac jeden punkt
    String komentarz() { return "Zwykle pole" ; }
    void ruch(Stan s){
        s.setPunkty(-1);
        super.ruch(s);
    }
}

class PolePremia extends Pole {

    String komentarz = "pole premiowane";

    String komentarz() {
        return "Pole premiowane!";
//        System.out.println(komentarz);
    }

    void ruch(Stan s){
        s.setPunkty(5);
        super.ruch(s);
    }
}

class Sciemnij extends Pole {
    String komentarz() {
        return "Bardzo ciemne miejsce jaskini, nic nie widzisz. [g,d,l,p]  ";
    }
    void ruch(Stan s) {
        for(int i = 0; i < 2; i++) {
            s.setPunkty(-1);
            System.out.print(komentarz());
            System.out.print(s.opisSlepy());
            switch (czytajZnak()) {
                case 'g':
                    s.wGore();
                    break;
                case 'd':
                    s.wDol();
                    break;
                case 'l':
                    s.wLewo();
                    break;
                case 'p':
                    s.wPrawo();
                    break;
                case 'q':
                    System.out.println("Awaryjny koniec gry.");
                    s.koniec = true;
                    break;
            }
        }
    }
}


class Wyjscie extends Pole {
    @Override
    String komentarz() {
        return "Czy zakonczyc gre? [t, n]";
    }
    // oferuje mozliwosc zakonczenia gry, a jezeli nie konczymy, to tak jak Pole
    String komentarzKoniec() {
        return "Koniec gry.";
    }

    void czyKoniec(Stan s){
        System.out.print("Czy zakonczyc gre? [t, n]");
        switch (czytajZnak()) {
            case 't' : s.koniec = true;
                System.out.println(komentarzKoniec()); break;
            case 'n' : s.koniec = false;
                super.ruch(s); break;
        }
    }

}

class Gra{
    public static void main(String[] a){
        // inicjalizacja "jaskini"
        int i,j ;
        int rozmiar = 10 ;
        Wyjscie w = new Wyjscie();
        Pole[][] jaskinia = new Pole[rozmiar][rozmiar] ;
        for (i = 0; i < rozmiar ; i++)
            for (j = 0; j < rozmiar ; j++){
                   if (i == 0 || i == rozmiar - 1 || j == 0 || j == rozmiar - 1)
                       jaskinia[i][j] = new Sciana();
                   else if (i == 3 && j >= 3)
                       jaskinia[i][j] = new Sciana();
                   else if (i == 2 && j == 4)
                       jaskinia[i][j] = new PolePremia();
                   else if (i == 5 && j == 2)
                       jaskinia[i][j] = new PolePremia();
                   else if (i == 8 && j == 6)
                       jaskinia[i][j] = new PolePremia();
                   else if (i == 6 && j == 8)
                       jaskinia[i][j] = new Sciemnij();
                   else
                jaskinia[i][j] = new ZwyklePole() ;
            }
        // gra wlasciwa
        Stan s = new Stan(5,5,16) ;
        while (!s.koniec) {
            (jaskinia[s.x()][s.y()]).ruch(s);
            while (s.getPunkty() < 1)
                w.czyKoniec(s);
        }
    }
}

/*
  ••••••••••••••••••••••••••••••••••
  ••▬▬••▬▬▬▬▬▬▬▬▬▬▬▬••
  ••▬▬••▬▬▬▬▬▬▬▬▬▬▬▬••
  ••▬▬••▬▬☺☺▬▬▬▬▬▬▬▬▬••
  ••▬▬••▬▬▬▬▬▬▬▬▬▬▬▬••
  ••▬▬••▬▬▬▬♠♠▬▬▬▬▬▬▬••
  ••▬▬••▬◘▬▬▬▬▬▬▬▬▬▬••
  ••▬♠♠••▬▬▬▬▬▬▬▬▬▬▬▬••
  ••▬▬••▬▬▬▬☺☺▬▬▬▬▬▬▬••
  ••▬▬▬▬♠♠▬▬▬▬▬▬▬▬▬▬••
  ••▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬••
  ••••••••••••••••••••••••••••••••••

  ◘ - pozycja początkowa
  •• - ściana
  ▬ - zwykłe pole
  ♠♠ - pole premium
  ☺☺ - pole ciemne


 */