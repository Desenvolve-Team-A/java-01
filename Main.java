import java.util.Scanner;

public class Main {

  static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {

    int option;
    boolean bool = true;

    do {
      System.out.println("---------------------[MENU DE OPÇÕES]----------------------");
      System.out.println("[1] - Calcular o fatorial de um número dado              |");
      System.out.println("[2] - Calcular a raiz quadrada de um número dado         |");
      System.out.println("[3] - Imprimir a tabuada completa de 1 a 10              |");
      System.out.println("[4] - Sair do programa                                   |");
      System.out.println("------------------------------------------------------------");

      System.out.print("Insira um número de 1 a 4 e após pressione enter: ");

      while (!scanner.hasNextInt()) {
        System.out.print("Entrada inválida. Por favor, digite um número: ");
        scanner.next();
      }

      option = scanner.nextInt();

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
        tabuada();
        main(args);
      case 4:
        sair();
    }
  }

  // FUNÇÔES

  // Função Fatorial
  public static void fatorial(){
    long input;

    System.out.print("Digite um número entre 0 a 20 para calcular seu fatorial: ");
    input = readLongPositive();

    System.out.println("O fatorial do número " + input + " é " + fatorialCalculo(input));
  }

  public static long fatorialCalculo(long number){
    if(number == 0 || number == 1){
      return 1;
    }

    return number * (fatorialCalculo(number - 1));
  }

  public static long readLongPositive(){
    boolean invalidNumber;
    long number = 0;

    do {
      try {
        number = Long.parseLong(scanner.next());

        if(number < 0 || number > 20) {
          throw new IllegalArgumentException();
        }

        invalidNumber = false;
      } catch (Exception e) {
        System.out.println("Valor digitado não é um número inteiro e positivo ou é maior que 20. Digite outro valor.");
        invalidNumber = true;
      }
    } while(invalidNumber);

    return number;
  }

  // Função Raiz
  public static void raizQuadrada() {

    System.out.print("Digite um número para calcular a raiz quadrada: ");

    while (!scanner.hasNextDouble()) {
      System.out.print("Entrada inválida. Por favor, digite um número: ");
      scanner.next();
    }

    double num = scanner.nextDouble();

    if (num >= 0) {
      double squareRoot = Math.sqrt(num);
      System.out.println("A raiz quadrada de " + num + " é: " + squareRoot);
      System.out.println("");
    } else {
      System.out.println("Não é possível calcular a raiz quadrada de um número negativo.");
      System.out.println("");
      raizQuadrada();
    }
  }

  // Função Tabuada

  public static void tabuada(){
    String divider, spaceAddit = "", spaceSubt = "", spaceMult = "", spaceDivis = "";
    int i = 1, j = 1, sizeSpaceAddit, sizeSpaceSubt, sizeSpaceMult;
    int addit, subt, mult;
    double divis;

    while (i < 11) {
      while (j < 11) {
        addit = i + j;
        subt = i - j;
        mult = i * j;
        divis = (double) i / (double) j;

        sizeSpaceAddit = String.valueOf(i).length() + String.valueOf(j).length()
                + String.valueOf(addit).length();
        sizeSpaceSubt = String.valueOf(i).length() + String.valueOf(j).length() + String.valueOf(subt).length();
        sizeSpaceMult = String.valueOf(i).length() + String.valueOf(j).length() + String.valueOf(mult).length();
        if (i != 10 && j == 10) {
          spaceDivis = "    |";
        } else if (i != 10 && j != 10) {
          spaceDivis = "     |";
        } else if (i == 10 && j == 10) {
          spaceDivis = "   |";
        }

        if (sizeSpaceAddit == 3) {
          spaceAddit = "      |      ";
        } else if (sizeSpaceAddit == 4) {
          spaceAddit = "     |      ";
        } else if (sizeSpaceAddit == 5) {
          spaceAddit = "    |      ";
        } else if (sizeSpaceAddit == 6) {
          spaceAddit = "   |      ";
        }
        // espaço subtracao
        if (sizeSpaceSubt == 3) {
          spaceSubt = "      |      ";
        } else if (sizeSpaceSubt == 4) {
          spaceSubt = "     |      ";
        } else if (sizeSpaceSubt == 5) {
          spaceSubt = "    |      ";
        } else if (sizeSpaceSubt == 6) {
          spaceSubt = "   |      ";
        }
        // Espaço Mult
        if (sizeSpaceMult == 3) {
          spaceMult = "      |      ";
        } else if (sizeSpaceMult == 4) {
          spaceMult = "     |      ";
        } else if (sizeSpaceMult == 5) {
          spaceMult = "    |      ";
        } else if (sizeSpaceMult == 6) {
          spaceMult = "   |      ";
        } else if (sizeSpaceMult == 7) {
          spaceMult = "  |      ";
        }

        if (j == 10) {
          divider = "===========================================================================================";
        } else {
          divider = "-------------------------------------------------------------------------------------------";
        }

        if (j == 1) {
          if (i > 0 && i < 10) {
            System.out.print("|                                     TABUADA DO " + i
                    + "                                        |\n"
                    + "===========================================================================================\n");

          } else {
            System.out.print("|                                     TABUADA DO " + i
                    + "                                       |\n"
                    + "===========================================================================================\n");
          }
        }

        System.out.println(
                "|      " + i + " + " + j + " = " + addit + spaceAddit +
                        +i + " - " + j + " = " + subt + spaceSubt +
                        +i + " x " + j + " = " + mult + spaceMult +
                        +i + " / " + j + " = " + String.format("%.2f", divis) + spaceDivis + "\n" + divider);

        j++;
      }
      j = 1;
      i++;
    }

  }

  // Função Sair do Programa
  public static void sair() {
    System.out.println("========================");
    System.out.println("|Você saiu do programa.|");
    System.out.println("========================");
    System.exit(0);
  }

}
