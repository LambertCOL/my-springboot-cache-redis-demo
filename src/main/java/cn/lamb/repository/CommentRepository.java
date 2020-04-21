package cn.lamb.repository;


import cn.lamb.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Description TODO
 * @Date 2020/4/17 12:03
 * @Creator Lambert
 * 继承 JpaRepository 接口可以无需编写sql来实现简单的数据库操作，再继承 JpaSpecificationExecutor 接口则可以实现复杂操作
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    @Transactional
    @Modifying
    @Query(value = "update t_comment c set c.author = ?1 where  c.id=?2",nativeQuery = true)
    void updateComment(String author, Integer getaId);
}
