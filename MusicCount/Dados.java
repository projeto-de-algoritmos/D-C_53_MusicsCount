package MusicCount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dados {
    private List<Pessoa> pessoaList = new ArrayList<>();

    public void autoCadastro() {

        Random ale = new Random();
        Integer[] listaInteiros = {0,1,2,3,4,5,6,7,8,9};
        
        for (int i = 0; i < 25; i++) {
            List<Integer> numeros = new ArrayList<>(Arrays.asList(listaInteiros));
            pessoaList.add(i, new Pessoa("Pessoa " + i,
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros),
                    removerNumeroAleatorio(numeros)));
        }
    }

    public static int removerNumeroAleatorio(List<Integer> numeros) {
        Random random = new Random();
        int indiceAleatorio = random.nextInt(numeros.size());
        return numeros.remove(indiceAleatorio);
    }

    public List<Pessoa> getPessoaList() {

        return pessoaList;
    }
}
