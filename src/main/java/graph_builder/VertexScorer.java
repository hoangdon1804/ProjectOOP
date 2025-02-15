package graph_builder;

import com.google.gson.JsonObject;

public class VertexScorer {
      private final static float TWEET_PARAM = 10;
      /// Score vertices
      float scoreKOL (JsonObject kol) {
            return kol.get("follower_count").getAsInt();
      }

      float scoreNonKOL () {
            return 300;
      }

      float scoreTweet (JsonObject tweet) {
            int views = tweet.get("view_count").getAsInt();
            int likes = tweet.get("like_count").getAsInt();
            int comments = tweet.get("comment_count").getAsInt();
            int reposts = tweet.get("repost_count").getAsInt();
            int bookmarks = tweet.get("bookmark_count").getAsInt();

            int engages = likes + comments+ reposts + bookmarks;
            return (float) (1.0f * views * Math.pow(1.0f * views / (views - engages), TWEET_PARAM));
      }
}
