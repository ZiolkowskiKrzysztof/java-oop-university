package Swing;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.*;

import static java.awt.Color.blue;
import static java.awt.Color.yellow;

class Przyciski extends JFrame{
    JTextField t = new JTextField(20);
    JButton b1 = new JButton("przycisk 1") ;
    JButton b2 = new JButton("przycisk 2") ;
    JButton b3 = new JButton("przycisk 3") ;
    JButton b4 = new JButton("przycisk 4") ;
    JButton zero = new JButton("zeruj") ;
    private int licznik, counter;

    int getLicznik() {
       return licznik;
    }

    void setLicznik(int licz) {
        this.licznik = licz;
    }

    Przyciski(){
        setTitle("Przyciski");
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout()) ;
        cp.add(b1) ;
        cp.add(b2) ;
        cp.add(b3) ;
        cp.add(b4) ;
        cp.add(t) ;
        cp.add(zero);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,200) ;
        setVisible(true) ;
        b1.addActionListener( new B1());
        b2.addActionListener( new B2());
        b3.addActionListener( new B3());
        b4.addActionListener( new B4());
        zero.addActionListener( new Zero());
        b1.setBackground(Color.blue);
        b2.setBackground(Color.blue);
        b3.setBackground(Color.blue);
        b4.setBackground(Color.blue);
    }

    void ileWlaczonych() {
        if ((b1.getBackground() == yellow && b2.getBackground() == yellow && b3.getBackground() == yellow) ||
                (b1.getBackground() == yellow && b2.getBackground() == yellow && b4.getBackground() == yellow) ||
                    (b1.getBackground() == yellow && b3.getBackground() == yellow && b4.getBackground() == yellow) ||
                        (b2.getBackground() == yellow && b3.getBackground() == yellow && b4.getBackground() == yellow))
            licznik = 3;
        else if ((b1.getBackground() == yellow && b2.getBackground() == yellow) || (b1.getBackground() == yellow && b3.getBackground() == yellow) ||
                (b1.getBackground() == yellow && b4.getBackground() == yellow) || (b2.getBackground() == yellow && b3.getBackground() == yellow) ||
                (b2.getBackground() == yellow && b4.getBackground() == yellow) || (b3.getBackground() == yellow && b4.getBackground() == yellow))
            licznik = 2;
        else if ((b1.getBackground() == blue) && (b2.getBackground() == blue) && (b3.getBackground() == blue) && (b4.getBackground() == blue))
            licznik = 0;
        else if ((b1.getBackground() == yellow) && (b2.getBackground() == yellow) && (b3.getBackground() == yellow) && (b4.getBackground() == yellow))
            licznik = 4;
        else
            licznik = 1;

    }

    void count() {
        counter++;
    }

    void zeruj() {
        counter = 0;
    }

    class B1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (licznik == 3) {
                b1.setEnabled(false);
                b1.setBackground(blue);
                count();
            }
            else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                count();
                if (b1.getBackground() == blue)
                    b1.setBackground(yellow);
                else b1.setBackground(blue);
            }
            ileWlaczonych();
            t.setText(String.valueOf(counter));
        }
    }

    class B2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (licznik == 3) {
                b2.setEnabled(false);
                b2.setBackground(blue);
                count();
            }
            else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                count();
                if (b2.getBackground() == blue)
                    b2.setBackground(yellow);
                else b2.setBackground(blue);
            }
            ileWlaczonych();
            t.setText(String.valueOf(counter));
        }
    }

    class B3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (licznik == 3) {
                b3.setEnabled(false);
                b3.setBackground(blue);
                count();
            }
            else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                count();
                if (b3.getBackground() == blue)
                    b3.setBackground(yellow);
                else b3.setBackground(blue);
            }
            ileWlaczonych();
            t.setText(String.valueOf(counter));
        }
    }

    class B4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (licznik == 3) {
                b4.setEnabled(false);
                b4.setBackground(blue);
                count();
            }
            else {
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                count();
                if (b4.getBackground() == blue)
                    b4.setBackground(yellow);
                else b4.setBackground(blue);
            }
            ileWlaczonych();
            t.setText(String.valueOf(counter));
        }
    }

    class Zero implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            zeruj();

            ileWlaczonych();
            t.setText(String.valueOf(counter));
        }
    }

    public static void main(String[] arg){
        JFrame f = new Przyciski() ;
        JFrame f1 = new Przyciski() ;
    }
}