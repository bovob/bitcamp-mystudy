package bitcamp.myapp.command;

import bitcamp.myapp.vo.Project;

public class ProjectList {

    private static final int MAX_SIZE = 100;
    private static final Project[] projects = new Project[MAX_SIZE];
    private static int projectLength = 0;

    public static void add(Project project) {
        projects[projectLength++] = project;
    }

    public static Project deletedProject(int projectNo) {
        Project deletedProject = ProjectList.findByNo(projectNo);
        if (deletedProject == null) {
            System.out.println("없는 프로젝트입니다.");
            return null;
        }
        int index = ProjectList.indexOf(deletedProject);
        for (int i = index + 1; i < projectLength; i++) {
            projects[i - 1] = projects[i];
        }
        projects[--projectLength] = null;
        return deletedProject;
    }

    public static Project[] toArray() {
        Project[] arr = new Project[projectLength];
        System.arraycopy(projects, 0, arr, 0, arr.length);
        return arr;
    }


    static Project findByNo(int projectNo) {
        for (int i = 0; i < projectLength; i++) {
            Project project = projects[i];
            if (project.getNo() == projectNo) {
                return project;
            }
        }
        return null;
    }

    static int indexOf(Project project) {
        for (int i = 0; i < projectLength; i++) {
            if (projects[i] == project) {
                return i;
            }
        }
        return -1;
    }
}
