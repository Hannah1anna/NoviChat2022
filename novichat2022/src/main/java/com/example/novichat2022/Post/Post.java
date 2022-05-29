package com.example.novichat2022.Post;
import com.example.novichat2022.appuser.AppUser;
import com.example.novichat2022.appuser.AppUserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "post")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String text;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "username")
    private AppUser appUser;

    public Post(String text) {
        this.text = text;
    }
}