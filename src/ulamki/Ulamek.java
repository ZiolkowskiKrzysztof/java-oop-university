package ulamki;

public class Ulamek {

    private int licznik;
    private int mianownik;

    Ulamek(int l, int m){
        this.licznik = l;
        this.mianownik = m;
    }

    Ulamek(){}

    public int getLicznik(){
        return licznik;
    }

    public void setLicznik(int licznik){
        this.licznik = licznik;
    }

    public int getMianownik(){
        return mianownik;
    }

    public void setMianownik(int mianownik){
        this.mianownik = mianownik;
    }

    static Ulamek razy(Ulamek u, Ulamek v) {
        return new Ulamek(u.getLicznik() * v.getLicznik(), u.getMianownik() * v.getMianownik());
    }

    public void mnozPrzez(Ulamek u) {
        this.licznik *= u.licznik;
        this.mianownik *= u.mianownik;
    }

    public void mnozPrzez(int liczba) {
        this.licznik *= liczba;
    }

    @Override
    public String toString() {
        return (this.licznik + "/" + this.mianownik);
    }
}


class Test {
    public static void main(String[] args){

        Ulamek u1 = new Ulamek(1,3);
        Ulamek u2 = new Ulamek(2,4);
        System.out.println(u1);
        System.out.println(u2);

        Ulamek u3 = Ulamek.razy(u1, u2);
        System.out.println(u3);

        u3.mnozPrzez(u1);
        System.out.println(u3);

        u3.mnozPrzez(2);
        System.out.println(u3);


    }
}