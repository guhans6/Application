import java.util.HashMap;

class Users {

    private static HashMap<String,User> users = new HashMap<>();
    private static HashMap<String,String> checker = new HashMap<>();

    //check username or password exists in Hashmap
    void checkUserExists(String name, String password, String email, String username) {
        if(checker.containsKey(username)) {
            System.out.println("Username already exists!");
        }
        else if(checker.containsValue(email)) {
            System.out.println("email already associated with another account!");
        }
        else {
            User user = new User();
            checker.put(username, email);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            users.put(username, user);
            System.out.println("User Successfully created.");
        }
    }

    //check user and password matches in users hashmap
    int loginUser(String username, String password) {
        if(users.containsKey(username)) {
            if(users.get(username).getPassword().equals(password)) {
                users.get(username).setLoggedIn(true);
                System.out.println("Logged in Successfully");
                return 1;
            }
            else {
                System.out.println("Passwords does not match!");
                return -2;
            }
        }

        System.out.println("User does not exists check username or create a new account.");
        return -1;
    }

    //list all users
    void listAllUsers() {
        for(String key: users.keySet()) {
            System.out.println(key);
        }
    }



}



    // protected int checkUserExists(String name, String password, String email, String username){

    //     if(users.containsKey(username)) {
    //         return -1;
    //     }
    //     else if(users.containsValue(email)) {
    //         return -2;
    //     }

    //     return 1;
    // }