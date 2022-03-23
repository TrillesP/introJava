package intro;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Gravacao {

    public static void main(String[] args) throws IOException {
        String[] cabecalho = {"nome,idade,telefone"};
        List<String[]> linhas = new ArrayList<>();

        linhas.add(new String[]{"Beatriz","29","(11) 99999-9999"});
        linhas.add(new String[]{"Jessica","30","(41) 98888-6666"});
        linhas.add(new String[]{"Pedro","28","(21) 97777-7777"});
        linhas.add(new String[]{"Juca", "40", "(57) 91111-1111"});
        linhas.add(new String[]{"Final Test", "90", "(32) 93333-3333"});

        Writer escritor = Files.newBufferedWriter(Paths.get("src/main/resources/logs/clientes.csv"));
        CSVWriter escritorCSV = new CSVWriter(escritor);

        escritorCSV.writeNext(cabecalho);
        escritorCSV.writeAll(linhas);

        escritorCSV.flush();
        escritor.close();
    }
}
