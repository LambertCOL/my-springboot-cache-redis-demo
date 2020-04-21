package cn.lamb.controller;

import cn.lamb.pojo.Comment;
import cn.lamb.service.AnnoCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anno")
public class AnnoCommentController {

    @Autowired
    private AnnoCommentService annoCommentService;


    @RequestMapping("/findCommentById")
    public Comment findCommentById(Integer id) {
        Comment comment = annoCommentService.findCommentById(id);
        return comment;

    }

    @RequestMapping("/updateComment")
    public Comment updateComment(Comment comment) {
        Comment commentById = annoCommentService.findCommentById(comment.getId());
        commentById.setAuthor(comment.getAuthor());
        Comment comment1 = annoCommentService.updateComment(commentById);
        return comment1;
    }

    @RequestMapping("/deleteComment")
    public void deleteComment(Integer id) {
        annoCommentService.deleteComment(id);
    }


}
