import java.util.Scanner;

public class Main {
public static void main(String[] args) {

    int option;
    boolean bool = true;
    Scanner write = new Scanner(System.in);

    do {
      System.out.println("---------------------[MENU DE OPÇÕES]----------------------");
      System.out.println("[1] - Calcular o fatorial de um número dado              |");
      System.out.println("[2] - Calcular a raiz quadrada de um número dado         |");
      System.out.println("[3] - Imprimir a tabuada completa de 1 a 10              |");
      System.out.println("[4] - Sair do programa                                   |");
      System.out.println("------------------------------------------------------------");

      System.out.print("Insira um número de 1 a 4 e após pressione enter: ");

      while (!write.hasNextInt()) {
        System.out.print("Entrada inválida. Por favor, digite um número: ");
        write.next();
      }

      option = write.nextInt();

      if (option >= 1 && option <= 4) {
        bool = false;
      }

    } while (bool);

    switch (option) {
      case 1:
        fatorial();
        main(args);
      case 2:
        raizQuadrada();
        main(args);
      case 3:

      case 4:
        sair();
    }
  }

  // FUNÇÔES

  // Função Raiz
  public static void raizQuadrada() {
    Scanner write = new Scanner(System.in);

    System.out.print("Digite um número para calcular a raiz quadrada: ");

    while (!write.hasNextInt()) {
      System.out.print("Entrada inválida. Por favor, digite um número: ");
      write.next();
    }

    double num = write.nextDouble();

    if (num >= 0) {
      double squareRoot = Math.sqrt(num);
      System.out.println("A raiz quadrada de " + num + " é: " + squareRoot);
      System.out.println("");
    } else {
      System.out.println("Não é possível calcular a raiz quadrada de um número negativo.");
    }
  }

  // Função Sair do Programa
  public static void sair() {
    System.out.println("========================");
    System.out.println("|Você saiu do programa.|");
    System.out.println("========================");
    System.exit(0);
  }


  // Função Fatorial
    public int fatorial(int numero){
        if(numero == 0 || numero == 1){
            return 1;
        }

        return numero * (fatorial(numero - 1));
    }

}
