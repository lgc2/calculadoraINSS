package calculadora;

public class Calculadora {

    private float[] calculadora(float salario) {
        float contribuicaoParaInss;
        float aliquotaPrimeiraFaixa = 0.075f;
        float aliquotaSegundaFaixa = 0.09f;
        float aliquotaTerceiraFaixa = 0.12f;
        float aliquotaQuartaFaixa = 0.14f;
        float salarioDeInicioDaSegundaFaixa = 1100.01f;
        float salarioDeInicioDaTerceiraFaixa = 2203.49f;
        float salarioDeInicioDaQuartaFaixa = 3305.23f;
        float salarioDeTeto = 6433.57f;

        if (salario < salarioDeInicioDaSegundaFaixa) {
            contribuicaoParaInss = salario * aliquotaPrimeiraFaixa;
        } else if (salario < salarioDeInicioDaTerceiraFaixa) {
            contribuicaoParaInss = (salarioDeInicioDaSegundaFaixa - 0.01f) * aliquotaPrimeiraFaixa
                    + (salario - salarioDeInicioDaSegundaFaixa) * aliquotaSegundaFaixa;
        } else if (salario < salarioDeInicioDaQuartaFaixa) {
            contribuicaoParaInss = (salarioDeInicioDaSegundaFaixa - 0.01f) * aliquotaPrimeiraFaixa
                    + ((salarioDeInicioDaTerceiraFaixa - 0.01f) - salarioDeInicioDaSegundaFaixa) * aliquotaSegundaFaixa
                    + (salario - salarioDeInicioDaTerceiraFaixa) * aliquotaTerceiraFaixa;
        } else if (salario <= salarioDeTeto) {
            contribuicaoParaInss = (salarioDeInicioDaSegundaFaixa - 0.01f) * aliquotaPrimeiraFaixa
                    + ((salarioDeInicioDaTerceiraFaixa - 0.01f) - salarioDeInicioDaSegundaFaixa) * aliquotaSegundaFaixa
                    + ((salarioDeInicioDaQuartaFaixa - 0.01f) - salarioDeInicioDaTerceiraFaixa) * aliquotaTerceiraFaixa
                    + (salario - salarioDeInicioDaQuartaFaixa) * aliquotaQuartaFaixa;
        } else {
            contribuicaoParaInss = (salarioDeInicioDaSegundaFaixa - 0.01f) * aliquotaPrimeiraFaixa
                    + ((salarioDeInicioDaTerceiraFaixa - 0.01f) - salarioDeInicioDaSegundaFaixa) * aliquotaSegundaFaixa
                    + ((salarioDeInicioDaQuartaFaixa - 0.01f) - salarioDeInicioDaTerceiraFaixa) * aliquotaTerceiraFaixa
                    + (salarioDeTeto - salarioDeInicioDaQuartaFaixa) * aliquotaQuartaFaixa;
        }

        float aliquotaEfetiva = (contribuicaoParaInss / salario) * 100;

        float[] arrayDeRetorno = new float[]{contribuicaoParaInss, aliquotaEfetiva};

        return arrayDeRetorno;
    }

    public void imprimir(String nome, float salario) {

        System.out.printf("%s ganha R$%.2f e contribui com R$%.2f para o INSS. Alíquota efetiva: %.2f%%.\n",
                nome, salario, calculadora(salario)[0], calculadora(salario)[1]);

    }
}
