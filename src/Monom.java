import java.util.ArrayList;
import java.util.List;

public class Monom implements Comparable {
    private int grad;
    private double coef;

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public Monom(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public Monom add(Monom m1) {
        return new Monom(this.grad, this.coef+m1.getCoef());
    }

    public Monom subtract(Monom m1) {
        return new Monom(this.grad, this.coef-m1.getCoef());
    }

    @Override
    public String toString() {
        return "Monom{" + "grad=" + grad + ", coef=" + coef + '}';
    }

    @Override
    public int compareTo(Object o) {
        if(this.grad > ((Monom) o).getGrad())
            return -1;
        else return 1;
    }
}
