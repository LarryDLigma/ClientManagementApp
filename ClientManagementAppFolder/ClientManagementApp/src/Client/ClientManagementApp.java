package Client;

import JSONFIlesManagement.JSONReader;
import JSONFIlesManagement.JSONWriter;
import Services.ClientBaseService;
import Manager.ClientManager;
import Services.ClientClientBaseService;
import Manager.ClientManagerInterface;
import java.util.Scanner;

public class ClientManagementApp {
    public static void main(String[] args) {
// r/w !TODO Check the filepaths!!!
        JSONReader reader = new JSONReader("C:\\Users\\Larry\\Desktop\\ClientManagementAppFolder\\ClientManagementApp\\src\\files\\ClientsData.json");
        JSONWriter writer = new JSONWriter("C:\\Users\\Larry\\Desktop\\ClientManagementAppFolder\\ClientManagementApp\\src\\files\\ClientsData.json");
        ClientBaseService clientBaseService = new ClientClientBaseService(reader, writer);
        ClientManagerInterface clientManagerInterface = new ClientManager(clientBaseService);
        ClientManagerInterface manager = new ClientManager(clientBaseService);
        System.out.println("Welcome to the Client Data Management System");
        displayOptions();

        boolean active = true;
        Scanner scanner = new Scanner(System.in);

        while (active) {
            String command = scanner.nextLine();

            switch (command) {
                case "Add Client":
                    addClient(scanner, manager);
                    break;
                case "Update Client":
                    updateClient(scanner, manager);
                    break;
                case "Remove Client":
                    removeClient(scanner, manager);
                    break;
                case "View Clients":
                    viewClients(manager);
                    break;
                case "Exit":
                    active = false;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
                    break;
            }
        }
    }

    private static void displayOptions() {
        System.out.println("Add Client");
        System.out.println("Update Client");
        System.out.println("Remove Client");
        System.out.println("View Clients");
        System.out.println("Exit");
    }

    private static void addClient(Scanner scanner, ClientManagerInterface manager) {
        System.out.println("Enter client details (ID, name, industry, contact person, revenue):");
        String clientDetails = scanner.nextLine();
        manager.performAction("Add " + clientDetails);
    }

    private static void updateClient(Scanner scanner, ClientManagerInterface manager) {
        System.out.println("Enter client details for update (ID, name, industry, contact person, revenue):");
        String clientDetails = scanner.nextLine();
        manager.performAction("Update " + clientDetails);
    }

    private static void removeClient(Scanner scanner, ClientManagerInterface manager) {
        System.out.println("Enter client ID for removal:");
        String clientId = scanner.nextLine();
        manager.performAction("Remove " + clientId);
    }

    private static void viewClients(ClientManagerInterface manager) {
        manager.performAction("View Clients");
    }
}