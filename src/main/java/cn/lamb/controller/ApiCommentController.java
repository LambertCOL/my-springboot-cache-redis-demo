//package cn.lamb.controller;
//
//import cn.lamb.pojo.Comment;
//import cn.lamb.service.ApiCommentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api")
//public class ApiCommentController {
//
//    @Autowired
//    private ApiCommentService apiCommentService;
//
//
//    @RequestMapping("/findCommentById")
//    public Comment findCommentById(Integer id) {
//        Comment comment = apiCommentService.findCommentById(id);
//        return comment;
//
//    }
//
//    @RequestMapping("/updateComment")
//    public Comment updateComment(Comment comment) {
//        Comment commentById = apiCommentService.findCommentById(comment.getId());
//        commentById.setAuthor(comment.getAuthor());
//        Comment comment1 = apiCommentService.updateComment(commentById);
//        return comment1;
//    }
//
//    @RequestMapping("/deleteComment")
//    public void deleteComment(Integer id) {
//        apiCommentService.deleteComment(id);
//    }
//
//
//}
