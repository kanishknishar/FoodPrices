import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public static void main() {
    String prices = """
            Chodi - 180 -- 148
            Moong Dal - 190 -- 149
            Mug - 180 -- 110
            Vatana - 200 -- 120
            Guinea Oil - 265 -- 220
            Postman Oil - 255 -- N/A
            Tal - 340 -- N/A
            Rajma - 200  -- 140
            Chole - 180 -- 131
            Dalia - 240 -- 205
            Matki - 160 -- 112
            Mixed Dal - 180 -- 109
            Masoor Dal - 140 -- 114
            Peanut - 180 -- 131
            Green Chana - 200 -- 232
            Wal - 240 -- N/A
            Poha - 80 -- 52
            Rawo - 60 -- 43
            Reshampati Mirchi - 400 -- N/A
            Kashmiri Mirchi - 80 -- N/A
            Kashmiri Mirchi Powder - 750 -- 400
            Boria Mirchi - 1300 -- N/A
            Liril - 71 -- 52
            Closeup - 98 -- 85.56
            Kharee Singh - 360 -- 166
            Besan Lot - 140 -- N/A
            Maidan Lot - 60 -- N/A
            Girnar - 560 -- 520
            Barik Sev - 500 -- N/A
            Surf Excel Detergent - 240 -- 215
            Mumra (1 packet) - 45 -- 36
            Jeera Khakra (1 packet) - 70 -- 74
            Amul Butter (500gm) - 255 -- 245
            Britannia Cheese (1 packet - 10 pieces) - 145 -- 105
            Vim Bar (300gm) - 29 -- 26
            Surf Excel Bar (250g) - 35 -- 34
            Parachute Hair Cream - 95 -- N/A
            """;

    String regex = "(?<item>.*?)-\\s*(?<retailPrice>\\d+)\\s*--\\s*(?<onlinePrice>(\\d+|N/A))\\s*";
    Pattern pat = Pattern.compile(regex);
    Matcher mat = pat.matcher(prices);
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("English","IN"));
    NumberFormat pf = NumberFormat.getPercentInstance();

    int itemCounter = 1;
    int savings = 0;
    double totalRetailPrice = 0;
    StringBuilder sb = new StringBuilder("Could not compare prices for:\n");

    while (mat.find()) {
        String item = mat.group("item").trim();
        int retailPrice = Integer.parseInt(mat.group("retailPrice"));
        String onlinePriceString = mat.group("onlinePrice");

        if (onlinePriceString.equals("N/A")) {
            sb.append(itemCounter++).append(". ").append(item).append("\n");
            continue;
        }

        int onlinePrice = Integer.parseInt(onlinePriceString);
        double discount = retailPrice - onlinePrice;
        double discountPercentage = discount / retailPrice;

        System.out.printf("%d. Discount on %s is %s - a discount of %s%n", itemCounter++, item, nf.format(discount), pf.format(discountPercentage));

        totalRetailPrice += retailPrice;
        savings += (int) discount;
    }

    System.out.println(STR."Total savings = \{nf.format(savings)}");
    System.out.println(STR."Average discount = \{pf.format(savings / totalRetailPrice)}");
    System.out.println(sb);

}
