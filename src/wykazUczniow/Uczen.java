package wykazUczniow;

import java.util.ArrayList;

public class Uczen {
    private String id;
    private String imie;
    private ArrayList<Integer> oceny = new ArrayList<Integer>();

    public String getId() {
        return this.id;
    }

    public String getImie() {
        return this.imie;
    }


    public int getSum() {
        Integer sum = 0;
        if (!oceny.isEmpty()) {
            for (int i = 0; i < oceny.size(); i++)
                sum += oceny.get(i);
            return sum;
        }
        else
            return sum;
    }

    public int iloscOcen() {
        return oceny.size();
    }

    public double getAvg() {
        Integer sum = this.getSum();
        return sum.doubleValue() / oceny.size();

    }

    public String dajImie(String id) {
        if (this.id == id)
            return imie;
        else
            return "";
    }

    public Uczen(String id, String imie) {
        this.id = id;
        this.imie = imie;
    }

    public void wstawOcene(int wartosc) {
        this.oceny.add(wartosc);
    }


    @Override
    public String toString() {
        return imie + " " + id + "\n" + oceny.toString();
    }
}

class UczenTest {
    public static void main(String[] args) {

        Uczen u1 = new Uczen("JP", "Jan");
        System.out.println(u1.toString());

        u1.wstawOcene(5);
        u1.wstawOcene(4);

        System.out.println(u1.toString());
        System.out.println(u1.dajImie("JP"));
        System.out.println(u1.getAvg());


    }
}
