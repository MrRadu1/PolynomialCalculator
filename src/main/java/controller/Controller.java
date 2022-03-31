package controller;

import model.Polynomial;
import view.GUI;

public class Controller {
    private static GUI view;
    public Controller() {
        view= new GUI();
        view.addBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
             P = getPolynoms(view.getFirstPol());
             Q = getPolynoms(view.getSecondPol());
             Polynomial R=P.addition(Q);
             view.setResult(R.toString());
             view.setResult2("");
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });

        view.subBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
                P = getPolynoms(view.getFirstPol());
                Q = getPolynoms(view.getSecondPol());
                Polynomial R=P.subtraction(Q);
                view.setResult(R.toString());
                view.setResult2("");
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });

        view.mltBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
                P = getPolynoms(view.getFirstPol());
                Q = getPolynoms(view.getSecondPol());
                Polynomial R=P.multiplication(Q);
                view.setResult(R.toString());
                view.setResult2("");
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });

        view.divBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
                P = getPolynoms(view.getFirstPol());
                Q = getPolynoms(view.getSecondPol());
                view.setResult(P.division(Q));
                view.setResult2("");
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });

        view.intBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
                P = getPolynoms(view.getFirstPol());
                Q = getPolynoms(view.getSecondPol());
                Polynomial R1=P.integration();
                Polynomial R2=Q.integration();
                view.setResult(R1.toString()+" + C");
                view.setResult2(R2.toString()+" + C");
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });

        view.drvBtnListener(e -> {
            Polynomial P;
            Polynomial Q;
            try {
                P = getPolynoms(view.getFirstPol());
                Q = getPolynoms(view.getSecondPol());
                Polynomial R1=P.derivation();
                Polynomial R2=Q.derivation();
                view.setResult(R1.toString());
                view.setResult2(R2.toString());
            }
            catch (NumberFormatException x) {
                view.showError("Date introduse gresit");
            }
        });
    }

    private Polynomial getPolynoms(String polynom) {
        Polynomial P = new Polynomial();
        P.getMonomials(polynom);
        return P;
    }
}
