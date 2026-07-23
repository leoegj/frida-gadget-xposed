package de.robv.android.xposed;

public class XCallback {
    public int priority;

    public XCallback() {
        this.priority = 50;
    }

    public XCallback(int priority) {
        this.priority = priority;
    }
}
