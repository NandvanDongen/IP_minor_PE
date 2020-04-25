package ip_minor.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
   private LocalDateTime dueDate;
   //private SubTask subtask;


   public Task() {
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

   /*public SubTask getSubtask() {
      return subtask;
   }

   public void setSubtask(SubTask subtask) {
      this.subtask = subtask;
   }*/
}
