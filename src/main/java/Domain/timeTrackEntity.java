package Domain;

import java.util.Objects;

public class timeTrackEntity {
   private int id;
   private static String name;
   private static String surname;

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public static String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public static String getSurname() {
      return surname;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      timeTrackEntity that = (timeTrackEntity) o;
      return id == that.id && Objects.equals(name, that.name) && Objects.equals(surname, that.surname);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, name, surname);
   }

   @Override
   public String toString() {
      return "timeTrackEntity{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", surname='" + surname + '\'' +
              '}';
   }
}
