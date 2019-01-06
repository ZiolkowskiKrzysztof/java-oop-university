package ulamki;

public class UlamekZP extends Ulamek {

    private boolean ulamekPierwotny;
    private Ulamek zapisanaWartosc;

    public UlamekZP(int l, int m) {
        super(l, m);
        zapisanaWartosc = new Ulamek(l, m);
        ulamekPierwotny = true;
    }

    @Override
    public void mnozPrzez(Ulamek u) {
        ulamekPierwotny = false;
        super.mnozPrzez(u);
    }

    public boolean sprawdz() {
        if (ulamekPierwotny == false) return true;
        else return false;
    }

    public void cofnij() {
        if (ulamekPierwotny == false) {
            this.setLicznik(zapisanaWartosc.getLicznik());
            this.setMianownik(zapisanaWartosc.getMianownik());
            zapisanaWartosc = this;
            ulamekPierwotny = true;
        }
        else
            System.out.println("Operacja niedozwolona.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


class TestUlamekZP {
    public static void main(String[] args){

        UlamekZP u1 = new UlamekZP(1,3);
        UlamekZP u2 = new UlamekZP(2,3);

        System.out.println("Ulamek u1: " + u1);
        System.out.println("Ulamek u2: " + u2);

        System.out.println("Czy mozna cofnąć u1? " + u1.sprawdz());
        System.out.println();

        u1.mnozPrzez(u2);
        System.out.println("u1 * u2 = " + u1);

        System.out.println("Czy mozna cofnąć u1? " + u1.sprawdz());
        System.out.println();

        u1.cofnij();
        System.out.println("Cofniete u1: " + u1);
        System.out.println("Czy mozna cofnąć u1? " + u1.sprawdz());
        u1.cofnij();

    }
}