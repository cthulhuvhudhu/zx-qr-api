package qrapi;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import org.springframework.stereotype.Service;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

@Service
public class QRService {
    public BufferedImage generateQRCode(String text, int size, ErrorCorrectionLevel errorLevel) {
        QRCodeWriter writer = new QRCodeWriter();
        try {
            Map<EncodeHintType, ?> hints = Map.of(EncodeHintType.ERROR_CORRECTION, errorLevel);
            BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, size, size, hints);
            return MatrixToImageWriter.toBufferedImage(bitMatrix);
        } catch (WriterException e) {
            System.out.println("Error on generating QR Code: " + e.getMessage());
            return null;
        }
    }

    private BufferedImage generateWhiteSquare(int size) {
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, size, size);
        return image;
    }
}
