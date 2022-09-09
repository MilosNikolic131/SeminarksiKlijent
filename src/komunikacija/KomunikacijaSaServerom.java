/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import konst.Port;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Master
 */
public class KomunikacijaSaServerom {

    public static KomunikacijaSaServerom instance;
    private Socket s;

    private KomunikacijaSaServerom() {
        try {
            System.out.println(Port.getInstance().getPort());
            int port = 9000;
            try {
                FileReader reader = new FileReader("..\\SeminarskiZajednicki\\port.txt");
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = bufferedReader.readLine();
                System.out.println(line);
                port = Integer.parseInt(line);
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(port);

            s = new Socket("localhost", port);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstance() {
        if (instance == null) {
            instance = new KomunikacijaSaServerom();
        }
        return instance;
    }

    public ServerskiOdgovor primiOdgovor() {
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ServerskiOdgovor so = (ServerskiOdgovor) ois.readObject();
            return so;
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Neuspesno primio zahtev");
        return null;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Socket getS() {
        return s;
    }

    public void setS(Socket s) {
        this.s = s;
    }
}
