// Alunos: Brenda de Andrade Barbosa e Samuel Seny Ferreira Santos
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrammarValidator {
    public static void main(String[] args) {
        Map<String, List<String>> gramatica = new HashMap<>();
        gramatica.put("S", List.of("aA", "bB", "c"));
        gramatica.put("A", List.of("aA", ""));
        gramatica.put("B", List.of("bB", ""));

        System.out.println(verificarCadeia(gramatica, "aaa"));  // true
        System.out.println(verificarCadeia(gramatica, "bb"));   // true
        System.out.println(verificarCadeia(gramatica, "c"));    // true
        System.out.println(verificarCadeia(gramatica, "ab"));   // false
    }

    public static boolean verificarCadeia(Map<String, List<String>> gramatica, String cadeia) {
        return verificarProducao(gramatica, "S", cadeia, 0);
    }

    private static boolean verificarProducao(Map<String, List<String>> gramatica, String producao, String cadeia, int pos) {
        if (producao.isEmpty()) {
            return pos == cadeia.length();
        }

        char simbolo = producao.charAt(0);
        String restoProducao = producao.substring(1);

        if (!gramatica.containsKey(String.valueOf(simbolo))) {
            if (pos < cadeia.length() && simbolo == cadeia.charAt(pos)) {
                return verificarProducao(gramatica, restoProducao, cadeia, pos + 1);
            }
            return false;
        }

        for (String expansao : gramatica.get(String.valueOf(simbolo))) {
            if (verificarProducao(gramatica, expansao + restoProducao, cadeia, pos)) {
                return true;
            }
        }
        return false;
    }

}
