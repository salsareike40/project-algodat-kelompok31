public class main {
    public static void main(String[] args) {
        List daftarFilmBioskop = new List();

        // Menambahkan data film dan bioskop
        daftarFilmBioskop.tambahFilm("Wicked", 160, "XXI");
        daftarFilmBioskop.tambahFilm("Moana 2", 100, "CGV");
        daftarFilmBioskop.tambahFilm("Mufasa: The Lion King", 118, "XXI");
        daftarFilmBioskop.tambahFilm("Habibie & Ainun", 125, "Cinepolis");
        daftarFilmBioskop.tambahFilm("Hutang Nyawa", 100, "CGV");
        daftarFilmBioskop.tambahFilm("Avangers: Endgame", 181, "Cinepolis");
        daftarFilmBioskop.tambahFilm("The Garfield Movie", 101, "XXI");

        // Menampilkan daftar film dan bioskop
        daftarFilmBioskop.tampilkanFilm();
    }
}
