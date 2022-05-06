import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;

public class Interfata extends JPanel implements ActionListener {
    private final JButton taduna;
    private final JButton tinmulteste;
    private final JButton tderiveaza;
    private final JButton tscade;
    private final JButton timparte;
    private final JButton tintegreaza;
    private final JButton b5;
    private final JButton b4;
    private final JButton bX;
    private final JButton b1;
    private final JButton bminus;
    private final JButton b0;
    private final JButton b3;
    private final JButton b6;
    private final JButton b2;
    private final JButton b7;
    private final JButton bplus;
    private final JButton bput;
    private final JButton bdel;
    private final JButton b9;
    private final JButton b8;
    private final JLabel poly1;
    private final JLabel poly2;
    private final JLabel poly3;
    private final JTextField text1;
    private final JTextField text2;
    private final JTextField text3;
    static JFrame f;
    private JTextField focused;

    public Interfata() {
        taduna = new JButton ("Aduna");
        tinmulteste = new JButton ("Inmulteste");
        tderiveaza = new JButton ("Deriveaza");
        tscade = new JButton ("Scade");
        timparte = new JButton ("Imparte");
        tintegreaza = new JButton ("Integreaza");
        b5 = new JButton ("5");
        b4 = new JButton ("4");
        bX = new JButton ("X");
        b1 = new JButton ("1");
        bminus = new JButton ("-");
        b0 = new JButton ("0");
        b3 = new JButton ("3");
        b6 = new JButton ("6");
        b2 = new JButton ("2");
        b7 = new JButton ("7");
        bplus = new JButton ("+");
        bput = new JButton ("^");
        bdel = new JButton ("DEL");
        b9 = new JButton ("9");
        b8 = new JButton ("8");
        poly1 = new JLabel ("Primul polinom:");
        poly2 = new JLabel ("Al doilea polinom:");
        poly3 = new JLabel ("Rezultat:");
        text1 = new JTextField (5);
        text2 = new JTextField (5);
        text3 = new JTextField (5);

        setPreferredSize (new Dimension (944, 574));
        setLayout(null);
        setBackground(Color.GRAY);

        taduna.addActionListener(this);
        tinmulteste.addActionListener(this);
        tderiveaza.addActionListener(this);
        tscade.addActionListener(this);
        timparte.addActionListener(this);
        tintegreaza.addActionListener(this);
        b5.addActionListener(this);
        bX.addActionListener(this);
        b1.addActionListener(this);
        bminus.addActionListener(this);
        b0.addActionListener(this);
        b3.addActionListener(this);
        b6.addActionListener(this);
        b2.addActionListener(this);
        b7.addActionListener(this);
        bplus.addActionListener(this);
        bput.addActionListener(this);
        bdel.addActionListener(this);
        b9.addActionListener(this);
        b8.addActionListener(this);
        b4.addActionListener(this);

        text3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                focused = text3;
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        text2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                focused = text2;
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        add (taduna);
        add (tinmulteste);
        add (tderiveaza);
        add (tscade);
        add (timparte);
        add (tintegreaza);
        add (b5);
        add (b4);
        add (bX);
        add (b1);
        add (bminus);
        add (b0);
        add (b3);
        add (b6);
        add (b2);
        add (b7);
        add (bplus);
        add (bput);
        add (bdel);
        add (b9);
        add (b8);
        add (poly1);
        add (poly2);
        add (poly3);
        add (text1);
        add (text2);
        add (text3);

        taduna.setBounds (545, 285, 100, 40);
        tinmulteste.setBounds (545, 335, 100, 40);
        tderiveaza.setBounds (545, 385, 100, 40);
        tscade.setBounds (665, 285, 100, 40);
        timparte.setBounds (665, 335, 100, 40);
        tintegreaza.setBounds (665, 385, 100, 40);
        b5.setBounds (320, 335, 45, 45);
        b4.setBounds (270, 335, 45, 45);
        bX.setBounds (320, 435, 45, 45);
        b1.setBounds (270, 285, 45, 45);
        bminus.setBounds (420, 335, 45, 45);
        b0.setBounds (270, 435, 45, 45);
        b3.setBounds (370, 285, 45, 45);
        b6.setBounds (370, 335, 45, 45);
        b2.setBounds (320, 285, 45, 45);
        b7.setBounds (270, 385, 45, 45);
        bplus.setBounds (420, 285, 45, 45);
        bput.setBounds (420, 385, 45, 45);
        bdel.setBounds (370, 435, 95, 45);
        b9.setBounds (370, 385, 45, 45);
        b8.setBounds (320, 385, 45, 45);
        poly1.setBounds (400, 15, 100, 25);
        poly2.setBounds (395, 85, 100, 25);
        poly3.setBounds (420, 165, 100, 25);
        text1.setBounds (300, 195, 300, 30);
        text2.setBounds (300, 115, 300, 30);
        text3.setBounds (300, 45, 300, 30);
    }

