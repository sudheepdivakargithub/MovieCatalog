package com.sdtech.ratingdataservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdtech.ratingdataservice.models.Rating;
import com.sdtech.ratingdataservice.models.UserRatings;

@RestController
@RequestMapping( "/ratingsData" )
public class RatingResource
{

    @RequestMapping( "/{movieId}" )
    public Rating getRatingForMovie( @PathVariable( "movieId" ) String movieId )
    {
        return new Rating( movieId, 4 );
    }

    @RequestMapping( "users/{userId}" )
    public UserRatings getRatings( @PathVariable( "userId" ) String userId )
    {
        List<Rating> ratings = Arrays.asList( new Rating( "100", 2 ), new Rating( "200", 3 ) );

        UserRatings userRating = new UserRatings();
        userRating.setUserRatings( ratings );
        return userRating;
    }

}
