import java.util.Scanner;

public class SimuladorAhorro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char repetir;

        do {
            double cantidadInicial = -1;
            double metaAhorro = -1;
            double ahorroMensual = -1;


            while (cantidadInicial < 0 || metaAhorro <= 0 || ahorroMensual <= 0) {
                System.out.print("Ingresa la cantidad inicial de dinero: ");
                cantidadInicial = scanner.nextDouble();
                System.out.print("Ingresa la meta de ahorro: ");
                metaAhorro = scanner.nextDouble();
                System.out.print("Ingresa el ahorro mensual fijo: ");
                ahorroMensual = scanner.nextDouble();

                if (cantidadInicial < 0 || metaAhorro <= 0 || ahorroMensual <= 0) {
                    System.out.println("Error: Los valores deben ser mayores a cero (la inicial puede ser 0). Intenta de nuevo.\n");
                }
            }


            System.out.println("\nSelecciona el plazo de simulación:");
            System.out.println("1. 6 meses");
            System.out.println("2. 12 meses");
            System.out.println("3. 24 meses");
            System.out.print("Elige una opción (6, 12 o 24): ");
            int opcionPlazo = scanner.nextInt();

            int mesesTotales = 24;
            switch (opcionPlazo) {
                case 6:  mesesTotales = 6; break;
                case 12: mesesTotales = 12; break;
                case 24: mesesTotales = 24; break;
                default: System.out.println("Opción inválida, se tomarán 24 meses por defecto.");
            }

            double saldoActual = cantidadInicial;
            double interesesTotales = 0;
            boolean metaAlcanzada = false;
            int mesMeta = 0;


            for (int mes = 1; mes <= mesesTotales; mes++) {
                double interesMes = saldoActual * 0.01; // 1% mensual sobre el saldo
                interesesTotales += interesMes;
                saldoActual += interesMes + ahorroMensual;


                if (!metaAlcanzada && saldoActual >= metaAhorro) {
                    metaAlcanzada = true;
                    mesMeta = mes;
                }
            }


            System.out.println("\n--- RESULTADOS DE LA SIMULACIÓN ---");
            System.out.println("Saldo final acumulado: $" + saldoActual);
            System.out.println("Intereses totales generados: $" + interesesTotales);

            if (metaAlcanzada) {
                System.out.println(" Se logró en el mes número " + mesMeta + ".");
            } else {
                System.out.println("No se logró alcanzar la meta en el plazo seleccionado.");
            }

            System.out.print("\n¿Deseas realizar otra simulación? (s/n): ");
            repetir = scanner.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        scanner.close();
    }
}