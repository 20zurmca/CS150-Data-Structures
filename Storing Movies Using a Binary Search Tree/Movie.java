
/**
 * Class Movie represents a movie 
 */
public class Movie implements Comparable<Movie>
{
    //////////////////////////////fields//////////////////////////////////////////////

    private String title; //the title of the movie 

    private String director; //the director 

    private Integer year; //year made 

    private String genre; //type

    /**
     * Constructor for class Movie
     * @param title the title
     * @param director the director
     * @param year the year
     * @param Genre the genre
     */
    public Movie(String title, String director, Integer year, String genre)
    {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    ////////////////////////////////////methods///////////////////////////////////////////////

    @Override
    public int compareTo(Movie m)
    {
        int compareYear = this.year .compareTo(m.year);
        int compareTitle = this.title.compareTo(m.title);
        int compareGenre = this.genre.compareTo(m.genre);
        int compareDirector = this.director.compareTo(m.director);
        
        if(compareYear != 0){ //first compare year
            return compareYear;
        } else if(compareTitle != 0){ //if year compare result is zero compare genre
            return compareTitle;
        } else if(compareGenre != 0){ //if genre compare result is zero compare director
            return compareGenre;
        } else {
            return compareDirector;
        }
    }
    
    public String toString()
    {
        return this.title + " " + this.director + " " + this.year + " " + this.genre;
    }
}

