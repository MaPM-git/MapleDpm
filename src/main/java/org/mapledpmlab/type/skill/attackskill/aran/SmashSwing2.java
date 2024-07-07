package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashSwing2 extends AttackSkill {
    public SmashSwing2() {
        this.setName("스매쉬 스윙(2타)");
        this.setDamage(150.0 + 615);    // 스위프트 무브
        this.setAttackCount(2L);
        this.setDelayByAttackSpeed(630L);
        this.setApplyFinalAttack(true);
        this.setCooldown(30.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new SmashSwing3());
    }
}
