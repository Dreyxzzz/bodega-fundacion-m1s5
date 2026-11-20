

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Suma suma = new Suma();
        Resta resta = new Resta();
        Multiplicacion mult = new Multiplicacion();
        Division div = new Division();

        int stock = 100;
        int op;

        do {
            System.out.println("\nStock actual: " + stock);
            System.out.println("1. Sumar donaciones");
            System.out.println("2. Restar despacho");
            System.out.println("3. Multiplicar lotes");
            System.out.println("4. Dividir donacion entre centros");
            System.out.println("5. Salir");
            op = leerEntero(sc, "Opcion: ", 1, 5);

            // IA ayudó a armar este bloque de validación y decisión según la regla de stock mínimo (10)
            if (op == 1) {
                int cant = leerEntero(sc, "Unidades a sumar: ", 1, 10000);
                stock = suma.calcular(stock, cant);
            } else if (op == 2) {
                int cant = leerEntero(sc, "Unidades a restar (max 50): ", 1, 50);
                if (cant > stock) {
                    System.out.println("No hay suficiente stock.");
                } else {
                    stock = resta.calcular(stock, cant);
                }
            } else if (op == 3) {
                int cajas = leerEntero(sc, "Cajas: ", 1, 100);
                int porCaja = leerEntero(sc, "Unidades por caja: ", 1, 50);
                System.out.println("Total calculado: " + mult.calcular(cajas, porCaja));
            } else if (op == 4) {
                int total = leerEntero(sc, "Unidades a repartir: ", 1, stock);
                int centros = leerEntero(sc, "Numero de centros: ", 1, 50);
                System.out.println("Por centro: " + div.calcular(total, centros));
            }

            if (op >= 1 && op <= 4 && stock <= 10) {
                System.out.println("Alerta: stock bajo (10 o menos).");
            }
        } while (op != 5);

        sc.close();
    }

    // IA ayudó a evitar fallos cuando el usuario escribe letras en lugar de números
    private static int leerEntero(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                sc.nextLine();
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.println("Fuera de rango (" + min + " a " + max + ").");
            } else {
                System.out.println("Numero invalido.");
                sc.nextLine();
            }
        }
    }
}