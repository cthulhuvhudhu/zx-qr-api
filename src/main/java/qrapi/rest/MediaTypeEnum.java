package qrapi.rest;

import org.springframework.http.MediaType;

public enum MediaTypeEnum {
    png(Constants.PNG),
    jpeg(Constants.JPEG),
    gif(Constants.GIF);

    private final MediaType type;

    MediaTypeEnum(MediaType type) {
        this.type = type;
    }

    public MediaType getType() {
        return type;
    }

    public static class Constants {
        public static final MediaType PNG = MediaType.IMAGE_PNG;
        public static final MediaType JPEG = MediaType.IMAGE_JPEG;
        public static final MediaType GIF = MediaType.IMAGE_GIF;
    }
}
