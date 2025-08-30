package mas.mp5.mas_final.controller;


import lombok.AllArgsConstructor;
import mas.mp5.mas_final.model.Group;
import mas.mp5.mas_final.model.Student;
import mas.mp5.mas_final.repository.GroupRepository;
import mas.mp5.mas_final.repository.StudentRepository;
import mas.mp5.mas_final.service.AddStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * Controller for showing students and adding to groups
 */

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class AddStudentController {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final AddStudentService addStudentService;


    @GetMapping("/{groupId}")

    public String showStudents(@PathVariable Long groupId, Model model) {
        Group group = groupRepository.findById(groupId).orElseThrow();

        Set<Student> studentsInGroup = group.getIsGroupOf();
        List<Student> allStudents = studentRepository.findAllByBelongsToIsNull();

        model.addAttribute("group", group);
        model.addAttribute("studentsInGroup", studentsInGroup);
        model.addAttribute("allStudents", allStudents);
        model.addAttribute("maxStudents", Group.getMaxStudents());

        return "students";
    }

    @PostMapping("/{groupId}/addStudent/{studentId}")
    public ResponseEntity<String> addStudentToGroup(@PathVariable Long groupId, @PathVariable Long studentId) {
        String info = addStudentService.addStudent(groupId, studentId);

        return ResponseEntity.ok(info);
    }
}
