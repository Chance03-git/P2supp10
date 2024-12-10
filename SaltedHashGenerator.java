public class SaltedHashGenerator {
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
