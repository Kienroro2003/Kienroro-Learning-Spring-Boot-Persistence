package com.bookstore;

import com.bookstore.entity.BookReview;
import static com.bookstore.entity.ReviewStatus.CHECK;
import com.bookstore.service.BookstoreService;
import java.util.logging.Logger;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MainApplication {

    private static final Logger logger = Logger.getLogger(MainApplication.class.getName());

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {

            bookstoreService.insertBook();

            BookReview bookReview = new BookReview();
            bookReview.setContent("Very good book!");
            bookReview.setEmail("marinv@gmail.com");
            bookReview.setStatus(CHECK);
//            BookReview bookReview2 = new BookReview();
//            bookReview2.setContent("Good book!");
//            bookReview2.setEmail("kienroro@gmail.com");
//            bookReview2.setStatus(CHECK);

            String response = bookstoreService.postReview(bookReview);
//            String response2 = bookstoreService.postReview(bookReview2);
            logger.info(() -> "Response: " + response);
        };
    }
}
