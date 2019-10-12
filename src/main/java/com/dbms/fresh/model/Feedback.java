package com.dbms.fresh.model;

public class Feedback {
    private int feedback_id;
    private String type;
    private int rating;
    private int order_id;
    private String comment;

    public int getFeedback_id() {
        return this.feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}