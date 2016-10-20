package com.musiccamp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.musiccamp.Exceptions.StorageFileNotFoundException;
import com.musiccamp.entities.Student;
import com.musiccamp.model.StudentDataModel;
import com.musiccamp.repositories.StudentRepository;
import com.musiccamp.services.StorageProperties;
import com.musiccamp.services.StorageService;

/**
 * 
 * @author Pushkar Kumar Kanikicherla & Pavan Kumar Peddavakkalam
 *
 */

@Controller
@EnableConfigurationProperties(StorageProperties.class)
@ComponentScan("com.musiccamp.services")
public class UploadController {
	@Autowired
	StudentRepository studentRepository;

	StudentDataModel sdm = new StudentDataModel();

	private final StorageService storageService;

	StorageProperties stp = new StorageProperties();

	@Autowired
	public UploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	// @RequestMapping("/")
	// public String listUploadedFiles(Model model) throws IOException {
	//
	// model.addAttribute("files", storageService
	// .loadAll()
	// .map(path ->
	// MvcUriComponentsBuilder
	// .fromMethodName(UploadController.class, "serveFile",
	// path.getFileName().toString())
	// .build().toString())
	// .collect(Collectors.toList()));
	//
	// return "uploadForm";
	// }

	// @RequestMapping("/files/{filename:.+}")
	// @ResponseBody
	// public ResponseEntity<Resource> serveFile(@PathVariable String filename)
	// {
	//
	// Resource file = storageService.loadAsResource(filename);
	// return ResponseEntity
	// .ok()
	// .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;
	// filename=\""+file.getFilename()+"\"")
	// .body(file);
	// }

	@RequestMapping(value = "/viewStudentData", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

		storageService.deleteAll();
		storageService.init();
		storageService.store(file);
		redirectAttributes.addFlashAttribute("message",
				"You successfully uploaded " + file.getOriginalFilename() + "!");
		stp.setFilename(file.getOriginalFilename());
		viewStudentData();
		return "viewStudentData";
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

	public String viewStudentData() {

		try {

			FileInputStream file = new FileInputStream(new File(stp.getLocation() + "//" + stp.getFilename()));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			List<Student> students = new ArrayList<>();
			Student student = null;
			boolean isEmptyRow = true;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				isEmptyRow = true;
				student = new Student();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getRowIndex() >= 1) {
						if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
							isEmptyRow = false;
						}
						// Check the cell type and format accordingly
						if (cell.getColumnIndex() == 0) {
							sdm.setStudentName(new ArrayList<String>());
							sdm.getStudentName().add(cell.getStringCellValue());
							student.setSname(String.valueOf(cell.getStringCellValue()));
							System.out.println("Inserted student name: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 1) {
							sdm.setStudentGrade(new ArrayList<Double>());
							sdm.getStudentGrade().add(cell.getNumericCellValue());
							student.setGrade(String.valueOf(cell.getNumericCellValue()));
							System.out.println("Inserted student Grade: " + cell.getNumericCellValue());
						} else if (cell.getColumnIndex() == 2) {
							sdm.setTrack(new ArrayList<String>());
							sdm.getTrack().add(cell.getStringCellValue());
							student.setTrack(cell.getStringCellValue());
							System.out.println("Inserted student track: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 3) {
							sdm.setPrimaryInstrument(new ArrayList<String>());
							sdm.getPrimaryInstrument().add(cell.getStringCellValue());
							student.setPrimaryInstrument(cell.getStringCellValue());
							System.out.println("Inserted student Primary Instrument: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 4) {
							sdm.setSecondaryInstrument(new ArrayList<String>());
							sdm.getSecondaryInstrument().add(cell.getStringCellValue());
							student.setSecondaryInstrument(cell.getStringCellValue());
							System.out.println("Inserted student Secondary Instrument: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 5) {
							sdm.setElective1(new ArrayList<String>());
							sdm.getElective1().add(cell.getStringCellValue());
							student.setElective1(cell.getStringCellValue());
							System.out.println("Inserted student Elective1: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 6) {
							sdm.setElective2(new ArrayList<String>());
							sdm.getElective2().add(cell.getStringCellValue());
							student.setElective2(cell.getStringCellValue());
							System.out.println("Inserted student Elective2: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 7) {
							sdm.setElective3(new ArrayList<String>());
							sdm.getElective3().add(cell.getStringCellValue());
							student.setElective3(cell.getStringCellValue());
							System.out.println("Inserted student Elective3: " + cell.getStringCellValue());
						} else if (cell.getColumnIndex() == 8) {
							sdm.setElective4(new ArrayList<String>());
							sdm.getElective4().add(cell.getStringCellValue());
							student.setElective4(cell.getStringCellValue());
							System.out.println("Inserted student Elective4: " + cell.getStringCellValue());
						}
						student.setStatus("Not Scheduled");
					}
				}
				if (!isEmptyRow) {
					students.add(student);
				}
				System.out.println("*******************");
			}
			// file.close();
			System.out.println(students.size());
			studentRepository.deleteAll();
			studentRepository.save(students);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "viewStudentData";
	}
}
