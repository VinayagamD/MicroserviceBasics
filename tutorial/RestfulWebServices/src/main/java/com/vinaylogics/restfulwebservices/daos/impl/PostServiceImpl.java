package com.vinaylogics.restfulwebservices.daos.impl;

import com.vinaylogics.restfulwebservices.daos.PostService;
import com.vinaylogics.restfulwebservices.models.Post;
import com.vinaylogics.restfulwebservices.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }


    @Override
    public Post save(Post post) {
        return repository.save(post);
    }
}
