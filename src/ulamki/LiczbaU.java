package ulamki;

public class LiczbaU {

    private int calosci;
    private Ulamek czescU;

    LiczbaU(int cal, Ulamek u){
        this.calosci = cal;
        this.czescU = u;
        if (u.getLicznik() >= u.getMianownik()) {
            napraw(this);
        }
        else
            return;
    }

    private void napraw(LiczbaU l) {
        this.calosci += l.czescU.getLicznik() / l.czescU.getMianownik();
        this.czescU.setLicznik(l.czescU.getLicznik() % l.czescU.getMianownik());
        this.czescU.setMianownik(l.czescU.getMianownik());
    }

    LiczbaU(){}

    public LiczbaU mnozPrzez(LiczbaU l){
        int l1, m1, l2, m2, licznik, mianownik;
        l1 = this.calosci * this.czescU.getMianownik() + this.czescU.getLicznik();
        m1 = this.czescU.getMianownik();

        l2 = l.calosci * l.czescU.getMianownik() + l.czescU.getLicznik();
        m2 = l.czescU.getMianownik();

        licznik = l1 * l2;
        mianownik = m1 * m2;

        Ulamek kopia =  new Ulamek(licznik, mianownik);
        LiczbaU wynik = new LiczbaU(0, kopia);

        if(wynik.czescU.getLicznik() >= wynik.czescU.getMianownik())
            napraw(wynik);

        return wynik;
    }

    public LiczbaU mnozPrzez(int liczba){
        int l1, m1, licznik, mianownik;
        l1 = this.calosci * this.czescU.getMianownik() + this.czescU.getLicznik();
        m1 = this.czescU.getMianownik();

        licznik = l1 * liczba;
        mianownik = m1;

        Ulamek kopia =  new Ulamek(licznik, mianownik);
        LiczbaU wynik = new LiczbaU(0, kopia);

        if(wynik.czescU.getLicznik() >= wynik.czescU.getMianownik())
            napraw(wynik);

        return wynik;
    }

    public LiczbaU mnozPrzez(Ulamek u){
        int l1, m1, l2, m2, licznik, mianownik;
        l1 = this.calosci * this.czescU.getMianownik() + this.czescU.getLicznik();
        m1 = this.czescU.getMianownik();

        l2 = u.getLicznik();
        m2 = u.getMianownik();

        licznik = l1 * l2;
        mianownik = m1 * m2;

        Ulamek kopia =  new Ulamek(licznik, mianownik);
        LiczbaU wynik = new LiczbaU(0, kopia);

        if(wynik.czescU.getLicznik() >= wynik.czescU.getMianownik())
            napraw(wynik);

        return wynik;
    }

    @Override
    public String toString() {
        return (calosci + " " + czescU.getLicznik() + "/" + czescU.getMianownik());
    }
}

class Test2 {
    public static void main(String[] args) {

        Ulamek u5 = new Ulamek(5,2);
        LiczbaU l1 = new LiczbaU(2, u5);
        System.out.println("liczba1 = " + l1);
        System.out.println();

        Ulamek u6 = new Ulamek(2,3);
        Ulamek u7 = new Ulamek(5, 7);
        LiczbaU l2 = new LiczbaU(3, u6);
        LiczbaU l3 = new LiczbaU(2, u7);

        System.out.println("liczba2 = " + l2);
        System.out.println("liczba3 = " + l3);

        System.out.println("liczba2 * liczba3 = " + l2.mnozPrzez(l3));
        System.out.println();

        Ulamek u8 = new Ulamek(5,8);
        LiczbaU l4 = new LiczbaU(4, u8);
        System.out.println("liczba4 = " + l4);
        System.out.println("liczba4 * 4 = " + l4.mnozPrzez(4));
        System.out.println();

        Ulamek u9 = new Ulamek(3,4);
        System.out.println("ulamek9 = " + u9);
        System.out.println("liczba1 = " + l1);
        System.out.println("liczba1 * ulamek9 = " + l1.mnozPrzez(u9));

    }
}

