import java.util.Base64;

public class HashValidator {
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
