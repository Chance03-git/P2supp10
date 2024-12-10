import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

    /**
     * Enum to define valid hash algorithms.
     */
    public enum HashAlgorithm {
        MD5,      // MD5 hash algorithm
        SHA1,     // SHA-1 hash algorithm
        SHA256    // SHA-256 hash algorithm
    }
    public static String hashString(String input, HashAlgorithm algorithm) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;

        // Select the hash algorithm based on the enum value
        switch (algorithm) {
            case MD5:
                messageDigest = MessageDigest.getInstance("MD5");
                break;
            case SHA1:
                messageDigest = MessageDigest.getInstance("SHA-1");
                break;
            case SHA256:
                messageDigest = MessageDigest.getInstance("SHA-256");
                break;
            default:
                throw new IllegalArgumentException("Unsupported hash algorithm: " + algorithm);
        }
         // Hash the input string
        byte[] hashBytes = messageDigest.digest(input.getBytes());

        // Convert the hash bytes to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        return hexString.toString();
    }
    public static void main(String[] args) {
        try {
            // Example usage of the hash function
            String input = "Hello, World!";
            
            // Hash using MD5
            System.out.println("MD5: " + hashString(input, HashAlgorithm.MD5));

            // Hash using SHA-1
            System.out.println("SHA-1: " + hashString(input, HashAlgorithm.SHA1));

            // Hash using SHA-256
            System.out.println("SHA-256: " + hashString(input, HashAlgorithm.SHA256));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }


    public static class HashUtilTest {

    @Test
    public void testHashing() throws NoSuchAlgorithmException {
        String input = "Hello, World!";

        // Test MD5 hashing
        String md5Hash = HashUtil.hashString(input, HashAlgorithm.MD5);
        assertNotNull(md5Hash);
        assertEquals("fc3ff98e8c6a0d3087d515c0473f8677", md5Hash);

        // Test SHA-1 hashing
        String sha1Hash = HashUtil.hashString(input, HashAlgorithm.SHA1);
        assertNotNull(sha1Hash);
        assertEquals("2ef7bde608ce5404e97d5f042f95f89f1c232871", sha1Hash);

        // Test SHA-256 hashing
        String sha256Hash = HashUtil.hashString(input, HashAlgorithm.SHA256);
        assertNotNull(sha256Hash);
        assertEquals("a591a6d40bf420404a011733cfb7b190d62c65bf0bcda9e59b3db9d23d3c86dd", sha256Hash);
    }
}