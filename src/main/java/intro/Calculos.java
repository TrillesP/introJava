package intro;

import static intro.Medidas.tabuada;
import static intro.Medidas.scanner;

public class Calculos {

    public static void main(String[] args){
        System.out.println("Deseja calcular a tabuada? (S/N)");
        String resposta = scanner.next();
        if (resposta.equalsIgnoreCase("S")) {
            tabuada();
        }
        else{
            System.out.println("Fechando programa.");
        }
    }
}
