import com.google.gson.Gson;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        Conversion conversionM = new Conversion();
        Gson gson = new Gson();

        while (true) {

            System.out.println("========== Conversor de Monedas ==========");
            System.out.println("1) Dólar => Peso Mexicano");
            System.out.println("2) Peso Mexicano => Dólar");
            System.out.println("3) Dólar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dólar");
            System.out.println("5) Dólar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("");


            System.out.print("Elige una opción: ");
            System.out.println("");


            int inputUsuario = teclado.nextInt();

            if (inputUsuario == 7) {
                break;

            } else if (inputUsuario > 7) {
                System.out.println("Opción inválida.");

            } else {
                String json = conversionM.consultar(inputUsuario);

                ConversionRates conversionRates = gson.fromJson(json,ConversionRates.class);

                System.out.print("Ingresa la cantidad a conversion: ");
                double valor = teclado.nextDouble();
                Calculos calculos = new Calculos();

                if (inputUsuario == 1) {
                    Double rate = conversionRates.conversion_rates().get("MXN");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] Equivale a: " + nuevoValor + "[MXN]");
                    System.out.println("");


                } else if (inputUsuario == 2) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[MXN] Equivale  a: " + nuevoValor + "[USD]");
                    System.out.println("");

                } else if (inputUsuario == 3) {
                    Double rate = conversionRates.conversion_rates().get("BRL");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] Equivale  a: " + nuevoValor + "[BRL]");
                    System.out.println("");


                } else if (inputUsuario == 4) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[BRL] Equivale  a: " + nuevoValor + "[USD]");
                    System.out.println("");


                } else if (inputUsuario == 5) {
                    Double rate = conversionRates.conversion_rates().get("COP");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[USD] Equivale  a: " + nuevoValor + "[COP]");
                    System.out.println("");


                } else if (inputUsuario == 6) {
                    Double rate = conversionRates.conversion_rates().get("USD");
                    double nuevoValor = calculos.convertir(valor, rate);
                    System.out.println(valor + "[COP] Equivale  a: " + nuevoValor + "[USD]");
                    System.out.println("");

                }
            }
        }
        System.out.println("Fin de programa");
    }
}