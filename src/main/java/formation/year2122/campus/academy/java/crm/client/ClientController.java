package formation.year2122.campus.academy.java.crm.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;


    /**
     * Create - Add a new employee
     * @param client An object employee
     * @return The employee object saved
     */
    @PostMapping("/client")
    public Client createClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    /**
	 * Read - Get one employee 
	 * @param id The id of the employee
	 * @return An Employee object full filled
	 */
	@GetMapping("/client/{id}")
	public Client getClient(@PathVariable("id") final Long id) {
		Optional<Client> client = clientService.getClient(id);
		if(client.isPresent()) {
			return client.get();
		} else {
			return null;
		}
	}


    /**
	 * Read - Get all employees
	 * @return - An Iterable object of Employee full filled
	 */
	@GetMapping("/clients")
	public Iterable<Client> getClients() {
		return clientService.getClients();
	}


    /**
	 * Delete - Delete an employee
	 * @param id - The id of the employee to delete
	 */
	@DeleteMapping("/client/{id}")
	public void deleteEmployee(@PathVariable("id") final Long id) {
		clientService.deleteClient(id);
	}
	

    
}






