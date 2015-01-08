package com.primefaces.sample3;

import com.afpa59.patrice.donnees.Client;
import com.afpa59.patrice.service.fichier.ServiceClient;
import com.afpa59.patrice.utils.ES;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

@ManagedBean
@SessionScoped
public class ClientsManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ServiceClient clientService = new ServiceClient();
    
    private String login;
	private String motPasse;
    private String rechercheClient;
    private Collection<Client> rechercheClientsResultats;
    private Client selectionClient;	
    

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
	
	public Client getSelectionClient() {
		if(selectionClient == null){
			selectionClient = new Client();
		}
		return selectionClient;
	}
	
	public void setSelectionClient(Client selectionClient) {
		this.selectionClient = selectionClient;
	}	
	
	
	public Collection<Client> getRechercheClientsResultats() {
		return rechercheClientsResultats;
	}
	public void setRechercheClientsResultats(
			Collection<Client> rechercheClientsResultats) {
		this.rechercheClientsResultats = rechercheClientsResultats;
	}

	public String getRechercheClient() {
		return rechercheClient;
	}
	public void setRechercheClient(String rechercheClient) {
		this.rechercheClient = rechercheClient;
	}
	
    public String login(){
        if("test".equalsIgnoreCase(getLogin()) && "test".equals(getMotPasse()))
        {
            return "home";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("login", new FacesMessage("Login et mot de passe invalide"));
            return "login";
        }
    }
    
    public String rechercheClients()
    {
        String login = (this.rechercheClient == null)? "":this.rechercheClient.trim();        
//        this.rechercheClientsResultats = clientService.retourner(login);
        ES.affiche(login);
        System.out.println("Notre liste contient: "+rechercheClientsResultats.size());
        return "home";
    }
    
    public String miseAjourClient()
    {
        clientService.modifier(this.selectionClient.getCode());
        return "home";
    }
    
    public void ligneSelectionne(SelectEvent event){
    	selectionClient =  (Client)event.getObject();
    	System.out.println("selectionClient = "+selectionClient.getNom());	
    }
    public void surClientSelectionne(SelectEvent event){ 
    	this.selectionClient =  (Client)event.getObject();
    	System.out.println("selectionClient = "+selectionClient.getNom());
    }
    public void surClientDeSelectionne(UnselectEvent event)
    {
    	selectionClient =  null;
    }    
}
