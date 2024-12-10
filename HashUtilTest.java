
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