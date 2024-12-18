import java.util.Scanner;
class Node {
    String namaFilm;
    int durasi;
    String namaBioskop;
    Node next;
    Node(String namaFilm, int durasi, String namaBioskop) {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.namaBioskop = namaBioskop;
        this.next = null;
    }
}
class FilmQueue {
    Node head, tail;

    void tambahFilm(String namaFilm, int durasi, String namaBioskop) {
        Node baru = new Node(namaFilm, durasi, namaBioskop);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
    }
    Node hapusFilm() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return temp;
    }
    void tampilkanFilm(String kategori) {
        if (head == null) {
            System.out.println("Tidak ada film dalam daftar " + kategori);
            return;
        }
        Node temp = head;
        int index = 1;
        System.out.println("Daftar Film " + kategori + ":");
        while (temp != null) {
            System.out.println(index++ + ". " + temp.namaFilm + " (" + temp.durasi + " menit) - " + temp.namaBioskop);
            temp = temp.next;
        }
    }
}
class FilmStack {
    private static class StackNode {
        Node film;
        StackNode next;

        StackNode(Node film) {
            this.film = film;
        }
    }

    private StackNode top;

    void push(Node film) {
        StackNode baru = new StackNode(film);
        baru.next = top;
        top = baru;
    }

    Node pop() {
        if (top == null) {
            return null;
        }
        Node film = top.film;
        top = top.next;
        return film;
    }

    boolean isEmpty() {
        return top == null;
    }

    void tampilkanRiwayat() {
        if (isEmpty()) {
            System.out.println("Belum ada riwayat film yang selesai tayang.");
            return;
        }

        System.out.println("Riwayat Film yang Selesai Tayang:");
        StackNode temp = top;
        while (temp != null) {
            Node film = temp.film;
            System.out.println("- " + film.namaFilm + " (" + film.durasi + " menit) - " + film.namaBioskop);
            temp = temp.next;
        }
    }
}

public class BioskopProgram {
    public static void main(String[] args) {
        FilmQueue daftarFilmBioskop = new FilmQueue();
        FilmQueue filmBakalTayang = new FilmQueue();
        FilmStack riwayatFilm = new FilmStack();
        daftarFilmBioskop.tambahFilm("Wicked (2024)", 160, "XXI");
        daftarFilmBioskop.tambahFilm("Moana 2 (2024)", 100, "CGV");
        daftarFilmBioskop.tambahFilm("Mufasa: The Lion King (2024)", 118, "XXI");
        daftarFilmBioskop.tambahFilm("Habibie & Ainun (2012)", 125, "Cinepolis");
        daftarFilmBioskop.tambahFilm("Hutang Nyawa (2024)", 100, "CGV");
        daftarFilmBioskop.tambahFilm("Avengers: Endgame (2019)", 181, "Cinepolis");
        daftarFilmBioskop.tambahFilm("The Garfield Movie (2024)", 101, "XXI");
        filmBakalTayang.tambahFilm  ("Moana 2 (2024)", 100, "CGV");
        filmBakalTayang.tambahFilm ("Wicked (2024)", 160, "XXI");
        filmBakalTayang.tambahFilm("Mufasa: The Lion King (2024)", 118, "XXI");
        filmBakalTayang.tambahFilm ("Habibie & Ainun (2012)", 125, "Cinepolis");
        filmBakalTayang.tambahFilm ("Hutang Nyawa (2024)", 100, "CGV");
        filmBakalTayang.tambahFilm ("Avengers: Endgame (2019)", 181, "Cinepolis");
        filmBakalTayang.tambahFilm ("The Garfield Movie (2024)", 101, "XXI");
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\t   *==============================*");
            System.out.println("\t   ||   Program Tiket CinePath   ||");
            System.out.println("\t   *==============================*");
            System.out.println();
            System.out.println(" ====================================================");
            System.out.println("\t   DAFTAR MENU ");
            System.out.println("\t*-------------------------------*");
            System.out.println("\t| 1. Daftar Film            |");
            System.out.println("\t| 2. Daftar Film Bakal Tayang   |");
            System.out.println("\t| 3. Riwayat Film               |");
            System.out.println("\t| 4. Keluar                     |");
            System.out.println("\t*-------------------------------*");
            System.out.println(" ====================================================");
            System.out.println();
            System.out.print(" Masukan Pilihan Anda (1-4) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                System.out.print(" Masukan Pilihan Anda (1-4) : ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            System.out.println();
            switch (pilihan) {
                case 1: {
                    daftarFilmBioskop.tampilkanFilm("yang Sedang Tayang");
                    break;
                }
                case 2: {
                    int pilih;
                    filmBakalTayang.tampilkanFilm("yang sedang tayang");
                   Node selesaiTayang = filmBakalTayang.hapusFilm();
                    if (selesaiTayang != null) {
                        riwayatFilm.push(selesaiTayang);
                        System.out.println("Film \"" + selesaiTayang.namaFilm + "\" telah selesai tayang dan masuk ke riwayat.");
                    } else {
                        System.out.println("Tidak ada film yang sedang tayang.");
                    }
                    break;
                }
                case 3: {
                    riwayatFilm.tampilkanRiwayat();
                    break;
                }
                case 4:
                    System.out.println("Keluar dari program. Terima kasih dan Sampai Jumpa Lagi");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (pilihan != 4);

        scanner.close();
    }
}
