import java.util.Base64;

public class HashValidator {
    public static void main(String[] args) {
        // Test case
        String input = "password123";
        String hash = "482c811da5d5b4bc6d497ffa98491e38"; // Hexadecimal MD5 hash of "password123"

        // Convert the hash to Base64 for testing (since the function uses Base64 encoding)
        String base64Hash = Base64.getEncoder().encodeToString(hexStringToBytes(hash));

        // Validate the hash
        boolean result = isMatchingHash(input, base64Hash, HashAlgorithm.MD5);
        System.out.println("Test Case: Does the hash match? " + result);

        // Expected output: Test Case: Does the hash match? true
    }
}
