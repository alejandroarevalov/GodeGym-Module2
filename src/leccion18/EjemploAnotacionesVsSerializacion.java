package leccion18;

import utilitarios.UtilitariosGenerales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EjemploAnotacionesVsSerializacion {

    public void serializarObjeto() {
        Perro perro = new Perro("Lucas", "Cocker Spaniel", 48);
        try(FileOutputStream archivoSalida = new FileOutputStream("resources/perro.dat")) {
            ObjectOutputStream flujoSalidaObjetos = new ObjectOutputStream(archivoSalida);
            flujoSalidaObjetos.writeObject(perro);
        } catch (IOException ex) {
            System.err.println("Error al intentar serializar el perro " + perro);
        }
        System.out.println("El perro " + perro + " ha sido guardado");
    }

    public void usarMarcadores() {
        Usuario usuario = new Usuario("Alejandro", "alejandro@codegym.com");
        String cadenaDeTexto = "Solo soy una cadena de texto";
        try {
            auditar(usuario);
            auditar(cadenaDeTexto);
        } catch (Exception ex) {
            System.err.println("Objeto no auditable");
        }
    }

    private void auditar(Object object) throws Exception {
        if (object instanceof Auditable) {
            System.out.println(object);
        } else {
            throw new Exception("Objeto no auditable");
        }
    }

    public void usarAnotaciones() throws Exception {
        Perro perro = new Perro("Spike", "Shitzu", 120);
        System.out.println(perro);
        Method ladrar = perro.getClass().getMethod("ladrar");
        int cantidadDeVeces = ladrar.getAnnotation(EjecutarInmediatamente.class).veces();
        for (int i = 0; i < cantidadDeVeces; i++) {
            ladrar.invoke(perro);
        }
    }

    public void usarInterceptor() throws Exception {
        Perro perro = new Perro("Lassie", "Border Collie", 240);
        Method ladrar = perro.getClass().getMethod("ladrar");
        Class clazz = ladrar.getAnnotation(Interceptar.class).interceptor();
        clazz.getMethod("ejecutar").invoke(Interceptora.class);
        ladrar.invoke(perro);
    }

    public static void main(String[] args) throws Exception {
        EjemploAnotacionesVsSerializacion ejemplo = new EjemploAnotacionesVsSerializacion();
        ejemplo.serializarObjeto();
        UtilitariosGenerales.imprimirLineasSeparacion();
        ejemplo.usarMarcadores();
        UtilitariosGenerales.imprimirLineasSeparacion();
        ejemplo.usarAnotaciones();
        UtilitariosGenerales.imprimirLineasSeparacion();
        ejemplo.usarInterceptor();
    }
}
