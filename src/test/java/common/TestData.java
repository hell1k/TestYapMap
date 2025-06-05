package common;

import java.util.Random;

public class TestData {
//    public String login = "wexezukecei-4791@yopmail.com";
//    public String login = "pammoukabava-8241@yopmail.com";
    public String login = "pegoulezeddi-9290@yopmail.com";
    public String login2 = "conagriffeumme-2559@yopmail.com";
    public String password = "Qq12345678!";
    public String text_250 = "Social media has revolutionized the way we connect and communicate. With just a few taps on our devices," +
            "we can instantly share our thoughts, photos, and videos with friends and family across the globe. These" +
            "platforms have also expanded our horizons, allowing us to connect with like-minded individuals and" +
            "discover new opportunities. However, it s essential to strike a balance between the benefits and potential" +
            "pitfalls of social media. While it keeps us connected, it can also impact our mental health and privacy." +
            "Ultimately, social media is a powerful tool that can enhance our lives if used wisely.";
    public String text_250_2 = "zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba" +
            " zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba " +
            "zyxwvutsrqponmlkjihgfedcba zyxwvutsrqponmlkjihgfedcba";

    public String text_1000 = "Social media platforms have become ubiquitous in modern society, transforming the way we communicate, " +
            "interact, and consume information. With billions of users worldwide, these platforms serve as virtual arenas where" +
            "individuals, businesses, and communities converge. They offer unprecedented connectivity, enabling people" +
            "to stay in touch with friends and family, share moments of their lives, and engage with content from " +
            "across the globe. However, this interconnectedness also brings forth challenges, including issues of privacy, " +
            "online harassment, and the spread of misinformation. As algorithms tailor content to users preferences, " +
            "echo chambers form, reinforcing pre-existing beliefs and potentially fostering polarization. Moreover, the curated " +
            "nature of social media feeds can contribute to feelings of inadequacy and low self-esteem as individuals compare" +
            "themselves to idealized portrayals. Despite these concerns, social media remains a powerful tool for" +
            "empowerment, activism, and social change. It facilitates the rapid dissemination of information, amplifies" +
            "marginalized voices, and fosters community-building on a global scale. As we navigate the complexities of" +
            "social media, it is imperative to strike a balance between harnessing its potential for connection and" +
            "creativity while mitigating its negative impacts on mental health and society. MORE THEN 1000 SYMBOLS";

    public String text_1000_2 = "A textbook is an informative manual or book on a specific subject, systematically designed to provide" +
            "comprehensive knowledge primarily for educational and instructional purposes." +
            "Textbooks fit squarely within the category of informational texts. They aim to disseminate a reliable," +
            "expansive pool of knowledge on a given topic, systematically dissecting its every aspect. This focus" +
            "on detail-oriented, comprehensive coverage sets them apart from other types of text materials." +
            "Unlike narrative or argumentative texts, textbooks generally lack a personal perspective or bias." +
            "Instead, they prioritize factual, thorough, and well-organized information. A textbook’s primary" +
            "purpose is to aid in teaching or learning, making them a fixture in academic settings." +
            "Real-Life Textbook Example: An example of a prominent textbook is “Gray’s Anatomy”, the go-to" +
            "reference for human anatomy and physiology. Its reputation stems from extensive, medically accurate" +
            "content organized for optimal understanding, complete with diagrams, images, and depth explanations." +
            "This textbook provides vital support for students and professionals in the medical field. 1000 symbols." +
            "More then 1000 symbols.";

    public String name_120 = "Name_120_symbols_jRJDKNd89kLB2K8pE5waql80WXVKVQeS3QCi1U7n9OPwrKi1KAWz4zyg8TYeuzh1d8Hzlv66LXhP4CZl4ziRWy8H7e5gFkXDvUgL_1234567";

    private static final Random random = new Random();

    public static String getFirstName() {
        return "John" + random.nextInt(10000);
    }

    public static int getRandomName() {
        return random.nextInt(10000);
    }

    public static String getLastName() {
        return "Doe" + random.nextInt(10000);
    }

    public static String getNickname() {
        return "nickname" + random.nextInt(99999);
    }

    public static String getRandomNumber(int length) {
        StringBuilder digits = new StringBuilder();
        for (int i = 0; i < length; i++) {
            digits.append(random.nextInt(10)); // генерирует от 0 до 9
        }
        return digits.toString();
    }
}
