public class Searching {
    public static int sequentialSearch(String[] films, String searchTitle) {
        for (int i = 0; i < films.length; i++) {
            if (films[i].equalsIgnoreCase(searchTitle)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(String[] films, String searchTitle) {
        int left = 0;
        int right = films.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = films[mid].compareToIgnoreCase(searchTitle);

            if (comparison == 0) {
                return mid;
            }
            if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void tampilkanFilm(String[] films) {
        System.out.println("Daftar Film:");
        for (int i = 0; i < films.length; i++) {
            System.out.println((i+1) + ". " + films[i]);
        }
    }
}