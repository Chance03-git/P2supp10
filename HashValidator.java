import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 * This class provides functionality to validate whether a given string matches
 * a specified hash using a given hashing algorithm.
 */
public class HashValidator {
    /**
     * Enum to represent supported hashing algorithms.
     */

    public enum HashAlgorithm {
        MD5("MD5"),
        SHA1("SHA-1"),
        SHA256("SHA-256"),
        SHA512("SHA-512");

        private final String algorithm;

        HashAlgorithm(String algorithm) {
            this.algorithm = algorithm;
        }

        public String getAlgorithm() {
            return algorithm;
        }
    }
    /**
     * Validates whether the hash of a given input string matches the provided hash.
     *
     * @param input     The input string to hash.
     * @param hash      The hash to compare against.
     * @param algorithm The hashing algorithm to use.
     * @return True if the computed hash matches the given hash; otherwise, false.
     * @throws IllegalArgumentException if the hashing algorithm is not supported.
     */
    public static boolean isMatchingHash(String input, String hash, HashAlgorithm algorithm) {
        try {
            // Get the MessageDigest instance for the specified algorithm
            MessageDigest digest = MessageDigest.getInstance(algorithm.getAlgorithm());
            // Compute the hash of the input string
            byte[] hashedBytes = digest.digest(input.getBytes());
            // Encode the hashed bytes to Base64 for comparison
            String computedHash = Base64.getEncoder().encodeToString(hashedBytes);
            // Compare the computed hash with the given hash
            return computedHash.equals(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Unsupported hashing algorithm: " + algorithm.getAlgorithm(), e);
        }
    }

    private static byte[] hexStringToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                                + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }


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
