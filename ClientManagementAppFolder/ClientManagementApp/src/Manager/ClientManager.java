package Manager;

import Entity.Client;
import Services.ClientBaseService;
import java.time.LocalDate;
public class ClientManager implements ClientManagerInterface {
    private final ClientBaseService clientBaseService;
    public ClientManager(ClientBaseService clientBaseService) {
        this.clientBaseService = clientBaseService;
    }
    public void execute(String command) {
        if (command.startsWith("Add Client")) {
            Client newClient = parseClientDetails(command);
            clientBaseService.addClient(newClient);

        } else if (command.startsWith("Update Client")) {
            String[] parts = command.split(" ", 3);
            int clientId = Integer.parseInt(parts[1]);
            String clientDetails = parts[2];
            Client updatedClient = parseClientDetails(clientDetails);
            clientBaseService.editClient(clientId, updatedClient);

        } else if (command.startsWith("Remove Client")) {
            int clientId = Integer.parseInt(command.split(" ")[2]);
            clientBaseService.removeClient(clientId);

        } else if (command.equals("View Clients")) {
            System.out.println(clientBaseService.listClients());

        } else if (command.equals("Exit")) {
            System.out.println("Goodbye!");

        } else {
            System.out.println("Invalid command. Please try again.");
        }
    }

    private Client parseClientDetails(String command) {
        String[] parts = command.split(" ", 2)[1].split(", ");
        String name = parts[0];
        String industry = parts[1];
        String contactPerson = parts[2];
        double revenue = Double.parseDouble(parts[3]);
        ClientIDMManager manager = new ClientIDMManager("C:\\Users\\Larry\\Desktop\\ClientManagementAppFolder\\ClientManagementApp\\src\\files\\SavingStuff.txt", 100);
        return new Client(manager, name, industry, contactPerson, revenue);
    }

    @Override
    public void performAction(String command) {
        execute(command);
    }
}
