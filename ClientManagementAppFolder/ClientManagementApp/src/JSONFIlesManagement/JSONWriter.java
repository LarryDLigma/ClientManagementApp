package JSONFIlesManagement;

import Entity.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class JSONWriter {

    private final String filePath;

    public JSONWriter(String filePath) {
        this.filePath = filePath;
    }

    public void writeObjectToFile(HashMap<Integer, Client> employees) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        File file = new File(filePath);

        try {
            // Write the employees HashMap to the JSON file
            objectMapper.writeValue(file, employees);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
