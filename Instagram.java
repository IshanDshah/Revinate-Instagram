package revinate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Your Instagram object will be instantiated and called as such: Instagram
 * instagram = new Instagram(); instagram.postMedia(userId,mediaId); List
 * <Integer> feed = instagram.getMediaFeed(userId);
 * instagram.follow(followerId,followedId);
 * instagram.unfollow(followerId,followedId);
 */

public class Instagram {
	List<Model> user;
	
	Map<Integer, ArrayList<Integer>> map;

	/** Initialize your data structure here. */
	public Instagram() {
		user = new ArrayList<>();
		// media=new ArrayList<>();
		map = new HashMap<>();
	}

	/** Add a new media. */
	public void postMedia(int userId, int mediaId) {
		user.add(new Model(userId, mediaId));
		
		if (!map.containsKey(userId)) {
			map.put(userId, new ArrayList<Integer>());
		}
	}

	/**
	 * Retrieve the 10 most recent media ids in the user's media feed. Each
	 * media must be posted by the user herself or by someone the user follows
	 * Media must be ordered from most recent to least recent.
	 */
	public List<Integer> getMediaFeed(int userId) {
		if (!map.containsKey(userId)) {
			return Collections.emptyList();
		} else {

			ArrayList<Integer> folowedUsers = map.get(userId);
		
			List<Integer> result = new ArrayList<>();
			for (int i = user.size() - 1; i >= 0; i--) {
				if (user.get(i).getUserId() == userId || folowedUsers.contains(user.get(i).getUserId())) {
					result.add(user.get(i).getMediaId());
				}
			}
			return result;
		}

	}

	/** A Follower follows a followed. Nothing happens if invalid */
	public void follow(int followerId, int followedId) {
		if (!map.containsKey(followerId))
			return;
		else {
			ArrayList<Integer> x = map.get(followerId);
			//To check whether the user is not already following
			if (!x.contains(followedId))
				x.add(followedId);
			map.put(followerId, x);
		}
	}

	/** A Follower unfollows a followed. Nothing happens if invalid */
	public void unfollow(int followerId, int followedId) {
		if (!map.containsKey(followerId))
			return;
		else {
			ArrayList<Integer> x = map.get(followerId);
			System.out.println();
			// x.add(followedId);
			for (int i = 0; i < x.size(); i++) {
				if (x.get(i) == followedId)
					x.remove(i);
			}
			map.put(followerId, x);
		}
	}

	public List<Model> getUser() {
		return user;
	}

	public void setUser(List<Model> user) {
		this.user = user;
	}

	public Map<Integer, ArrayList<Integer>> getMap() {
		return map;
	}

	public void setMap(Map<Integer, ArrayList<Integer>> map) {
		this.map = map;
	}

}
