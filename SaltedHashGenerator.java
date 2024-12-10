import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
/**
 * This class provides functionality to generate salted hashes using specified algorithms.
 */

public class SaltedHashGenerator {
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
     * Generates a salted hash of a given input string using the specified algorithm.
     *
     * @param input     The input string to hash.
     * @param salt      The salt to append to the input string before hashing.
     * @param algorithm The hashing algorithm to use.
     * @return The Base64-encoded salted hash.
     * @throws IllegalArgumentException if the hashing algorithm is not supported.
     */
    public static String generateSaltedHash(String input, String salt, HashAlgorithm algorithm) {
        try {
            // Combine the input string and salt
            String saltedInput = input + salt;

            // Get the MessageDigest instance for the specified algorithm
            MessageDigest digest = MessageDigest.getInstance(algorithm.getAlgorithm());

            // Compute the hash of the salted input
            byte[] hashedBytes = digest.digest(saltedInput.getBytes());

            // Encode the hashed bytes to a Base64 string
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("Unsupported hashing algorithm: " + algorithm.getAlgorithm(), e);
        }
    }
    /**
     * Main method for testing the salted hash generator functionality.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Test case
        String input = "password123";
        String salt = "randomSalt";
        HashAlgorithm algorithm = HashAlgorithm.SHA256;

        // Generate a salted hash
        String saltedHash = generateSaltedHash(input, salt, algorithm);

        // Print the result
        System.out.println("Input: " + input);
        System.out.println("Salt: " + salt);
        System.out.println("Algorithm: " + algorithm.getAlgorithm());
        System.out.println("Salted Hash (Base64): " + saltedHash);
    }
}
