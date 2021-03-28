/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import java.util.*;

public class Profile {
   // 質問の回答集
   private Map<String, Answer> answers = new HashMap<>();
   private int score;
   private String name;

   /**
    * 
    * @param name
    */
   public Profile(String name) {
      this.name = name;
   }

   /**
    * 
    * @return
    */
   public String getName() {
      return name;
   }

   /**
    * 質問の回答をリストに入れる
    * 
    * @param answer
    */
   public void add(Answer answer) {
      answers.put(answer.getQuestionText(), answer);
   }

   /**
    * 企業の条件と求職者の条件を集計し、マッチングしてるかどうかを図る
    * 
    * @param criteria 企業の条件
    * @return
    */
   public boolean matches(Criteria criteria) {
      score = 0;

      boolean kill = false;
      boolean anyMatches = false;
      for (Criterion criterion : criteria) {
         Answer answer = answers.get(criterion.getAnswer().getQuestionText());
         boolean match = criterion.getWeight() == Weight.DontCare || answer.match(criterion.getAnswer());

         if (!match && criterion.getWeight() == Weight.MustMatch) {
            kill = true;
         }
         if (match) {
            score += criterion.getWeight().getValue();
         }
         anyMatches |= match;
      }
      if (kill)
         return false;
      return anyMatches;
   }

   public int score() {
      return score;
   }
}
