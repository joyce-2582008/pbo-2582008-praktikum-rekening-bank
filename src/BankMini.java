import java.util.Scanner;

public class BankMini {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat object Rekening (nomor 001, pemilik Ani, saldo awal 100.000)
        Rekening rekening = new Rekening("001", "Ani", 100000);

        // Ketentuan 7: Mencoba akses field private secara langsung
// Jika baris di bawah ini di-uncomment, akan muncul error:
// java: saldo has private access in Rekening
// rekening.saldo = 1000000;

        System.out.println("============ BANK MINI ============");
        System.out.print("Rekening " );
        rekening.cetakInfo();

        int pilihan;
        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.print("Jumlah: ");
                int jmlSetor = input.nextInt();
                boolean statusSetor = rekening.setor(jmlSetor);
                if (statusSetor) {
                    System.out.println("  Berhasil");
                } else {
                    System.out.println("  Ditolak");
                }
            } else if (pilihan == 2) {
                System.out.print("Jumlah: ");
                int jmlTarik = input.nextInt();
                boolean statusTarik = rekening.tarik(jmlTarik);
                if (statusTarik) {
                    System.out.println("  Berhasil");
                } else {
                    System.out.println("  Ditolak");
                }
            } else if (pilihan == 3) {
                rekening.cetakInfo();
            } else if (pilihan == 0) {
                // Keluar dari menu
                break;
            } else {
                System.out.println("Menu tidak dikenal");
            }

        } while (pilihan != 0);

        // Ketentuan 6: Sesudah keluar dari menu, cetak info rekening sekali lagi sebagai saldo akhir
        System.out.println("\n=========== SALDO AKHIR ===========");
        rekening.cetakInfo();

        input.close();
    }
}