public class MultiplosDe3e5 {
    public static void main(String[] args) {
        int limite = 1000;
        int soma = 0;

        for (int i = 1; i < limite; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                soma += i;
            }
        }

        System.out.println("A soma de todos os múltiplos de 3 ou 5 abaixo de 1000 é: " + soma);
    }
}