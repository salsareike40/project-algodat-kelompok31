public class List {
    node head;

    void tambahFilm(String namaFilm, int durasi, String namaBioskop) {
        node baru = new node(namaFilm, durasi, namaBioskop);
        if(head == null) {
            head = baru;
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
    }

    void tampilkanFilm() {
        if (head == null) {
            System.out.println("Tidak ada film dalam daftar");
            return;
        }
        node temp = head;
        System.out.println("Daftar Film yang Sedang Tayang:");
        while (temp != null) {
            System.out.println("- " + temp.namaFilm + " (" + temp.durasi + " menit) - " + temp.namaBioskop);
            temp = temp.next;
        }
    }
}