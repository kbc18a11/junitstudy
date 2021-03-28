/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import org.junit.*;

public class ProfileTest {

   @Test
   public void test() {
      // プロフィール生成
      Profile profile = new Profile("Bull Hockey, Inc.");
      // 質問生成
      Question question = new BooleanQuestion(1, "ボーナスは支給されますか?");
      // 質問の回答を生成
      Answer profileAnswer = new Answer(question, Bool.TRUE);
      // 質問の回答をプロフィールに追加
      profile.add(profileAnswer);

      // 企業の条件一覧生成
      Criteria criteria = new Criteria();
      // 質問の回答生成
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      // 条件の重要性
      Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
      // 条件の重要性を一覧に追加
      criteria.add(criterion);
   }

}
