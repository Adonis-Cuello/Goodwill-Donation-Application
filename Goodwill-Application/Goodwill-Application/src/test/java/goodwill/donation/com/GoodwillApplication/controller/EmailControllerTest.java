package goodwill.donation.com.GoodwillApplication.controller;

import goodwill.donation.com.GoodwillApplication.service.EmailServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class EmailControllerTest {

    @MockBean
    EmailServiceImpl emailService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JavaMailSender inputJavaMailSender;

    @BeforeEach
    public void setUp() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("adonisac2002@gmail.com");
        message.setTo("adonisac2002@gmail.com");
        message.setSubject("Receipt");
        message.setText("thank you for donating here is your receipt");

        inputJavaMailSender.send(message);
    }

    @Test
    void sendEmail() {
        String userEmail = "adonisac2002@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("adonisac2002@gmail.com");
        message.setTo(userEmail);
        message.setSubject("Receipt");
        message.setText("thank you for donating here is your receipt");


        String expected = "Mail sent successfully";

        String actual = emailService.sendEmail();

        Assertions.assertEquals(expected,actual);



    }

    @Test
    void sendEmailWithAttachment() {
    }
}