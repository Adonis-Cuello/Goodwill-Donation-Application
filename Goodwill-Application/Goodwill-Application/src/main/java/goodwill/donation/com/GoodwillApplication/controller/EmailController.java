package goodwill.donation.com.GoodwillApplication.controller;

import goodwill.donation.com.GoodwillApplication.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/receipt")
public class EmailController {
    @Autowired
    EmailServiceImpl emailService;

    @GetMapping("/sendEmail")
    public String sendEmail() {
        return emailService.sendEmail();
    }

    @GetMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment() {
        return emailService.sendEmailWithAttachment();
    }
}
