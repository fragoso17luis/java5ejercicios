import java.util.Scanner;

public class MenuMatematicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;


        do {
            System.out.println("\n===== MENÚ DE OPERACIONES MATEMÁTICAS =====");
            System.out.println("1. Calcular el cuadrado de un número");
            System.out.println("2. Calcular el cubo de un número");
            System.out.println("3. Determinar si un número es par o impar");
            System.out.println("4. Calcular la suma desde 1 hasta N");
            System.out.println("5. Salir del programa");
            System.out.print("Elige una opción (1-5): ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa un número: ");
                    double num1 = scanner.nextDouble();
                    System.out.println("El cuadrado de " + num1 + " es: " + (num1 * num1));
                    break;

                case 2:
                    System.out.print("Ingresa un número: ");
                    double num2 = scanner.nextDouble();
                    System.out.println("El cubo de " + num2 + " es: " + (num2 * num2 * num2));
                    break;

                case 3:
                    System.out.print("Ingresa un número entero: ");
                    int num3 = scanner.nextInt();
                    // if-else simple para par o impar
                    if (num3 % 2 == 0) {
                        System.out.println("El número " + num3 + " es PAR.");
                    } else {
                        System.out.println("El número " + num3 + " es IMPAR.");
                    }
                    break;

                case 4:
                    int n = -1;

                    while (n <= 0) {
                        System.out.print("Ingresa un número entero positivo (N): ");
                        n = scanner.nextInt();
                        if (n <= 0) {
                            System.out.println("Error: El número debe ser positivo.");
                        }
                    }

                    int suma = 0;
                    for (int i = 1; i <= n; i++) {
                        suma += i;
                    }
                    System.out.println("La suma desde 1 hasta " + n + " es: " + suma);
                    break;

                case 5:
                    System.out.println("finalizado.");
                    break;

                default:

                    System.out.println("Error: Opción no válida. elige un número entre 1 y 5.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}