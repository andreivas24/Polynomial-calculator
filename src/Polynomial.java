import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Polynomial {
    private ArrayList<Monom> terms = new ArrayList<Monom>();

    public Polynomial() {

    }

    public ArrayList<Monom> getTerms() {
        return terms;
    }

    public Polynomial(ArrayList<Monom> terms) {
        this.terms = terms;
    }

    public Polynomial(int grad, int coef) throws NegativeExponentException {
        if (grad < 0) {
            throw new NegativeExponentException("Nu avem exponent negativ!");
        }
        if (coef != 0) {
            this.terms.add(new Monom(grad, coef));
        }
    }

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        ArrayList<Monom> terms2 = new ArrayList<Monom>();
        Polynomial result = new Polynomial(terms2);
        ArrayList<Monom> p1_m = new ArrayList<Monom>(p1.getTerms());
        ArrayList<Monom> p2_m = new ArrayList<Monom>(p2.getTerms());
        for(Monom t1 : p1.getTerms()) {
            for(Monom t2 : p2.getTerms()) {
                if(t1.getGrad() == t2.getGrad()) {
                    terms2.add(t1.add(t2));
                    p1_m.remove(t1);
                    p2_m.remove(t2);
                }
            }
        }
        System.out.println(p1_m);
        System.out.println(p2_m);
        for(Monom t1 : p1_m) {
            terms2.add(t1);
        }
        for(Monom t2 : p2_m) {
            terms2.add(t2);
        }
        System.out.println(terms2);
        return result;
    }

    public Polynomial subtract(Polynomial p3, Polynomial p4) {

        ArrayList<Monom> terms2 = new ArrayList<Monom>();
        Polynomial result = new Polynomial(terms2);
        ArrayList<Monom> p3_m = new ArrayList<Monom>(p3.getTerms());
        ArrayList<Monom> p4_m = new ArrayList<Monom>(p4.getTerms());
        for(Monom t3 : p3.getTerms()) {
            for(Monom t4 : p4.getTerms()) {
                if(t3.getGrad() == t4.getGrad()) {
                    terms2.add(t3.subtract(t4));
                    p3_m.remove(t3);
                    p4_m.remove(t4);
                }
            }
        }
        System.out.println(p3_m);
        System.out.println(p4_m);
        for(Monom t3 : p3_m) {
            terms2.add(t3);
        }
        for(Monom t4 : p4_m) {
            terms2.add(t4);
        }
        System.out.println(terms2);
        return result;
    }

    public String afisare() {
        if (this.terms.size() == 0) {
            return "0";
        }
        Collections.sort(terms);
        String s = "";

        for(Monom mon : terms) {
            s = s + " + " + mon.getCoef() + "X^" + mon.getGrad() + " ";
        }
        return s;
    }

}
