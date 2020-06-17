package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.Date;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.CurrentUser;

public class Question {
	private long id;
	private String title;
	private String text;
	private String type;
	private long instructorId;
	private Date date;
	private List<Option> options;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(long instructorId) {
		this.instructorId = instructorId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public boolean delete(IQuestionPersistence questionDB) {
		return questionDB.delete(id);
	}

	public boolean create(IQuestionPersistence questionDB) {
		if(null != CurrentUser.instance().getCurrentAuthenticatedUser()) {
			this.setInstructorId(CurrentUser.instance().getCurrentAuthenticatedUser().getId());
			return questionDB.create(this);
		}
		else {
			return false;
		}
	}
}