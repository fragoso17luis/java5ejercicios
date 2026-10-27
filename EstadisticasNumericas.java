import java.util.Scanner;

public class EstadisticasNumericas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int MULTIPLO_BASE_3 = 3;
        final int MULTIPLO_BASE_4 = 4;

        char repetir;

        do {
            int n = 0;

            while (n <= 0) {
                System.out.print("Ingresa un número entero positivo (N): ");
                n = scanner.nextInt();
                if (n <= 0) {
                    System.out.println("Error: Debe ser mayor a 0. Intenta de nuevo.");
                }
            }


            int sumaDivisibles4 = 0;
            int contadorMultiplos3 = 0;
            int contadorAmbos = 0;


            for (int i = 1; i <= n; i++) {
                boolean esDivisible4 = (i % 4 == 0);
                boolean esMultiplo3 = (i % 3 == 0);


                if (esDivisible4 && esMultiplo3) {
                    contadorAmbos++;
                    sumaDivisibles4 += i;
                    contadorMultiplos3++;
                } else {
                    if (esDivisible4) {
                        sumaDivisibles4 += i;
                    }
                    if (esMultiplo3) {
                        contadorMultiplos3++;
                    }
                }
            }

            System.out.println("\n--- RESULTADOS GENERALES ---");
            System.out.println("Suma de números divisibles entre 4: " + sumaDivisibles4);
            System.out.println("Cantidad de números múltiplos de 3: " + contadorMultiplos3);
            System.out.println("Cantidad de números divisibles entre ambos (3 y 4): " + contadorAmbos);

            // Switch para elegir qué estadística adicional visualizar
            System.out.println("\n¿Qué deseas visualizar?");
            System.out.println("1. Pares en la secuencia");
            System.out.println("2. Impares en la secuencia");
            System.out.println("3. Múltiplos de 5 en la secuencia");
            System.out.print("Elige una opción (1-3): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Números pares: ");
                    for (int i = 1; i <= n; i++) {
                        if (i % 2 == 0) System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Números impares: ");
                    for (int i = 1; i <= n; i++) {
                        if (i % 2 != 0) System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Múltiplos de 5: ");
                    for (int i = 1; i <= n; i++) {
                        if (i % 5 == 0) System.out.print(i + " ");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.print("\n¿Deseas realizar otro análisis? (s/n): ");
            repetir = scanner.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        scanner.close();
    }
}