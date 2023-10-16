package org.example.otherserver;

import static spark.Spark.*;

/**
 * Clase que maneja el Spark que sirve de servidor
 */
public class SecureOtherSpark {

    /**
     * Metodo principal de la clase, maneja las diferentes peticiones
     * @param args
     */
    public static void main(String[] args) {
        port(getPort());
        secure("servidor-keystore.jks", "123456", "myTrustStoreServidor", "123456");
        get("/hello", ((request, response) -> "Hi, login successful, you're a pro"));
    }

    /**
     * Metodo que retorna el puerto por el que se correra el servicio
     * @return numero del puerto
     */
    public static int getPort(){
        if(System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35001;
    }
}
