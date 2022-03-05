package com.sdtech.moviecatalogservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sdtech.moviecatalog.models.CatalogItem;
import com.sdtech.moviecatalog.models.Movie;
import com.sdtech.moviecatalog.models.UserRatings;

@RestController
@RequestMapping( "/catalog" )
public class MovieCatalogResource
{
    @Autowired
    RestTemplate template;

    @RequestMapping( "/{userId}" )
    public List<CatalogItem> getCatalog( @PathVariable( "userId" ) String userId )
    {
        //        RestTemplate template = new RestTemplate();
        UserRatings ratings = template.getForObject( "http://rating.data.service/ratingsData/users/213/", UserRatings.class );

        return ratings.getUserRatings().stream().map( r -> {
            Movie movie = template.getForObject( "http://movie-info-service/movies/" + r.getMovieId(), Movie.class );
            return new CatalogItem( movie.getName(), "Movie description", r.getRating() );
        } ).collect( Collectors.toList() );

        //        return Collections.singletonList( new CatalogItem( "Movie 1", "Movie description", 1 ) );

    }
}
