package com.likebookapp.service.impl;

import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.model.dto.PostDisplayDTO;
import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    private MoodRepository moodRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, UserRepository userRepository, MoodRepository moodRepository) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
    }

    @Override
    @Transactional
    public List<PostDisplayDTO> getUserPosts(long userId) {
        List<Post> userPosts = this.postRepository.findAllByCreatorId(userId);

        return Arrays.stream(this.modelMapper.map(userPosts, PostDisplayDTO[].class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<PostDisplayDTO> getOthersPosts(long currentUserId) {
        List<Post> userPosts = this.postRepository.findAllByCreatorIdNot(currentUserId);

        return Arrays.stream(this.modelMapper.map(userPosts, PostDisplayDTO[].class)).collect(Collectors.toList());
    }

    @Override
    public void createPost(PostCreateDTO postCreateDTO, long creatorId) {
        Post newPost = this.modelMapper.map(postCreateDTO, Post.class);
        newPost.setCreator(this.userRepository.getById(creatorId));
        newPost.setMood(this.moodRepository.findByName(postCreateDTO.getMood()));

        this.postRepository.save(newPost);
    }

    @Override
    public void deletePost(long postId, long currentUserId) {
        Optional<Post> byId = this.postRepository.findById(postId);

        if (byId.isPresent() && byId.get().getCreator().getId() == currentUserId) {
            this.postRepository.delete(byId.get());
        }
    }

    @Override
    @Transactional
    public void likePost(long postId, long currentUserId) throws Exception {
        Optional<Post> optionalPost = this.postRepository.findById(postId);
        Optional<User> optionalUser = this.userRepository.findById(currentUserId);

        if (optionalPost.isPresent() && optionalUser.isPresent()) {
            Post currentPost = optionalPost.get();
            User currentUser = optionalUser.get();

            if(currentPost.getLikes().contains(currentUser)) {
                throw new Exception("You have liked this already!");
            } else {
                currentPost.getLikes().add(currentUser);
                this.postRepository.save(currentPost);
            }
        }
    }
}
