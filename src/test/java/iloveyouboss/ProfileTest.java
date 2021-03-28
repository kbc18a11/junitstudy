/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package iloveyouboss;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.*;

public class ProfileTest {
   // プロフィール
   Profile profile;
   // 質問
   Question question;
   // 企業の条件一覧
   Criteria criteria;

   @Before
   public void create() {
      // プロフィール生成
      profile = new Profile("Bull Hockey, Inc.");
      // 質問生成
      question = new BooleanQuestion(1, "ボーナスは支給されますか?");

      // 企業の条件一覧生成
      criteria = new Criteria();
   }

   @Test
   public void matchAnswersFalseWhenMustCriterNotMet() {
      // 質問の回答をプロフィールに追加
      profile.add(new Answer(question, Bool.FALSE));

      // 質問の回答生成
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      // 条件の重要性
      Criterion criterion = new Criterion(criteriaAnswer, Weight.MustMatch);
      // 条件の重要性を一覧に追加
      criteria.add(criterion);

      // マッチング開始
      boolean matches = profile.matches(criteria);

      // マッチングはされなかったか？
      assertFalse(matches);
   }

   @Test
   public void matchAnswersTrueForAnyDontCareCriter() {
      // 質問の回答をプロフィールに追加
      profile.add(new Answer(question, Bool.TRUE));

      // 質問の回答生成
      Answer criteriaAnswer = new Answer(question, Bool.TRUE);
      // 条件の重要性
      Criterion criterion = new Criterion(criteriaAnswer, Weight.DontCare);
      // 条件の重要性を一覧に追加
      criteria.add(criterion);

      // マッチング開始
      boolean matches = profile.matches(criteria);

      // マッチングはしたか？
      assertTrue(matches);
   }
}
