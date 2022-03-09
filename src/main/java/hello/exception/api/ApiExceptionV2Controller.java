package hello.exception.api;

import hello.exception.exception.BadRequestException;
import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
public class ApiExceptionV2Controller {

    @GetMapping("/api2/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id){
        if("ex".equals(id)){
            throw new RuntimeException("잘못된 사용자입니다.");
        }
        if ("bad".equals(id)) {
            throw new IllegalArgumentException("잘못된 입력 값");
        }
        if ("user-ex".equals(id)) {
            throw new UserException("사용자 오류");
        }
        return new MemberDto(id, "hello "+id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;

    }
}
