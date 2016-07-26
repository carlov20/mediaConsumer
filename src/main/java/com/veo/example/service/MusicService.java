package com.veo.example.service;

import java.util.List;

import com.veo.example.model.Album;

public interface MusicService {

	List<Album> findByAlbumTitle(String albumTitle);
}
