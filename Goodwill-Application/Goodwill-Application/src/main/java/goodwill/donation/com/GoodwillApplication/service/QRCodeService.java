package goodwill.donation.com.GoodwillApplication.service;

public interface QRCodeService {
    byte[] generate(String text, int width, int height);
}
