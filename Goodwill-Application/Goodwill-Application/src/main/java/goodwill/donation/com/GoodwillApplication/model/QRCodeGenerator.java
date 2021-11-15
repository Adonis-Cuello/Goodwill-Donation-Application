package goodwill.donation.com.GoodwillApplication.model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;

public class QrCode {


    public static void generateQrCode(String text, int width, int height, String filePath){
            throws WriterException, IOException {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = new BitMatrix(text, BarcodeFormat.QR_CODE, width, height);
        }


    }
}
