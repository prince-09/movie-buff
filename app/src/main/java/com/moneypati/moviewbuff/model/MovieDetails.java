package com.moneypati.moviewbuff.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetails {
    @SerializedName("adult")
    boolean adult;

    @SerializedName("homepage")
    String homePage;

    @SerializedName("id")
    String Id;

    @SerializedName("title")
    String title;

    @SerializedName("overview")
    String description;

    @SerializedName("poster_path")
    String posterPath;

    @SerializedName("release_date")
    String releaseDate;

    @SerializedName("vote_average")
    float voteAverage;

    @SerializedName("genres")
    List<Genre> genreList;

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @SerializedName("tagline")
    String tagline;
}

/*{
   "adult":false,
   "backdrop_path":"/ouOojiypBE6CD1aqcHPVq7cJf2R.jpg",
   "belongs_to_collection":null,
   "budget":0,
   "genres":[
      {
         "id":53,
         "name":"Thriller"
      },
      {
         "id":18,
         "name":"Drama"
      },
      {
         "id":28,
         "name":"Action"
      },
      {
         "id":9648,
         "name":"Mystery"
      }
   ],
   "homepage":"https://www.warnerbros.com/movies/those-who-wish-me-dead",
   "id":578701,
   "imdb_id":"tt3215824",
   "original_language":"en",
   "original_title":"Those Who Wish Me Dead",
   "overview":"A young boy finds himself pursued by two assassins in the Montana wilderness with a survival expert determined to protecting him - and a forest fire threatening to consume them all.",
   "popularity":1446.705,
   "poster_path":"/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg",
   "production_companies":[
      {
         "id":13240,
         "logo_path":"/aTc07YaNHo8WNgkQSnvLmG6w4nW.png",
         "name":"Bron Studios",
         "origin_country":"CA"
      },
      {
         "id":8083,
         "logo_path":null,
         "name":"Film Rites",
         "origin_country":"US"
      },
      {
         "id":53152,
         "logo_path":"/8XHHLy8GGTuHM9JMzYjGqxB6oPa.png",
         "name":"Creative Wealth Media Finance",
         "origin_country":"CA"
      },
      {
         "id":12,
         "logo_path":"/iaYpEp3LQmb8AfAtmTvpqd4149c.png",
         "name":"New Line Cinema",
         "origin_country":"US"
      },
      {
         "id":174,
         "logo_path":"/IuAlhI9eVC9Z8UQWOIDdWRKSEJ.png",
         "name":"Warner Bros. Pictures",
         "origin_country":"US"
      },
      {
         "id":106789,
         "logo_path":"/oEgUdRh5YWF6Il705WnpwauirIj.png",
         "name":"Bosque Ranch Productions",
         "origin_country":"US"
      }
   ],
   "production_countries":[
      {
         "iso_3166_1":"CA",
         "name":"Canada"
      },
      {
         "iso_3166_1":"US",
         "name":"United States of America"
      }
   ],
   "release_date":"2021-05-05",
   "revenue":0,
   "runtime":100,
   "spoken_languages":[
      {
         "english_name":"English",
         "iso_639_1":"en",
         "name":"English"
      }
   ],
   "status":"Released",
   "tagline":"Nature finds a way.",
   "title":"Those Who Wish Me Dead",
   "video":false,
   "vote_average":7.2,
   "vote_count":210
} */
