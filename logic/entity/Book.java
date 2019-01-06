package by.bsuir.semenchik.logic.entity;

public class Book {

    private String title;
    private String author;
    private String physicalType;

    public String getPhysicalType() {
        return physicalType;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Book(String title, String author, String physicalType) {
        if (title != null && author != null && physicalType != null) {
            this.title = title;
            this.author = author;
            this.physicalType = physicalType;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(title).append(" ");
        builder.append(author).append(" ");
        builder.append(physicalType);
        return builder.toString();
    }
}
