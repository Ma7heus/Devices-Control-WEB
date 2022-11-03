package br.com.devicesControl.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class ClientRestProxyService {

	private final String uriBaseAPI = "http://localhost:8080/DevicesControl/api/v1";

	public <T> T createProxy(Class<T> resourceInterface) {

		Client client = ClientBuilder.newClient();
		//client.register(ObjectMapperProvider.class);
		//client.register(ClientAuthorizationHeaderProvider.class);
		//client.register(ClientResponseExceptionProvider.class);
		WebTarget target = client.target(uriBaseAPI);
		ResteasyWebTarget resteasyWebTarget = (ResteasyWebTarget) target;
		return resteasyWebTarget.proxy(resourceInterface);
	}
}
// terminar classe, serve para se comunicar com a API