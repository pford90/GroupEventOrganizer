package com.peterford.groupeventorganizer.domain;


public class Event {
    private String mTitle;
    private String mDate;
    private String mTime;
    private String mDescription;

    public Event(Builder builder) {
        mTitle = builder.title;
        mDate = builder.date;
        mTime = builder.time;
        mDescription = builder.description;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }


    static class Builder {
        String title;
        String date;
        String time;
        String description;


        public void setTitle(String title) {
            this.title = title;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Event build() {
            Event event = null;
            if( title != null && title.length() != 0 && date != null )
                event = new Event(this);
            return event;
        }
    }

}
