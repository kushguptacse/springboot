package sample.rabbitmqconsumerdocker.model;

import java.io.Serializable;

public class DataModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -835924662663569188L;

	private String content;

	private Long id;

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DataModel [content=" + content + ", id=" + id + "]";
	}


}
