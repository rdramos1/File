package file;

import java.io.File; 
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Arquivo {
    String path;
    File file;
    
    JSONObject jsonObject = new JSONObject();
    JSONObject jsonObject2;
    FileWriter writeFile = null;
    JSONParser parser = new JSONParser();
	
   
    public void SetPath(){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select the path");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            System.out.println(path);
        }
    }
    public void CreateFile(String name){
        try {
        file = new File(path+"\\"+name+".json");
        file.createNewFile();
        } catch (Exception e) {}
    }
    public void DeleteFile() {
    	try {
			file.delete();
		} catch (Exception e) {}
    }
    public void WriteFile(String type, String value) {
    	jsonObject.put(type, value);
    	try {
        	writeFile = new FileWriter(file);
			writeFile.write(jsonObject.toJSONString());
			writeFile.close();
		} catch (Exception e) {}
    }
    public void ReadFile(String type) {
    	String read;
    	try {
    		jsonObject2 = (JSONObject) parser.parse(new FileReader(file));
    		read = (String) jsonObject2.get(type);
    		String e = type+"="+read; 
        	System.out.println(e);
		} catch (Exception e) {}
    }
}
