package HashTable;

import Business.Business;
import LinkedList.LinkedList;
import LinkedList.Node;

public class HashTable {

    //definir le tamaño ya que debe ser finito
    //el limite es recomendable que sea un un numero primo

    private int size = 100003;

    private LinkedList[] tabla = new LinkedList[size];


    public int convertirNumero(String valor) {
        int count = 0;

        for (int i = 0; i < valor.length(); i++) {
            char caracter = valor.charAt(i);
            int Ascii = (int) caracter;
            count += Ascii;
        }
        return count;
    }

    public int hashDivision(Integer k) {
        Integer key = 0;
        //metodo de hasheo de division
        //0x7fffffff es un numero binario en donde nuestro primer bit o sea 0 representa el signo donde 0 es positivo lo demas del 0 es el tamaño macimo de enteros
        //sirve como para volver a k como un valor absoluto y seimpre tenerlo positivo
        key = (k & 0x7fffffff) % size;
        int hashResultadoD = (int) key;

        return hashResultadoD;
    }

    public void insertarD(String key, Business objBusiness) {
        int numeroAsc = this.convertirNumero(key);
        int index = this.hashDivision(numeroAsc);
        if (tabla[index] == null) {
            tabla[index] = new LinkedList();
        }
        tabla[index].push(objBusiness);

    }


    public void buscarD(String id,String name, String address) {
        int numeroAsc = this.convertirNumero(id);
        int index = this.hashDivision(numeroAsc);

        System.out.println("Lo que se buscara sera: "+ name + " " + address);
        System.out.println("El indice hasheado es: "+index);

        for(int i=0; i<this.tabla.length; i++) {
            if (this.tabla[i] != null) {
                if (i == index) {

                    for (int j = 0; j < this.tabla[i].size(); j++) {
                        Node nodoBuscar = this.tabla[i].getElementAt(j);
                        if (nodoBuscar.getBusiness().getName().equals(name) && nodoBuscar.getBusiness().getAddress().equals(address)) {
                            System.out.println("\nEl indice que tiene es: " + j);
                            System.out.println("Los datos almacenados son:" + nodoBuscar.getBusiness().toString());
                        }
                    }
                }
            }
        }
    }

//////////////////////////////////////////////////////////////////////multipliccion////////////////////////////////////////
    public int hashMultiplicacion(int k) {
        double A = 0.3565;
        double key = (size * ((k * A) % 1));
        int hashResultadoM = (int) key;
        return hashResultadoM;

    }
    public void insertarM(String key, Business objBusiness) {
        int numeroAsc = this.convertirNumero(key);
        int index = this.hashMultiplicacion(numeroAsc);
        if (tabla[index] == null) {
            tabla[index] = new LinkedList();
        }
        tabla[index].push(objBusiness);

    }

    public void buscarM(String id,String name, String address) {
        int numeroAsc = this.convertirNumero(id);
        int index = this.hashMultiplicacion(numeroAsc);

        System.out.println("Lo que se buscara sera: "+ name + " " + address);
        System.out.println("El indice hasheado es: "+index);

        for(int i=0; i<this.tabla.length; i++) {
            if (this.tabla[i] != null) {
                if (i == index) {

                    for (int j = 0; j < this.tabla[i].size(); j++) {
                        Node nodoBuscar = this.tabla[i].getElementAt(j);
                        if (nodoBuscar.getBusiness().getName().equals(name) && nodoBuscar.getBusiness().getAddress().equals(address)) {
                            System.out.println("\nEl indice que tiene es: " + j);
                            System.out.println("Los datos almacenados son:" + nodoBuscar.getBusiness().toString());
                        }
                    }
                }
            }
        }
    }
}




