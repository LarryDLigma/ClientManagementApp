package Services;

import Entity.Client;

import java.util.HashMap;

public abstract class ClientBaseService {
    public abstract void addClient(Client client);
    public abstract HashMap<Integer, Client> listClients();
    public abstract void editClient(int id, Client newClient);
    public abstract void removeClient(int id);
    public abstract HashMap<Integer, Client> searchByIndustry(String industry);
    public abstract Client searchByID(int id);
    public abstract HashMap<Integer, Client> searchByName(String name);
}