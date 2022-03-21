// 1 - Pacote
package intro;

// 2 - Referências as bibliotecas

import java.util.Scanner;

// 3 - Classe
public class Medidas {
    // 3.1 - Atributos - Características

    // 3.2 - Métodos e Funções

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma opção.");
        System.out.println("C - Calcular em modo compacto.\nE - Calcular em modo extenso.\nR - Contagem regressiva.\nD - Contar até 10.");
        String opcao = scanner.next();
        //String opcao = "blabla";
        switch (opcao){
            case "c":
            case "C":
                calcularAreaModoCompacto();
                break;
            case "E":
            case "e":
                calcularAreaModoExtenso();
                break;
            case "r":
            case "R":
                contagemRegressiva();
                break;
            case "d":
            case "D":
                contarAteDez();
                break;
            default:
                System.out.println("Nenhum método válido escolhido.");
                break;
        }

    }

    public static void calcularAreaModoExtenso(){
        System.out.println("Calculando de modo extenso.");
        float largura;
        float comprimento;
        float resultado;

        largura = 4;
        comprimento = 3;

        resultado = largura * comprimento;

        System.out.println("A área do retângulo é: " + resultado+ " m2.");
    }

    public static void calcularAreaModoCompacto(){
        System.out.println("Calculando de modo compacto.");
        int largura = 5;
        int comprimento = 6;
        System.out.println("A área do retângulo é: " + largura*comprimento + " m2.");
    }
    public static void contarAteDez(){
        System.out.println("Contando até 10.");
        for (int numero = 1; numero <= 10; numero++){
            System.out.println(numero);
        }
    }
    public static void contagemRegressiva(){
        System.out.println("Fazendo contagem regressiva.");
        for (int numero = 10; numero >=0; numero--){
            System.out.println(numero);
        }
    }

}
