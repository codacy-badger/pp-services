package br.com.passeio_pago.file_handler.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.passeio_pago.file_handler.exception.FileStorageException;

@Service
public class SpreadsheetService {

	// private final Path fileStorageLocation;
	//
	// @Autowired
	// public FileStorageService(FileStorageProperties fileStorageProperties) {
	// this.fileStorageLocation =
	// Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
	// try {
	// Files.createDirectories(this.fileStorageLocation);
	// } catch (Exception ex) {
	// throw new FileStorageException("Could not create the directory where the
	// uploaded files will be stored.", ex);
	// }
	// }

	private FileInputStream handleMultipartFile(MultipartFile file) throws FileStorageException, IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (file.isEmpty()) {
			throw new FileStorageException("Filename cannot be empty.");
		}
		if (fileName.contains("..")) {
			throw new FileStorageException(String.format("Filename contains invalid path sequence %s. Cannot store file with relative path outside current directory.", fileName));
		}
		return (FileInputStream) file.getInputStream();
	}

	public void readSpreadsheet(MultipartFile file) {
		try {
			FileInputStream excelFile = handleMultipartFile(file);
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			int count = 1;
			JSONArray jsonArray = new JSONArray();
			
			
			String[] arrayTitle = getArrayTitle(iterator);
			String[][] arrayValues = getArrayValues(iterator);
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				while (cellIterator.hasNext()) {
					Cell currentCell = cellIterator.next();
					if (currentCell.getCellTypeEnum() == CellType.STRING) {
						System.out.print(currentCell.getStringCellValue() + "--");
					} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
						System.out.print(currentCell.getNumericCellValue() + "--");
					}

				}
				System.out.println();
			}
			workbook.close();
			excelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String[][] getArrayValues(Iterator<Row> iterator) {
		List<String> values = new ArrayList<String>();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					System.out.print(currentCell.getStringCellValue() + "--");
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					System.out.print(currentCell.getNumericCellValue() + "--");
				}
			}
			System.out.println();
		}
		return null;
	}

	private String[] getArrayTitle(Iterator<Row> iterator) {
		List<String> titles = new ArrayList<String>();
		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					titles.add(currentCell.getStringCellValue());
				} else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
					titles.add(currentCell.getStringCellValue());
				}
			}
			break;
		}
		return titles.toArray(new String[0]);
	}

	// public Resource loadFileAsResource(String fileName) {
	// try {
	// Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
	// Resource resource = new UrlResource(filePath.toUri());
	// if (resource.exists()) {
	// return resource;
	// } else {
	// throw new MyFileNotFoundException("File not found " + fileName);
	// }
	// } catch (MalformedURLException ex) {
	// throw new MyFileNotFoundException("File not found " + fileName, ex);
	// }
	// }

}
