package it.polito.tdp.borders.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jgrapht.Graphs;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.graph.SimpleGraph;
import it.polito.tdp.borders.db.BordersDAO;

public class Model {
	
	private UndirectedGraph<Country, Border> graph ;
	private BordersDAO dao ;
	
	public Model() {
		
		dao = new BordersDAO() ; 
	}

	public void createGraph(int year) {
		graph = new SimpleGraph<>(Border.class) ;
		Graphs.addAllVertices(graph, dao.loadAllCountries()) ; // aggiungi tutti i vertici

		for(Border b : dao.getCountryPairs(year)){
			
			Country c1 = new Country(b.getC1()) ;
			Country c2 = new Country(b.getC2()) ;
			
			if (graph.containsVertex(c1) && graph.containsVertex(c2))
				graph.addEdge(c1, c2) ;
			//System.out.println(b.getC1() + " - " + (new Country(b.getC1())).getStateAbb());
			//System.out.println(b.getC2() + " - " + (new Country(b.getC2())).getStateAbb());
			//Border j = graph.addEdge(new Country(b.getC1()), new Country(b.getC2())) ;
		}
		
		//System.out.println(graph.containsVertex(new Country("ITA")) );
		//System.out.println(graph.containsVertex(new Country("USA")) );
		
	}

	public Set<Country> getCountries() {
		return graph.vertexSet() ; 
	}

	public Map<Country, Integer> getCountryCounts() {
		
		Map<Country, Integer> map = new HashMap<>();
		
		for(Country c : graph.vertexSet()) {
			
			map.put(c, graph.degreeOf(c)) ;
		}
		
		return map;
	}

	public int getNumberOfConnectedComponents() {
		
		ConnectivityInspector connInsp = new ConnectivityInspector(graph) ;
		
		return connInsp.connectedSets().size() ;
		
		// return 0;
	}

}
