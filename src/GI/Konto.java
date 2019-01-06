package GI;

public class Konto {
    private int stan;

    Konto() {
        stan = 0;
    }

    public void operacja(int ile) throws DebetException {
        if (stan + ile >= 0 )
            stan += ile;
        else
            throw new DebetException();
    }

    public int dajStan() {
        return stan ;
    }
}


