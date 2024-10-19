package leccion18;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AnotacionImportante {
    /** Tipos de parametros admitidos en anotaciones
     * * Primitivos
     * * String
     * * Class
     * * Enum
     * * Arreglos de los tipos anteriores
     * @return
     */
    String descripcion() default "";
    int version();
}
