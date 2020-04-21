//package cn.lamb.service;
//
//import cn.lamb.pojo.Comment;
//import cn.lamb.repository.CommentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
///**
// * @Description TODO
// * @Date 2020/4/19 14:19
// * @Creator Lambert
// */
//@Service
//public class ApiCommentService {
//    @Autowired
//    private CommentRepository commentRepository;
//
//    //使用 Redis 提供给 Java 的 API 来做缓存操作
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    public Comment findCommentById(Integer id) {
//        //到数据库查询之前先查缓存有没有
//
//        //Q:为什么获取 key 为 "comment_"+id 的缓存值？
//        //A:因为当参数只有一个的时候，默认将参数作为 key，再加上有命名空间，所以“命名空间_参数”就是缓存的 key
//        Object cacheValue = redisTemplate.opsForValue().get("comment_" + id);
//        if (null == cacheValue) { //无则进行数据库查询
//            Optional<Comment> optional = commentRepository.findById(id);
//            if (optional.isPresent()) {
//                Comment comment = optional.get();
//                //因为缓存中没有，所以查询要往缓存中放一份
//                redisTemplate.opsForValue().set("comment_" + id, comment);
//                return comment;
//            }
//        } else { //有则取缓存
//            return (Comment) cacheValue;
//        }
//        return null;
//    }
//
//    public Comment updateComment(Comment comment) {
//        commentRepository.updateComment(comment.getAuthor(), comment.getId());
//        //更新完后要把新数据重新放到缓存
//        redisTemplate.opsForValue().set("comment_" + comment.getId(), comment);
//        return comment;
//    }
//
//    public void deleteComment(int comment_id) {
//        commentRepository.deleteById(comment_id);
//        redisTemplate.delete("comment_" + comment_id);
//    }
//}