import java.util.Scanner;

public class Dosen09 {
    String nidn;
    String nama;
    String email;
    int thnMasuk;
    String prodi;

    public Dosen09(String nidn, String nama, String email, int thnMasuk, String prodi) {
        this.nidn = nidn;
        this.nama = nama;
        this.email = email;
        this.thnMasuk = thnMasuk;
        this.prodi = prodi;
    }

    public int getMasaKerja(int thnSekarang) {
        return thnSekarang - thnMasuk;
    }

    public void tampilkanData(int thnSekarang) {
        System.out.println("NIDN: " + nidn);
        System.out.println("Nama: " + nama);
        System.out.println("Email: " + email);
        System.out.println("Masa Kerja: " + getMasaKerja(thnSekarang) + " tahun");
        System.out.println("Program Studi: " + prodi);
        System.out.println();
    }
}