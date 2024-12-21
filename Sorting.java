
public class Sorting {

    public class Film {

        private final String title;
        private final int duration;
        private final String cinema;
        private Film next;

        public Film(String title, int duration, String cinema) {
            this.title = title;
            this.duration = duration;
            this.cinema = cinema;
            this.next = null;
        }

        public int getDuration() {
            return duration;
        }

        public String getTitle() {
            return title;
        }

        public String getCinema() {
            return cinema;
        }
    }
    private Film head;

    public void tambahFilm(String title, int duration, String cinema) {
        if (isDuplicate(title)) {
            return;
        }
        Film newFilm = new Film(title, duration, cinema);
        if (head == null) {
            head = newFilm;
        } else {
            Film current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFilm;
        }
    }

    private boolean isDuplicate(String title) {
        Film current = head;
        while (current != null) {
            if (current.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void sortAscending() {
        head = mergeSort(head);
        System.out.println("Urutan Film Berdasarkan Durasi (Terpendek ke Terpanjang):");
        displayList();
    }

    private Film mergeSort(Film head) {
        if (head == null || head.next == null) {
            return head;
        }
        Film middle = getMiddle(head);
        Film nextToMiddle = middle.next;
        middle.next = null;
        Film left = mergeSort(head);
        Film right = mergeSort(nextToMiddle);
        return merge(left, right);
    }

    private Film merge(Film left, Film right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        Film result;
        if (left.getDuration() <= right.getDuration()) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    private Film getMiddle(Film head) {
        if (head == null) {
            return head;
        }
        Film slow = head;
        Film fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayList() {
        Film current = head;
        int counter = 1;
        while (current != null) {
            System.out.println(counter + ". " + current.getTitle() + " - " + current.getDuration() + " menit (" + current.getCinema() + ")");
            current = current.next;
            counter++;
        }
        System.out.println();
    }
}
