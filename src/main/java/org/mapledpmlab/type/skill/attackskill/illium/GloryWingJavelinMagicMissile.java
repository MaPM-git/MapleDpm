package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GloryWingJavelinMagicMissile extends AttackSkill {
    public GloryWingJavelinMagicMissile() {
        this.setName("글로리 윙:자벨린(매직 미사일)");
        this.setDamage(375.0);
        this.setAttackCount(3L);
        this.setDotDuration(750L);
        this.setInterval(250L);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.setLimitAttackCount(3L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
