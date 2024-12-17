public class BinarySearch {
    private final Film[] films;
    private int size;
    
    public BinarySearch(int capacity) {
        films = new Film[capacity];
        size = 0;
    }
    
    public void addFilm(String title, int duration) {
        films[size++] = new Film(title, duration);
    }
    
    public void sortByDuration() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (films[j].getDuration() > films[j + 1].getDuration()) {
                    Film temp = films[j];
                    films[j] = films[j + 1];
                    films[j + 1] = temp;
                }
            }
        }
    }
    
    public int searchFilm(String title) {
        int left = 0;
        int right = size - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = films[mid].getTitle().compareTo(title);
            
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
    
    private class Film {
        private final String title;
        private final int duration;
        
        public Film(String title, int duration) {
            this.title = title;
            this.duration = duration;
        }
        
        public String getTitle() {
            return title;
        }
        
        public int getDuration() {
            return duration;
        }
    }
}