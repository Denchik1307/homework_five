package den.homework.homework_five.repository;

import den.homework.homework_five.entity.UsersProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    List<UsersProject> findByProjectId(Long projectId);
    List<UsersProject> findByUserId(Long userId);

    UsersProject findByUserIdAndProjectId(Long userId, Long projectId);
}

