public class FilmStack {
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
    public Node pop() {
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
        int counter = 1; 
        while (temp != null) {
        Node film = temp.film;
        System.out.println(counter + ". " + film.getNamaFilm() + " - " + film.getDurasi() + " menit (" + film.getNamaBioskop() + ")");
        temp = temp.next;
        counter++; 
        }
    }
}