import HashTable.HashTable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Business.Business;

public class App {
    public static void main(String[] args) throws Exception {
        HashTable tablaHash = new HashTable();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la función de hash que desea usar:");
        System.out.println("1. División");
        System.out.println("2. Multiplicación");
        int opcion = scanner.nextInt();


        String line = "";
        String splitBy = ",";
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                String name = bussines[1];
                String address = bussines[2];
                String city = bussines[3];
                String state = bussines[4];
                Business objBusiness = new Business(name,address,city,state);
                tablaHash.insertarM(bussines[0],objBusiness);
                tablaHash.insertarD(bussines[0],objBusiness);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if(opcion==1){

            tablaHash.buscarD("7BPPs1Jzx8hMBDgMJYpwfQ","Plaza Vazquez", "1642 W High St");
        }
        else if (opcion ==2){
            tablaHash.buscarM("7BPPs1Jzx8hMBDgMJYpwfQ","Plaza Vazquez", "1642 W High St");
        }
        else {
            System.out.println("Opción no válida.");
        }

    }




}



