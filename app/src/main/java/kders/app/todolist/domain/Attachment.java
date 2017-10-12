package kders.app.todolist.domain;

import android.net.Uri;

/**
 * Created by xzen4ever on 10/9/2017.
 */

public class Attachment {
    int attachmentId;
    Uri URI;

    public Attachment(int attachmentId, Uri URI) {
        this.attachmentId = attachmentId;
        this.URI = URI;
    }

    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Uri getURI() {
        return URI;
    }

    public void setURI(Uri URI) {
        this.URI = URI;
    }
}
