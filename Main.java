public class Main {
        public static void main(String[] args) {
            LinkedList daftarFilmBioskop = new LinkedList();

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

           // Mencari film dengan binary search
           BinarySearch binarySearch = new BinarySearch(7);
           binarySearch.addFilm("Wicked", 160);
           binarySearch.addFilm("Moana 2", 100);
           binarySearch.addFilm("Mufasa: The Lion King", 118);
           binarySearch.addFilm("Habibie & Ainun", 125);
           binarySearch.addFilm("Hutang Nyawa", 100);
           binarySearch.addFilm("Avangers: Endgame", 181);
           binarySearch.addFilm("The Garfield Movie", 101);


        }
}