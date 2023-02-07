package com.bookin.bookin;

import com.bookin.bookin.dao.bookRepository;
import com.bookin.bookin.entity.Book;
import com.bookin.bookin.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdminServiceTest {

@InjectMocks
AdminService adminService;

@Mock    private bookRepository bookRepository1;

@Test
    void test1() throws Exception {
   Book book=new Book();
   book.setAuthor("abx");
   book.setId(1L);
   //set other
//    when(bookRepository1.findById(1L)).thenReturn(Optional.of(book));
//    adminService.increaseBookQuantity(1L);
//    verify(adminService).increaseBookQuantity(1L);

}
}
