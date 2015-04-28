package date.view;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import date.Main;

public class DateController {

	@SuppressWarnings("unused")
	private Main main;

	@FXML
	private ComboBox<String> boxMonth;
	@FXML 
	private ComboBox<String> boxDay;
	@FXML
	private ComboBox<String> boxYear;

	private Calendar cal = Calendar.getInstance();
	private ObservableList<String> full31 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
	private ObservableList<String> full30 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30");
	private ObservableList<String> short29 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29");
	private ObservableList<String> short28 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28");
	private ObservableList<String> months = FXCollections.observableArrayList("Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec");
	private ObservableList<String> years = FXCollections.observableArrayList("2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020");


	public void setMain(Main m) {
		main = m;	
	}

	public DateController() {
	}

	@FXML
	public void initialize() {
		boxMonth.setItems(months);
		boxMonth.setValue(monthSwitch(1+cal.get(Calendar.MONTH)));
		boxYear.setItems(years);
		boxYear.setValue(""+cal.get(Calendar.YEAR));
		getMonth();
		getYear();
		boxDay.setValue(""+cal.get(Calendar.DATE));
	}
	
	@FXML
	private void getMonth() {
		if(boxMonth.getValue().equals("Jan")||boxMonth.getValue().equals("Mar")||boxMonth.getValue().equals("May") ||boxMonth.getValue().equals("July") ||boxMonth.getValue().equals("Aug") || boxMonth.getValue().equals("Oct") ||boxMonth.getValue().equals("Dec")) {
			boxDay.setItems(full31);
		}
		else if(boxMonth.getValue().equals("Sep") || boxMonth.getValue().equals("Apr") || boxMonth.getValue().equals("June") ||boxMonth.getValue().equals("Nov")) {
			boxDay.setItems(full30);
		}
		else {
			getLeapYear(); //feb
		}
	}

	private void getLeapYear() {
		if(boxYear.getValue().equals("2012") || boxYear.getValue().equals("2016") ||boxYear.getValue().equals("2020")) {
			boxDay.setItems(short29);
		} else boxDay.setItems(short28);
	}

	@FXML
	private void getYear() {
		if(boxMonth.getValue().equals("Feb")) {
			getLeapYear();
		}
	}

	private String monthSwitch(int month) {
		switch (month) {
		case 1:  return "Jan";
		case 2:  return "Feb";
		case 3:  return "Mar";
		case 4:  return "Apr";
		case 5:  return "May";
		case 6:  return "June";
		case 7:  return "July";
		case 8:  return "Aug";
		case 9:  return "Sep";
		case 10: return "Oct";
		case 11: return "Nov";
		case 12: return "Dec";
		}
		return null;
	}
}
