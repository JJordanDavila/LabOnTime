package pe.edu.upc.labontime.network;

public class ClearbitLogoService {

    public static String LOGO_BASE_URL = "https://logo.clearbit.com/";
    public static String SMALL_SIZE = "128";
    public static String MEDIUM_SIZE = "256";
    public static String LARGE_SIZE = "512";

    public static String getUrlToSmallLogoFor(String domain) {
        return getUrlToLogoFor(domain, SMALL_SIZE);
    }

    public static String getUrlToMediumLogoFor(String domain) {
        return getUrlToLogoFor(domain, MEDIUM_SIZE);
    }

    public static String getUrlToLargeLogoFor(String domain) {
        return getUrlToLogoFor(domain, LARGE_SIZE);
    }
    private static String getUrlToLogoFor(String domain, String size) {
        return LOGO_BASE_URL + domain + "?size=" + size;
    }

}
