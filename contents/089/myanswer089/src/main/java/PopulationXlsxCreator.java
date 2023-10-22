import com.opencsv.exceptions.CsvValidationException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.opencsv.CSVReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PopulationXlsxCreator {
    private static final String POPULATION_SHEET_NAME = "人口";
    private static final String CSV_PATH = "/base-data.csv";

    public static void createPopulationXlsx() {
        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fileOut = new FileOutputStream("population.xlsx")) {

            createPopulationSheet(workbook, readPopulationsFromCsv());

            workbook.write(fileOut);
        } catch (IOException e) {
            System.err.println("エラーが発生しました: " + e.getMessage());
        } catch (CsvValidationException e) {
            System.err.println("CSVエラーが発生しました: " + e.getMessage());
        }
    }

    private static Map<String, Integer> readPopulationsFromCsv() throws IOException, CsvValidationException {
        Map<String, Integer> populations = new HashMap<>();

        try (CSVReader reader = new CSVReader(
                new InputStreamReader(
                        Objects.requireNonNull(PopulationXlsxCreator.class.getResourceAsStream(CSV_PATH)),
                        StandardCharsets.UTF_8
                ))
        ) {
            String[] nextLine;
            int lineCounter = 0;

            while ((nextLine = reader.readNext()) != null) {
                lineCounter++;

                // ヘッダ行とその他の無関係な行をスキップ
                if (lineCounter <= 9 || nextLine.length < 3) {
                    continue;
                }

                String prefecture = nextLine[0];

                int population;
                try {
                    population = Integer.parseInt(nextLine[2].replace(",", ""));
                } catch (NumberFormatException e) {
                    continue; // 数値変換に失敗した場合、行をスキップ
                }

                populations.put(prefecture, population);
            }
        }
        return populations;
    }

    private static Sheet createPopulationSheet(Workbook workbook, Map<String, Integer> populations) {
        // 新しいシートの作成
        Sheet sheet = workbook.createSheet(POPULATION_SHEET_NAME);

        // シートにデータを追加する
        populateSheetWithData(sheet, populations);

        // カラム幅の自動調整
        sheet.autoSizeColumn(0);
        return sheet;
    }

    private static void populateSheetWithData(Sheet sheet, Map<String, Integer> populations) {
        CellStyle style = createNumberCellStyle(sheet.getWorkbook());
        int rowIndex = 0;

        // 人口データをシートに追加
        for (Map.Entry<String, Integer> entry : populations.entrySet()) {
            Row row = sheet.createRow(rowIndex++);
            createCellWithData(row, 0, entry.getKey());
            createCellWithStyleAndData(row, 1, entry.getValue(), style);
        }

        // 合計行を追加
        addTotalRow(sheet, rowIndex, style);
    }

    private static CellStyle createNumberCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("#,##0")); // カンマ区切りの指定
        return style;
    }

    private static void createCellWithData(Row row, int cellIndex, Object value) {
        Cell cell = row.createCell(cellIndex);
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
    }

    private static void createCellWithStyleAndData(Row row, int cellIndex, int value, CellStyle style) {
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }

    private static void addTotalRow(Sheet sheet, int rowIndex, CellStyle style) {
        Row totalRow = sheet.createRow(rowIndex);
        createCellWithData(totalRow, 0, "合計");

        Cell totalValueCell = totalRow.createCell(1);
        totalValueCell.setCellFormula("SUM(B1:B" + rowIndex + ")");
        totalValueCell.setCellStyle(style);
    }
}
