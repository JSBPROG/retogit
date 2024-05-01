package chat;




import java.util.Scanner;

public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        Fichero chat = new Fichero(true, true, true);
        Bot cleverIA = new Bot(chat.getNombre());
        String respuesta;

        do {
            System.out.println("Háblale al bot ");
            respuesta = sc.nextLine();
            cleverIA.responde(chat.escribe(respuesta));

            System.out.println("¿Quieres seguir escribiendo?");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("si"));

        System.out.println("Fin de la charla");
    }





}





