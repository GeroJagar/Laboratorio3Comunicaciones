package Punto1;

public class ConversionSN {

    //1) Convertir un número entero decimal a binario, especificando la longitud en bits.
    public static String decimalABinario(int numero, int bits) {
        String binario = Integer.toBinaryString(numero); // convierte a binario
        // Rellenar con ceros a la izquierda hasta la longitud requerida
        while (binario.length() < bits) {
            binario = "0" + binario;
        }
        // Si el número necesita más bits que los especificados, recorta
        if (binario.length() > bits) {
            binario = binario.substring(binario.length() - bits);
        }
        return binario;
    }

    //2) Convertir un número binario a entero decimal.
    public static int binarioADecimal(String binario) {
        int decimal = 0;
        int longitud = binario.length();
        for (int i = 0; i < longitud; i++) {
            // Tomamos cada carácter y lo convertimos en 0 o 1
            char bit = binario.charAt(longitud - 1 - i);
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }
        return decimal;
    }

    //3) Convertir un número entero decimal a hexadecimal, especificando el ancho en dígitos
    //hexadecimales.
    public static String decimalAHexadecimal(int numero, int digitos) {
        String hex = Integer.toHexString(numero).toUpperCase(); // convierte a hex y en mayúsculas

        // Rellenar con ceros a la izquierda
        while (hex.length() < digitos) {
            hex = "0" + hex;
        }
        // Si el número ocupa más dígitos que los especificados, recortar
        if (hex.length() > digitos) {
            hex = hex.substring(hex.length() - digitos);
        }
        return hex;
    }

    //4) Convertir un número hexadecimal a entero decimal.
    public static int hexadecimalADecimal(String hexadecimal) {
        return Integer.parseInt(hexadecimal, 16);
    }

    //5) Convertir un número binario a hexadecimal, especificando el ancho en dígitos hexadecimales.
    public static String binarioAHexadecimal(String binario, int digitos) {
        // Primero convertimos binario a decimal
        int decimal = 0;
        int longitud = binario.length();
        for (int i = 0; i < longitud; i++) {
            char bit = binario.charAt(longitud - 1 - i);
            if (bit == '1') {
                decimal += Math.pow(2, i);
            }
        }

        // Luego convertimos decimal a hexadecimal
        String hex = Integer.toHexString(decimal).toUpperCase();

        // Rellenar con ceros a la izquierda si es necesario
        while (hex.length() < digitos) {
            hex = "0" + hex;
        }

        // Recortar si ocupa más dígitos de los especificados
        if (hex.length() > digitos) {
            hex = hex.substring(hex.length() - digitos);
        }

        return hex;
    }

    //6) Convertir un número hexadecimal a binario.
    public static String hexadecimalABinario(String hex) {
        int decimal = Integer.parseInt(hex, 16);         // Hexadecimal a decimal
        return Integer.toBinaryString(decimal);          // Decimal a binario
    }

}
