package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeathMark extends AttackSkill {
    public DeathMark() {
        this.setName("사혼 각인");
        this.setDamage(715.0);
        this.setAttackCount(3L);
        this.setRelatedSkill(new DeathMarkDot());
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(720L);
    }
}
