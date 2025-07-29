import java.io.*;
import java.util.ArrayList;

public class Basedata implements Serializable {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Object> basedata = new ArrayList<>();


    private Basedata() {}

    

    public static void add(Object object) {
        basedata.add(object);
    }

    public static Object get(int index) {
        return basedata.get(index);
    }

    public static ArrayList<Object> getBasedata() {
        return basedata;
    }


    public static void save(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            oos.writeObject(basedata);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void load(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            basedata = (ArrayList<Object>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}