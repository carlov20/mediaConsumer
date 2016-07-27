package com.veo.test

import com.veo.example.model.FullAlbum
import com.veo.example.service.DiscogsMusicService
import org.apache.commons.lang3.StringUtils
import spock.lang.Specification

import java.util.stream.Stream

class DiscogsMusicServiceSpec extends Specification {


    private DiscogsMusicService musicService;

    def setup() {
        musicService = new DiscogsMusicService();
        musicService.setApiToken("RAOqBOJeYRxfvpAoxKjgdspxBkhTjlPmDhPSzadL");

    }

    def "find albums by title returns albums with tracks"() {
        given: "An album title"
        String albumTitle = "nevermind";
        when: "music service is called"
        Stream<FullAlbum> albums = musicService.findByAlbumTitle(albumTitle);
        then: "all albums have tracks and all albums contain search title"
        albums.allMatch({ album -> !album.getTracklist().isEmpty() && StringUtils.containsIgnoreCase(album.getTitle(), albumTitle) });

    }
}
