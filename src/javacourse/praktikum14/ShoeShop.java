package javacourse.praktikum14;

import java.io.*;
import java.util.ArrayList;

/**
 * Main class for Shoe shop problem.
 * Created by Rando on 20.11.2016.
 */
public class ShoeShop implements Serializable{
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {

        Client c1 = new Client("Rando", 20, 46);
        Client c2 = new Client("Urmas", 50, 52);
        Client c3 = new Client("Bob", 5, 32);
        Client c4 = new Client("Mari", 25, 37);

        addClient(c1);
        addClient(c2);
        addClient(c3);

        deserializeClients();

        removeClient(c2);
        removeClient(0);

        deserializeClients();

        addClient(c1);
        addClient(c2);
        addClient(c4);

        deserializeClients();

        c4.setAge(26);
        c1.setName("Ayoooo");
        c2.setShoeNumber(99);

        deserializeClients();

    }

    private static void addClient(Client client) {
        clients.add(client);
        serializeClients();
    }

    private static void removeClient(Client client) {
        clients.remove(client);
        serializeClients();
    }

    private static void removeClient(int index) {
        clients.remove(index);
        serializeClients();
    }

    static void serializeClients() {
        String filePath = ShoeShop.class.getResource(".").getPath();
        try {
            FileOutputStream fOut = new FileOutputStream(filePath + "kliendid.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fOut);
            oos.writeObject(clients);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deserializeClients() {
        String filePath = ShoeShop.class.getResource(".").getPath();
        try {
            FileInputStream fIn = new FileInputStream(filePath + "kliendid.ser");
            ObjectInputStream ois = new ObjectInputStream(fIn);
            ArrayList<Client> c = (ArrayList<Client>) ois.readObject();
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
