// 1 - Pacote
package intro;

// 2 - Referências as bibliotecas

import java.util.Scanner;

// 3 - Classe
public class Medidas {
    // 3.1 - Atributos - Características
    static Scanner scanner = new Scanner(System.in);
    // 3.2 - Métodos e Funções

    public static void main(String[] args){
        String opcao = " ";
        while (!opcao.equals("s") & !opcao.equals("S")) {
            System.out.println("\nEscolha uma opção:\n");
            System.out.println("1 - Calcular em modo compacto.\n2 - Calcular em modo extenso.\n3 - Contagem regressiva.\n4 - Contar até 10.\n5 - Tabuada.\nS - Sair.");
            opcao = scanner.next();
            //String opcao = "blabla";
            switch (opcao) {
                case "1":
                    calcularAreaModoCompacto();
                    break;
                case "2":
                    calcularAreaModoExtenso();
                    break;
                case "3":
                    contagemRegressiva();
                    break;
                case "4":
                    contarAteDez();
                    break;
                case "5":
                    tabuada();
                    break;
                case "s":
                case "S":
                    System.out.println("Fechando programa.");
                    break;
                default:
                    System.out.println("Nenhum método válido escolhido.");
                    break;
            }
        }

    }

    public static void calcularAreaModoExtenso(){
        System.out.println("Calculando de modo extenso.");
        float largura;
        float comprimento;
        float resultado;
        System.out.println("Digite a largura: ");
        largura = scanner.nextFloat();
        System.out.println("Digite o comprimento: ");
        comprimento = scanner.nextFloat();

        resultado = largura * comprimento;

        System.out.println("A área do retângulo é: " + resultado+ " m2.");
    }

    public static void calcularAreaModoCompacto(){
        System.out.println("Calculando de modo compacto.");
        System.out.println("Digite a largura: ");
        float largura = scanner.nextFloat();
        System.out.println("Digite o comprimento: ");
        float comprimento = scanner.nextFloat();
        System.out.println("A área do retângulo é: " + largura*comprimento + " m2.");
    }
    public static void contarAteDez(){
        System.out.println("Contando até 10.");
        for (int numero = 1; numero < 11; numero++){
            System.out.println(numero);
        }
    }
    public static void contagemRegressiva(){
        System.out.println("Fazendo contagem regressiva.");
        for (int numero = 10; numero > -1; numero--){
            System.out.println(numero);
        }
    }
    public static void tabuada(){
        System.out.println("Escolha um número para ver sua tabuada: ");
        int numero = scanner.nextInt();
        for (byte i = 1; i<11; i++){
            if (i == 10){
                System.out.print((numero*i + "."));
            }
            else {
                System.out.print(numero * i + ", ");
            }
        }
    }
}
