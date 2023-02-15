package com.bookin.bookin.service;

import com.bookin.bookin.GoogleBooksApi.GoogleBooks;
import com.bookin.bookin.GoogleBooksApi.GoogleApiWrapper;
import com.bookin.bookin.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoogleBooksService {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public List<Book> getmodifiedbooks(GoogleBooks googlebooks) {
        List<GoogleApiWrapper> googlebookitems=googlebooks.getItems();

        List<Book> bookslist = new ArrayList<>();
        for (GoogleApiWrapper apiwrapper : googlebookitems){
            Book book=new Book();
            try {
                book.setTitle(apiwrapper.getVolumeInfo().getTitle());
            }
            catch (Exception err){

            }
            try{
                book.setAuthor(apiwrapper.getVolumeInfo().getAuthors().get(0));
            }
            catch (Exception err){

            }
            try{
                book.setDescription(apiwrapper.getVolumeInfo().getDescription());
            }
            catch (Exception err){

            }


            bookslist.add(book);
        }
        return bookslist;
    }
}