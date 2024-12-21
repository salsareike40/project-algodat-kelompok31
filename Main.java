import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilmQueue daftarFilmBioskop = new FilmQueue();
        FilmQueue filmBakalTayang = new FilmQueue();
        FilmStack riwayatFilm = new FilmStack();
        Sorting sorting = new Sorting(); 
        Searching searching = new Searching(); 
        daftarFilmBioskop.tambahFilm("Wicked (2024)", 160, "XXI");
        daftarFilmBioskop.tambahFilm("Moana 2 (2024)", 100, "CGV");
        daftarFilmBioskop.tambahFilm("Mufasa: The Lion King (2024)", 118, "XXI");
        daftarFilmBioskop.tambahFilm("The Marvels (2024)", 105, "Cinepolis");
        daftarFilmBioskop.tambahFilm("Red One (2024)", 123, "CGV");
        daftarFilmBioskop.tambahFilm("Aquaman and the Lost Kingdom (2024)", 144, "Cinepolis");
        daftarFilmBioskop.tambahFilm("Dune: Part Two (2024)", 167, "XXI");
        filmBakalTayang.tambahFilm("Moana 2 (2024)", 100, "CGV");
        filmBakalTayang.tambahFilm("Wicked (2024)", 160, "XXI");
        filmBakalTayang.tambahFilm("Mufasa: The Lion King (2024)", 118, "XXI");
        filmBakalTayang.tambahFilm("Dune: Part Two (2024)", 167, "XXI");
        filmBakalTayang.tambahFilm("Red One (2024)", 123, "CGV");
        filmBakalTayang.tambahFilm("Avengers: Endgame", 181, "Cinepolis");
        filmBakalTayang.tambahFilm("The Marvels (2024)", 105, "Cinepolis");

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            clearScreen();
            System.out.println("\t");
            System.out.println("\t");
            System.out.println("\t ================================");
            System.out.println("\t ||  ~Program Film CinePath~   ||");
            System.out.println("\t ================================");
            System.out.println();
            System.out.println(" ====================================================");
            System.out.println("\t          DAFTAR MENU ");
            System.out.println("\t*--------------------------------*");
            System.out.println("\t| 1. Daftar Film                 |");
            System.out.println("\t| 2. Antrian Film Bakal Tayang   |");
            System.out.println("\t| 3. Riwayat Film                |");
            System.out.println("\t| 4. Urutkan Film                |");
            System.out.println("\t| 5. Cari Film                   |");
            System.out.println("\t| 6. Rute Bioskop                |");
            System.out.println("\t| 7. Keluar                      |");
            System.out.println("\t*--------------------------------*");
            System.out.println(" ====================================================");
            System.out.println();
            System.out.print(" Masukan Pilihan Anda (1-7) : ");

            while (!scanner.hasNextInt()) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                System.out.print(" Masukan Pilihan Anda (1-7) : ");
                scanner.next();
            }

            pilihan = scanner.nextInt();
            System.out.println();

            switch (pilihan) {
                case 1: {
                    clearScreen();
                    daftarFilmBioskop.tampilkanFilm("yang Sedang Tayang");
                    pressEnterToContinue(scanner);
                    break;
                }
                case 2: {
                    clearScreen();
                    filmBakalTayang.tampilkanFilm("yang akan tayang");
                    Node selesaiTayang = filmBakalTayang.hapusFilm();
                    if (selesaiTayang != null) {
                        riwayatFilm.push(selesaiTayang);
                        System.out.println("Film \"" + selesaiTayang.getNamaFilm() + "\" telah selesai tayang dan masuk ke riwayat.");
                    } else {
                        System.out.println("Tidak ada film yang sedang tayang.");
                    }
                    pressEnterToContinue(scanner);
                    break;
                }
                case 3: {
                    clearScreen();
                    riwayatFilm.tampilkanRiwayat();
                    pressEnterToContinue(scanner);
                    break;
                }
                case 4: {
                    clearScreen();
                    sorting.tambahFilm("Wicked (2024)", 160, "XXI");
                    sorting.tambahFilm("Moana 2 (2024)", 100, "CGV");
                    sorting.tambahFilm("Mufasa: The Lion King (2024)", 118, "XXI");
                    sorting.tambahFilm("The Marvels (2024)", 105, "Cinepolis");
                    sorting.tambahFilm("Red One (2024)", 123, "CGV");
                    sorting.tambahFilm("Aquaman and the Lost Kingdom (2024)", 144, "Cinepolis");
                    sorting.tambahFilm("Dune: Part Two (2024)", 167, "XXI");

                    sorting.sortAscending();
                    pressEnterToContinue(scanner);
                    break;
                }
                case 5: {
                    clearScreen();
                    daftarFilmBioskop.tampilkanFilm("yang Tersedia");
                    System.out.print("\nMasukkan judul film yang ingin dicari: ");
                    scanner.nextLine(); // Clear buffer
                    String searchTitle = scanner.nextLine();

                    String[] films = daftarFilmBioskop.getFilmArray();
                    int result = Searching.sequentialSearch(films, searchTitle);

                    if (result != -1) {
                        System.out.println("Film ditemukan pada posisi " + (result + 1));
                    } else {
                        System.out.println("Film tidak ditemukan");
                    }
                    pressEnterToContinue(scanner);
                    break;
                }
                case 6: {
                    Graph graph = new Graph();

                    graph.addVertex("rumah1");
                    graph.addVertex("bioskopB");
                    graph.addVertex("bioskopA");
                    graph.addVertex("bioskopC");
                    graph.addVertex("bioskopD");
                    graph.addVertex("bioskopE");
                    graph.addVertex("bioskopF");
                    graph.addVertex("rumah2");
                    graph.addVertex("rumah3");

                    graph.addEdge("rumah1", "bioskopB", 12);
                    graph.addEdge("rumah1", "bioskopE", 9);
                    graph.addEdge("bioskopB", "bioskopA", 9);
                    graph.addEdge("bioskopB", "bioskopC", 12);
                    graph.addEdge("bioskopA", "rumah3", 5);
                    graph.addEdge("bioskopC", "bioskopD", 6);
                    graph.addEdge("bioskopE", "bioskopF", 15);
                    graph.addEdge("bioskopF", "rumah2", 11);

                    graph.addEdge("rumah2", "bioskopF", 11);
                    graph.addEdge("rumah2", "bioskopD", 9);
                    graph.addEdge("bioskopD", "rumah3", 6);
                    graph.addEdge("bioskopD", "bioskopC", 6);
                    graph.addEdge("rumah3", "bioskopA", 5);
                    graph.addEdge("bioskopF", "bioskopE", 15);
                    graph.addEdge("bioskopC", "bioskopB", 12);
                    graph.addEdge("bioskopE", "rumah1", 9);

                    graph.addEdge("rumah3", "bioskopA", 5);
                    graph.addEdge("rumah3", "bioskopD", 6);
                    graph.addEdge("bioskopD", "rumah2", 9);
                    graph.addEdge("bioskopD", "bioskopC", 6);
                    graph.addEdge("bioskopA", "bioskopB", 9);
                    graph.addEdge("bioskopC", "bioskopF", 9);
                    graph.addEdge("bioskopB", "rumah1", 12);
                    graph.addEdge("rumah1", "bioskopE", 9);

                    String startVertex;

                    while (true) {
                        System.out.print("Pilih simpul awal (rumah1, rumah2, rumah3): ");
                        scanner.nextLine(); // Clear buffer
                        startVertex = scanner.nextLine().trim();

                        if (startVertex.equals("rumah1") || startVertex.equals("rumah2") || startVertex.equals("rumah3")) {
                            break;
                        } else {
                            System.out.println("Input tidak valid. Silakan pilih antara rumah1, rumah2, atau rumah3.");
                        }
                    }

                    graph.dijkstra(startVertex);
                    pressEnterToContinue(scanner);
                    clearScreen();
                    break;
                }
                case 7: {
                    clearScreen();
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    pressEnterToContinue(scanner);
                }
            }

        } while (pilihan != 7);

        scanner.close();
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        }
    }
    private static void pressEnterToContinue(Scanner scanner) {
        System.out.println("\nTekan Enter untuk melanjutkan...");
        scanner.nextLine(); 
        scanner.nextLine(); 
    }
}