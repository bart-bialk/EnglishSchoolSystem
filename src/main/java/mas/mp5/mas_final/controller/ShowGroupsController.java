package mas.mp5.mas_final.controller;

import lombok.AllArgsConstructor;
import mas.mp5.mas_final.model.Group;
import mas.mp5.mas_final.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller shows groups
 */

@Controller
@RequestMapping("/addStudent")
@AllArgsConstructor
public class ShowGroupsController {

    private final GroupRepository groupRepository;

    @GetMapping("/groups")
    public String showGroups(Model model) {
        model.addAttribute("groups", groupRepository.findAll());
        model.addAttribute("maxStudents", Group.getMaxStudents());

        return "groups";
    }
}
