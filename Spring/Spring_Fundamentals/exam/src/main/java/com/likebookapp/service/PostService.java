package com.likebookapp.service;

import com.likebookapp.model.dto.PostCreateDTO;
import com.likebookapp.model.dto.PostDisplayDTO;

import java.util.List;

public interface PostService {

    List<PostDisplayDTO> getUserPosts(long userId);

    List<PostDisplayDTO> getOthersPosts(long currentUserId);

    void createPost(PostCreateDTO postCreateDTO, long creatorId);

    void deletePost(long postId, long currentUserId);

    void likePost(long postId, long currentUserId) throws Exception;

}
