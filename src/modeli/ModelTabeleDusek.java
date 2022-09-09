/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Dusek;
import domen.Materijal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import komunikacija.KomunikacijaSaServerom;
import konst.Konstante;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Master
 */
public class ModelTabeleDusek extends AbstractTableModel {

    ArrayList<Dusek> lista;
    String[] kolone = {"DusekID", "Naziv Duseka", "Cena", "Materijal", "Tvrdoca"};

    public ModelTabeleDusek() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dusek d = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return d.getDusekID();
            case 1:
                return d.getNazivDuseka();
            case 2:
                return d.getCena();
            case 3:
                return nazivMaterijala(d.getMaterijal());
            case 4:
                return nazivTvrdoce(d.getTvrdoca());
            default:
                return "Greska";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Dusek d) {
        this.lista.add(d);
        fireTableDataChanged();
    }

    public Dusek vrati(int row) {
        return lista.get(row);
    }

    public void obrisi(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    public ArrayList<Dusek> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Dusek> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void ocisti() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }

    public String nazivMaterijala(int id) {
        KlijentskiZahtev kz2 = new KlijentskiZahtev(Konstante.VRATI_MATERIJAL, null);
        KomunikacijaSaServerom.getInstance().posaljiZahtev(kz2);
        ServerskiOdgovor so2 = KomunikacijaSaServerom.getInstance().primiOdgovor();
        ArrayList<Materijal> listaM = (ArrayList<Materijal>) so2.getParametar();

        for (Materijal materijal : listaM) {
            if (materijal.getMaterijalID() == id) {
                return materijal.getNazivMaterijala();
            }
        }
        return "Nepoznat materijal";
    }

    public String nazivTvrdoce(int id) {
        switch (id) {
            case 1:
                return "Mek";
            case 2:
                return "Srednji";
            case 3:
                return "Tvrd";
            default:
                return "greska";
        }
    }

    public double vratiUkupno() {
        double ukupno = 0;
        for (Dusek dusek : lista) {
            ukupno += dusek.getCena();
        }
        return ukupno;
    }

    public void osvezi() {
        fireTableDataChanged();
    }
}
