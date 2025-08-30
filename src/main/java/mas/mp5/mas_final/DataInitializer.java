package mas.mp5.mas_final;

import mas.mp5.mas_final.model.*;
import mas.mp5.mas_final.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

/**
 * Adds initial data, when database is empty
 */

@Component
public class DataInitializer implements CommandLineRunner {

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    private final EmployeeRepository employeeRepository;
    private final TutorRepository tutorRepository;
    private final ManagerRepository managerRepository;
    private final AdministratorRepository administratorRepository;
    private final BuildingRepository buildingRepository;
    private final RoomRepository roomRepository;
    private final ProgramRepository programRepository;
    private final LessonRepository lessonRepository;
    private final OccupancyRepository occupancyRepository;

    public DataInitializer(GroupRepository groupRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository, TutorRepository tutorRepository, ManagerRepository managerRepository, AdministratorRepository administratorRepository, BuildingRepository buildingRepository, RoomRepository roomRepository, ProgramRepository programRepository, LessonRepository lessonRepository, OccupancyRepository occupancyRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.employeeRepository = employeeRepository;
        this.tutorRepository = tutorRepository;
        this.managerRepository = managerRepository;
        this.administratorRepository = administratorRepository;
        this.buildingRepository = buildingRepository;
        this.roomRepository = roomRepository;
        this.programRepository = programRepository;
        this.lessonRepository = lessonRepository;
        this.occupancyRepository = occupancyRepository;
    }

    @Override
    public void run(String... args) {
        //Program
        Program program = Program.builder().name("Upgrade english skills").startDate(LocalDate.of(2020, 1, 1)).build();
        if (programRepository.count() == 0) {
            programRepository.save(program);
        }

        //Group
        Group group1 = Group.builder()
                .groupCode("WAW1")
                .city("Warszawa")
                .language("English")
                .level("B1")
                .realises(program)
                .build();
        Group group2 = Group.builder()
                .groupCode("WAW2")
                .city("Warszawa")
                .language("English")
                .level("A1")
                .build();

        Group group3 = Group.builder()
                .groupCode("WAW3")
                .city("Warszawa")
                .language("Spanish")
                .level("B1")
                .realises(program)
                .build();

        Group group4 = Group.builder()
                .groupCode("KRA1")
                .city("Kraków")
                .language("English")
                .level("C1")
                .build();
        if (groupRepository.count() == 0) {
            groupRepository.saveAll(List.of(group1, group2, group3, group4));
        }


        //Student
        Student student1 = Student.builder()
                .name("Jan")
                .surname("Kowalski")
                .dateOfBirth(LocalDate.of(2000, 1, 1))
                .telephone("123456789")
                .city("Warszawa")
                .status(StudentStatus.Assigned)
                .belongsTo(group1)
                .build();

        Student student2 = Student.builder()
                .name("Anna")
                .surname("Nowak")
                .dateOfBirth(LocalDate.of(2000, 3, 3))
                .telephone("987654321")
                .city("Warszawa")
                .status(StudentStatus.Confirmed)
                .build();

        Student student3 = Student.builder()
                .name("Ewa")
                .surname("Abacka")
                .dateOfBirth(LocalDate.of(2000, 8, 8))
                .telephone("222222222")
                .city("Warszawa")
                .status(StudentStatus.Confirmed)
                .build();

        Student student4 = Student.builder()
                .name("Tomasz")
                .surname("Nowak")
                .dateOfBirth(LocalDate.of(2000, 5, 5))
                .telephone("111111111")
                .city("Kraków")
                .status(StudentStatus.Confirmed)
                .build();
        if (studentRepository.count() == 0) {
            studentRepository.saveAll(List.of(student1, student2, student3, student4));
        }

        // Employee
        Employee employee1 = Employee.builder()
                .name("Jan")
                .surname("Kwiatkowski")
                .dateOfBirth(LocalDate.of(1990, 3, 3))
                .telephone("987654321")
                .city("Warszawa")
                .salary(5000.0)
                .build();

        Employee employee2 = Employee.builder()
                .name("Jan")
                .surname("Kwiatkowski")
                .dateOfBirth(LocalDate.of(1990, 3, 3))
                .telephone("987654321")
                .city("Warszawa")
                .salary(5000.0)
                .build();
        if (employeeRepository.count() == 0) {
            employeeRepository.saveAll(List.of(employee1, employee2));
        }

        //Tutor
        Tutor tutor = Tutor.builder()
                .knownLanguages(Set.of("English"))
                .superclass(employee1)
                .build();
        if (tutorRepository.count() == 0) {
            tutorRepository.save(tutor);
        }

        //Manager
        Manager manager = Manager.builder()
                .courses(Set.of("Managing school"))
                .superclass(employee1)
                .build();
        if (managerRepository.count() == 0) {
            managerRepository.save(manager);
        }

        //Administrator
        Administrator administrator = Administrator.builder()
                .bonus(200.0)
                .superclass(employee2)
                .build();

        if (administratorRepository.count() == 0) {
            administratorRepository.save(administrator);
        }

        //Building and room
        Building building = Building.builder()
                .name("A1")
                .city("Warszawa")
                .street("Nowowiejska")
                .number("12A")
                .build();

        if (buildingRepository.count() == 0) {
            buildingRepository.save(building);
        }

        Room room1 = Room.builder().number(1).places(5).whole(building).build();
        Room room2 = Room.builder().number(2).places(8).whole(building).build();
        Room room3 = Room.builder().number(3).places(7).whole(building).build();
        if (roomRepository.count() == 0) {
            roomRepository.saveAll(List.of(room1, room2, room3));
        }

        //Lesson
        Lesson lesson1 = Lesson.builder().
                taughtOn(group1)
                .taughtBy(tutor)
                .date(LocalDate.of(2025, 5, 5))
                .topic("Past simple").build();

        Lesson lesson2 = Lesson.builder().
                taughtOn(group1).
                taughtBy(tutor).
                date(LocalDate.of(2025, 5, 12))
                .topic("Past perfect")
                .build();
        if (lessonRepository.count() == 0) {
            lessonRepository.saveAll(List.of(lesson1, lesson2));
        }

        //Occupancy
        Occupancy occupancy1 = Occupancy.builder()
                .occupiedBy(lesson1)
                .occupies(room1)
                .hourFrom(LocalTime.of(12,30))
                .hourTo(LocalTime.of(13,30))
                .build();

        Occupancy occupancy2 = Occupancy.builder()
                .occupiedBy(lesson2)
                .occupies(room1)
                .hourFrom(LocalTime.of(14,30))
                .hourTo(LocalTime.of(15,30))
                .build();
        if (occupancyRepository.count() == 0) {
            occupancyRepository.saveAll(List.of(occupancy1, occupancy2));
        }

    }
}
