/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import domen.Dimenzije;
import domen.Dusek;
import domen.Materijal;
import domen.Narucen;
import domen.Porudzbina;
import domen.Prodavac;
import domen.Tvrdoca;
import domen.Velicina;
import java.util.ArrayList;
import komunikacija.KomunikacijaSaServerom;
import konst.Konstante;
import modeli.ModelTabeleDusek;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Master
 */
public class KontrolerK {

    private static KontrolerK instance;
    private Prodavac korisnik;

    public KontrolerK() {

    }

    public static KontrolerK getInstance() {
        if (instance == null) {
            instance = new KontrolerK();
        }
        return instance;
    }

    public Prodavac login(String user, String pass) {
        Prodavac k = new Prodavac(user, pass);
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.LOGIN, k);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return k;
        } else {
            return null;
        }
    }

    public boolean dodajMaterijal(String naziv) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.DODAJ_MATERIJAL, naziv);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validirajMaterijal(String naziv) {
        if (naziv == null || naziv.equals("") || naziv.equals("-") || naziv.equals(" ")) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<Velicina> vratiVelicine() {
        KlijentskiZahtev kz3 = new KlijentskiZahtev(Konstante.VRATI_VELICINE, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz3);
        ServerskiOdgovor so3 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Velicina> listaVelicina = (ArrayList<Velicina>) so3.getParametar();
        return listaVelicina;
    }

    public ArrayList<Materijal> vratiMaterijale() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_MATERIJAL, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Materijal> listaMaterijala = (ArrayList<Materijal>) so.getParametar();
        return listaMaterijala;
    }

    public ArrayList<Tvrdoca> vratiTvrdoce() {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.VRATI_TVRDOCE, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Tvrdoca> listaTvrdoce = (ArrayList<Tvrdoca>) so2.getParametar();
        return listaTvrdoce;
    }

    public ArrayList<Dusek> vratiDuseke() {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.VRATI_DUSEK, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Dusek> listaDusek = (ArrayList<Dusek>) so2.getParametar();
        return listaDusek;
    }

    public ArrayList<Porudzbina> vratiPorudzbine() {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.VRATI_PORUDZBINE, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Porudzbina> listaPorudzbine = (ArrayList<Porudzbina>) so2.getParametar();
        return listaPorudzbine;
    }

    public boolean sacuvajDimenzije(int id, Velicina v) {
        int idV = v.getVelicinaID();
        Dimenzije d = new Dimenzije(idV, id);
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.SACUVAJ_DIMENZIJE, d);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validirajDusekDodavanje(Dusek d) {
        if (d.getNazivDuseka() == null || d.getNazivDuseka().equals("") || d.getNazivDuseka().equals("-") || d.getNazivDuseka().equals(" ")) {
            return false;
        }
        if (d.getCena() == 0.0) {
            return false;
        }
        return true;
    }

    public int vratiIDDuseka() {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.VRATI_ID_DUSEKA, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        int id = (int) so2.getParametar();
        return id;
    }

    public int vratiIDPorudzbine() {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.VRATI_ID_PORUDZBINE, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        int id = (int) so.getParametar();
        return id;
    }

    public boolean dodajDusek(Dusek d) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.SACUVAJ_DUSEK, d);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean brisanjeDuseka(int id) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.OBRISI_DUSEK, id);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validirajPorudzbinu(Porudzbina p, ModelTabeleDusek mtg) {
        if (p.getAdresa() == null || p.getAdresa().equals("") || p.getAdresa().equals("-") || p.getAdresa().equals(" ")) {
            return false;
        }
        if (p.getImePrezime() == null || p.getImePrezime().equals("") || p.getImePrezime().equals("-") || p.getImePrezime().equals(" ")) {
            return false;
        }
        if (p.getNapomena() == null || p.getNapomena().equals("") || p.getNapomena().equals("-") || p.getNapomena().equals(" ")) {
            return false;
        }
        if (mtg.getLista().size() < 1) {
            return false;
        }
        return true;
    }

    public boolean sacuvajPorudzbinu(Porudzbina p) {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.SACUVAJ_PORUDZBINU, p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so2.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean sacuvajStavku(Narucen n) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.SACUVAJ_STAVKU, n);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean izmeniDimenzije(Dimenzije d) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.IZMENI_DIMENZIJE, d);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validirajIzmenuDuseka(Dusek d) {
        if (d.getNazivDuseka() == null || d.getNazivDuseka().equals("") || d.getNazivDuseka().equals("-") || d.getNazivDuseka().equals(" ")) {
            return false;
        }
        if (d.getCena() == 0.0) {
            return false;
        }
        return true;
    }

    public boolean izmeniDusek(Dusek d) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.IZMENI_DUSEK, d);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean stornirajPorudzbinu(Porudzbina p) {
        KlijentskiZahtev kz = new KlijentskiZahtev(Konstante.STORNIRAJ, p);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstance().primiOdgovor();
        if (so.getPoruka().equals("OK")) {
            return true;
        } else {
            return false;
        }
    }

   
}
