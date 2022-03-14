package com.example.springintro;

import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

//     _11
//        BookSummary summary = this.bookService.getSummaryForTitle("Things Fall Apart");
//        System.out.println(summary.getTitle() + " " + summary.getEditionType() + " " + summary.getAgeRestriction() + " " + summary.getPrice());

//     _10
//        this.authorService.findWithTotalCopies()
//                .forEach(a -> System.out.printf("%s %s - %d" + System.lineSeparator(), a.getFirstName(), a.getLastName(), a.getTotalCopies()));

//     _09
//        int booksCountWithLongerTitles = this.bookService
//                .findCountByTitleLongerThan(40);
//
//        System.out.printf("There are %d books with longer title than 40 symbols", booksCountWithLongerTitles);

//     _08
//        this.bookService
//                .findByAuthorLastNameStartingWith("gr")
//                .forEach(b -> System.out.printf("%s (%s %s)" + System.lineSeparator(), b.getTitle(), b.getAuthor().getFirstName(), b.getAuthor().getLastName()));

//     _07
//        this.bookService
//                .findByTitleContaining("sK")
//                .forEach(b -> System.out.println(b.getTitle()));

//     _06
//        this.authorService
//                .findByFirstNameEndingWith("dy")
//                .stream()
//                .map(a -> a.getFirstName() + " " + a.getLastName())
//                .forEach(System.out::println);

//     _05
//        this.bookService
//                .findReleasedBefore("12-04-1992")
//                .forEach(b -> System.out.printf("%s %s %.2f" + System.lineSeparator(), b.getTitle(), b.getEditionType(), b.getPrice()));

//      _04
//        this.bookService
//                .findNotReleasedIn(2000)
//                .forEach(b -> System.out.println(b.getTitle()));

//      _03
//        this.bookService
//                .findByPriceNowBetween(5, 40)
//                .forEach(b -> System.out.println(b.getTitle() + " - $" + b.getPrice()));


//      _02
//        this.bookService
//                .findTitlesByEditionAndCopies(EditionType.GOLD, 5000)
//                .forEach(System.out::println);

//      _01
//        this.bookService
//                .findAllTitlesByAgeRestriction("miNor")
//                .forEach(System.out::println);

//        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
