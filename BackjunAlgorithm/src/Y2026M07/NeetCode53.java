package Y2026M07;

import java.util.*;

public class NeetCode53 {
    static class Twitter {

        private Map<Integer, List<Tweet>> tweetMap;
        private Map<Integer, Set<Integer>> followerMap;
        private int time;

        private static class Tweet {
            private int tweetId;
            private int time;

            public Tweet(int tweetId, int time) {
                this.tweetId = tweetId;
                this.time = time;
            }
        }

        public Twitter() {
            tweetMap = new HashMap<>();
            followerMap = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {

            tweetMap.computeIfAbsent(userId, key -> new ArrayList())
                    .add(new Tweet(tweetId, time));

            time++;
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<Tweet> tweetQueue = new PriorityQueue<>((a, b) -> b.time - a.time);
            List<Tweet> tweetList = tweetMap.get(userId);
            if (tweetList != null) {
                tweetList.forEach(tweet -> {
                    tweetQueue.offer(tweet);
                });
            }
            followerMap.computeIfPresent(userId, (key, set) -> {
                for (Integer followerId : set) {
                    List<Tweet> followerTweetList = tweetMap.get(followerId);
                    if (followerTweetList != null) {
                        followerTweetList.forEach(tweet -> {
                            tweetQueue.offer(tweet);
                        });
                    }
                }
                return set;
            });

            List<Integer> answer = new ArrayList<>();
            while(!tweetQueue.isEmpty() && answer.size() < 10) {
                Tweet tweet = tweetQueue.poll();
                answer.add(tweet.tweetId);
            }

            return answer;
        }

        public void follow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            followerMap.computeIfAbsent(followerId, key -> new HashSet<>())
                    .add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            if (followerId == followeeId) return;
            followerMap.computeIfAbsent(followerId, key -> new HashSet<>())
                    .remove(followeeId);
        }
    }

}
