package den.homework.homework_five.controller;

import den.homework.homework_five.entity.Project;
import den.homework.homework_five.entity.User;
import den.homework.homework_five.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserProjectController {

    @Autowired
    private UserProjectService userProjectService;

    @GetMapping("/users/{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long projectId) {
        List<User> users = userProjectService.getUsersByProjectId(projectId);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/projects/{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        List<Project> projects = userProjectService.getProjectsByUserId(userId);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addUserToProject(@RequestParam Long userId, @RequestParam Long projectId) {
        userProjectService.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove")
    public ResponseEntity<Void> removeUserFromProject(@RequestParam Long userId, @RequestParam Long projectId) {
        userProjectService.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }
}

