package com.sshsys.springbootsecurity.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeRepository noticeRepository;

    /**
     * 모든 공지사항 조회
     *
     * @return 모든 공지사항 List
     */
    @Transactional
    public List<Notice> findAll() {
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    /**
     * 공지사항 등록
     *
     * @param title 제목
     * @param content 내용
     * @return 등록된 공지사항
     */
    public Notice saveNotice(String title, String content) {
        return noticeRepository.save(new Notice(title, content));
    }

    /**
     * 공지사항 삭제
     *
     * @param id 공지사항 id
     */
    public void deleteNotice(Long id) {
        noticeRepository.findById(id).ifPresent(noticeRepository::delete);
    }

}
