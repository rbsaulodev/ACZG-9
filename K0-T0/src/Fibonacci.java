public class Fibonacci{
    public static void main(String[] args) {
        int limite = 4000000;
        int soma = 0;
        int termo1 = 1;
        int termo2 = 2;

        while (termo2 <= limite) {
            if (termo2 % 2 == 0) {
                soma += termo2;
            }

            int proximo = termo1 + termo2;
            termo1 = termo2;
            termo2 = proximo;
        }

        System.out.println("Valor da Fibonacci ate 4000000 é: " + soma);
    }
}