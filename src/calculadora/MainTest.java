package calculadora;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    static private ByteArrayOutputStream baOut;
    static private PrintStream psOut;

    Calculadora calculadora = new Calculadora();

    Pessoas p1 = new Pessoas("João", 1099.99f);
    Pessoas p2 = new Pessoas("Maria", 1100.00f);
    Pessoas p3 = new Pessoas("Joaquina", 1100.01f);
    Pessoas p4 = new Pessoas("Julio", 2203.47f);
    Pessoas p5 = new Pessoas("Diene", 2203.48f);
    Pessoas p6 = new Pessoas("Batuta", 2203.49f);
    Pessoas p7 = new Pessoas("Letícia", 3305.21f);
    Pessoas p8 = new Pessoas("Renata", 3305.22f);
    Pessoas p9 = new Pessoas("Thiago", 3305.23f);
    Pessoas p10 = new Pessoas("Joselei", 6433.57f);
    Pessoas p11 = new Pessoas("Rafaela", 10000f);

    @BeforeClass
    public static void beforeClassInit() {
        baOut = new ByteArrayOutputStream();
        psOut = new PrintStream(baOut);
        System.setOut(psOut);
    }

    @AfterClass
    public static void afterClassFinalize() {
        psOut.close();
    }

    @Before
    public void setUp() {
        baOut.reset();
    }

    @Test
    public void testeValido01() {
        calculadora.imprimir(p1.getNome(), p1.getSalario());

        String output = baOut.toString();

        assertEquals("João ganha R$1099,99 e contribui com R$82,50 para o INSS. Alíquota efetiva: 7,50%.\n", output);
    }

    @Test
    public void testeValido02() {
        calculadora.imprimir(p2.getNome(), p2.getSalario());

        String output = baOut.toString();

        assertEquals("Maria ganha R$1100,00 e contribui com R$82,50 para o INSS. Alíquota efetiva: 7,50%.\n", output);
    }

    @Test
    public void testeValido03() {
        calculadora.imprimir(p3.getNome(), p3.getSalario());

        String output = baOut.toString();

        assertEquals("Joaquina ganha R$1100,01 e contribui com R$82,50 para o INSS. Alíquota efetiva: 7,50%.\n", output);
    }

    @Test
    public void testeValido04() {
        calculadora.imprimir(p4.getNome(), p4.getSalario());

        String output = baOut.toString();

        assertEquals("Julio ganha R$2203,47 e contribui com R$181,81 para o INSS. Alíquota efetiva: 8,25%.\n", output);
    }

    @Test
    public void testeValido05() {
        calculadora.imprimir(p5.getNome(), p5.getSalario());

        String output = baOut.toString();

        assertEquals("Diene ganha R$2203,48 e contribui com R$181,81 para o INSS. Alíquota efetiva: 8,25%.\n", output);
    }

    @Test
    public void testeValido06() {
        calculadora.imprimir(p6.getNome(), p6.getSalario());

        String output = baOut.toString();

        assertEquals("Batuta ganha R$2203,49 e contribui com R$181,81 para o INSS. Alíquota efetiva: 8,25%.\n", output);
    }

    @Test
    public void testeValido07() {
        calculadora.imprimir(p7.getNome(), p7.getSalario());

        String output = baOut.toString();

        assertEquals("Letícia ganha R$3305,21 e contribui com R$314,02 para o INSS. Alíquota efetiva: 9,50%.\n", output);
    }

    @Test
    public void testeValido08() {
        calculadora.imprimir(p8.getNome(), p8.getSalario());

        String output = baOut.toString();

        assertEquals("Renata ganha R$3305,22 e contribui com R$314,02 para o INSS. Alíquota efetiva: 9,50%.\n", output);
    }

    @Test
    public void testeValido09() {
        calculadora.imprimir(p9.getNome(), p9.getSalario());

        String output = baOut.toString();

        assertEquals("Thiago ganha R$3305,23 e contribui com R$314,02 para o INSS. Alíquota efetiva: 9,50%.\n", output);
    }

    @Test
    public void testeValido10() {
        calculadora.imprimir(p10.getNome(), p10.getSalario());

        String output = baOut.toString();

        assertEquals("Joselei ganha R$6433,57 e contribui com R$751,99 para o INSS. Alíquota efetiva: 11,69%.\n", output);
    }

    @Test
    public void testeValido11() {
        calculadora.imprimir(p11.getNome(), p11.getSalario());

        String output = baOut.toString();

        assertEquals("Rafaela ganha R$10000,00 e contribui com R$751,99 para o INSS. Alíquota efetiva: 7,52%.\n", output);
    }

    @Test
    public void testeInvalido12() {
        calculadora.imprimir(p11.getNome(), p11.getSalario());

        String output = baOut.toString();

        assertEquals(output, "Rafaela ganha R$10000,00 e contribui com R$1400,00 para o INSS. Alíquota efetiva: 14,00%.\n");
    }
}
