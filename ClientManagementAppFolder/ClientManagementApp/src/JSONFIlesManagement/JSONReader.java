package JSONFIlesManagement;

import Entity.Client;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
public class JSONReader {
    private final String filePath;
    public JSONReader(String filePath) {
        this.filePath = filePath;
    }
    public HashMap<Integer, Client> readAllClients() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        File file = new File(filePath);
        // Check if the file exists
        if (!file.exists()) {
            // If the file doesn't exist, return an empty HashMap
            return new HashMap<>();
        }

        try {
            // Read the existing content into a HashMap
            return objectMapper.readValue(file, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
