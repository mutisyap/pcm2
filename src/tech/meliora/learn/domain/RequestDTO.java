package tech.meliora.learn.domain;

public class RequestDTO {
    private Long id;

    private String reference;

    public RequestDTO(Long id, String reference) {
        this.id = id;
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                '}';
    }
}
