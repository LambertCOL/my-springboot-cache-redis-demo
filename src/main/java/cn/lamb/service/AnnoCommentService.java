package cn.lamb.service;

import cn.lamb.pojo.Comment;
import cn.lamb.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description TODO
 * @Date 2020/4/19 14:19
 * @Creator Lambert
 */
@Service
public class AnnoCommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Cacheable(cacheNames = "comment", unless = "#result==null")
    public Comment findCommentById(Integer id) {
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isPresent()) {
            Comment comment = optional.get();
            return comment;
        }
        return null;
    }

    @CachePut(cacheNames = "comment", key = "#result.id")
    public Comment updateComment(Comment comment) {
        commentRepository.updateComment(comment.getAuthor(), comment.getId());
        return comment;
    }

    @CacheEvict(cacheNames = "comment")
    public void deleteComment(int comment_id) {
        commentRepository.deleteById(comment_id);
    }
}