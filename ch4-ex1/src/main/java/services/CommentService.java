package services;

import POJO.Comment;
import proxies.CommentNotificationProxy;
import repository.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;
    private  final CommentNotificationProxy commentNotificationProxy;

    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment); // 댓글 저장
        commentNotificationProxy.sendComment(comment); // 알림 전송
    }
}
