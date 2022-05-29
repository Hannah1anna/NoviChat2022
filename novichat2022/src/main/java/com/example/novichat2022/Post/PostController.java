package com.example.novichat2022.Post;

import com.example.novichat2022.appuser.AppUser;
import com.example.novichat2022.appuser.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AppUserRepository appUserRepository;


    @GetMapping()
    public ResponseEntity<List<PostDTO>> getAllPosts() {

        List<PostDTO> postsDTO = new ArrayList<>();
        List<Post> posts = postRepository.findAll();

        posts.forEach(x -> {
            PostDTO post = new PostDTO();
            post.setText(x.getText());
            post.setUsername(x.getAppUser().getUsername());
            postsDTO.add(post);
        });
        return ResponseEntity.ok().body(postsDTO);
    }

    @PostMapping()
    public ResponseEntity<String> postPost(
            @RequestPart("json") PostDTO postDTO,
            @RequestPart("image") MultipartFile file) throws IOException {


        AppUser appUser = appUserRepository.findById(postDTO.getUsername()).orElseThrow(() ->
                new RuntimeException("geen User"));
        Post post = new Post("new post");
        System.out.println(postDTO.getText());
        post.setText(postDTO.getText());
        post.setAppUser(appUser);
        postRepository.save(post);

        return ResponseEntity.ok().body("gelukt");
    }
    
}
