// Alunos: Brenda de Andrade Barbosa e Samuel Seny Ferreira Santos
public class GrammarChecker {

    public static void main(String[] args) {
        System.out.println(verificaCadeia("aaa"));
        System.out.println(verificaCadeia("bbb"));
        System.out.println(verificaCadeia("aab"));
        System.out.println(verificaCadeia("baa"));
        System.out.println(verificaCadeia(""));
    }
    public static boolean verificaCadeia(String cadeia) {
        if (cadeia.isEmpty()) {
            return false;
        }
        char primeiro = cadeia.charAt(0);

        if (primeiro == 'a') {
            for (int i = 1; i < cadeia.length(); i++) {
                if (cadeia.charAt(i) != 'a') {
                    return false;
                }
            }
            return true;
        }

        if (primeiro == 'b') {
            for (int i = 1; i < cadeia.length(); i++) {
                if (cadeia.charAt(i) != 'b') {
                    return false;
                }
            }
            return true;
        }

        return false;
    }

}
