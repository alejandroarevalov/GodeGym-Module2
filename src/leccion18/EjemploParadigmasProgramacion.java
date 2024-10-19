package leccion18;

import java.util.Arrays;
import java.util.List;

public class EjemploParadigmasProgramacion {

    public void sumarNumerosParesConProgramacionImperativa() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int suma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) % 2 == 0) {
                suma += numeros.get(i);
            }
        }

        System.out.println("Suma de los números pares: " + suma);
    }

    public void sumarImparesConProgramacionDeclarativa() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int suma = numeros.stream()
            .filter(n -> n % 2 != 0)
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("Suma de los números impares: " + suma);
    }
    public static void main(String[] args) {
        EjemploParadigmasProgramacion ejemplo = new EjemploParadigmasProgramacion();
        ejemplo.sumarNumerosParesConProgramacionImperativa();
        ejemplo.sumarImparesConProgramacionDeclarativa();
    }
}
