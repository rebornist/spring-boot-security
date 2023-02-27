package com.sshsys.springbootsecurity.notice;

import com.sshsys.springbootsecurity.note.NoteRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    /**
     * 공지사항 조회
     *
     * @return notice/index.html
     */
    @GetMapping
    public String getNotice(Model model) {
        List<Notice> noticeList = noticeService.findAll();
        model.addAttribute("notices", noticeList);
        return "notice/index";
    }

    /**
     * 공지사항 등록
     *
     * @param title 제목
     * @param content 내용
     * @return notice/index.html
     */
    @PostMapping
    public String postNotice(@ModelAttribute NoteRegisterDto noteDto) {
        noticeService.saveNotice(noteDto.getTitle(), noteDto.getContent());
        return "redirect:/notice";
    }

    /**
     * 공지사항 삭제
     *
     * @param id 공지사항 id
     * @return notice/index.html
     */
    @DeleteMapping
    public String deleteNotice(@RequestParam Long id) {
        noticeService.deleteNotice(id);
        return "redirect:/notice";
    }
}
