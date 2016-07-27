package com.veo.example.service;

import com.veo.example.model.FullAlbum;

import java.util.stream.Stream;

public interface MusicService {

	Stream<FullAlbum> findByAlbumTitle(String albumTitle);
}
