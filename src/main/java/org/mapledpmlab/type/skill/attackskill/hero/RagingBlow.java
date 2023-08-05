package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RagingBlow extends AttackSkill {
    public RagingBlow() {
        this.setName("레이징 블로우");
        this.setDamage(590.0);
        this.setDelayByAttackSpeed(780L);
        this.setAttackCount(5L);    // 레이징 블로우-보너스 어택
        this.setAddDamage(20L);     // 레이징 블로우-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
