package br.com.devicesControl.beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.core.GenericType;
import br.com.common.DTO.StatusDTO;
import br.com.common.resources.StatusResource;
import br.com.devicesControl.rest.ClientRestProxyService;

@Named 
@ViewScoped
public class StatusBean extends AbstractFormBean {

	private static final long serialVersionUID = 1L;

	private List<StatusDTO> listaStatus =  new ArrayList<>();
	
	private StatusDTO statusDTO = new StatusDTO();
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando aplicacao");
		buscaStatus();
	}
	
	public void buscaStatus() {
		System.out.println("buscando lista de status");
		this.listaStatus = (List<StatusDTO>) getStatusResource()
				.findAll().readEntity(new GenericType<List<StatusDTO>>() {});
	}
	
	private StatusResource getStatusResource() {
		StatusResource statusResource = new ClientRestProxyService().createProxy(StatusResource.class);
		return statusResource;
	}
	
	public StatusDTO getStatusDTO() {
		return statusDTO;
	}
	public void setStatusDTO(StatusDTO statusDTO) {
		this.statusDTO = statusDTO;
	}
	public List<StatusDTO> getListaStatus() {
		return listaStatus;
	}
	public void setListaStatus(List<StatusDTO> listaStatus) {
		this.listaStatus = listaStatus;
	}
}
