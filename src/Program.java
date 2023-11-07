import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Program {
    HashMap<String,String> dictionary = new HashMap<String,String>();
    public Program() throws Exception{
        BufferedReader fout = new BufferedReader(new FileReader(new File("slang.txt")));
        fout.readLine(); // collumns' name
        String line;
        while ((line = fout.readLine()) != null) {
            String[] values = line.split("`");
            dictionary.put(values[0],values[1]);
        }
        fout.close();
    }

    public HashMap<String, String> getDictionary() {
        return dictionary;
    }

    public static void main(String[] args) throws Exception{
        Program a = new Program();
        System.out.print("size of dictionary:");
        System.out.println(a.getDictionary().size());
    }
}
