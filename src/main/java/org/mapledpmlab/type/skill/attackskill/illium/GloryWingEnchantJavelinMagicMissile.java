package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GloryWingEnchantJavelinMagicMissile extends AttackSkill {
    public GloryWingEnchantJavelinMagicMissile() {
        this.setName("글로리 윙:인챈트 자벨린(매직 미사일)");
        this.setDamage(375.0 + 170);
        this.setAttackCount(3L);
        this.setDotDuration(1000L);
        this.setInterval(90L);
        this.setLimitAttackCount(9L);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(0.55555555555555);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
