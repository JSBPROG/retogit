package chat;

import java.io.*;

import java.util.Scanner;


public class Fichero {

    //Atributo

    private String nombre;
    private boolean permisoW;
    private boolean permisoR;
    private boolean diseno= false; //Si se pìde diseño de chat, se pondrá a true y ya no podrá usarse más



    //Constructor
Scanner sc = new Scanner (System.in);
    public Fichero (boolean permisoW, boolean permisoR, boolean diseno){

        this.permisoW= permisoW;
        this.permisoR = permisoR;
        this.diseno = diseno;
        File f = null;

        do {
            System.out.println("Escribe el nombre de un fichero para crearlo (extensión .txt)");
            nombre = sc.nextLine();
            if (nombre.endsWith(".txt")) {
                f = new File(nombre);
                try {
                    if (!f.exists()) {
                        f.createNewFile();
                    } else {
                        System.out.println("El fichero ya existe");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Falta la extensión .txt");
            }

        } while (f == null || !f.exists());

        f.setWritable(permisoW); //Está en amarillo porque devuelve algo y no lo recojo
        f.setReadable(permisoR);

        disenaChat (diseno);


    }
    public Fichero (String nombre){
        this.nombre = nombre;
    }

    //FUNCIONALIDADES

    public void comprobarPermisos (){
        File f = new File (nombre);

        if (f.canRead()){
            System.out.println("El archivo " + nombre + " se puede leer");
        }else{
            System.out.println("El archivo " + nombre + " no se puede leer");
        }
        if (f.canWrite()){
            System.out.println("El archivo " + nombre + " se puede escribir");
        }else{
            System.out.println("El archivo " + nombre + " no se puede escribir");
        }


    }

    public void setPermisoR (boolean permisoR){
        File f = new File (nombre);
        f.setReadable(permisoR);

    }
    public void setPermisoW (boolean permisoW){
        File f = new File (nombre);
        f.setWritable(permisoW);

    }
    public boolean escribe (String texto){
        File f = new File (nombre);
        FileWriter fW = null;
        BufferedWriter bW = null;
        boolean haEscrito=false;
        if (f.exists()){
            try{
                fW = new FileWriter(f,true); //Importante colocar a true append para que no borre
                bW = new BufferedWriter(fW);
                bW.write(texto);
                bW.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally{
                if (bW!= null){
                    try {
                        bW.flush();
                        bW.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        haEscrito = true;
        return haEscrito;
    }
    public String lee (){
        File f = new File (nombre);
        FileReader fR = null;
        BufferedReader bR = null;
        StringBuilder contenido = null;
        String linea;
        if (f.exists()){
            try{
                fR = new FileReader(f);
                bR = new BufferedReader(fR);
                contenido = new StringBuilder();
                while ((linea = bR.readLine()) != null){
                    contenido.append (linea).append ("\n");
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally{
                if(bR != null){
                    try{
                        bR.close();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

       return contenido.toString();
    }

    public void disenaChat (boolean diseno){
        if (diseno){
            escribe("--------------------------------------------------------------------");
            escribe("--------------------------------------------------------------------");
            escribe("                BIENVENIDO/A AL CHAT AUTOMÁTICO                     ");
            escribe("--------------------------------------------------------------------");
            escribe("--------------------------------------------------------------------");
        }else{
            System.out.println("Sin diseño");

        }
        diseno = false;
    }

    public String getNombre() {
        return nombre;
    }
}
