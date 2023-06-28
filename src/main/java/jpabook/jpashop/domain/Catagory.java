package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Catagory {
    @Id @GeneratedValue
    @Column(name = "catagory_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "catagory_item",
            joinColumns = @JoinColumn(name = "catagory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Catagory parent;

    @OneToMany(mappedBy = "parent")
    private List<Catagory> child = new ArrayList<>();

}
