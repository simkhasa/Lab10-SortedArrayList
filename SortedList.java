import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int index = binarySearch(value);
        list.add(index, value);
    }

    public int binarySearch(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);

            if (midVal.compareTo(value) < 0) {
                low = mid + 1;
            } else if (midVal.compareTo(value) > 0) {
                high = mid - 1;
            } else {
                return mid; // value found
            }
        }
        return low; // value not found, return insertion point
    }

    public String search(String value) {
        int index = binarySearch(value);
        if (index < list.size() && list.get(index).equals(value)) {
            return " \"" + value + " \"" + " is found at index: " + index;
        } else {
            return " \"" + value + " \"" + " is not found. It would be at index: " + index;
        }
    }

    public ArrayList<String> getList() {
        return list;
    }
}