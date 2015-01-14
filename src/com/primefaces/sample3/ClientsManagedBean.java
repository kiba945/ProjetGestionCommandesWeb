package com.primefaces.sample3;

import com.afpa59.patrice.donnees.Client;
import com.afpa59.patrice.service.fichier.ServiceClient;
import com.afpa59.patrice.utils.ConnectionFichiersClients;

import java.io.Serializable;
import java.util.ArrayList;
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

	static ServiceClient clientService;
	static ConnectionFichiersClients fichClt;
	static String nomPhysiqueClient = "TableClients";	

	private String utilisateur;
	private String motPasse;
	private String rechercheClient;
	private Collection<Client> rechercheClientsResultats;
	private Client selectionClient;	


	public String getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(String login) {
		this.utilisateur = login;
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
		if("test".equalsIgnoreCase(getUtilisateur()) && "test".equals(getMotPasse()))
		{
//			fichClt = new ConnectionFichiersClients("TableClients");
//			clientService = fichClt.getTab();

//			
//			String mes;
//
//			mes = "\n*** CHARGEMENT du FICHIER des CLIENTS ***\n";
			if(clientService == null){
				
				clientService = new ServiceClient();

//				try {
//					clientService.readData();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					System.out.println("EXCEPTION Test MODULE GESTION Articles");
//					e.printStackTrace();
//				}
				
//				mes = mes + "*** TABLE des CLIENTS VIDE ***" +
//						"CREATION par DEFAUT de la TABLE des CLIENTS ***\n";
				clientService.creer(1,"SIMPSON","Homer","SPRINGFIELD");
				clientService.creer(2,"SIMPSON","Marge","WINTERFIELD");
				clientService.creer(3,"SIMPSON","Bart","SUMMERFIELD");
				
			}

//			ES.affiche(mes);	
//			ES.affiche(clientService.toString());

			return "home";
		}
		else
		{
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("utilisateur", new FacesMessage("Login et mot de passe invalide"));
			return "utilisateur";
		}
	}

	public String rechercheClients()
	{
		String login = (this.rechercheClient == null)? "":this.rechercheClient.trim();
		
		this.rechercheClientsResultats = searchUsers(login);
		System.out.println("Notre liste contient: "+rechercheClientsResultats.size());
		return "home";
	}
	
    public Collection<Client> searchUsers(String utilisateur)
    {
        String critere = (utilisateur == null)? "":utilisateur.toLowerCase().trim();
        Collection<Client> users = clientService.getTabClient();
        Collection<Client> searchResults = new ArrayList<Client>();
        for (Client clt : users)
        {
            if(clt.getPrenom() != null && clt.getPrenom().toLowerCase().trim().startsWith(critere))
            {
                searchResults.add(clt);
            }
        }
        return searchResults;
    }	

	public void supprimerClient(SelectEvent event)
	{
		selectionClient =  (Client)event.getObject();
		System.out.println("supprimer le client : " + selectionClient.getNom());
//		clientService.supprimer(selectionClient.getCode());
		
	}    
    
	public String miseAjourClient()
	{
		clientService.modifier(this.selectionClient.getCode());
		return "home";
	}

	public void ligneSelect(SelectEvent event){
		selectionClient =  (Client)event.getObject();
		System.out.println("selectionClient = "+selectionClient.getNom());	
	}
	public void surClientSelect(SelectEvent event){ 
		this.selectionClient =  (Client)event.getObject();
		System.out.println("selectionClient = "+selectionClient.getNom());
	}
	public void surClientDeSelect(UnselectEvent event)
	{
		selectionClient =  null;
	}    
}
