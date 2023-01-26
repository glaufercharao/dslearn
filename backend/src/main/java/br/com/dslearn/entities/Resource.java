package br.com.dslearn.entities;

import br.com.dslearn.enums.ResourceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_resource")
public class Resource implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Integer position;
    private String imgUri;
    private ResourceType type;
    private String externalLink;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @OneToMany(mappedBy = "resource")
    private List<Section> sections = new ArrayList<>();

    public Resource() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desscription) {
        this.description = desscription;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUrl) {
        this.imgUri = imgUrl;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return id.equals(resource.id) && Objects.equals(title, resource.title) && Objects.equals(description,
                resource.description) && Objects.equals(position, resource.position) && Objects.equals(imgUri,
                resource.imgUri) && Objects.equals(type, resource.type) && Objects.equals(externalLink,
                resource.externalLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, position, imgUri, type, externalLink);
    }
}
