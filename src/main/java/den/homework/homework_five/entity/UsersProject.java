package den.homework.homework_five.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users_projects")
public class UsersProject extends EntityWithRelation {
    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "user_id")
    private Long userId;

    public UsersProject(Long id, Long relatedEntityId) {
        super(id, relatedEntityId);
    }

    // Getters and Setters

}
