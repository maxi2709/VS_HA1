package de.kurssystem.mb;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("menueMB")
@RequestScoped

public class MenuMB {

	public String starteEventVw(){
		System.out.println("Anzeigen EventVw");
		return "EVENTVW_MENUE";
	}

	public String starteUserVw(){
		return "USERVW_MENUE";
	}
	
}
