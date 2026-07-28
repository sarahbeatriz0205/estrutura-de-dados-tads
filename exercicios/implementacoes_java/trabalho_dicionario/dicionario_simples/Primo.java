package dicionario_simples;

public class Primo {
    public static boolean ehPrimo(int n){
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int maiorPrimoMenorQue(int n) {
        int candidato = n - 1;
        while (candidato > 1) {
            if (ehPrimo(candidato)) {
                return candidato;
            }
            candidato--;
        }
        return -1;
    }

    public static int menorPrimoMaiorOuIgualA(int n) {
        int candidato = n;
        while (true) {
            if (ehPrimo(candidato)) {
                return candidato;
            }
            candidato++;
        }
    }
}
