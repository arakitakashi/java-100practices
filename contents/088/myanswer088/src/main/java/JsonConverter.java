import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Scanner;

import static org.apache.commons.lang3.StringUtils.*;

public class JsonConverter {
    public static void convertAndPrint(String[] args) {
        try {
            switch (args[0]) {
                case "-s" -> {
                    String json = convertToJson(args);
                    System.out.println(json);
                }
                case "-d" -> {
                    Item item = convertToObject(args);
                    System.out.println(item);
                }
                default -> printUsageAndExit();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("入力内容が不正です。");
            printUsageAndExit();
        } catch (JsonSyntaxException e) {
            System.err.println("入力されたJSON文字列が不正です。");
            System.err.println("構文及び改行が存在していないか確認してください。");
            printUsageAndExit();
        }
    }

    private static Item convertToObject(String[] args) {
        if (args.length != 1 ) throw new IllegalArgumentException("入力項目数が不正です。");

        System.out.print("JSON形式の文字列(改行なし)を入力してください：");
        Scanner scanner = new Scanner(System.in);
        String inputJson = scanner.nextLine();

        Gson gson = new Gson();

        return gson.fromJson(inputJson, Item.class);
    }

    private static String convertToJson(String[] args) {
        if (args.length < 3 || args.length > 4) throw new IllegalArgumentException("入力項目数が不正です。");
        if (!isNumeric(args[1])) throw new IllegalArgumentException("Ageの値が不正です。");

        Item item = args.length == 2
                ? Item.newInstance(Long.valueOf(args[1]), args[2])
                : Item.newInstanceWithDescription(Long.valueOf(args[1]), args[2], args[3]);

        Gson gson = new Gson();

        return gson.toJson(item);
    }

    private static void printUsageAndExit() {
        System.err.println("Usage: ");
        System.err.println("  For serialization: -s <age> <name> [description]");
        System.err.println("  For deserialization: -d (followed by JSON input)");
        System.exit(2);
    }
}