    public ArrayList<Monom> parseTextInput(String s) {
        String sClone = s.replace("-","+-");
        System.out.println(sClone);
        ArrayList<Monom> output = new ArrayList<Monom>();
        String[] split1 = sClone.split("[+*/]");
        for(String c : split1) {
            String[] members = c.split("X\\^?");
            int coef;
            try {
                coef = Integer.parseInt(members[0]);
            }
            catch (NumberFormatException ex) {
                if(c.contains("-") == true){
                    coef = -1;
                }
                else coef = 1;
            }
            int grad;
            if(members[0].equals(c)) {
                grad = 0;
            }
            else { try {
                grad = Integer.parseInt(members[1]);
            }
            catch (ArrayIndexOutOfBoundsException ex) {
                grad = 1;
            }
            }
                output.add(new Monom(grad, coef));
        }
        return output;
    }

    public void actionPerformed(ActionEvent e) {
        String s;

        if(e.getSource() == b1) {
            s = focused.getText() + "1";
            focused.setText(s);
        }

        if(e.getSource() == b2) {
            s = focused.getText() + "2";
            focused.setText(s);
        }

        if(e.getSource() == b3) {
            s = focused.getText() + "3";
            focused.setText(s);
        }

        if(e.getSource() == b4) {
            s = focused.getText() + "4";
            focused.setText(s);
        }

        if(e.getSource() == b5) {
            s = focused.getText() + "5";
            focused.setText(s);
        }

        if(e.getSource() == b6) {
            s = focused.getText() + "6";
            focused.setText(s);
        }

        if(e.getSource() == b7) {
            s = focused.getText() + "7";
            focused.setText(s);
        }

        if(e.getSource() == b8) {
            s = focused.getText() + "8";
            focused.setText(s);
        }

        if(e.getSource() == b9) {
            s = focused.getText() + "9";
            focused.setText(s);
        }

        if(e.getSource() == b0) {
            s = focused.getText() + "0";
            focused.setText(s);
        }

        if(e.getSource() == taduna) {
            String s1 = text3.getText();
            String s2 = text2.getText();

            Polynomial p1 = new Polynomial(parseTextInput(s1));
            Polynomial p2 = new Polynomial(parseTextInput(s2));
            Polynomial result = new Polynomial();

            result = result.add(p1, p2);
            text1.setText(result.afisare());
        }

        if(e.getSource() == tinmulteste) {
            //to be continued
        }

        if(e.getSource() == tderiveaza) {
            //to be continued
        }

        if(e.getSource() == tscade) {
            String s1 = text3.getText();
            String s2 = text2.getText();

            Polynomial p1 = new Polynomial(parseTextInput(s1));
            Polynomial p2 = new Polynomial(parseTextInput(s2));
            Polynomial result = new Polynomial();

            result = result.subtract(p1, p2);
            text1.setText(result.afisare());
        }

        if(e.getSource() == timparte) {
            //to be continued
        }

        if(e.getSource() == tintegreaza) {
            //to be continued
        }

        if(e.getSource() == bminus) {
            s = focused.getText() + "-";
            focused.setText(s);
        }

        if(e.getSource() == bplus) {
            s = focused.getText() + "+";
            focused.setText(s);
        }

        if(e.getSource() == bput) {
            s = focused.getText() + "^";
            focused.setText(s);
        }

        if(e.getSource() == bdel) {
            s = "";
            text3.setText(s);
            text2.setText(s);
            text1.setText(s);
        }

        if(e.getSource() == bX) {
            s = focused.getText() + "X";
            focused.setText(s);
        }
    }

    public static void main (String[] args) {
        f = new JFrame ("Polynom Calculator");
        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add (new Interfata());
        f.pack();
        f.setVisible (true);
    }
}
