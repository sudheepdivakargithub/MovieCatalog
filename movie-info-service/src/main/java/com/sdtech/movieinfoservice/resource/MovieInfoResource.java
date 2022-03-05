package com.sdtech.movieinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sdtech.movieinfoservice.models.Movie;
import com.sdtech.movieinfoservice.models.MovieSummary;

@RestController
@RequestMapping( "/movies" )
public class MovieInfoResource
{
    @Autowired
    RestTemplate template;

    @Value( "${api.key}" )
    private String apiKey;

    @RequestMapping( "/{movieId}" )
    public Movie getMovieInfo( @PathVariable( "movieId" ) int movieId )
    {
        String url = String.format( "https://api.themoviedb.org/3/movie/%s?api_key=%s", movieId, "d332c3ad8af6c8c1c989f8584a2290cb" );
        MovieSummary movieSummary = template.getForObject( url, MovieSummary.class );
        return new Movie( movieSummary.getId(), movieSummary.getTitle(), movieSummary.getOverview() );
    }
}
