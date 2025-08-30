package mas.mp5.mas_final.service;


import lombok.AllArgsConstructor;
import mas.mp5.mas_final.model.Group;
import mas.mp5.mas_final.model.Student;
import mas.mp5.mas_final.model.StudentStatus;
import mas.mp5.mas_final.repository.GroupRepository;
import mas.mp5.mas_final.repository.StudentRepository;
import org.springframework.stereotype.Service;

/**
 * Service checks if student is from the same city as group and adds the student to group or returns failure error
 */

@AllArgsConstructor
@Service
public class AddStudentService {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;


    public String addStudent(Long groupId, Long studentId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        if (group.getIsGroupOf().size() >= Group.getMaxStudents()) {
            return "Group has max participants!";
        }

        if (!group.getCity().equals(student.getCity())) {
            return "Students in the group have to be from the same city";
        }

        student.setBelongsTo(group);
        student.setStatus(StudentStatus.Assigned);

        studentRepository.save(student);
        groupRepository.save(group);

        return "Student added successfully";

    }

}
