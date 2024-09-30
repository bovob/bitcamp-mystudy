package bitcamp.myapp.controller;

import bitcamp.myapp.service.StorageService;
import bitcamp.myapp.service.UserService;
import bitcamp.myapp.vo.User;
import java.util.HashMap;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

    private StorageService storageService;
    private UserService userService;

    private String folderName = "user/";


    public UserController(UserService userService, StorageService storageService) {
        this.userService = userService;
        this.storageService = storageService;
    }

    @GetMapping("/user/form")
    public String form() {
        return "user/form";
    }

    @PostMapping("/user/add")
    public String add(User user, MultipartFile file) throws Exception {
        // 첨부 파일을 Object Storage에 올린다.
        // 클라이언트가 보낸 파일을 저장할 때 다른 파일 이름과 충돌나지 않도록 임의의 새 파일 이름을 생성한다.
        String fileName = UUID.randomUUID().toString();

        HashMap<String, Object> options = new HashMap<>();
        options.put(StorageService.CONTENT_TYPE, file.getContentType());

        storageService.upload(
            folderName + fileName, // 업로드 파일의 경로(폴더 경로 포함)
            file.getInputStream(), // 업로드 파일 데이터를 읽어 들일 입력스트림
            options);

        user.setPhoto(fileName); // DB에 저장할 사진 파일 이름 설정

        userService.add(user);
        return "redirect:list";
    }

    @GetMapping("/user/list")
    public String list(Model model) throws Exception {
        List<User> list = userService.list();
        model.addAttribute("list", list);
        return "user/list";
    }

    @GetMapping("/user/view")
    public String view(int no, Model model) throws Exception {
        User user = userService.get(no);
        model.addAttribute("user", user);
        return "user/view";
    }

    @PostMapping("/user/update")
    public String update(User user, MultipartFile file) throws Exception {
        User old = userService.get(user.getNo());

        if (file != null && file.getSize() > 0) {
            storageService.delete(folderName + old.getPhoto());

            String fileName = UUID.randomUUID().toString();
            HashMap<String, Object> options = new HashMap<>();
            options.put(StorageService.CONTENT_TYPE, file.getContentType());

            storageService.upload(
                folderName + fileName, // 업로드 파일의 경로(폴더 경로 포함)
                file.getInputStream(), // 업로드 파일 데이터를 읽어 들일 입력스트림
                options);

            user.setPhoto(fileName);
        } else {
            user.setPhoto(old.getPhoto());
        }

        if (userService.update(user)) {
            return "redirect:list";
        } else {
            throw new Exception("없는 회원입니다!");
        }
    }

    @Transactional
    @GetMapping("/user/delete")
    public String delete(int no) throws Exception {
        //여기에 두면 파일먼저 삭제
        User old = userService.get(no);

        if (userService.delete(no)) {
            // 여기에 두면 데이터베이스 에서 부터 삭제
            storageService.delete(folderName + old.getPhoto());
            return "redirect:list";
        } else {
            throw new Exception("없는 회원입니다.");
        }
    }
}
