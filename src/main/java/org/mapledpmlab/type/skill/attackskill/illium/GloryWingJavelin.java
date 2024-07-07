package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GloryWingJavelin extends AttackSkill {
    public GloryWingJavelin() {
        this.setName("글로리 윙:자벨린");
        this.setDamage(925.0);
        this.setDelayByAttackSpeed(540L);
        this.setAttackCount(6L + 1);
        this.setAddDamage(20L + 20);    // 자벨린-리인포스, 보스 킬러
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new GloryWingJavelinMagicMissile());
        this.setApplyFinalAttack(true);
    }
}
