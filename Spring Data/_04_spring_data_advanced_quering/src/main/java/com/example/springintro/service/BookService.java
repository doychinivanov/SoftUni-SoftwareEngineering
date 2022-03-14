package com.example.springintro.service;

import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookSummary;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllTitlesByAgeRestriction(String ageRestriction);

    List<String> findTitlesByEditionAndCopies(EditionType type, int copiesAmount);

    List<Book> findByPriceNowBetween(int lowerPriceBorder, int upperPriceBorder);

    List<Book> findNotReleasedIn(int year);

    List<Book> findReleasedBefore(String date);

    List<Book> findByTitleContaining(String partOfTitle);

    List<Book> findByAuthorLastNameStartingWith(String lastNameStart);

    int findCountByTitleLongerThan(int length);

    BookSummary getSummaryForTitle(String title);
}
