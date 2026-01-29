public class MaiorFatorPrimo {
    public static void main(String[] args) {
        long numero = 600851475143L;
        long maiorFator = -1;

        while (numero % 2 == 0) {
            maiorFator = 2;
            numero /= 2;
        }

        for (long i = 3; i * i <= numero; i += 2) {
            while (numero % i == 0) {
                maiorFator = i;
                numero /= i;
            }
        }

        if (numero > 2) {
            maiorFator = numero;
        }

        System.out.println("O maior fator primo do número 600851475143 é: " + maiorFator);
    }
}