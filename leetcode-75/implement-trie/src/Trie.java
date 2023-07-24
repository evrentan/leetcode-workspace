import java.util.LinkedList;
import java.util.ListIterator;

public class Trie {

    private LinkedList<String> stringLinkedList;

    public Trie() {
        stringLinkedList = new LinkedList<>();
    }

    public void insert(String word) {
        stringLinkedList.push(word);
    }

    public boolean search(String word) {
        return stringLinkedList.contains(word);
    }

    public boolean startsWith(String prefix) {
        ListIterator<String> listIterator = stringLinkedList.listIterator();

        while (listIterator.hasNext()) {
            if (String.valueOf(listIterator.next()).startsWith(prefix))
                return true;
        }

        return false;
    }
}
