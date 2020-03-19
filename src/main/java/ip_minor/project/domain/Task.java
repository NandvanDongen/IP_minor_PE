package ip_minor.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Task {
   @Id
   @GeneratedValue
   private Long id;
   @NotNull
   private String title;
   private String description;
   @NotEmpty
   private LocalDateTime dueDate;

   public Task() {
   }

   public Task(String title, String description, LocalDateTime ldt){
      this.title = title;
      this.description = description;
      this.dueDate = ldt;
   }

   public String getTitle() { return title; }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public LocalDateTime getDueDate() {
      return dueDate;
   }

   public void setDueDate(LocalDateTime dueDate) {
      this.dueDate = dueDate;
   }

   public Long getId(){ return id;}

   public void setId(Long id){ this.id = id;}
}
