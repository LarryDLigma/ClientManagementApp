package Services;

import JSONFIlesManagement.JSONReader;
import JSONFIlesManagement.JSONWriter;
import Entity.Client;
import java.time.LocalDate;
import java.util.HashMap;
public class ClientClientBaseService extends ClientBaseService {
    private JSONReader reader;
    private final JSONWriter writer;
    private final HashMap<Integer, Client> clients; // Store employees data
    public ClientClientBaseService(JSONReader reader, JSONWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.clients = reader.readAllClients(); // Initialize employees from JSON file
    }
    @Override
    public void addClient(Client client) {
        if (client != null) {
            clients.put(client.getId(), client);
            writer.writeObjectToFile(clients);
            System.out.println("Client added successfully!");
        } else {
            System.out.println("Cannot add a null client!");
        }
    }

    @Override
    public HashMap<Integer, Client> listClients() {
        return new HashMap<>(clients);
    }

    @Override
    public void editClient(int id, Client updatedClient) {
        if (clients.containsKey(id) && updatedClient != null) {
            clients.put(id, updatedClient);
            writer.writeObjectToFile(clients);
        } else {
            if (updatedClient == null) {
                System.out.println("Invalid input");
            } else {
                System.out.println("Client with ID " + id + " not found.");
            }
        }
    }

    @Override
    public void removeClient(int id) {
        if (clients.containsKey(id)) {
            Client client = clients.get(id);
            writer.writeObjectToFile(clients);
            System.out.println("Client removed successfully!");
        } else {
            System.out.println("Client with ID " + id + " not found!");
        }
    }


    @Override
    public HashMap<Integer, Client> searchByIndustry(String industry) {
        if (industry != null && !industry.isEmpty()) {
            HashMap<Integer, Client> industryClients = new HashMap<>();
            for (Client client : clients.values()) {
                if (industry.equalsIgnoreCase(client.getIndustry())) {
                    industryClients.put(client.getId(), client);
                }
            }
            return industryClients;
        } else {
            System.out.println("Industry not found!");
            return new HashMap<>();
        }
    }

    @Override
    public Client searchByID(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID. ID should be a positive number.");
            return null;
        } else {
            Client foundClient = clients.get(id);
            if (foundClient == null) {
                System.out.println("Client with ID " + id + " not found.");
            }
            return foundClient;
        }
    }

    @Override
    public HashMap<Integer, Client> searchByName(String name) {
        if (name != null && !name.isEmpty()) {
            HashMap<Integer, Client> nameClients = new HashMap<>();
            for (Client client : clients.values()) {
                if (name.equalsIgnoreCase(client.getName())) {
                    nameClients.put(client.getId(), client);
                }
            }
            return nameClients;
        } else {
            System.out.println("No client with such name!");
            return new HashMap<>();
        }
    }
}




