import java.util.Scanner;

public class Monedero {
    private double saldo;

    public Monedero(double saldoInicial) {
        saldo = saldoInicial;
    }

    public void meterDinero(double cantidad) {
        saldo += cantidad;
    }

    public void sacarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
        } else {
            System.out.println("No hay suficiente dinero en el monedero.");
        }
    }

    public double consultarDisponible() {
        return saldo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        Monedero monedero = new Monedero(saldoInicial);
        System.out.println("Saldo inicial: " + monedero.consultarDisponible());

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Añadir saldo");
            System.out.println("2. Sacar saldo");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a añadir: ");
                    double cantidadAgregar = scanner.nextDouble();
                    monedero.meterDinero(cantidadAgregar);
                    System.out.println("Saldo después de añadir dinero: " + monedero.consultarDisponible());
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad a sacar: ");
                    double cantidadSacar = scanner.nextDouble();
                    monedero.sacarDinero(cantidadSacar);
                    System.out.println("Saldo después de sacar dinero: " + monedero.consultarDisponible());
                    break;
                case 3:
                    System.out.println("Saldo disponible: " + monedero.consultarDisponible());
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}

