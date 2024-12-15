public class LinkedList {
    Node head;

    void tambahFilm(String namaFilm, int durasi, String namaBioskop) {
        Node baru = new Node(namaFilm, durasi, namaBioskop);
        if(head == null) {
            head = baru;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(baru);
        }
    }

    void tampilkanFilm() {
        if (head == null) {
            System.out.println("Tidak ada film dalam daftar");
            return;
        }
        Node temp = head;
        System.out.println("Daftar Film yang Sedang Tayang:");
        while (temp != null) {
            System.out.println("- " + temp.getNamaFilm() + " (" + temp.getDurasi() + " menit) - " + temp.getNamaBioskop());
            temp = temp.getNext();
        }
    }
}