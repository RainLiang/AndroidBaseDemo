package com.rongma.tarot;

/**
 * Created by RongMa on 16/6/29.
 */

public class Question
{
    private String mResouceText;
    private boolean mIsTrue;

    public Question(String mResouceText, boolean mIsTrue) {
        this.mResouceText = mResouceText;
        this.mIsTrue = mIsTrue;
    }

    public Question() {
    }

    public String getResouceText() {
        return mResouceText;
    }

    public void setResouceId(String mResouceText) {
        this.mResouceText = mResouceText;
    }

    public boolean isTrue() {
        return mIsTrue;
    }

    public void setIsTrue(boolean mIsTrue) {
        this.mIsTrue = mIsTrue;
    }
}
