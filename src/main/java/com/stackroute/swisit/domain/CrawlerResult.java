package com.stackroute.swisit.domain;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@JsonIgnoreProperties(ignoreUnknown=true)
public class CrawlerResult {
	@JsonProperty("query")
	private String query;
	
	@JsonProperty("link")
	private String link;
	@JsonProperty("terms")
	private ContentSchema terms;
	@JsonProperty("title")
	private String title;
	@JsonProperty("snippet")
	private String snippet;
	@JsonProperty("lastindexedof")
	private Date lastindexedof;
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getLastindexedof() {
		return lastindexedof;
	}
	public void setLastindexedof(Date lastindexedof) {
		this.lastindexedof = lastindexedof;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public ContentSchema getTerms() {
		return terms;
	}
	public void setTerms(ContentSchema terms) {
		this.terms = terms;
	}
}
