package tn.esprit.springboot.kaddem1.util;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tn.esprit.springboot.kaddem1.entity.Projet;

public class ExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Projet> listP;

    public ExcelExporter(List<Projet> listP) {
        this.listP = listP;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Projects");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Project ID", style);
        createCell(row, 1, "Description", style);


    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Projet projet : listP) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, projet.getIdProjet(), style);
            createCell(row, columnCount++, projet.getDescription(), style);

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
