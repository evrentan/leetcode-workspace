import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchSuggestionsSystem {
    public static void main(String[] args) {

        Scanner scanner =  new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int count = scanner.nextInt();

        System.out.println("Enter all products: ");
        String[] products = new String[count];
        for (int i = 0; i < count; i++) {
            products[i] = scanner.next();
        }

        System.out.print("Enter search word: ");
        String searchWord = scanner.next();

        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        System.out.println(searchSuggestionsSystem.suggestedProducts(products, searchWord));
    }

    private List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> searchWordList = this.prepareSearchWordList(searchWord);

        List<String> productList = Arrays.stream(products).sorted().toList();

        List<List<String>> suggestedProductList = new ArrayList<>();

        for (String tempSearchWord : searchWordList) {
            int count = 0;
            List<String> tempSuggestedProductList = new ArrayList<>();
            for (String product : productList) {
                if (product.startsWith(tempSearchWord)) {
                    tempSuggestedProductList.add(product);
                    count++;
                }
                if (count == 3) break;
            }

            suggestedProductList.add(tempSuggestedProductList);
        }

        return suggestedProductList;
    }

    private List<String> prepareSearchWordList(String searchWord) {
        int searchWordLength = searchWord.length();

        char[] searchWordCharArray = searchWord.toCharArray();

        List<String> searchWordExtendedList = new ArrayList<>();
        for (int i = 0; i < searchWordLength; i++) {
            char[] tempArray = new char[i + 1];
            for (int j = 0; j <= i; j++) {
                tempArray[j] = searchWordCharArray[j];
            }

            searchWordExtendedList.add(String.valueOf(tempArray));
        }

        return searchWordExtendedList;
    }
}