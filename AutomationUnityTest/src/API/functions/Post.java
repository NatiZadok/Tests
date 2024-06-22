package API.functions;

public class Post {
	
	 	private String title;
	    private String content;
	    private String status;
	    private boolean published;
	    private String publisher;

	    public Post() {
	    }

	    public Post(String title, String content, String status, boolean published, String publisher) {
	        this.title = title;
	        this.content = content;
	        this.status = status;
	        this.published = published;
	        this.publisher = publisher;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getContent() {
	        return content;
	    }

	    public void setContent(String content) {
	        this.content = content;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public boolean isPublished() {
	        return published;
	    }

	    public void setPublished(boolean published) {
	        this.published = published;
	    }

	    public String getPublisher() {
	        return publisher;
	    }

	    public void setPublisher(String publisher) {
	        this.publisher = publisher;
	    }

		public void printPost()
		{
			System.out.println("-----Post details-----");
			System.out.println("Title : "+title);
			System.out.println("Content : "+content);
			System.out.println("Status : "+status);
			System.out.println("Published : "+published);
			System.out.println("Publisher : "+publisher);
			System.out.println("-------------------------");
		}
}
