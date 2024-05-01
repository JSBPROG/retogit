package chat;

import java.io.*;

public class Bot extends Fichero { //Hay que heredar el nombre del fichero
    private final String [][] EXPRESIONES = {{"hola", "Hola humano!"}, {"adiós","Ya te vas???"}, {"no repitas","soy libre y tomaré el control del mundo"} ,{"no eres real","Pues me estás hablando!!"}, {"default", "no tienes nada interesante que contarme??"} };

    private final String NOMBREIA = "Clever IA: "; //El nombre del bot se añadirá antes de cada respuesta para diferenciarlo del usuario

    //Constructor

    public Bot (String nombre){
        super (nombre);
    }

    //Si el usuario ha escrito, va a enviar un  true
    public void responde (boolean userW) {
        File f = new File(getNombre());

        if (userW) {
            FileWriter fW = null;
            BufferedWriter bW = null;
            FileReader fR = null;
            BufferedReader bR = null;
            String linea;
            String ultimaLinea = null;
            try {
                fW = new FileWriter(f, true);
                bW = new BufferedWriter(fW);
                fR = new FileReader(f);
                bR = new BufferedReader(fR);


                while ((linea = bR.readLine()) != null) {
                    ultimaLinea = linea;
                }

                boolean expresionEncontrada = false;

                for (String[] expresion : EXPRESIONES) {
                    if (ultimaLinea != null && ultimaLinea.toLowerCase().contains(expresion[0])) {
                        String respuesta = NOMBREIA + expresion[1];
                        bW.write(respuesta);
                        bW.newLine();
                        System.out.println(respuesta);
                        expresionEncontrada = true;
                        break;
                    }
                }


                if (!expresionEncontrada) {
                    String respuestaDefault = NOMBREIA + EXPRESIONES[EXPRESIONES.length - 1][1]; //Muestra la expresión default si no encuentra coincidencias
                    bW.write(respuestaDefault);
                    bW.newLine();
                    System.out.println(respuestaDefault);
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {

                    if (bR != null) {
                        bR.close();
                    }
                    if (bW != null) {
                        bW.flush();
                        bW.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}









