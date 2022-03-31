package model;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    @org.junit.jupiter.api.Test
    void addition() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="4x^5-3x^4+x^2-8x+1";
        String p2="3x^4-x^3+x^2+2x-1";
        System.out.println("Addition of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result: 4x^5-1x^3+2x^2-6x\n");
        assertEquals(p.addition(q).toString(),"4x^5-1x^3+2x^2-6x");
    }

    @org.junit.jupiter.api.Test
    void subtraction() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="4x^5-3x^4+x^2-8x+1";
        String p2="3x^4-x^3+x^2+2x-1";
        System.out.println("Subtraction of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result: 4x^5-6x^4+x^3-10x+2\n");
        assertEquals(p.subtraction(q).toString(),"4x^5-6x^4+x^3-10x+2");
    }

    @org.junit.jupiter.api.Test
    void multiplication() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="3x^2-x+1";
        String p2="x-2";
        System.out.println("Multiplication of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result: 3x^3-7x^2+3x-2\n");
        assertEquals(p.multiplication(q).toString(),"3x^3-7x^2+3x-2");
    }

    @org.junit.jupiter.api.Test
    void derivation() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="x^3-2x^2+6x-5";
        String p2="3x^2-4x+6";
        System.out.println("Derivation of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result: 3x^2-4x+6\n        6x-4\n");
        assertEquals(p.derivation().toString(),"3x^2-4x+6");
        assertEquals(q.derivation().toString(),"6x-4");
    }

    @org.junit.jupiter.api.Test
    void integration() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="x^3+4x^2+5";
        String p2="3x^2-4x+6";
        System.out.println("Integration of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result: 1/4x^4+4/3x^3+5x+C\n        x^3-2x^2+6x+C\n");
        assertEquals(p.integration().toString(),"1/4x^4+4/3x^3+5x");
        assertEquals(q.integration().toString(),"x^3-2x^2+6x");
    }

    @org.junit.jupiter.api.Test
    void division() {
        Polynomial p=new Polynomial();
        Polynomial q=new Polynomial();
        String p1="x^3-2x^2+6x-5";
        String p2="x^2-1";
        System.out.println("Division of: \n" + p1 + "\n" + p2);
        p.getMonomials(p1);
        q.getMonomials(p2);
        System.out.println("Result:\nQ: x-2\nR: 7x-7\n");
        assertEquals(p.division(q),"Q: x-2 R: 7x-7");
    }
}