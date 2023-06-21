package MusicCount;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;


public class ModelTablePessoas extends AbstractTableModel{
    private final String[] colunas = {"Nome", "Rock", "Pop", "Funk", "Forró", "Axé", "Country", "MPB", "Pagode", "Jazz", "Rap"};
    private static List<String[]> pessoaDados;

    public ModelTablePessoas(List<String[]> lista) {
        pessoaDados = lista;
    }


    @Override
    public int getRowCount() {
        return pessoaDados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna){
            case 0 -> {
                return pessoaDados.get(linha)[0];
            }
            case 1 -> {
                return pessoaDados.get(linha)[1];
            }
            case 2 -> {
                return pessoaDados.get(linha)[2];
            }
            case 3 -> {
                return pessoaDados.get(linha)[3];
            }
            case 4 -> {
                return pessoaDados.get(linha)[4];
            }
            case 5 -> {
                return pessoaDados.get(linha)[5];
            }
            case 6 -> {
                return pessoaDados.get(linha)[6];
            }
            case 7 -> {
                return pessoaDados.get(linha)[7];
            }
            case 8 -> {
                return pessoaDados.get(linha)[8];
            }
            case 9 -> {
                return pessoaDados.get(linha)[9];
            }
            case 10 -> {
                return pessoaDados.get(linha)[10];
            }
            default -> {
                return 0;
            }
        }
    }

    @Override
    public String getColumnName(int indice){
        return colunas[indice];
    }

}
