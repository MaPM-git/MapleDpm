package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MassiveFireIRONBHit extends AttackSkill {
    public MassiveFireIRONBHit() {
        this.setName("매시브 파이어 : IRON-B(1차 타격)");
        this.setAttackCount(6L + 1);            // 매시브 파이어 : IRON-B-보너스 어택
        this.setDamage(570.0);
        this.setDelayByAttackSpeed(780L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new MassiveFireIRONBExplosion());
        this.setAddDamage(10L);                 // 매시브 파이어-리인포스
    }
}
