import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    int num = 0;
    Str[] strArray = new String[];

    //It should support a path for adding a new string to the list, 
    //and a path for querying the list of strings and 
    //returning a list of all strings that have a given substring.



    public String handleRequest(URI url) {
        ///add?s=anewstringtoadd
        if (url.getPath().contains("add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("count")) {
                strArray.append(parameters[1]);
            }
        } 
        // else if (url.getPath().equals("/query")) {
        //     do what??;
        } else {
            System.out.println("Path: " + url.getPath());
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                for(int i=, ;<strArray.length; i++)
                {
                    if(strArray[i]==parameters[0])
                        return strArray[i];
                }
                // if (parameters[0].equals("count")) {
                //     num += Integer.parseInt(parameters[1]);
                //     return String.format("Number increased by %s! It's now %d", parameters[1], num);
                // }
            }
            return "404 Not Found!";
        }
    }
}

class NumberServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
