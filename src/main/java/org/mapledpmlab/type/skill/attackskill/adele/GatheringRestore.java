package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GatheringRestore extends AttackSkill {
    public GatheringRestore() {
        this.setName("게더링(리스토어)");
        this.setDamage(970.0);
        this.setAttackCount(4L * 8);
        this.setCooldown(15.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new BlossomRestore());
    }
}
