package qrapi;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import qrapi.rest.Errors;
import qrapi.rest.MediaTypeEnum;
import qrapi.validator.Groups;
import qrapi.validator.ImageSize;
import qrapi.validator.ValidCorrectionEnum;
import qrapi.validator.ValidMediaTypeEnum;

import javax.imageio.ImageIO;
import jakarta.validation.GroupSequence;
import jakarta.validation.constraints.NotBlank;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Validated
@GroupSequence({Groups.P1.class, Groups.P2.class, Groups.P3.class, QRController.class})
@RestController
@RequestMapping("/api")
public class QRController {

    @Autowired
    private QRService qrService;

    @GetMapping("/qrcode")
    public ResponseEntity<byte[]> getQRCode(
            @ImageSize(groups = Groups.P2.class)
            @RequestParam(required = false, name = "size", defaultValue = "250")
            Integer size,
            @ValidMediaTypeEnum
            @RequestParam(required = false, name = "type", defaultValue = "png")
            String typeName,
            @NotBlank(groups = Groups.P1.class, message = Errors.INVALID_CONTENTS)
            @RequestParam(required = false, name = "contents")
            String contents,
            @ValidCorrectionEnum(groups = Groups.P3.class)
            @RequestParam(required = false, name = "correction", defaultValue = "L")
            String correction

    ) throws IOException {
        var bufferedImage = qrService.generateQRCode(contents.trim(), size, ErrorCorrectionLevel.valueOf(correction));
        var baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, typeName, baos);
        byte[] bytes = baos.toByteArray();
        return ResponseEntity
                .ok()
                .contentType(MediaTypeEnum.valueOf(typeName).getType())
                .body(bytes);
    }

    @GetMapping("/health")
    public ResponseEntity<Object> healthCheck() {
        return ResponseEntity.ok().build();
    }
}
