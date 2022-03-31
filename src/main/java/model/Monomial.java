package model;

public class Monomial implements Comparable<Monomial> {
    private int coefficient;
    private int grade;
    private int num=0;

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Monomial o) {
        return o.getGrade()-this.getGrade();
    }

    public String toString() {
        if (this.num == 0) {
            if (this.grade == 1) {
                if (this.coefficient == 1)
                    return "x";
                else
                    return this.coefficient + "x";
            } else if (this.grade == 0) {
                return "" + this.coefficient;
            } else {
                if (this.coefficient == 1)
                    return "x^" + this.grade;
                else
                    return this.coefficient + "x^" + this.grade;
            }
        } else {
        if (this.grade == 1) {
                return this.coefficient + "/" + this.num + "x";
        } else if (this.grade == 0) {
            return "" + this.coefficient + "/" + this.num;
        } else {
                return this.coefficient + "/" + this.num + "x^" + this.grade;
        }
    }
}


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    public Polynomial toPolynom() {
        Polynomial T= new Polynomial();
        T.getMonomialList().add(this);
        return T;
    }
}
