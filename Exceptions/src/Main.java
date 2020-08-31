public class Main {
    public static void main(String[] args) {
            FileManager cabinet = new FileManager();
        try {
           // cabinet.createFile("newFile");
            cabinet.login();
            for (int i = 0; i < 11; i++) {
                cabinet.createFile("Fun Tastik File"+i);
            }
        } catch (NotEnoughSpaceException e){
            System.out.println("Not enough space");
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (NotEnoughPermissionsException e){
            System.out.println("Not logged in");
        }catch (FileException e){
            System.out.println("Something went wrong");
        }

        
    }
}
