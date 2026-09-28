package org.festpass.festpass.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

    @GetMapping(value = "/{code}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQR(@PathVariable String code) throws Exception {

        BitMatrix matrix = new MultiFormatWriter().encode(
                code,
                BarcodeFormat.QR_CODE,
                300,
                300
        );

        BufferedImage image = new BufferedImage(
                300,
                300,
                BufferedImage.TYPE_INT_RGB
        );

        for (int x = 0; x < 300; x++) {
            for (int y = 0; y < 300; y++) {
                image.setRGB(
                        x,
                        y,
                        matrix.get(x, y) ? 0x000000 : 0xFFFFFF
                );
            }
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        ImageIO.write(image, "PNG", output);

        return output.toByteArray();
    }
}