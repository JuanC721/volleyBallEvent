package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Participant;


public class VoleibolEvent {

	public VoleibolEvent() {
		//this.newOnes = new ArrayList<Participant>();
	}
	
	private Participant root;
	private Participant first;
	
	private Participant countryRoot;
	//private ArrayList<Participant> newOnes;
	
	public void loadParticipants(String path, String step) throws IOException{
		File file = new File(path);
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String line = br.readLine();
		line = br.readLine();
		int cont = 0;
		while(line != null){
			String[] temporalDataArray = line.split(step);
			Participant temporalNewParticipant = new Participant(Integer.parseInt(temporalDataArray[0]), temporalDataArray[1],temporalDataArray[2],temporalDataArray[3],temporalDataArray[4],temporalDataArray[6]);
			addParticipant(temporalNewParticipant);
			line = br.readLine();
			if(cont<499) {
				addingOficialParticipants(temporalNewParticipant);
			}
			cont++;
		}
		fileReader.close();
		br.close();
	}
	public List<Participant> preOrder(){
		return preOrder(root);
	}
	private List<Participant> preOrder(Participant currentNode){
		List<Participant> l = new ArrayList<>();
		if(currentNode != null){
			l.add(currentNode);
			List<Participant> ll = preOrder(currentNode.getLeft());
			List<Participant> lr = preOrder(currentNode.getRigth());
			//System.out.println(ll);
			//System.out.println(lr);
			l.addAll(ll);
			l.addAll(lr);
		}
		return l;
	}
	
	public void addParticipant(Participant part) {
		addParticipant(part, root);
	}
	
	public void addParticipant(Participant part, Participant current) {
		if(root == null){
			root = part;
		}
		else {
			System.out.println(current.getId());

			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					
					addParticipant(part, current.getLeft());
				}
			}else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addParticipant(part, current.getRigth());
				}
			}
			
		}
	}
	public Participant searching(int id) {
		Participant search = new Participant(id,"","","","","");
		Participant current = root;
		boolean flag = true;
		if(current != null && flag) {
			if(search.compareTo(current)>0){
				System.out.println(current.getFirstName());
				current = current.getRigth();
			}else if(search.compareTo(current)<0) {
				current = current.getLeft();
			}else {
				search = current;
				flag = !flag;
			}
		}
		return search;
	}
	public void addingOficialParticipants(Participant newOne){
		if(first == null){
			first = newOne;
		}else{
			Participant current = first;
			while(current.getNext() != null){
				current = current.getNext();
//				C:\Users\johan\eclipse-workspace\voleibolEvent-bst-linkedList\data\MOCK_DATA (2).csv
			}
			current.setNext(newOne);
			Participant temp = current;
			current = current.getNext();
			current.setPreovious(temp);
		}
	}
	public void print(){
		Participant current = first;
		while(current != null) {
			current = current.getNext();
//			System.out.println(current.getFirstName());
		}
	
	}
	public Participant searchInBTS(int id){
		Participant newOne= new Participant(id,"","","","","");
		return searchInBTS(root,newOne);
	}
	public Participant searchingParticipants(int id) throws NullPointerException{
		Participant search = new Participant(id,"","","","","");
		Participant current = first;
		while(current != null){
			if(current.getId()==id) {
				search = current;
			}
			current = current.getNext();
		}
		return search;
	}
	private Participant searchInBTS(Participant current, Participant newOne) {
		if(current!=null) {
			if(newOne.compareTo(current)<0) {
				if(current.getLeft()!=null){
					return searchInBTS(current.getLeft(),newOne);
				}else {
					return searchInBTS(current.getRigth(), newOne);
				}
			}else if(newOne.compareTo(current)>0){
				if(current.getRigth()!=null) {
					return searchInBTS(current.getRigth(), newOne);
				}else {
					return searchInBTS(current.getLeft(), newOne);
				}
			}else {
				return current;
			}
		}
		return current;
	}
	public void findTeamCountry(String country) {
		Participant current = first;
		while(current.getNext() != null) {
			
			if(current.getCountry().equalsIgnoreCase(country)) {
				addParticipantCountry(current);
				System.out.println(current.getCountry());
			}else {
			current = current.getNext();
			}
		}
	}
	public void addParticipantCountry(Participant part) {
		addParticipant(part, countryRoot);
	}
	public void addParticipantCountry(Participant part, Participant current) {
		if(countryRoot == null){
			countryRoot = part;
		}
		else {
			if(part.compareTo(current) <= 0) {
				if(current.getLeft() == null) {
					current.setLeft(part);
				}else{
					addParticipant(part, current.getLeft());
				}
			}else{
				if(current.getRigth() == null) {
					current.setRigth(part);
				} else {
					addParticipant(part, current.getRigth());
				}
			}
			
		}
	}
}