public class FilmQueue {
    Node head, tail;
    void tambahFilm(String namaFilm, int durasi, String namaBioskop) {
        Node baru = new Node(namaFilm, durasi, namaBioskop);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.setNext(baru);
            tail = baru;
        }
    }
    Node hapusFilm() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = head.getNext();
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
        System.out.println("Antrian Film " + kategori + ":");
        while (temp != null) {
            System.out.println(index++ + ". " + temp.getNamaFilm() + " - " + temp.getDurasi() + " menit (" + temp.getNamaBioskop() + ")");
            temp = temp.getNext();
        }
    }
    String[] getFilmArray() {
        if (head == null) {
            return new String[0];
        }
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        String[] films = new String[count];
        temp = head;
        for (int i = 0; i < count; i++) {
            films[i] = temp.getNamaFilm();
            temp = temp.getNext();
        }
        return films;
    }
    public Node getHead() {
        return head;
    }
}