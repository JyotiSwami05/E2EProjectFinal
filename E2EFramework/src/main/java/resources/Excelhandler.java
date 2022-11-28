package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelhandler extends Base
{
	
	private String username;
	private String password;
	
	private ArrayList<String> usernames = new ArrayList<>();
	private ArrayList<String> passwords = new ArrayList<>();
	
	public void handleExcel() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		String path = getBasePath()+ "\\src\\main\\java\\QAClickTestData\\LoginData.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		
		username = row.getCell(1).toString();
		password = row.getCell(2).toString();
		
		int rowCount = sheet.getLastRowNum();//4
		
		int colCount = row.getLastCellNum() - 1;//2
		System.out.println("rowCount: " + rowCount);
		
		System.out.println("colCount: " + colCount);
		
		Cell cell;
		for(int i=1;i<=rowCount;i++) {
			row = sheet.getRow(i);
			for(int j=1;j<=colCount;j++) {
				cell = row.getCell(j);
				if(j==1) {
					usernames.add(cell.toString());
				}
				else {
					passwords.add(cell.toString());
				}
				System.out.print(cell.toString());
			}
		}
		
		file.close();
		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public ArrayList<String> getUsernames() {
		return usernames;
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}
	
	
}
