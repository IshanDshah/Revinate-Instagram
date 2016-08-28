package revinate;

public class Model {

	private int userId;
	private int mediaId;

	public Model(int userId, int mediaId) {
		this.mediaId = mediaId;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

}
