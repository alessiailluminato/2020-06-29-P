package it.polito.tdp.PremierLeague.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.PremierLeague.db.PremierLeagueDAO;

public class Model {
	
        
		private Graph<Integer, DefaultWeightedEdge> grafo;
		private List<Adiacenza> adiacenze;
		private PremierLeagueDAO dao;
		
		
		
		public Model() {
			this.dao = new PremierLeagueDAO();
		}
		
		public List<Integer> getMesi(){
			return this.dao.getMesi();
		}
		
		public int vertici() {
			return this.grafo.vertexSet().size();
		}
		
		public int archi() {
			return this.grafo.edgeSet().size();
		}

		public List<Adiacenza> getAdiacenze(){
			return this.adiacenze;
		}
		
		public void creaGrafo(Integer minuti,Integer mesi) {
this.grafo = new SimpleWeightedGraph<Integer,DefaultWeightedEdge>(DefaultWeightedEdge.class);
			
			
			
			adiacenze = this.dao.getAdiacenze(minuti,mesi);
			
			for(Adiacenza a : adiacenze) {
				if(!this.grafo.containsVertex(a.getP1()))
					this.grafo.addVertex(a.getP1());
				if(!this.grafo.containsVertex(a.getP2()))
					this.grafo.addVertex(a.getP2());
				if(this.grafo.getEdge(a.getP1(), a.getP2()) == null) {
			Graphs.addEdgeWithVertices(this.grafo, a.getP1(), a.getP2(), a.getPeso());
				}
			}
			
			System.out.println("Grafo creato!");
			System.out.println("# VERTICI: " + this.grafo.vertexSet().size());
			System.out.println("# ARCHI: " + this.grafo.edgeSet().size());
		}
		
		public List<Arco> getArchi(){
			List<Arco> archi = new ArrayList<>();
			int peso=0;
			for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
				if(this.grafo.getEdgeWeight(e)>peso)
				peso+=this.grafo.getEdgeWeight(e);
				}
				
			
			if(peso!=0) {
			for(DefaultWeightedEdge e : this.grafo.edgeSet()) {
				if(this.grafo.getEdgeWeight(e)== peso)
					archi.add(new Arco(this.grafo.getEdgeSource(e),this.grafo.getEdgeTarget(e),(int) this.grafo.getEdgeWeight(e)));
			}
			Collections.sort(archi);
			
		}
			return archi;
}}

	

