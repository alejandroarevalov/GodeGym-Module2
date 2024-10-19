package leccion18;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@SuppressWarnings("unused")
@AnotacionImportante(descripcion = "Esta clase modela perritos", version = 1)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perro implements Serializable {

    @AnotacionImportante(version = 1)
    private String nombre;
    private String raza;
    private int edadEnMeses;

    @AnotacionImportante(version = 1)
    @EjecutarInmediatamente(veces = 4)
    @Interceptar(interceptor = Interceptora.class)
    public void ladrar() {
        System.out.println("Guau, guau, estoy ladrando...");
    }
}
