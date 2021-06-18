package ArticleV2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Article> articleStorage = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] articleData = scan.nextLine().split(", ");
            String title = articleData[0];
            String content = articleData[1];
            String author = articleData[2];

            articleStorage.add(new Article(title, content, author));
        }

        String criteria = scan.nextLine();

        if(criteria.equals("title")){
            articleStorage.sort(Comparator.comparing(Article::getTitle));
        } else if (criteria.equals("content")){
            articleStorage.sort(Comparator.comparing(Article::getContent));
        } else if(criteria.equals("author")){
            articleStorage.sort(Comparator.comparing(Article::getAuthor));
        }

        System.out.println(printElements(articleStorage));
    }

    public static String printElements(List<Article> articles){
        String result = "";

        for (Article article: articles) {
            result += String.format("%s - %s: %s\n", article.getTitle(), article.getContent(), article.getAuthor());
        }

        return result;
    }
}
