import java.util.InputMismatchException;
import java.util.Scanner;

class App {

    private Scanner scanner;
    int choice = 0;

    void menu() {
        scanner = new Scanner(System.in);
        Users users = new Users();
        boolean menu = true;
        String name;
        String username;
        String email;
        String password;
        while(menu) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            try {
            choice = scanner.nextInt(); }
            catch(InputMismatchException e) {
                System.out.println("Enter correct choice!");
            }
            scanner.nextLine();
            if(choice == 1) {
                System.out.print("Enter your name: ");
                name = scanner.nextLine();
                System.out.print("Enter your email: ");
                email = scanner.nextLine();
                System.out.print("Enter your username: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                users.checkUserExists(name, password, email, username);
            }
            else if(choice == 2) {
                System.out.print("Enter your username: ");
                username = scanner.nextLine();
                System.out.print("Enter your password: ");
                password = scanner.nextLine();
                int login = users.loginUser(username, password);
                if(login == 1)
                {
                    userMenu();
                }
            }
            else if(choice == 3) {
                scanner.close();
                menu = false;
            }
            else if(choice == 5)
            {
                users.listAllUsers();
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

    void userMenu() {
        boolean menu = true;
        while(menu) {
            System.out.println("1. Create Post");
            System.out.println("2. Share Post");
            System.out.println("3. Add Friend");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt(); }
                catch(InputMismatchException e) {
                    System.out.println("Enter correct choice!");
                }
            scanner.nextLine();
            if(choice == 1) {
                System.out.println("Enter your post: ");
                String post = scanner.nextLine();
                createPost(post);
            }
            else if(choice == 2) {
                System.out.println("Enter the username of the user you want to share post with: ");
                String username = scanner.nextLine();
                System.out.println("Enter the post id you want to share: ");
                int id = scanner.nextInt();
                sharePost(username, id);
            }
            else if(choice == 3) {
                System.out.println("Enter the username of the user you want to add as friend: ");
                String username = scanner.nextLine();
                addFriend(username);
            }
            else if(choice == 4) {
                System.err.println("Logout Successful.");
                menu = false;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

    private void createPost(String post) {
        System.out.println("Posted !");
    }

    private void addFriend(String username) {
        System.out.println("Freind Added !");
    }

    private void sharePost(String username, int id) {
        System.out.println("Shared succesfully!");
    }
    
}
