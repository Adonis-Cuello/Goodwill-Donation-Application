package goodwill.donation.com.GoodwillApplication.controller;

import goodwill.donation.com.GoodwillApplication.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QRCodeController {

    private final int WIDTH = 250;
    private final int HEIGHT = 250;
    private final String QR_TEXT = "Spring Boot REST API to generate QR Code - https://goodwillnne.org/donate/how-to-fill-out-a-goodwill-donation-tax-receipt/";
//    private final String QR_TEXT = "Spring Boot REST API to generate QR Code - http://localhost:3000/";



    @Autowired private QRCodeService qrCodeService;

    @GetMapping("qr-code")
    public ResponseEntity<byte[]> getQrCode() {

        byte[] qrImage = qrCodeService.generate(QR_TEXT, WIDTH, HEIGHT);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(qrImage);
    }
}
