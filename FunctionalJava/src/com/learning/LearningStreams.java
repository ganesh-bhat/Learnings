package com.learning;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LearningStreams {

    private List<Artist> allArtists;
    private List<Track> allTracks;

    public void setAllTracks(List<Track> allTracks) {
        this.allTracks = allTracks;
    }

    public LearningStreams(List<Artist> allArtists)  {
        this.allArtists = allArtists;
    }

    /* filter */
    public List<Artist> getAllArtistsFrom(String origin) {
        if(origin!=null) {
            return allArtists.stream().filter(
                    artist -> origin.equals(artist.getOrigin())
            ).collect(Collectors.toList());
        }
        return null;
    }

    public List<String> abcList() {
        return Stream.of("a","b","c").collect(Collectors.toList());
    }


    public void mapReduce() {
        IntStream intStream = IntStream.range(1, 100);
        List<Integer> resultList = intStream.filter(it -> it % 2 == 0)
                .map(it -> it * 2)
                .boxed().collect(Collectors.toList());




    }

    public List<Long> fibonacci(int max) {
         return Stream.iterate(
                new Pair(1, 1), it -> new Pair(it.getTwo(), it.getOne().doubleValue() + it.getTwo().doubleValue()))
                .limit(max)
                .map(pair -> pair.getTwo().longValue())
                .collect(Collectors.toList());
    }


    public int numbersSum(int lastNo) {
        return IntStream.range(1,lastNo).reduce((acc, elem) -> acc+elem).getAsInt();
    }

    public Track findLongestTrack() {
        return allTracks.stream().max(
                Comparator.comparing(it->it.getLength())).get();
    }


    private static class Pair<T extends Number> {
        private T one;
        private T two;
        public Pair(T a, T b) {
            this.one = a;
            this.two = b;
        }

        public T getOne() {
            return one;
        }

        public void setOne(T one) {
            this.one = one;
        }

        public T getTwo() {
            return two;
        }

        public void setTwo(T two) {
            this.two = two;
        }
    }

}
