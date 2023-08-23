package careiopack;

public class Xls_reader 

	import java.awt.Color;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.util.HashMap;
	import javax.swing.RowFilter;
	import org.apache.poi.hslf.model.Sheet;
	import org.apache.poi.hssf.model.Workbook;
	import org.apache.poi.hssf.record.formula.SheetNameFormatter;
	import org.apache.poi.hssf.record.formula.functions.Row;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.eventusermodel.XSSFBReader;

import com.google.common.collect.Table.Cell;

		private FileInputStream fis;
		private FileOutputStream fileOut;
		private org.apache.poi.ss.usermodel.Workbook wb;
		private int sh;
		private Cell cell;
		private Row row;
		private CellStyle cellStyle;
		private Color myColor;
		private String excelfilepathString;
		private HashMap<String, Integer> columns = new HashMap<>();
		
		public void setExcelfile(String Excelpath,String SheetName)throws Exception{
			
			try {
				Xls_Reader reader  =new XSSFBReader();
				wb=WorkbookFactory.create(fis);
				sh = wb.getSheetIndex(SheetName);
				
			}

			
		}
	}

	
}
