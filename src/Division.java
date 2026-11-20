public class Division {
    // IA ayudó a manejar la validación para evitar división por cero
    public int calcular(int total, int divisores) {
        if (divisores <= 0) {
            return 0;
        }
        return total / divisores;
    }
}