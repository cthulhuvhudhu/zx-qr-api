package qrapi.rest;

public class Errors {
    public static final String INVALID_CONTENTS = "Contents cannot be null or blank";
    public static final String INVALID_CORRECTION_TYPE = "Permitted error correction levels are L, M, Q, H";
    public static final String INVALID_IMAGE_TYPE = "Only png, jpeg and gif image types are supported";
    public static final String INVALID_SIZE_MESSAGE = "Image size must be between 150 and 350 pixels";
}
