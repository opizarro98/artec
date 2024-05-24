package ec.artec.model.entities;

import java.util.Date;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "events")
@Getter
@Setter
public class Events {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long eventId;

  @Column(length = 45, unique = true)
  @NonNull
  private String code;

  @Column(length = 45)
  @NonNull
  private String name;

  @Column(length = 45)
  @NonNull
  private String description;

  @Column()
  private int cost;

  @Column()
  @JsonFormat(pattern = "yyyy/MM/dd")
  private Date date;

  @Column(length = 45)
  @NonNull
  private String address;

  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "category_id")
  private Category category;

}
