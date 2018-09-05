package br.com.passeio_pago.file_handler.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.passeio_pago.common.exception.ReadingFileException;

@Service
public class SpreadsheetService {

	private FileInputStream handleMultipartFile(MultipartFile file) throws ReadingFileException, IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (file.isEmpty()) {
			throw new ReadingFileException("Filename cannot be empty.");
		}
		if (fileName.contains("..")) {
			throw new ReadingFileException(String.format("Filename contains invalid path sequence %s. Cannot store file with relative path outside current directory.", fileName));
		}
		return (FileInputStream) file.getInputStream();
	}

	public List<Map<String, Object>> readSpreadsheet(MultipartFile file) {
		List<Map<String, Object>> rowsArray = new ArrayList<Map<String, Object>>();
		try {
			FileInputStream excelFile = handleMultipartFile(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = datatypeSheet.iterator();
			int count = 0;
			List<String> titles = new ArrayList<String>();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				Map<String, Object> map;
				while (cellIterator.hasNext()) {
					map = new HashMap<String, Object>();
					Cell cell = cellIterator.next();
					int columnIndex = cell.getColumnIndex();
					if (cell.getCellTypeEnum() == CellType.STRING) {
						String stringCellValue = cell.getStringCellValue();
						if (count == 0) {
							titles.add(stringCellValue);
						} else {
							map.put(titles.get(columnIndex), stringCellValue);
						}
					} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
						double numericCellValue = cell.getNumericCellValue();
						if (count == 0) {
							titles.add(String.valueOf(numericCellValue));
						} else {
							map.put(titles.get(columnIndex), numericCellValue);
						}
					}
					if (count != 0) {
						rowsArray.add(map);
					}
				}
				count++;
			}
			workbook.close();
			excelFile.close();
			return rowsArray;
		} catch (Exception e) {
			throw new ReadingFileException("Badly formed file.");
		}
	}

}
