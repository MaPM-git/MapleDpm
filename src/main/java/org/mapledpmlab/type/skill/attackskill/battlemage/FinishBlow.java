package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinishBlow extends AttackSkill {
    public FinishBlow() {
        this.setName("피니쉬 블로우");
        this.setDamage(666.0);
        this.setAttackCount(6L);
        this.addIgnoreDefenseList(22L);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DarkLightning());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
