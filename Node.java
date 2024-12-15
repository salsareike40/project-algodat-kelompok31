public class Node {
    private String namaFilm;
    private int durasi;
    private String namaBioskop;
    private Node next;

    public Node(String namaFilm, int durasi, String namaBioskop) {
        this.namaFilm = namaFilm;
        this.durasi = durasi;
        this.namaBioskop = namaBioskop;
        this.next = null;
    }

    public String getNamaFilm() {
        return namaFilm;
    }

    public void setNamaFilm(String namaFilm) {
        this.namaFilm = namaFilm;
    }

    public int getDurasi() {
        return durasi;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public String getNamaBioskop() {
        return namaBioskop;
    }

    public void setNamaBioskop(String namaBioskop) {
        this.namaBioskop = namaBioskop;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}