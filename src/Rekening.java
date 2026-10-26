public class Rekening {
    // Ketentuan 1: Field nomor, pemilik, dan saldo semuanya private
    private String nomor;
    private String pemilik;
    private int saldo;

    // Ketentuan 2: Constructor dengan parameter sama, diisi memakai this
    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Ketentuan 3: Saldo read-only (ada getSaldo, tanpa setSaldo)
    public int getSaldo() {
        return saldo;
    }

    // Ketentuan 4: Method setor dengan validasi jumlah <= 0
    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    // Ketentuan 4: Method tarik dengan validasi jumlah <= 0 dan melebihi saldo
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    // Ketentuan 5: Method private formatRupiah dari Bab 08
    private String formatRupiah(int nominal) {
        return String.format("Rp%,d", nominal).replace(',', '.');
    }

    // Ketentuan 5: Method cetakInfo mencetak format sesuai ketentuan
    public void cetakInfo() {
        System.out.printf("%s | %-6s | %10s%n", nomor, pemilik, formatRupiah(saldo));
    }
}