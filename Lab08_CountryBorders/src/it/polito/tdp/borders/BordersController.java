/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {

		try {
			int year = 0 ; 
			
			year = Integer.parseInt(txtAnno.getText() );
			
			if(year < 1816 || year > 2016)
				throw new RuntimeException("Inserisci un anno compreso tra 1816 e 2016. \n") ;
			
			
			txtResult.appendText("Creo il grafo relativo al "+ year+".\n");
			model.createGraph(year);

			Set<Country> countries = model.getCountries();
			txtResult.appendText(String.format("Trovate %d nazioni\n", countries.size()));

			txtResult.appendText(String.format("Numero componenti connesse: %d\n", model.getNumberOfConnectedComponents()) );
			
			Map<Country, Integer> stats = model.getCountryCounts();
			for (Country country : stats.keySet())
				txtResult.appendText(String.format("%s %d\n", country.getStateAbb(), stats.get(country)));
			
			//List<String> allCountries = model.createGraph(year) ;
			
			//txtResult.appendText(String.format("Grafo creato con %d vertici.\n",allWord.size()));

			//inputNumeroLettere.setEditable(false); // così evito errori
			
			txtResult.appendText("_________________________________________________\n");
			
		} catch (RuntimeException re) {
			txtResult.appendText(re.getMessage()+"\n");
		}
		
		
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model) {
		this.model=model ;
	}
}
