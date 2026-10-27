import java.util.Scanner;

public class NumerosAmigos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char repetir;

        do {
            int num1 = 0, num2 = 0;


            while (num1 <= 0 || num2 <= 0) {
                System.out.print("Ingresa el primer número entero positivo: ");
                num1 = scanner.nextInt();
                System.out.print("Ingresa el segundo número entero positivo: ");
                num2 = scanner.nextInt();

                if (num1 <= 0 || num2 <= 0) {
                    System.out.println("Error: Ambos números deben ser mayores a cero.\n");
                }
            }


            int sumaDivisores1 = 0;
            for (int i = 1; i < num1; i++) {
                if (num1 % i == 0) {
                    sumaDivisores1 += i;
                }
            }

            int sumaDivisores2 = 0;
            for (int i = 1; i < num2; i++) {
                if (num2 % i == 0) {
                    sumaDivisores2 += i;
                }
            }


            System.out.println("\n¿Qué deseas visualizar?");
            System.out.println("1. Mostrar suma de divisores y resultado de la comparación");
            System.out.println("2. Únicamente el resultado de la comparación");
            System.out.print("Elige una opción (1-2): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Suma de divisores propios de " + num1 + " es: " + sumaDivisores1);
                    System.out.println("Suma de divisores propios de " + num2 + " es: " + sumaDivisores2);

                    break;
                case 2:

                    break;
                default:
                    System.out.println("Opción no válida. Se mostrará el resultado completo.");
            }


            if (sumaDivisores1 == num2 && sumaDivisores2 == num1) {
                System.out.println("¡Resultado: El " + num1 + " y el " + num2 + " SÍ son números amigos!");
            } else {
                System.out.println("Resultado: El " + num1 + " y el " + num2 + " NO son números amigos.");
            }

            System.out.print("\n¿Deseas analizar otra pareja de números? (s/n): ");
            repetir = scanner.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        scanner.close();
    }
}