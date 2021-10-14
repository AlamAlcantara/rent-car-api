/**
 * 
 */
package com.example.rentcar.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.rentcar.entities.Employee;
import com.example.rentcar.entities.Inspection;
import com.example.rentcar.entities.Rent;
import com.example.rentcar.entities.Vehicle;



/**
 * @author alamalcantara
 *
 */
@Service("reportService")
public class ReportService {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private InspectionService inspectionService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private VehicleService vehicleService;
	
	
	public Resource generateReport() {
		//Workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		this.addRentsSheet(workbook);
		this.addInspectionsSheet(workbook);
		this.addEmployeesSheet(workbook);
		this.addVehiclesSheet(workbook);
  
        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out;
		try {
			
			String tDir = System.getProperty("java.io.tmpdir");
				
			File fileToRetrieve = new File(tDir, "rent-car-report.xlsx");
			
			out = new FileOutputStream(fileToRetrieve);
			
			workbook.write(out);
	        out.close();
	        
	     
//			FileCopyUtils.copy(workbook., new FileOutputStream(fileToRetrieve));
			return new FileSystemResource(fileToRetrieve);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ha ocurrido un error generando reporte");
		}
			
	}
	
	public void addRentsSheet(XSSFWorkbook workbook) {
		List<Rent> rents = rentService.getAll();
		XSSFSheet sheet = workbook.createSheet("Rentas");
		sheet.setDefaultColumnWidth(32);

		
		Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();
		
		String[] headers = {"Vehiculo", "Cliente", "Empleado", "Fecha Inicio", "Fecha Fin", "Estado"};
		
		sheetData.put("1", headers);
		
		int counter = 2;
		
		for(Rent r : rents) {
			sheetData.put(String.valueOf(counter), 
					new Object[] {
							r.getVehicle().getBrand().getDescription() + " " + r.getVehicle().getLicensePlate(),
								r.getCustomer().getName(),
								r.getEmployee().getName(),
								r.getStartDate().toString(),
								r.getEndDate().toString(),
								r.getState().toString()
								});
				
				counter++;
			}
			
		    Set<String> keyid = sheetData.keySet();
		    
		    this.addRows(keyid, sheet, sheetData);
		
	}
	
	public void addInspectionsSheet(XSSFWorkbook workbook) {
		List<Inspection> inspections = inspectionService.getAll();
		XSSFSheet sheet = workbook.createSheet("Inspecciones");
		sheet.setDefaultColumnWidth(32);
		
		Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();
		
		String[] headers = {"Vehiculo", "Cliente", "Empleado", "Fecha", "Tipo"};
		
		sheetData.put("1", headers);
		
		int counter = 2;
		
		for(Inspection i : inspections) {
			sheetData.put(String.valueOf(counter), 
					new Object[] {
							i.getVehicle().getBrand().getDescription() + " " + i.getVehicle().getLicensePlate(),
								i.getCustomer().getName(),
								i.getEmployee().getName(),
								i.getInspectionDate().toString(),
								i.getInspectionType().toString()
								});
				
				counter++;
			}
			
		    Set<String> keyid = sheetData.keySet();
		      
		    this.addRows(keyid, sheet, sheetData);
		
	}
	
	public void addEmployeesSheet(XSSFWorkbook workbook) {
		List<Employee> employees = employeeService.getAll();
		XSSFSheet sheet = workbook.createSheet("Empleados");
		sheet.setDefaultColumnWidth(32);
		
		Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();
		
		String[] headers = {"Nombre", "Cedula", "Tanda", "Fecha de Entrada", "Comision", "Inspecciones realizadas", "Rentas realizadas", "Estado"};
		
		sheetData.put("1", headers);
		
		int counter = 2;
		
		for(Employee e : employees) {
			sheetData.put(String.valueOf(counter), 
					new Object[] {
							e.getName(),
							e.getPersonalId(),
							e.getWorkShift().getDescription(),
							e.getEntryDate().toString(),
							e.getCommissionPercentage() + "%",
							String.valueOf(e.getInspections().size()),
							String.valueOf(e.getRents().size()),
							e.isActive() ? "ACTIVO" : "INACTIVO"
					});
				
				counter++;
			}
			
		    Set<String> keyid = sheetData.keySet();
		      
		    this.addRows(keyid, sheet, sheetData);
		
	}
	
	public void addVehiclesSheet(XSSFWorkbook workbook) {
		List<Vehicle> vehicles = vehicleService.getAll();
		XSSFSheet sheet = workbook.createSheet("Vehiculos");
		sheet.setDefaultColumnWidth(32);
		
		Map<String, Object[]> sheetData = new TreeMap<String, Object[]>();
		
		String[] headers = {"Marca", "Modelo", "Tipo de Combustible","Chasis", 
				"No. Motor", "Placa", "Cantidad de rentas", "Cantidad de inspecciones"};
		
		sheetData.put("1", headers);
		
		int counter = 2;
		
		for(Vehicle v : vehicles) {
			sheetData.put(String.valueOf(counter), 
					new Object[] {
							v.getBrand().getDescription(),
							v.getModel().getDescription(),
							v.getFuelType().getDescription(),
							v.getChassisNumber(),
							v.getEngineNumber(),
							v.getLicensePlate(),
							String.valueOf(v.getRents().size()),
							String.valueOf(v.getInspections().size())
					});
				
				counter++;
			}
			
		    Set<String> keyid = sheetData.keySet();
		      
		    this.addRows(keyid, sheet, sheetData);
		
	}
	
	public void addRows(Set<String> keyid, XSSFSheet sheet, Map<String, Object[]> sheetData) {
		//Row
		XSSFRow row;
        int rowid = 0;
  	  
        // writing the data into the sheets...
  
        for (String key : keyid) {
  
            row = sheet.createRow(rowid++);
            Object[] objectArr = sheetData.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                
                Font font = new XSSFFont();
                font.setFontHeightInPoints((short) 20);
                RichTextString text = new XSSFRichTextString((String)obj);
                text.applyFont(font);
               
                
                cell.setCellValue(text);
            }
        }
	}

	
	
}
