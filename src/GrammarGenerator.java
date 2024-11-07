// Alunos: Brenda de Andrade Barbosa e Samuel Seny Ferreira Santos
import java.util.ArrayList;
import java.util.List;

public class GrammarGenerator {

    public static void main(String[] args) {
        int N = 1;
        List<String> cadeias = gerarCadeias(N);
        System.out.println("Cadeias de comprimento " + N + ": " + cadeias);
    }
    public static List<String> gerarCadeias(int N) {
        List<String> resultados = new ArrayList<>();
        gerarPorProducao("S", "", N, resultados);
        return resultados;
    }

    private static void gerarPorProducao(String producao, String cadeiaAtual, int N, List<String> resultados) {
        if (cadeiaAtual.length() == N) {
            resultados.add(cadeiaAtual);
            return;
        }

        if (cadeiaAtual.length() > N) {
            return;
        }

        switch (producao) {
            case "S":
                gerarPorProducao("A", cadeiaAtual + "a", N, resultados);

                gerarPorProducao("B", cadeiaAtual + "b", N, resultados);

                gerarPorProducao("", cadeiaAtual + "c", N, resultados);
                break;

            case "A":
                gerarPorProducao("A", cadeiaAtual + "a", N, resultados);

                gerarPorProducao("", cadeiaAtual, N, resultados);
                break;

            case "B":
                gerarPorProducao("B", cadeiaAtual + "b", N, resultados);

                gerarPorProducao("", cadeiaAtual, N, resultados);
                break;
        }
    }

}
