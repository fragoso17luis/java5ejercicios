import java.util.Scanner;

public class CompetenciaResistencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char repetir;

        do {
            System.out.print("Ingresa la cantidad de participantes: ");
            int totalParticipantes = scanner.nextInt();

            double mayorDistanciaAcumulada = -1;
            int ganador = 1;

            int countBajo = 0;
            int countMedio = 0;
            int countAlto = 0;


            for (int p = 1; p <= totalParticipantes; p++) {
                double distanciaTotalParticipante = 0;

                System.out.println("\n--- Participante " + p + " ---");
                for (int ronda = 1; ronda <= 5; ronda++) {
                    double distancia = -1;


                    while (distancia < 0) {
                        System.out.print("  Distancia en ronda " + ronda + " (km): ");
                        distancia = scanner.nextDouble();
                        if (distancia < 0) {
                            System.out.println("  Error: La distancia no puede ser negativa.");
                        }
                    }

                    distanciaTotalParticipante += distancia;


                    if (distancia < 2.0) {
                        countBajo++;
                    } else if (distancia <= 4.0) {
                        countMedio++;
                    } else {
                        countAlto++;
                    }
                }


                if (distanciaTotalParticipante > mayorDistanciaAcumulada) {
                    mayorDistanciaAcumulada = distanciaTotalParticipante;
                    ganador = p;
                }

                double promedioParticipante = distanciaTotalParticipante / 5.0;
                System.out.println("  -> Distancia total: " + distanciaTotalParticipante + " km | Promedio: " + promedioParticipante + " km/ronda");
            }


            System.out.println("\n¿Qué estadística general deseas ver?");
            System.out.println("1. Conteo de rondas por categoría (Bajo, Medio, Alto)");
            System.out.println("2. Participante con mayor distancia acumulada");
            System.out.print("Elige una opción (1-2): ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- ESTADÍSTICAS DE CATEGORÍAS ---");
                    System.out.println("Rondas con rendimiento Bajo (< 2 km): " + countBajo);
                    System.out.println("Rondas con rendimiento Medio (2 - 4 km): " + countMedio);
                    System.out.println("Rondas con rendimiento Alto (> 4 km): " + countAlto);
                    break;
                case 2:
                    System.out.println("\n--- GANADOR DE RESISTENCIA ---");
                    System.out.println("El participante #" + ganador + " obtuvo la mayor distancia acumulada con " + mayorDistanciaAcumulada + " km.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

            System.out.print("\n¿Deseas registrar otra competencia? (s/n): ");
            repetir = scanner.next().charAt(0);

        } while (repetir == 's' || repetir == 'S');

        scanner.close();
    }
}
