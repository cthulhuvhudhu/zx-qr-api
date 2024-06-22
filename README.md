# zx-qr-api
A Java Spring API to generate a QR Code.

This follows the Intro to Spring Java course from HyperSkill:
https://hyperskill.org/projects/385

Technologies used:
- Java 21
- Spring Boot 3.3.1
Utilizes custom validation annotations, groups, and exception handling.

This API generates a QR code.
GET `api/qrcode` accepts the following parameters:
- `size` (int) - the size of the QR code, between 150 and 350 inclusive
- `typeName` (String) - the output media type of the QR code, one of "png", "jpg", or "gif"
- `content` [required] (String) - the content to encode in the QR code. Must not be blank
- `correction` (char) - the error correction level of the QR code, one of 'L', 'M', 'Q', or 'H'