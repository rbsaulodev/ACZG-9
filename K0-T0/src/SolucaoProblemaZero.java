import java.math.BigInteger;

public class SolucaoProblemaZero {
    public static void main(String[] args) {
        int limite = 143000;
        BigInteger soma = BigInteger.ZERO;

        for (int i = 1; i <= limite; i++) {
            if (i % 2 != 0) {
                BigInteger quadrado = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i));
                soma = soma.add(quadrado);
            }
        }

        System.out.println("A resposta para é " + soma);
    }
}