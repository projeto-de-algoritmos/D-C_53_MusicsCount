package MusicCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controlador {
    //DECLARACAO
    private static final List<String[]> dadosPessoas = new ArrayList<>();
    private static final ArrayList<int[]> contagemInversoes = new ArrayList<>();
    private static int cont = 0;
    public static List<String[]> dadosTabela(Dados pessoas){
        return getStrings(pessoas);
    }

    public static List<String[]> dadosTabelaInverscoes(Dados pessoas){

        for(int i=0;i < pessoas.getPessoaList().size(); i++){
            pessoas.getPessoaList().get(i).setContagem(countInversions(TelaResultado.getPessoaGosto(), dadosPessoas.get(i)));
            contagemInversoes.add(new int[]{pessoas.getPessoaList().get(i).getContagem(), i});

        }

        return getStrings(pessoas);
    }

    private static List<String[]> getStrings(Dados pessoas) {
        dadosPessoas.clear();

        if(cont == 0) {
            for (int i = 0; i < pessoas.getPessoaList().size(); i++) {
                dadosPessoas.add(i, new String[]{pessoas.getPessoaList().get(i).getNome(),
                        String.valueOf(pessoas.getPessoaList().get(i).getRock()),
                        String.valueOf(pessoas.getPessoaList().get(i).getPop()),
                        String.valueOf(pessoas.getPessoaList().get(i).getFunk()),
                        String.valueOf(pessoas.getPessoaList().get(i).getForro()),
                        String.valueOf(pessoas.getPessoaList().get(i).getAxe()),
                        String.valueOf(pessoas.getPessoaList().get(i).getCountry()),
                        String.valueOf(pessoas.getPessoaList().get(i).getMpb()),
                        String.valueOf(pessoas.getPessoaList().get(i).getPagode()),
                        String.valueOf(pessoas.getPessoaList().get(i).getJazz()),
                        String.valueOf(pessoas.getPessoaList().get(i).getRap()),
                        String.valueOf(pessoas.getPessoaList().get(i).getContagem())});
            }
            cont = 1;
        }
        else {
            Collections.sort(contagemInversoes, (array1, array2) -> {
                int valor1 = array1[0]; // Segundo elemento do primeiro array
                int valor2 = array2[0]; // Segundo elemento do segundo array
                return Integer.compare(valor1, valor2); // Ordenação decrescente
            });
            for (int i = 0; i < contagemInversoes.size(); i++) {
                int[] vetor = contagemInversoes.get(i);
                dadosPessoas.add(i, new String[]{pessoas.getPessoaList().get(vetor[1]).getNome(),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getRock()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getPop()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getFunk()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getForro()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getAxe()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getCountry()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getMpb()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getPagode()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getJazz()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getRap()),
                        String.valueOf(pessoas.getPessoaList().get(vetor[1]).getContagem())});
            }
            contagemInversoes.clear();
        }

        return dadosPessoas;
    }

    public static int countInversions(String[] ordemCorreta, String[] array) {
        String[] temp = new String[array.length];
        return mergeSort(ordemCorreta, array, temp, 1, array.length - 1);
    }

    public static int mergeSort(String[] ordemCorreta, String[] array, String[] temp, int left, int right) {
        int inversions = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            inversions += mergeSort(ordemCorreta, array, temp, left, mid);
            inversions += mergeSort(ordemCorreta, array, temp, mid + 1, right);
            inversions += merge(ordemCorreta, array, temp, left, mid, right);
        }
        return inversions;
    }

    public static int merge(String[] ordemCorreta, String[] array, String[] temp, int left, int mid, int right) {
        int inversions = 0;
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (getIndex(ordemCorreta, array[i]) <= getIndex(ordemCorreta, array[j])) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                inversions += mid - i + 1; // Incrementa o número de inversões
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = temp[i];
        }

        return inversions;
    }

    public static int getIndex(String[] array, String element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1; // Elemento não encontrado no array
    }
}

