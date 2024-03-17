package me.practice;

import java.util.*;

public class Twitter {

    Map<Integer, PriorityQueue<Integer>> userTweetsMap;
    Map<Integer, List<Integer>> userFollowersMap;


    public Twitter() {
        this.userTweetsMap = new HashMap<>();
        this.userFollowersMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        PriorityQueue<Integer> tweets;
        if (userTweetsMap.containsKey(userId)) {
            tweets = userTweetsMap.get(userId);
        } else {
            tweets = new PriorityQueue<>(Comparator.reverseOrder());
        }
        tweets.offer(tweetId);
        userTweetsMap.put(userId, tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> tweets = userTweetsMap.getOrDefault(userId, new PriorityQueue<>());
        if (userFollowersMap.containsKey(userId)) {
            List<Integer> followers = userFollowersMap.get(userId);
            for (Integer followerId : followers) {
                if (userTweetsMap.containsKey(followerId)) {
                    PriorityQueue<Integer> followerTweets = userTweetsMap.get(followerId);
                    tweets.addAll(followerTweets);
                }
            }
        }
        return new ArrayList<>(tweets);
    }
    
    public void follow(int followerId, int followeeId) {
        List<Integer> followers = userFollowersMap.getOrDefault(followerId, new ArrayList<>());
        followers.add(followeeId);
        userFollowersMap.put(followerId, followers);
    }
    
    public void unfollow(int followerId, int followeeId) {
        List<Integer> followers = userFollowersMap.get(followerId);
        if (null != followers) {
            PriorityQueue<Integer> tweets = userTweetsMap.get(followerId);
            if (null != tweets || !tweets.isEmpty()) {
                tweets.removeAll(userTweetsMap.get(followeeId));
            }
            followers.remove((Integer)followeeId);
        }
        userFollowersMap.put(followerId, followers);
    }

    public static void main(String[] args) {
        Twitter obj = new Twitter();
        obj.postTweet(1, 5);
        List<Integer> params = obj.getNewsFeed(1);
        System.out.println(params);
        obj.follow(1, 2);
        obj.postTweet(2, 6);
        params = obj.getNewsFeed(1);
        System.out.println(params);
        obj.unfollow(1, 2);
        params = obj.getNewsFeed(1);
        System.out.println(params);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */