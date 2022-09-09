/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Porudzbina;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Master
 */
public class ModelTabelePorudzbina extends AbstractTableModel {

    ArrayList<Porudzbina> lista;
    String[] kolone = {"ID", "Ime i prezime", "Adresa", "Napomena", "Ukupno"};

    public ModelTabelePorudzbina() {
        this.lista = new ArrayList<>();
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
        Porudzbina p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getPorudzbinaID();
            case 1:
                return p.getImePrezime();
            case 2:
                return p.getAdresa();
            case 3:
                return p.getNapomena();
            case 4:
                return p.getUkupno();
            default:
                return "greska";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void dodaj(Porudzbina p) {
        this.lista.add(p);
        fireTableDataChanged();
    }

    public Porudzbina vrati(int row) {
        return lista.get(row);
    }

    public void obrisi(int row) {
        lista.remove(row);
        fireTableDataChanged();
    }

    public ArrayList<Porudzbina> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Porudzbina> lista) {
        this.lista = lista;
        fireTableDataChanged();
    }

    public void ocisti() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }
    
    public void osvezi() {
      fireTableDataChanged();
    }
    
}
