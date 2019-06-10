package my.notebook.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Note {
    private LocalDate date;
    private String subject;
    private String note;

    public Note() {
        this(LocalDate.now(), "", "");
    }

    public Note(LocalDate date, String subject, String note) {
        this.date = date;
        this.subject = subject;
        this.note = note;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/M/yy"));
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
