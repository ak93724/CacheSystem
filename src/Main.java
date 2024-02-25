import servie.CacheController;
import servie.impl.CacheControllerService;
import servie.impl.LruEvictionPolicy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        //CacheController controller = CacheControllerService.getInstance();
        CacheController controller = CacheControllerService.getInstance(2, new LruEvictionPolicy());

        try {
            controller.add("1", "String key 1");
            controller.add(1, "Integer key 1");
            controller.add('1', "char key 1");

            controller.get("1");
            controller.get('1');
            controller.get(1);

            controller.add("2", "String key 2");
            controller.add(2, "Integer key 2");
            controller.add('2', "char key 2");

            controller.get("1");
            controller.get('1');
            controller.get(1);

            controller.get("2");
            controller.get('2');
            controller.get(2);


        } catch (Exception e) {
            System.out.println("Ex : "+ e.getMessage());
        }

    }
}