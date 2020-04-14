package l202004;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lanshan
 */
public class Twitter {
    Map<Integer, List<Msg>> userAndTweet;
    Map<Integer, Set<Integer>> userFollow;

    static class Msg {
        int msgNo;
        int msgId;

        public Msg(int msgNo, int msgId) {
            this.msgNo = msgNo;
            this.msgId = msgId;
        }

        public int getMsgNo() {
            return msgNo;
        }

        public void setMsgNo(int msgNo) {
            this.msgNo = msgNo;
        }

        public int getMsgId() {
            return msgId;
        }

        public void setMsgId(int msgId) {
            this.msgId = msgId;
        }

        @Override
        public String toString() {
            return "Msg{" +
                    "msgNo=" + msgNo +
                    ", msgId=" + msgId +
                    '}';
        }
    }

    AtomicInteger msgCount;

    /** Initialize your data structure here. */
    public Twitter() {
        userAndTweet = new HashMap<>();
        userFollow = new HashMap<>();
        msgCount = new AtomicInteger(0);
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        userAndTweet.computeIfAbsent(userId, i -> new ArrayList<>()).add(new Msg(msgCount.incrementAndGet(), tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Msg> heap = new PriorityQueue<>(10, (o1, o2) -> o2.msgNo - o1.msgNo);
        Set<Integer> set = new HashSet<>();
        addHeap(userId, heap, set);
        Set<Integer> integers = userFollow.get(userId);
        if (integers != null && integers.size() > 0) {
            integers.forEach(i-> addHeap(i, heap, set));
        }
        return getFromHeap(heap);
    }

    private List<Integer> getFromHeap(PriorityQueue<Msg> heap) {
        List<Integer> list = new ArrayList<>();
        int count = 10;
        while (heap.size() > 0 && count-->0) {
            list.add(heap.poll().msgId);
        }
        return list;
    }

    private void addHeap(Integer userId, PriorityQueue<Msg> heap, Set<Integer> set) {
        List<Msg> integers1 = userAndTweet.get(userId);
        if (integers1 != null && integers1.size() > 0) {
            for (Msg msg : integers1) {
                if (set.contains(msg.getMsgId())) {
                    continue;
                }
                heap.add(msg);
                set.add(msg.msgId);
            }

        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        userFollow.computeIfAbsent(followerId, i -> new HashSet<>()).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> integers = userFollow.get(followerId);
        if (integers == null || integers.size()==0) {
            return;
        }
        integers.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.postTweet(1,3);
        twitter.postTweet(1,101);
        twitter.postTweet(1,13);
        twitter.postTweet(1,10);
        twitter.postTweet(1,2);
        twitter.postTweet(1,94);
        twitter.postTweet(1,505);
        twitter.postTweet(1,333);
        List<Integer> newsFeed = twitter.getNewsFeed(1);
        System.out.println(newsFeed);


    }
}
