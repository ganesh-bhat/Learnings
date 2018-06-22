import com.learning.Artist;
import com.learning.LearningStreams;
import com.learning.Track;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LearningStreamsTest {

    @Test
    public void testGetAllArtists() {

        List<Artist> artists = Arrays.asList(new Artist("Abc","London"),new Artist("Cde","US"));

        List<Artist> results = new LearningStreams(artists).getAllArtistsFrom("London");

        Assert.assertEquals(results.size(),1);

        for(Artist artist:results) {
            Assert.assertEquals("London", results.get(0).getOrigin());
        }
    }

    @Test
    public void testMapReduce() {

        new LearningStreams(null).mapReduce();
    }

    @Test
    public void testFibonacci() {
        List<Long> result = new LearningStreams(null).fibonacci(10);
        result.forEach(it->System.out.println(it));
        Assert.assertEquals((long)result.get(3),5);
    }

    @Test
    public void numbersSum() {

        int sum = new LearningStreams(null).numbersSum(4);
        System.out.println(sum);

    }

    @Test
    public void findLongestTrack() {
        LearningStreams learningStreams = new LearningStreams(null);
        learningStreams.setAllTracks(Arrays.asList(new Track("1",1),new Track("10",10),new Track("4",4),new Track("8",8)));
        Track track = learningStreams.findLongestTrack();
        Assert.assertEquals(track.getName(),"10");
    }



}
