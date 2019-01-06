package wykazUczniow;

import java.util.ArrayList;
import java.util.Comparator;

public class WykazU {

    private ArrayList<Uczen> lista = new ArrayList<Uczen>();

    /**
     * Metoda dodaje ucznia na listę uczniów.
     * @param id identyfikator ucznia
     * @param imie imię ucznia
     */
    public void wstawUcznia(String id, String imie) {
        lista.add(new Uczen(id, imie));
    }

    public void wypisz(String id) {
        for (int i = 0; i < lista.size(); i++) {
            Uczen p = lista.get(i);
            if (p.getId() == id)
                System.out.println(p.toString());
            else ;
        }
    }

    public void wypisz() {
        for (int i = 0; i < lista.size(); i++) {
            Uczen p = lista.get(i);
            System.out.println(p.toString());
        }
    }

    public void wstawOcene(String id, int ocena) {
        for (int i = 0; i < lista.size(); i++) {
            Uczen p = lista.get(i);
            if (p.getId() == id)
                p.wstawOcene(ocena);
            else ;
        }
    }

    public void sortujA() {
        lista.sort(Comparator.comparing(Uczen::getImie));
    }

    public void sortujS() {
        lista.sort(Comparator.comparing(Uczen::getAvg).reversed());
    }

    public double srednia() {
        Integer oceny = 0;
        int ilosc = 0;
        for (Uczen u : lista) {
            oceny += u.getSum();
            ilosc += u.iloscOcen();
        }
        return oceny.doubleValue() / ilosc;
    }
}

class TestWykazU{
    public static void main(String[] a){
        WykazU wu = new WykazU();

        wu.wstawUcznia("K","Kazik");
        wu.wstawUcznia("K1","Kazik");
        wu.wstawUcznia("N","Nikodem");
        wu.wstawUcznia("J","Jan");
        wu.wstawUcznia("W","Wiesiek");


        wu.wstawOcene("K",5);
        wu.wstawOcene("K",4);
        wu.wstawOcene("K",3);
        wu.wstawOcene("K",5);
        wu.wstawOcene("K",2);

        wu.wstawOcene("K1",5);
        wu.wstawOcene("K1",6);

        wu.wstawOcene("N",4);
        wu.wstawOcene("N",5);
        wu.wstawOcene("N",4);

        wu.wstawOcene("J",3);
        wu.wstawOcene("W",5);

        System.out.println("Wypisanie wszystkich:\n");
        wu.wypisz();
        System.out.println();
        System.out.println("Wypisanie po id:\n");
        wu.wypisz("K");
        System.out.println();
        System.out.println("Wypisanie po sortowaniu alfabetycznym:\n");
        wu.sortujA();
        wu.wypisz();
        System.out.println();
        System.out.println("Wypisanie po sortowaniu według średniej:\n");
        wu.sortujS();
        wu.wypisz();
        System.out.println();
        System.out.println(wu.srednia());

    }
}
