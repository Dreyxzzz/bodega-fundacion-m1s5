public class Resta {
    // IA ayudó a controlar que el stock nunca quede negativo
    public int calcular(int stockActual, int despacho) {
        int res = stockActual - despacho;
        if (res < 0) {
            return 0;
        }
        return res;
    }
}