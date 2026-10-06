/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import model.Halte;
import model.HalteReguler;
import model.HalteTransit;

/**
 *
 * @author user
 */
public class HalteController {
    private ArrayList<Halte> daftarHalte;
    private int nomorId;

    public HalteController() {
        daftarHalte = new ArrayList<>();
        nomorId = 3;

        daftarHalte.add(new HalteReguler(
                "H001",
                "Halte Taman Kota",
                "Jalan Merdeka",
                20,
                "Rute A1",
                "Terminal Kota"
        ));

        daftarHalte.add(new HalteTransit(
                "H002",
                "Halte Pusat Kota",
                "Jalan Sudirman",
                40,
                "Rute A2",
                "Rute B2"
        ));
    }

    public String buatIdHalte() {
        String idHalte;

        if (nomorId < 10) {
            idHalte = "H00" + nomorId;
        } else if (nomorId < 100) {
            idHalte = "H0" + nomorId;
        } else {
            idHalte = "H" + nomorId;
        }

        nomorId++;
        return idHalte;
    }

    public void tambahHalte(Halte halte) {
        daftarHalte.add(halte);
    }

    public ArrayList<Halte> getDaftarHalte() {
        return daftarHalte;
    }

    public Halte cariHalte(String idHalte) {
        for (Halte halte : daftarHalte) {
            if (halte.getIdHalte().equalsIgnoreCase(idHalte)) {
                return halte;
            }
        }

        return null;
    }

    public Halte cariHalte(String namaHalte, String lokasi) {
        for (Halte halte : daftarHalte) {
            if (halte.getNamaHalte().equalsIgnoreCase(namaHalte)
                    && halte.getLokasi().equalsIgnoreCase(lokasi)) {
                return halte;
            }
        }

        return null;
    }

    public void ubahHalte(Halte halte, String namaBaru,
                          String lokasiBaru, int kapasitasBaru,
                          String ruteBaru) {
        halte.setNamaHalte(namaBaru);
        halte.setLokasi(lokasiBaru);
        halte.setKapasitas(kapasitasBaru);
        halte.setRuteBus(ruteBaru);
    }

    public void hapusHalte(Halte halte) {
        daftarHalte.remove(halte);
    }

    public boolean dataKosong() {
        return daftarHalte.size() == 0;
    }
}