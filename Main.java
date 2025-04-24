import java.util.Calendar;
import java.util.Scanner;

public class Main {
    static void selectionNIDN(Dosen09[] dosens) {     // Selection Sort - ascending
        for (int i = 0; i < dosens.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < dosens.length; j++) {
                if (dosens[j].nidn.compareTo(dosens[minIdx].nidn) < 0) {
                    minIdx = j;
                }
            }
            Dosen09 temp = dosens[minIdx];
            dosens[minIdx] = dosens[i];
            dosens[i] = temp;
        }
    }

    static void bubbleMasaKerja(Dosen09[] dosens, int tahunSekarang) {        // Bubble Sort - descending
        for (int i = 0; i < dosens.length - 1; i++) {
            for (int j = 0; j < dosens.length - i - 1; j++) {
                if (dosens[j].getMasaKerja(tahunSekarang) < dosens[j + 1].getMasaKerja(tahunSekarang)) {
                    Dosen09 temp = dosens[j];
                    dosens[j] = dosens[j + 1];
                    dosens[j + 1] = temp;
                }
            }
        }
    }

    static void linearSearchName(Dosen09[] dosens, String targetNama, int tahunSekarang) {      // Linear Search - cari nama
        boolean ditemukan = false;
        for (Dosen09 d : dosens) {
            if (d.nama.equalsIgnoreCase(targetNama)) {
                d.tampilkanData(tahunSekarang);
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Dosen dengan nama " + targetNama + " tidak ditemukan.");
        }
    }

    static void tampilkanSemuaDosen(Dosen09[] dosens, int tahunSekarang) {
        for (Dosen09 d : dosens) {
            d.tampilkanData(tahunSekarang);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tahunSekarang = 2025;

        Dosen09[] dosens = {
            new Dosen09("A1234", "Angga", "angga@polinema.ac.id", 2013, "Sistem Informasi Bisnis"),
            new Dosen09("B2345", "Syamlan", "syamlan@polinema.ac.id", 2010, "Teknik Elektro"),
            new Dosen09("C3456", "Zinky", "zinky@polinema.ac.id", 2019, "Teknik Sipil"),
            new Dosen09("D4567", "Sastra", "sastra@polinema.ac.id", 2007, "Teknik Mesin"),
            new Dosen09("E5678", "Zaki", "zaki@polinema.ac.id", 2012, "Administrasi Bisnis")
        };

        int pilihan;
        do {
            System.out.println("====== MENU ======");
            System.out.println("1. Tampilkan Data Dosen");
            System.out.println("2. Tampilkan urutan Dosen berdasarkan NIDN");       // (Selection Sort: ascending)
            System.out.println("3. Cari data Dosen berdasarkan Nama");      // (Linear Search)
            System.out.println("4. Tampilkan urutan masa kerja dosen");     // (Bubble Sort: descending)
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("--- Data Semua Dosen ---");
                    tampilkanSemuaDosen(dosens, tahunSekarang);
                    break;
                case 2:
                    System.out.println("--- Dosen diurutkan berdasarkan NIDN ---");
                    selectionNIDN(dosens);
                    tampilkanSemuaDosen(dosens, tahunSekarang);
                    break;
                case 3:
                    System.out.print("Masukkan nama dosen yang ingin dicari: ");
                    String namaCari = input.nextLine();
                    linearSearchName(dosens, namaCari, tahunSekarang);
                    break;
                case 4:
                    System.out.println("--- Dosen diurutkan berdasarkan Masa Kerja ---");
                    bubbleMasaKerja(dosens, tahunSekarang);
                    tampilkanSemuaDosen(dosens, tahunSekarang);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

    }
}
