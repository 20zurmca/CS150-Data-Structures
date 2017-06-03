import java.util.NoSuchElementException;
/**
 * Controller Class
 */
public class Controller
{
    public static void main(String [] args)
    {
        MovieLibrary lib = new MovieLibrary(); 
        lib.addMovies(args[0]); //the first argument will be the file to read movies from, create movie objects, and add them to MovieLibrary 
        try{
            lib.writeToFile(args[1]); //The second argument will be the file to write the movies in order to
        } catch(NoSuchElementException e){
            e.printStackTrace();
        }
    }
}
