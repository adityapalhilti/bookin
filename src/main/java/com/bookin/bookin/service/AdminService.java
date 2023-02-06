package com.bookin.bookin.service;

import com.bookin.bookin.dao.bookRepository;
import com.bookin.bookin.entity.Book;
import com.bookin.bookin.kafka.Producer;
import com.bookin.bookin.requestmodels.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private bookRepository bookRepository1;
    @Autowired
    public AdminService (bookRepository bookRepository1){
        this.bookRepository1=bookRepository1;
    }

    public void increaseBookQuantity(Long bookId) throws Exception {
        Optional<Book> book =bookRepository1.findById(bookId);

        if(!book.isPresent()){
            throw new Exception("Book not found");
        }

        book.get().setCopiesAvailable(book.get().getCopiesAvailable()+1);
        book.get().setCopies(book.get().getCopies()+1);

        bookRepository1.save(book.get());
    }

    public void decreaseBookQuantity(Long bookId) throws Exception{

        Optional<Book> book =bookRepository1.findById(bookId);

        if(!book.isPresent() || book.get().getCopiesAvailable()<=0 || book.get().getCopies()<=0){
            throw new Exception("Book not found or quantity locked");
        }
        book.get().setCopiesAvailable(book.get().getCopiesAvailable()-1);
        book.get().setCopies(book.get().getCopies()-1);

        bookRepository1.save(book.get());
    }



    public void postBook(AddBookRequest addBookRequest){
        Book book = new Book();
        book.setTitle(addBookRequest.getTitle());
        book.setAuthor(addBookRequest.getAuthor());
        book.setDescription(addBookRequest.getDescription());
        book.setCopies(addBookRequest.getCopies());
        book.setCopiesAvailable(addBookRequest.getCopies());
        book.setCategory(addBookRequest.getCategory());
        book.setImg(addBookRequest.getImg());
        bookRepository1.save(book);

    }

    public void deleteBook(Long bookId) throws Exception {

        Optional<Book> book= bookRepository1.findById(bookId);

        if(!book.isPresent()){
            throw new Exception("Book not found");
        }
        bookRepository1.delete(book.get());
    }

}
