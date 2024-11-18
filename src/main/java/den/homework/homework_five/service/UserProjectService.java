package den.homework.homework_five.service;

import den.homework.homework_five.entity.Project;
import den.homework.homework_five.entity.User;
import den.homework.homework_five.entity.UsersProject;
import den.homework.homework_five.repository.ProjectRepository;
import den.homework.homework_five.repository.UserRepository;
import den.homework.homework_five.repository.UsersProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProjectService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UsersProjectRepository usersProjectRepository;

    public List<User> getUsersByProjectId(Long projectId) {
        List<UsersProject> usersProjects = usersProjectRepository.findByProjectId(projectId);
        return usersProjects.stream()
                .map(up -> userRepository.findById(up.getUserId()).orElse(null))
                .toList();
    }

    public List<Project> getProjectsByUserId(Long userId) {
        List<UsersProject> usersProjects = usersProjectRepository.findByUserId(userId);
        return usersProjects.stream()
                .map(up -> projectRepository.findById(up.getProjectId()).orElse(null))
                .toList();
    }

    public void addUserToProject(Long userId, Long projectId) {
        UsersProject usersProject = new UsersProject();
        usersProject.setUserId(userId);
        usersProject.setProjectId(projectId);
        usersProjectRepository.save(usersProject);
    }

    public void removeUserFromProject(Long userId, Long projectId) {
        UsersProject usersProject = usersProjectRepository.findByUserIdAndProjectId(userId, projectId);
        if (usersProject != null) {
            usersProjectRepository.delete(usersProject);
        }
    }
}

