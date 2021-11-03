package formation.year2122.campus.academy.java.crm.client;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Data
@Service
public class ClientService {

    @Autowired

    private ClientRiposotory clientRiposotory;
    public Optional<Client> getClient(final Long id) {
        return clientRiposotory.findById(id);
    }

    public Iterable<Client> getClients() {
		return clientRiposotory.findAll();
	}

    public void deleteClient(final Long id) {
        clientRiposotory.deleteById(id);
    }

    public Client saveClient(Client client) {
        return clientRiposotory.save(client);
    }



}
