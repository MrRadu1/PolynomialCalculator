package model;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private ArrayList<Monomial> MonomialList;

    public Polynomial() {
        MonomialList = new ArrayList<Monomial>();
    }

    public ArrayList getMonomialList() {
        return MonomialList;
    }

    public void setMonomialList(ArrayList monomialList) {
        MonomialList = monomialList;
    }

    private void addMonomial (Monomial m) {
        MonomialList.add(m);
    }

    public void getMonomials(String polynom) {
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(polynom);
        while (matcher.find()) {
            Monomial m = new Monomial();
            String monomial = matcher.group(1);
            int length = monomial.length();
            int i=getDigit(m,monomial,length);
            getGrade(i,m,monomial,length);
            this.addMonomial(m);
        }
        Collections.sort(this.getMonomialList());
    }

    private int getDigit (Monomial m , String monomial , int length) {
        int i=0;
        String digit = "";
        if (monomial.charAt(i)!='+' && monomial.charAt(i)!='-') {
            while ( i<length && monomial.charAt(i)!='x' ) {
                digit= digit + monomial.charAt(i);
                i++;}
            if (digit.equals(""))
                m.setCoefficient(1);
            else
                m.setCoefficient(Integer.parseInt(digit));
        } else {
            i++;
            while (i<length && monomial.charAt(i)!='x' ) {
                digit= digit + monomial.charAt(i);
                i++;}
            if (digit.equals("") && monomial.charAt(0) == '+')
                m.setCoefficient(1);
            else if (digit.equals("") && monomial.charAt(0) == '-')
                m.setCoefficient(-1);
            else if (monomial.charAt(0) == '+')
                m.setCoefficient(Integer.parseInt(digit));
            else
                m.setCoefficient(-Integer.parseInt(digit));
        }
        return i;
    }

    private void getGrade (int i, Monomial m, String monomial, int length) {
        if (i>=length)
            m.setGrade(0);
        else if (++i>=length)
            m.setGrade(1);
        else
            m.setGrade(Integer.parseInt(monomial.substring(++i)));
    }

    public Polynomial addition (Polynomial Q) {
        Polynomial R = new Polynomial();
        ArrayList<Integer> grades=new ArrayList<>();
        for (Object x : Q.getMonomialList())
        {
            Monomial m1= (Monomial) x;
            for (Object y : this.getMonomialList()) {
                Monomial m2 = (Monomial) y;
                if (m1.getGrade() == m2.getGrade()) {
                    grades.add(m1.getGrade());
                    Monomial r = new Monomial();
                    r.setGrade(m1.getGrade());
                    r.setCoefficient(m1.getCoefficient() + m2.getCoefficient());
                    if (r.getCoefficient()!=0)
                        R.addMonomial(r);
                }
            }
        }
        for (Object x : Q.getMonomialList()) {
            Monomial m= (Monomial) x;
            if (!grades.contains(m.getGrade()))
                R.addMonomial(m);
        }
        for (Object x : this.getMonomialList()) {
            Monomial m = (Monomial) x;
            if (!grades.contains(m.getGrade()))
                R.addMonomial(m);
        }
        Collections.sort(R.getMonomialList());
        return R;
    }

    public Polynomial subtraction (Polynomial Q) {
        for (Object x : Q.getMonomialList()) {
            Monomial m= (Monomial) x;
            m.setCoefficient(-m.getCoefficient());
        }
        return this.addition(Q);
    }

    public Polynomial multiplication (Polynomial Q) {
        Polynomial R = new Polynomial();
        ArrayList<Integer> grades = new ArrayList<>();
        for (Object x : this.getMonomialList()) {
            Monomial m1 = (Monomial) x;
            for (Object y : Q.getMonomialList()) {
                Monomial m2 = (Monomial) y;
                Monomial r = new Monomial();
                r.setGrade(m1.getGrade() + m2.getGrade());
                if (m2.getNum()!=0 && m1.getCoefficient()/m2.getNum()==(int)m1.getCoefficient()/m2.getNum())
                    r.setCoefficient(m1.getCoefficient()/m2.getNum() * m2.getCoefficient());
                else if(m1.getNum()!=0 && m2.getCoefficient()/m1.getNum()==(int)m2.getCoefficient()/m1.getNum())
                    r.setCoefficient(m2.getCoefficient()/m1.getNum() * m1.getCoefficient());
                else
                    r.setCoefficient(m2.getCoefficient()* m1.getCoefficient());
                if (!grades.contains(r.getGrade())) {
                    grades.add(r.getGrade());
                    R.addMonomial(r);
                } else {
                    for (Object z : R.getMonomialList()) {
                        Monomial m3 = (Monomial) z;
                        if (m3.getGrade() == r.getGrade())
                            m3.setCoefficient(m3.getCoefficient() + r.getCoefficient());
                    }
                }
            }
        }
        Collections.sort(R.getMonomialList());
        return R;
    }

    public Polynomial derivation() {
        Polynomial R = new Polynomial();
        for (Object x : this.getMonomialList()) {
            Monomial m= (Monomial) x;
            Monomial r = new Monomial();
            r.setCoefficient(m.getGrade()*m.getCoefficient());
            r.setGrade(m.getGrade()-1);
            if (r.getGrade()!=-1)
                R.addMonomial(r);
        }
        Collections.sort(R.getMonomialList());
        return R;
    }

    public Polynomial integration() {
        Polynomial R = new Polynomial();
        for (Object x : this.getMonomialList()) {
            Monomial m= (Monomial) x;
            Monomial r = new Monomial();
            float cf = (float)m.getCoefficient()/(m.getGrade()+1);
            if (cf-(int)cf==0)
                r.setCoefficient(m.getCoefficient()/(m.getGrade()+1));
            else {
                r.setCoefficient(m.getCoefficient());
                r.setNum(m.getGrade()+1);}
            r.setGrade(m.getGrade()+1);
            R.addMonomial(r);
        }
        Collections.sort(R.getMonomialList());
        return R;
    }

    public String division(Polynomial X) {
        if (this.getMonomialList().isEmpty())
            return "Lipsa numarator";
        if (X.getMonomialList().isEmpty())
            return "Lipsa numitor";
        if (X.toString().equals("0"))
            return "Numitorul nu poate fi 0";
        Polynomial Q= new Polynomial();
        Polynomial R= new Polynomial();
        R.setMonomialList(this.getMonomialList());
        Monomial firstR = (Monomial) R.getMonomialList().get(0);
        Monomial firstX = (Monomial) X.getMonomialList().get(0);
        while (!R.getMonomialList().isEmpty() && firstR.getGrade()>=firstX.getGrade()) {
            Monomial t = new Monomial();
            t.setGrade(firstR.getGrade()-firstX.getGrade());
            float x = (float)firstR.getCoefficient()/firstX.getCoefficient();
            if (x-(int)x==0)
                t.setCoefficient(firstR.getCoefficient()/ firstX.getCoefficient());
            else {
                t.setCoefficient(firstR.getCoefficient());
                t.setNum(firstX.getCoefficient());}
            Q.getMonomialList().add(t);
            R=R.subtraction(X.multiplication(t.toPolynom()));
            if (!R.getMonomialList().isEmpty())
                firstR = (Monomial) R.getMonomialList().get(0);
        }
        Collections.sort(Q.getMonomialList());
        Collections.sort(R.getMonomialList());
        return "Q: " + Q + " R: " + R;

    }

    public String toString () {
        if (this.getMonomialList().isEmpty())
        {
            return "0";
        } else {
            String result="";
            int first=0;
            for (Object x : this.getMonomialList())
            {
                Monomial a= (Monomial) x;
                if (first==0 || a.getCoefficient()<0) {
                    result = result + a.toString();
                    first++;
                } else
                    result=result + "+" + a.toString();
            }
            return result;
        }
    }
}
