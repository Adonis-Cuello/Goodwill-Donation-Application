package goodwill.donation.com.GoodwillApplication.service;

import goodwill.donation.com.GoodwillApplication.model.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl {

    @Autowired
    JavaMailSender javaMailSender;
    Form form;

    public String sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("adonisac2002@gmail.com");
        message.setTo("adonisac2002@gmail.com");
        message.setSubject("Receipt");
        message.setText("thank you for donating here is your receipt");

        javaMailSender.send(message);

        return "Mail sent successfully";
    }

    public String sendEmailWithAttachment(){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();

            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

            messageHelper.setFrom("adonisac2002@gmail.com");
            messageHelper.setTo("adonisac2002@gmail.com");
            messageHelper.setSubject("Receipt");
            messageHelper.setText("thank you for donating here is your receipt");

            File file = new File("C:\\Users\\aydon\\hello.txt");

            messageHelper.addAttachment(file.getName(), file);

            javaMailSender.send(message);

            return "Mail sent successfully";
        } catch (Exception e){
            return "Mail sent failed";
        }
    }
}


