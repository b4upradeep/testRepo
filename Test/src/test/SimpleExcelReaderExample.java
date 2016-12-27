package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SimpleExcelReaderExample {
	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
	
	public List<Student> readBooksFromExcelFile(String excelFilePath) throws IOException {
	    List<Student> listBooks = new ArrayList<>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workbook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	    Row nextRow = iterator.next();
	    while (iterator.hasNext()) {
	        nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        Student studentObject = new Student();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
	            case 0:
	            	studentObject.setName((String)getCellValue(nextCell));
	                break;
	            case 1:
	            	studentObject.setMarks((int)Double.parseDouble(String.valueOf(getCellValue(nextCell))));
	                break;
	            }
	 
	 
	        }
	        listBooks.add(studentObject);
	    }
	 
	    workbook.close();
	    inputStream.close();
	 
	    return listBooks;
	}
	public static void main(String[] args) throws IOException {
        String excelFilePath = "D:\\test.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
       SimpleExcelReaderExample reader = new SimpleExcelReaderExample();
       List<Student> listBooks = reader.readBooksFromExcelFile(excelFilePath);
       System.out.println(listBooks.get(0).getName() + " " +listBooks.get(0).getMarks());
//        Workbook workbook = new XSSFWorkbook(inputStream);
//        Sheet firstSheet = workbook.getSheetAt(0);
//        Iterator<Row> iterator = firstSheet.iterator();
//         
//        while (iterator.hasNext()) {
//            Row nextRow = iterator.next();
//            Iterator<Cell> cellIterator = nextRow.cellIterator();
//             
//            while (cellIterator.hasNext()) {
//                Cell cell = cellIterator.next();
//                 
//                switch (cell.getCellType()) {
//                    case Cell.CELL_TYPE_STRING:
//                        System.out.print(cell.getStringCellValue());
//                        break;
//                    case Cell.CELL_TYPE_BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue());
//                        break;
//                    case Cell.CELL_TYPE_NUMERIC:
//                        System.out.print(cell.getNumericCellValue());
//                        break;
//                }
//                System.out.print(" - ");
//            }
//            System.out.println();
//        }
//         
//        workbook.close();
//        inputStream.close();
    }
}
